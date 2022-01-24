package Part1;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class Part1DietProxy implements Part1Eat {

    private final Part1Diet dietObj;

    public Part1DietProxy(Part1Diet dietObj) {
        this.dietObj = dietObj;
    }

    DayOfWeek[] AllowedDays = new DayOfWeek[]{DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY, DayOfWeek.SUNDAY};
    int[] AllowedTimeRange = new int[]{12, 20}; // Intermittent Fasting Diet

    @Override
    public void eat() {
        if(checkIfCanEat()) {
            dietObj.setCalories(dietObj.getCalories() + 500);
            dietObj.eat();
        }
    }

    @Override
    public void calCount() {
        if(checkIfCanEat()) {
            dietObj.calCount();
        }
    }

    @Override
    public int mealCount() {
        return dietObj.getNumMeals();
    }

    public boolean checkIfCanEat() {
        LocalDateTime time = LocalDateTime.now();
        for(int i = 0; i < AllowedDays.length; i++) {
            if (time.getDayOfWeek() == AllowedDays[i]) {
                if (time.getHour() >= AllowedTimeRange[0] && time.getHour() <= AllowedTimeRange[1]) {
                    return true;
                }
            }
        }
        return false;
    }

}
