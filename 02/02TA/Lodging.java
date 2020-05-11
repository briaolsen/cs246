
public class Lodging implements Expense {

  Destination dest;
  int nights;

  public Lodging(Destination dest, int nights) {
    this.dest = dest;
    this.nights = nights;
}

  public float getCost() {


    switch(dest) {

      case Mexico:
        return nights * 100.00f;
      case Europe:
        return (nights * 200.00f) * 1.1f;
      case Japan:
        return (nights * 300.00f) * 1.3f;
      default:
        return 0.0f;
    }
  }

}