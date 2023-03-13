package productManagment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductSelection implements ProductSelector {
  private List<Product> productList = new ArrayList<>();

  public ProductSelection(productList products) {
    this.productList = products.getProductList();
  }

  @Override
  public List<Product> selectProducts() {
    Scanner scanner = new Scanner(System.in);
    List<Product> selectedProducts = new ArrayList<>();
    double total = 0.0;
    while (true) {
      System.out.println("Insert product ID from the list (enter 0 to exit):");
      int selectedProductId = scanner.nextInt();
      if (selectedProductId == 0) {
        break;
      }

      Product selectedProduct =
          productList.stream()
              .filter(product -> product.getIdP() == selectedProductId)
              .findFirst()
              .orElse(null);

      if (selectedProduct == null) {
        System.out.println("Product not found");
      } else {
        selectedProducts.add(selectedProduct);
        total += selectedProduct.getPrice();
        System.out.println(
            selectedProduct.getName() + " " + selectedProduct.getPrice() + " added to cart");
      }
    }

    System.out.println("Selected Products:");
    ProductListPrinter productListPrinter = new ProductListPrinter();
    productListPrinter.printProductList(selectedProducts);

    return selectedProducts;
  }
}
