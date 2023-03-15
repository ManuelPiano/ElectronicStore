package Order;

import java.util.Scanner;

public class PurchaseProcess implements PaymentProcessor {

  @Override
  public void processPayment(double totalPrice) {
    System.out.println("-----------------------");
    System.out.println("SubTotal: " + totalPrice);
    System.out.println("-----------------------");

    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter payment method (1. credit card, 2. cash):");
    int option = scanner.nextInt();
    switch (option) {
      case 1 -> {
        creditCard creditCard = new creditCard();
        creditCard.pay();
        System.out.println("Total Price: " + totalPrice);
      }
      case 2 -> {
        cash Cash = new cash(totalPrice);
        Cash.pay();
      }
      default -> System.out.println("Option invalid");
    }

    System.out.println("Payment processed successfully!");
  }
}
