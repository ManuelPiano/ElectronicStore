package Controllers;

import InvoiceManagment.EmailSender;
import InvoiceManagment.Invoice;
import InvoiceManagment.InvoiceGenerator;
import Order.PurchaseProcess;
import peopleManagment.Client;
import productManagment.Product;
import productManagment.ProductListPrinter;
import productManagment.ProductSelection;
import productManagment.AddProductsToList;

import java.util.List;
import java.util.Scanner;

public class Controller {
    private final EmployeeConsoleInput employeeConsoleInput;
    private final Scanner scanner;
    private final AddProductsToList products;

    public Controller() {
        employeeConsoleInput = new EmployeeConsoleInput();
        scanner = new Scanner(System.in);
        products = new AddProductsToList();
    }

    public void run() {
        employeeConsoleInput.EmployeeConsole();
        int option = 0;
        while (option < 1 || option > 2) {
            System.out.println("What do you want to do?");
            System.out.println("1. Attendig client");
            System.out.println("2. Logout");
            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                switch (option) {
                    case 1 -> attendClient();
                    case 2 -> logout();
                    default -> System.out.println("Invalid Option");
                }
            } else {
                System.out.println("Invalid Option");
                scanner.next();
            }
        }
    }

    private void attendClient() {
        products.addProduct();
        ProductListPrinter productListPrinter = new ProductListPrinter();
        productListPrinter.printProductList(products.getProductList());
        ProductSelection productSelection = new ProductSelection(products);
        List<Product> selectedProducts = productSelection.selectProducts();
        double totalPrice = 0;
        for (Product product : selectedProducts) {
            totalPrice += product.getPrice();
        }
        PurchaseProcess purchase = new PurchaseProcess();
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
        emailSender.sendEmail(newClient, invoiceGenerator);
        scanner.close();

    }

    private void logout() {
        System.out.println("Logout");
        System.exit(0);
    }
}
