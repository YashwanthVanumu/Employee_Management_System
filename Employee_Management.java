/*Employee management system using OOPS.
 *It allows users to add employees, display employee details, and search for employees by their ID.
 *The program utilizes classes such as Employee and Manager, where the Manager class maintains a list of Employee objects using an ArrayList.
 *The user interacts with the program through a menu-driven interface, and the code ensures data encapsulation.*/


//Package Statement
package employee_management_system;

//import statements
import java.util.ArrayList;

import java.util.Scanner;

//Employee class declaration
class Employee {
	
	//Instance variables declared as private for data integrity
	private int ID;
	private String name;
	private String designation;
	private double salary;

	//Constructor for User Input through parameters
	public Employee(int ID, String name, String designation, double salary) {
		this.ID = ID;
		this.name = name;
		this.designation = designation;
		this.salary = salary;
	}
    
	//Getter methods
	public int getID() {
		return ID;
	}

	public String getName() {
		return name;
	}

	public String getDesignation() {
		return designation;
	}

	public double getSalary() {
		return salary;
	}

	public String toString() {
		return " ID: " + ID + '\n' +  " Name: " + name + '\n' + " Designation: " + designation + '\n' +  " Salary: " + salary + '\n' + "------------------" + '\n' ;
	}
}


//Manager class declaration
class Manager {
	
	//Instance variables declared as private for data integrity 
	private ArrayList<Employee> employees;

	//Constructor
	public Manager() {
		employees = new ArrayList<>(); // Initialize the ArrayList to store employees
	}

	//Instance method that adds an employee to the list.
	public void addEmployee(Employee employee) {
		employees.add(employee); // Add an employee to the ArrayList
	}

	//Instance method that displays the details of each employees.
	public void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            System.out.println("Employee Details:");
            for (Employee employee : employees) {		      
       	          System.out.println(employee.toString());  // Display details of each employee 		
       	      }   
        }
	}
	
	//Instance method that searches for an employee by their ID and displays their details if found
	public void searchEmployee(int id) {
		boolean found = false;
		
		// for loop is used to iterate over each employee in the employees list maintained by the Manager class and it iterates over each Employee object, assigning it to the employee variable for each iteration.
		for (Employee employee : employees) {		
			if (employee.getID() == id) {
				System.out.println("Employee Found:");
				System.out.println(employee.toString()); // Display details of the found employee
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("Employee not found.");
		}
	}
}

//Main Class
public class Employee_Management {
	
	//Main method
	public static void main(String[] args) {
			
		try (Scanner scanner = new Scanner(System.in)) {
			Manager manager = new Manager(); // Create an instance of the Manager class
			
			//while loop executes until the user enters the choice is to exit the menu 
			while (true) {
				System.out.println("Choose an operation:");
				System.out.println("1. Add an employee");
				System.out.println("2. Display all employees");
				System.out.println("3. Search an employee by ID");
				System.out.println("4. Exit");
				System.out.print("Enter your choice: ");
				int choice = scanner.nextInt(); //User Input for switch case statement

				switch (choice) {
				
				//case 1 is used to take the user input such as employee details from the user
				
				case 1:
					System.out.print("Enter ID: ");
					int id = scanner.nextInt(); 
					scanner.nextLine(); // Consume the newline character
					System.out.print("Enter name: ");
					String name = scanner.nextLine();
					System.out.print("Enter designation: ");
					String designation = scanner.nextLine();
					System.out.print("Enter salary: ");
					double salary = scanner.nextDouble();
					Employee employee = new Employee(id, name, designation, salary); //Object Instantiation
					manager.addEmployee(employee); // Add the employee details to the Manager's employee list
					System.out.println("Employee added successfully.");
					break;
					
				//case 2 is used to display details of all employees which are stored in Manager's employee list
					
				case 2:
					manager.displayEmployees(); // Display details of all employees
					break;
					
				//case 3 is used to search for an employee by taking user input such as ID from the user and displaying it.	
					
				case 3:
					System.out.print("Enter the ID to search: ");
					int searchId = scanner.nextInt();
					manager.searchEmployee(searchId); // Search for an employee by ID
					break;
					
			    //case 4 is used to exit the program		
					
				case 4:
					System.out.println("Exiting the program...");
					System.exit(0); // Exit the program
					
				//default case is used to display the menu again if the user enters a invalid choice.
				
				default:
					System.out.println("Invalid choice. Please try again.");
				}

				System.out.println();	
				
			}
		}
	
	}
	
}
