package peopleManagment;

public interface PersonFactory {
  public Client createClient(String name, String email);

  public Employee createEmployee(String name, String email, int idEmployee);
}
