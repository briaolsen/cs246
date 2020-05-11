
public class Dining implements Expense {

  Destination dest;
  int nights;

  // Assign Two Variables (Destination & Nights)
  public Dining(Destination dest, int nights) {
    this.dest = dest;
    this.nights = nights;
  }

  // Find Total Cost of Dining at Destination Selected  
  public float getCost() {

    switch(dest) {

      case Mexico:
        return nights * 10.00f;
      case Europe:
        return nights * 20.00f;
      case Japan:
        return nights * 30.00f;
      default:
        return 0.0f;
    }
  }
}