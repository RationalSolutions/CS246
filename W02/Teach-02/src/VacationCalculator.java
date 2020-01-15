import java.util.ArrayList;
import java.util.List;

public class VacationCalculator {

    public static void main(String[] args) {

        VacationCalculator vc = new VacationCalculator();

        float mexicoCost = vc.calculateVacationCost(Destination.Mexico, 5);
        float europeCost = vc.calculateVacationCost(Destination.Europe, 5);
        float japanCost = vc.calculateVacationCost(Destination.Japan, 5);

        System.out.println("Cost for a vacation to Mexico: " + mexicoCost);
        System.out.println("Cost for a vacation to Europe: " + europeCost);
        System.out.println("Cost for a vacation to Japan: " + japanCost);

    }

    public float calculateVacationCost(Destination destination, int nights){

        List<Expense> expenseList = new ArrayList<Expense>();
        expenseList.add(new Cruise(destination));
        expenseList.add(new Dining(destination,nights));
        expenseList.add(new Lodging(destination, nights));

        return tallyExpenses(expenseList);
    }

    private float tallyExpenses(List<Expense> expenses){

        float totalCost = 0;

        for (Expense e: expenses) {
            totalCost += e.getCost();
        }

        return totalCost;
    }

}
