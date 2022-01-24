package Part1;

public class Part1Diet implements Part1Eat {
    private int numMeals = 0;
    private int calories = 0;


    public int getNumMeals() {
        return numMeals;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public void eat() {
        numMeals++;
        System.out.println("This is your number " + numMeals + " meal of the day");
    }

    @Override
    public void calCount() {
        System.out.println("You've eaten a total of: " + calories + " calories today");
    }

    @Override
    public int mealCount() {
        return numMeals;
    }
}
