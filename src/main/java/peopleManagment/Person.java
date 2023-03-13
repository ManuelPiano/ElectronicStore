package peopleManagment;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Person {
  protected String name;
  protected String email;
}
