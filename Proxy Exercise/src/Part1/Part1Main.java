package Part1;

public class Part1Main {
    public static void main(String[] args) {
        Part1Diet diet = new Part1Diet();
        Part1DietProxy dietProxy = new Part1DietProxy(diet);

        dietProxy.eat();
        dietProxy.calCount();
        dietProxy.eat();
        dietProxy.mealCount();
        dietProxy.eat();
        dietProxy.eat();
        dietProxy.mealCount();
        dietProxy.calCount();
    }
}
