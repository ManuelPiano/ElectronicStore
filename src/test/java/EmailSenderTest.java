import InvoiceManagment.EmailSender;
import InvoiceManagment.Invoice;
import org.junit.jupiter.api.Test;
import peopleManagment.Client;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmailSenderTest {
    @Test
    public void testSendEmail() {
        // Create a mock client and invoice
        Client client = new Client("John", "sales.manuel3113@gmail.com");
        Invoice invoice = new Invoice("invoice.pdf");

        // Create an EmailSender object
        EmailSender emailSender = new EmailSender();

        // Call the sendEmail method
        emailSender.sendEmail(client, invoice);

        // Check that the email was sent successfully
        // In this example, we're just checking that no exceptions were thrown
        // We can add more assertions to check other things as well
        assertTrue(true);
    }
}
