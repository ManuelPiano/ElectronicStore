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

    EmployeeConsoleInput employeeConsoleInput = new EmployeeConsoleInput();
    employeeConsoleInput.EmployeeConsole();
    Scanner scanner = new Scanner(System.in);
    int option = 0;
    while (option < 1 || option > 2) {
      System.out.println("What do you want to do?");
      System.out.println("1. Attendig client");
      System.out.println("2. Logout");
      if (scanner.hasNextInt()) {
        option = scanner.nextInt();

        switch (option) {
          case 1:
            productList products = new productList();
            products.addProduct();
            ProductListPrinter productListPrinter = new ProductListPrinter();
            productListPrinter.printProductList(products.getProductList());
            ProductSelection productSelection = new ProductSelection(products);
            List<Product> selectedProducts = productSelection.selectProducts();
            double totalPrice = 0;
            for (Product product : selectedProducts) {
              totalPrice += product.getPrice();
            }
            purchaseProcess purchase = new purchaseProcess();
            purchase.processPayment(totalPrice);
            Client newClient = ClientConsoleInput.promptClientData();
            System.out.println("New client created:");
            System.out.println("Name: " + newClient.getName());
            System.out.println("Email: " + newClient.getEmail());
            System.out.println("Client ID: " + newClient.getIdC());
            InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
            Invoice invoice =
                invoiceGenerator.generateInvoice(selectedProducts, newClient, totalPrice);

            EmailSender emailSender = new EmailSender();
            emailSender.sendEmail(newClient, invoice);

            break;
          case 2:
            System.out.println("Logout");
            System.exit(0);
          default:
            System.out.println("Invalid Option");
            break;
        }
      } else {
        System.out.println("Invalid Option");
        scanner.next();
      }
    }
  }
}
