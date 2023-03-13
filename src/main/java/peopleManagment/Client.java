package peopleManagment;

import lombok.Getter;
import lombok.Setter;

public class Client extends Person {
  private static int lastIdC = 0;

  @Getter @Setter protected int idC;

  public Client(String name, String email) {
    super(name, email);
    this.idC = ++lastIdC;
  }
}
