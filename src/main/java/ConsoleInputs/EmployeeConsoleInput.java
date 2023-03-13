package ConsoleInputs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import peopleManagment.Employee;
import peopleManagment.PersonFactory;
import peopleManagment.PersonFactoryImpl;

public class EmployeeConsoleInput {
  public void EmployeeConsole() {
    PersonFactory personFactory = new PersonFactoryImpl();
    List<Employee> employeeList = new ArrayList<Employee>();
    employeeList.add(personFactory.createEmployee("John", "john@company.com", 1));
    employeeList.add(personFactory.createEmployee("Mary", "mary@company.com", 2));
    employeeList.add(personFactory.createEmployee("Bob", "bob@company.com", 3));
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the ID of the employee who will attend the client: ");
    int employeeId = scanner.nextInt();
    Employee employee = null;
    while (employee == null) {
      for (Employee e : employeeList) {
        if (e.getIdEmployee() == employeeId) {
          employee = e;
          break;
        }
      }
      if (employee == null) {
        System.out.println("No employee with the entered ID was found.");
        System.out.print("Enter the ID of the employee who will attend the client: ");
        employeeId = scanner.nextInt();
      }
    }

    System.out.println("Welcome:");
    System.out.println("Name: " + employee.getName());
    System.out.println("Email: " + employee.getEmail());
    System.out.println("Employee ID: " + employee.getIdEmployee());
  }
}
