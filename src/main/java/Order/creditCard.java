package Order;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class creditCard implements IPayment {

  @Override
  public void pay() {
    System.out.println("paying with credit card");
    System.out.println("Thanks for your purchase");
  }
}
