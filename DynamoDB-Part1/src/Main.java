
import java.util.*;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.DeleteItemSpec;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.spec.UpdateItemSpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.QueryRequest;
import com.amazonaws.services.dynamodbv2.model.ReturnValue;

public class Main {

    /****************** PART 1 **************************/

    public static void main(String[] args) {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withRegion("us-west-1")
                .build();

        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("follows");

        String followerHandle = "@Fred";
        String followerName = "Fred Flinstone";
        String followeeHandle = "@Clint";
        String followeeName = "Clint Eastwood";


        // Put

        for(int i = 0; i < 10; i++) {
            try {
                System.out.println("Adding a new item...");
                PutItemOutcome outcome = table
                        .putItem(new Item().withPrimaryKey("follower_handle", followerHandle).withString
                                ("followee_handle", followeeHandle).withString("follower_name", followerName).withString
                                ("followee_name", followeeName).withNumber
                                ("followers_number", Math.floor(Math.random() * 250)).withNumber
                                ("followees_number", Math.floor(Math.random() * 250)));

                System.out.println("PutItem succeeded:\n" + outcome.getPutItemResult());

            } catch (Exception e) {
                System.err.println("Unable to add item: " + followerHandle + " " + followerName);
                System.err.println(e.getMessage());
            }
        }

        // Get
        GetItemSpec spec = new GetItemSpec().withPrimaryKey("follower_handle", followerHandle, "followee_handle", followeeHandle);

        try {
            System.out.println("Attempting to read the item...");
            Item outcome = table.getItem(spec);
            System.out.println("GetItem succeeded: " + outcome);

        }
        catch (Exception e) {
            System.err.println("Unable to read item: " + followerHandle);
            System.err.println(e.getMessage());
        }

        // Update
        UpdateItemSpec updateItemSpec = new UpdateItemSpec().withPrimaryKey("follower_handle", followerHandle, "followee_handle", followeeHandle)
                .withUpdateExpression("set followee_name =:Eastwood2, follower_name =:Fred2")
                .withValueMap(new ValueMap().withString(":Eastwood2", followeeName).withString(":Fred2", followerName))
                .withReturnValues(ReturnValue.UPDATED_NEW);

        try {
            System.out.println("Updating the item...");
            UpdateItemOutcome outcome = table.updateItem(updateItemSpec);
            System.out.println("UpdateItem succeeded:\n" + outcome.getItem().toJSONPretty());

        }
        catch (Exception e) {
            System.err.println("Unable to update item: " + followerName);
            System.err.println(e.getMessage());
        }

        // Delete

//        DeleteItemSpec deleteItemSpec = new DeleteItemSpec()
//                .withPrimaryKey("follower_handle", followerHandle, "followee_handle", followeeHandle);
//
//        try {
//            System.out.println("Attempting a conditional delete...");
//            table.deleteItem(deleteItemSpec);
//            System.out.println("DeleteItem succeeded");
//        }
//        catch (Exception e) {
//            System.err.println("Unable to delete item: " + followerHandle);
//            System.err.println(e.getMessage());
//        }

        /****************** PART 2 **************************/
        // “Query” the “follows” table to return all of the users being followed by a user,
        // sortedby “followee_handle”

        HashMap<String, String> nameMap = new HashMap<String, String>();
        nameMap.put("#follower_handle", "follower_handle");

        HashMap<String, Object> valueMap = new HashMap<String, Object>();
        valueMap.put(":followee", followeeHandle);

        ItemCollection<QueryOutcome> items = null;
        Iterator<Item> iterator = null;
        Item item = null;

        QuerySpec querySpec = new QuerySpec().
                withKeyConditionExpression("#follower_handle = :followee")
                .withNameMap(nameMap).withValueMap(valueMap)
                .withScanIndexForward(true);

        try {
            items = table.query(querySpec);

            iterator = items.iterator();
            while (iterator.hasNext()) {
                item = iterator.next();
                System.out.println(item.getString("followee_handle") + ": " + item.getString("followee_handle"));
            }

        }
        catch (Exception e) {
            System.err.println("Unable to query follows table");
            System.err.println(e.getMessage());
        }

        // Reverser Order

        QuerySpec querySpecc = new QuerySpec().
                withKeyConditionExpression("#follower_handle = :followee")
                .withNameMap(nameMap).withValueMap(valueMap)
                .withScanIndexForward(false);

        try {
            items = table.query(querySpecc);

            iterator = items.iterator();
            while (iterator.hasNext()) {
                item = iterator.next();
                System.out.println(item.getString("followee_handle") + ": " + item.getString("followee_handle"));
            }

        }
        catch (Exception e) {
            System.err.println("Unable to query follows table");
            System.err.println(e.getMessage());
        }

        /****************** PART 2 with pagination  **************************/

        // Copies in order to print results of queries in pages of size ten

        HashMap<String, String> nameMap2 = new HashMap<String, String>();
        nameMap.put("#follower_handle", "follower_handle");

        HashMap<String, Object> valueMap2 = new HashMap<String, Object>();
        valueMap.put(":followee", followeeHandle);


        ItemCollection<QueryOutcome> items2 = null;
        Iterator<Item> iterator2 = null;
        Item item2 = null;

        QuerySpec querySpec2 = new QuerySpec().withKeyConditionExpression("#follower_handle = :followee")
                .withNameMap(nameMap).withValueMap(valueMap)
                .withScanIndexForward(true).withMaxResultSize(10);

        try {
            items2 = table.query(querySpec2);

            iterator2 = items2.iterator();
            while (iterator2.hasNext()) {
                item2 = iterator2.next();
                System.out.println(item2.getString("followee_handle") + ": " + item2.getString("followee_handle"));
            }

        }
        catch (Exception e) {
            System.err.println("Unable to query follows table");
            System.err.println(e.getMessage());
        }

        // Getting the lastEvaluatedKey and then using it in withExclusiveStartKey
        assert items2 != null;

        Map<String, AttributeValue> lastEvaluatedKey = items2.getLastLowLevelResult().getQueryResult().getLastEvaluatedKey();

        if(lastEvaluatedKey != null) {
            querySpec2.withExclusiveStartKey("followee_handle", lastEvaluatedKey.get("followee_handle").getS(), "follower_handle", lastEvaluatedKey.get("follower_handle").getS());
        }

        // Reverser Order

        ItemCollection<QueryOutcome> items3 = null;
        Iterator<Item> iterator3 = null;
        Item item3 = null;

        QuerySpec querySpecc2 = new QuerySpec().
                withKeyConditionExpression("#follower_handle = :followee")
                .withNameMap(nameMap).withValueMap(valueMap)
                .withScanIndexForward(false).withMaxResultSize(10);

        try {
            items3 = table.query(querySpecc2);

            iterator3 = items3.iterator();
            while (iterator3.hasNext()) {
                item3 = iterator.next();
                System.out.println(item3.getString("followee_handle") + ": " + item3.getString("followee_handle"));
            }

        }
        catch (Exception e) {
            System.err.println("Unable to query follows table");
            System.err.println(e.getMessage());
        }

        // Getting the lastEvaluatedKey and then using it in withExclusiveStartKey
        assert items3 != null;

        Map<String, AttributeValue> lastEvaluatedKeyReversed = items3.getLastLowLevelResult().getQueryResult().getLastEvaluatedKey();

        if(lastEvaluatedKey != null) {
            querySpec2.withExclusiveStartKey("followee_handle", lastEvaluatedKeyReversed.get("followee_handle").getS(), "follower_handle", lastEvaluatedKey.get("follower_handle").getS());
        }
    }
}
