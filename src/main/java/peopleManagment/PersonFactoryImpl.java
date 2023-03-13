package peopleManagment;

public class PersonFactoryImpl implements PersonFactory {
  @Override
  public Client createClient(String name, String email) {
    return new Client(name, email);
  }

  @Override
  public Employee createEmployee(String name, String email, int idEmployee) {
    return new Employee(name, email, idEmployee);
  }
}
