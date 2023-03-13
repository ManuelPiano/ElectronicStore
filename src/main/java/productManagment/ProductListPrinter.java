package productManagment;

import java.util.List;

public class ProductListPrinter {
  public void printProductList(List<Product> productList) {
    System.out.println("Product List:");
    for (Product product : productList) {
      System.out.println(product.getIdP() + ". " + product.getName() + " - " + product.getPrice());
    }
  }
}
