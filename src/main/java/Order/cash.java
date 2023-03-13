package Order;

import java.util.Scanner;

public class cash implements IPayment {
  double amount;

  public cash(double amount) {
    this.amount = amount;
  }

  @Override
  public void pay() {
    boolean enoughtCashProvided = false;
    Scanner scanner = new Scanner(System.in);
    while (!enoughtCashProvided) {
      System.out.println("Enter amount of cash:");
      double cash = scanner.nextDouble();
      double change = cash - amount;
      if (change >= 0) {
        System.out.println("Payment processed successfully!");
        System.out.println("------------------");
        System.out.println("Change: " + change);
        System.out.println("-------------------");
        enoughtCashProvided = true;
      } else {
        System.out.println("Not enough cash provided!");
      }
    }
  }
}
