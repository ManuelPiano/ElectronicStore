package productManagment;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

public class AddProductsToList implements IProduct {
  @Getter private List<Product> productList = new ArrayList<>();

  @Override
  public void addProduct() {
    Product product1 = new Product("Laptop", 1, 600.0);
    Product product2 = new Product("Cellphone", 2, 300.0);
    Product product3 = new Product("Charger Laptop", 3, 20.0);
    Product product4 = new Product("Pc Desktop", 4, 800.0);
    Product product5 = new Product("Camera", 5, 500.0);
    productList.add(product1);
    productList.add(product2);
    productList.add(product3);
    productList.add(product4);
    productList.add(product5);
  }
}
