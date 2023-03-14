package InvoiceManagment;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import peopleManagment.Client;
import productManagment.Product;
public class InvoiceGenerator {

  private Invoice lastInvoice;

  private static final Font titleFont =
      FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20, BaseColor.BLACK);
  private static final Font subtitleFont =
      FontFactory.getFont(FontFactory.HELVETICA, 14, BaseColor.BLACK);
  private static final Font headerFont =
      FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.WHITE);
  private static final Font normalFont = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK);
  public Invoice generateInvoice(List<Product> selectedProducts, Client client, double totalPrice) {
    // Create a new document
    Date currentDate = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
    String dateAndTime = dateFormat.format(currentDate);
    String filename = "invoice_" + dateAndTime + ".pdf";
    String filePath = "invoices/" + filename;
    Document document = new Document();
    try {
      // Create a PdfWriter instance to write the document to a file
      PdfWriter.getInstance(document, new FileOutputStream(filePath));
      // Open the document
      document.open();

      Paragraph title = new Paragraph("Electronic Store - Invoice", titleFont);
      title.setAlignment(Element.ALIGN_CENTER);
      document.add(title);
      // Subtitle
      Paragraph subtitle = new Paragraph("Date: " + new Date(), subtitleFont);
      subtitle.setAlignment(Element.ALIGN_CENTER);
      document.add(subtitle);
      // Add client information
      Paragraph clientInfo = new Paragraph();
      clientInfo.add(new Paragraph("Client: Mr.", headerFont));
      clientInfo.add(new Paragraph(client.getName(), normalFont));
      clientInfo.add(new Paragraph("Email:", headerFont));
      clientInfo.add(new Paragraph(client.getEmail(), normalFont));
      clientInfo.setSpacingBefore(20);
      document.add(clientInfo);
      // Group products by name
      Map<Product, Integer> productQuantities = new HashMap<>();
      for (Product product : selectedProducts) {
        Integer quantity = productQuantities.get(product);
        if (quantity == null) {
          quantity = 0;
        }
        productQuantities.put(product, quantity + 1);
      }

      // Create table
      PdfPTable table = new PdfPTable(4);
      table.setWidthPercentage(100);
      table.setSpacingBefore(10);
      table.setSpacingAfter(10);
      PdfPCell cell;
      cell = new PdfPCell(new Phrase("Product"));
      cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
      table.addCell(cell);

      cell = new PdfPCell(new Phrase("Unit Price"));
      cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
      table.addCell(cell);

      cell = new PdfPCell(new Phrase("Quantity"));
      cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
      table.addCell(cell);

      cell = new PdfPCell(new Phrase("Subtotal"));
      cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
      table.addCell(cell);

      // Add products to table
      for (Map.Entry<Product, Integer> entry : productQuantities.entrySet()) {
        Product product = entry.getKey();
        Integer quantity = entry.getValue();

        cell = new PdfPCell(new Phrase(product.getName()));
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("$" + product.getPrice()));
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(quantity.toString()));
        table.addCell(cell);

        double subtotal = quantity * product.getPrice();
        cell = new PdfPCell(new Phrase("$" + subtotal));
        cell.setBackgroundColor(new BaseColor(255,215,0));
        table.addCell(cell);
      }

      document.add(new Paragraph("Selected Products:"));
      document.add(table);

      Paragraph totalPriceInfo = new Paragraph("Total Price: " + totalPrice + " USD", normalFont);
      totalPriceInfo.setSpacingBefore(10);
      document.add(totalPriceInfo);

      document.close();
      lastInvoice= new Invoice(filePath);
      return lastInvoice;
    }
    catch (DocumentException | FileNotFoundException e) {
      e.printStackTrace();
      return null;
    }
  }
  public Invoice getLastinvoice(){
    return lastInvoice;
  }
}