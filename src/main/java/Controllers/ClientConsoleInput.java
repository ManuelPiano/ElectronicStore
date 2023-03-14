package Controllers;

import java.util.Scanner;
import peopleManagment.Client;

public class ClientConsoleInput {
  private ClientConsoleInput(){}
  public static Client promptClientData() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter client name:");
    String name = scanner.nextLine();

    System.out.println("Enter client email:");
    String email = scanner.nextLine();

    scanner.close();

    return new Client(name, email);
  }
}
