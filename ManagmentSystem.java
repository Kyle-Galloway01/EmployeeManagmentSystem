import java.util.Scanner;

public class EmployeeManagementSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static EmployeeDatabase employeeDatabase = new EmployeeDatabase();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Welcome to the Employee Management System!");
            System.out.println("1. Add an employee");
            System.out.println("2. Update an employee");
            System.out.println("3. Delete an employee");
            System.out.println("4. View all employees");
            System.out.println("5. Search employees by name");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    updateEmployee();
                    break;
                case 3:
                    deleteEmployee();
                    break;
                case 4:
                    viewAllEmployees();
                    break;
                case 5:
                    searchEmployees();
                    break;
                case 6:
                    System.out.println("Thank you for using the Employee Management System!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addEmployee() {
        System.out.print("Enter the employee's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the employee's salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter the employee's department: ");
        String department = scanner.nextLine();
        System.out.print("Enter the employee's hire date (in the format yyyy-mm-dd): ");
        String hireDate = scanner.nextLine();
        Employee employee = new Employee(name, salary, department, hireDate);
        employeeDatabase.addEmployee(employee);
        System.out.println("Employee added successfully.");
    }

    private static void updateEmployee() {
        System.out.print("Enter the ID of the employee you want to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Employee employee = employeeDatabase.getEmployeeById(id);
        if (employee == null) {
            System.out.println("Employee not found.");
            return;
        }
        System.out.print("Enter the new name for the employee (or press enter to keep the current name): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            employee.setName(name);
        }
        System.out.print("Enter the new salary for the employee (or press enter to keep the current salary): ");
        String salaryString = scanner.nextLine();
        if (!salaryString.isEmpty()) {
            double salary = Double.parseDouble(salaryString);
            employee.setSalary(salary);
        }
        System.out.print("Enter the new department for the employee (or press enter to keep the current department): ");
        String department = scanner.nextLine();
        if (!department.isEmpty()) {
            employee.setDepartment(department);
        }
        System.out.print("Enter the new hire date for the employee (in the format yyyy-mm-dd, or press enter to keep the current hire date): ");
        String hireDateString = scanner.nextLine();
        if (!hireDateString.isEmpty()) {
            employee.setHireDate(hireDateString);
        }
        employeeDatabase.updateEmployee(employee);
        System.out.println("Employee updated successfully.");
    }

    private static void deleteEmployee() {
        System.out.print("Enter the ID of the employee you want to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Employee employee = employeeDatabase.getEmployeeById(id);
        if (employee == null) {
            System.out
