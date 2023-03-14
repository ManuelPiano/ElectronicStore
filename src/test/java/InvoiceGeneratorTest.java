import InvoiceManagment.Invoice;
import InvoiceManagment.InvoiceGenerator;
import org.junit.jupiter.api.Test;
import peopleManagment.Client;
import productManagment.Product;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class InvoiceGeneratorTest {
    @Test
    public void testGenerateInvoice() {
        // Create a list of mock products
        List<Product> products = new ArrayList<>();
        products.add(new Product("Product 1", 1,10.0));
        products.add(new Product("Product 2", 2,20.0));
        products.add(new Product("Product 3", 3,30.0));

        // Create a mock client
        Client client = new Client("John", "manuel.alvarado3113@gmail.com");

        // Generate the invoice
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Invoice invoice = invoiceGenerator.generateInvoice(products, client, 60.0);

        // Check that the invoice was generated successfully
        assertNotNull(invoice);
        assertEquals("invoice.pdf", invoice.file());
    }
}
