package peopleManagment;

import lombok.Getter;
import lombok.Setter;

public class Employee extends Person {

  @Getter @Setter private int idEmployee;

  public Employee(String name, String email, int idEmployee) {
    super(name, email);
    this.idEmployee = idEmployee;
  }
}
