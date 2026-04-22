import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class PayrollCalculator {
    public static void main(String[] args){
        String file = "employees.csv";
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split("\\|");

                int employeeId     = Integer.parseInt(values[0].trim());
                String name        = values[1].trim();
                double hoursWorked = Double.parseDouble(values[2].trim());
                double payRate  = Double.parseDouble(values[3].trim());

                employees.add(new Employee(employeeId, name, hoursWorked, payRate));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage().toString());
        }

        //display employees
        System.out.printf("%-6s %-20s %10s %n", "ID", "Name", "Gross Pay");
        for (Employee eachEmployee : employees) {
            System.out.printf("%-6d %-20s $%9.2f%n",
                    eachEmployee.getEmployeeId(),
                    eachEmployee.getName(),
                    eachEmployee.getGrossPay());
        }
    }

}
