package Part2;

public class Part2Main {
    public static void main(String[] args) {
        Part2Array2DImplementation array = new Part2Array2DImplementation(20,20);
        array.set(5, 10, 50);
        array.set(4,12,14);
        System.out.println(array.get(5, 10));

        try {
            array.save("TwoD-Array.txt");
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Part2LazyArray2DProxy array2DProxy = new Part2LazyArray2DProxy("TwoD-Array.txt");
            System.out.println(array2DProxy.get(4, 12));
        } catch (Exception e) {
            System.out.println(e);
        }


    }
}
