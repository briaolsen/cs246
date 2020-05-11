import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class VacationCalculator {



  public static void main(String[] args) {

    VacationCalculator vc = new VacationCalculator();

    // Ask how many nights...
    Scanner scanner = new Scanner(System.in);
    System.out.println("How nights do you want to stay? ");
    int nights = scanner.nextInt();
    scanner.close();

    // Calculate some vacation costs...
    float japanCost = vc.calculateVacationCost(Destination.Japan, nights);
    float mexicoCost = vc.calculateVacationCost(Destination.Mexico, nights);
    float europeCost = vc.calculateVacationCost(Destination.Europe, nights);

    // Print the cost...
    System.out.format(String.format("Total cost for trip to Mexico: $%.2f%n", mexicoCost));
    System.out.format(String.format("Total cost for trip to Europe: $%.2f%n", europeCost));
    System.out.format(String.format("Total cost for trip to Japan: $%.2f%n", japanCost));
  }

  /**
   * Calculates the total cost for vacationing at a given location for a specific
   * number of nights.
   *
   * @param dest the destination of the vacation
   * @return the total cost of the vacation
   */
  public float calculateVacationCost(Destination dest, int nights) {

    ArrayList<Expense> a = new ArrayList<Expense>();
    Cruise cruise = new Cruise(dest);
    a.add(cruise);
    Dining dining = new Dining(dest, nights);
    a.add(dining);
    Lodging lodging = new Lodging(dest, nights);
    a.add(lodging);

    float cost = tallyExpenses(a);
    return cost;
  }

  /**
   * An internal method used by VacationCalculator to loop through a List of items
   * that implement the Expense interface and determine their cost
   *
   * @param expenses A list of items that implement the Expense interface
   * @return the total cost calculated by the items
   */
  float tallyExpenses(List<Expense> expenses) {
    float cost = 0;

    for (int i = 0; i < expenses.size(); i++) {
      cost += expenses.get(i).getCost();
    }

    return cost;
  }
}