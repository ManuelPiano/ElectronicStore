package productManagment;

import java.util.*;

public class ProductSelection implements ProductSelector {
  private List<Product> productList = new ArrayList<>();

  public ProductSelection(productList products) {
    this.productList = products.getProductList();
  }

  @Override
  public List<Product> selectProducts() {
    Scanner scanner = new Scanner(System.in);
    List<Product> selectedProducts = new ArrayList<>();
    Map<Integer, Integer> productCounts = new HashMap<>();
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
        int count = productCounts.getOrDefault(selectedProductId, 0);
        productCounts.put(selectedProductId, count + 1);
        System.out.println(
            selectedProduct.getName() + " " + selectedProduct.getPrice() + " added to cart");
      }
    }

    System.out.println("Selected Products:");
    for (Map.Entry<Integer, Integer> entry : productCounts.entrySet()) {
      int productId = entry.getKey();
      int count = entry.getValue();
      Product product = productList.stream()
              .filter(p -> p.getIdP() == productId)
              .findFirst()
              .orElse(null);
      if (product != null) {
        System.out.println(product.getName() + " x " + count);
      }
    }

    return selectedProducts;
  }
}
