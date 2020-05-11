//import java.rmi.MarshalException;

public class Cruise implements Expense {
    
    Destination dest;
    

    public Cruise(Destination dest) {
        this.dest = dest;
    }

    public float getCost() {
      // What can enum values utilize?
      switch(dest) {
        case Mexico:
          return 1000.00f;
        case Europe:
          return 2000.00f;
        case Japan:
          return 3000.00f;
        default:
          return 0.0f;
      }   
    }
}