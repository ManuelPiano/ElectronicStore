import ConsoleInputs.ClientConsoleInput;
import ConsoleInputs.EmployeeConsoleInput;
import InvoiceManagment.EmailSender;
import InvoiceManagment.Invoice;
import InvoiceManagment.InvoiceGenerator;
import Order.purchaseProcess;
import java.util.List;
import java.util.Scanner;
import peopleManagment.Client;
import productManagment.Product;
import productManagment.ProductListPrinter;
import productManagment.ProductSelection;
import productManagment.productList;

public class Main {
  public static void main(String[] args) {
    Controller controller = new Controller();
    controller.run();
  }
}
