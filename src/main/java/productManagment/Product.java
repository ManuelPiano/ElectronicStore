package productManagment;

import lombok.Getter;

@Getter
public class Product {
  protected String name;
  protected int idP;
  protected double price;

  public Product(String name, int idP, double price) {
    this.name = name;
    this.idP = idP;
    this.price = price;
  }
}
