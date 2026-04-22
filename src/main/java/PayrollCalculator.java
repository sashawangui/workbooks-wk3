import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PayrollCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Reading the file.
        System.out.println("Enter the name of the file to be read");
        String inputFileName = input.nextLine().trim();
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName))) {
            String line = br.readLine();
            while (line != null) {
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

        //Write values to a new output file - depending on extension
        System.out.print("Enter the name of the payroll file to create: ");
        String outputFileName = input.nextLine().trim();

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName))){
            if (outputFileName.endsWith(".json")){
                bw.write("[");
                bw.newLine();

                for (int i = 0; i < employees.size(); i++){
                    Employee employee = employees.get(i);
                    bw.write("{");
                    bw.newLine();
                    bw.write("\"id\": " + employee.getEmployeeId() + ",");
                    bw.newLine();
                    bw.write("\"name\": \"" + employee.getName() + "\",");
                    bw.newLine();
                    bw.write(String.format("\"grossPay\": %.2f", employee.getGrossPay()));
                    bw.newLine();

                    if (i < employees.size() - 1){
                        bw.write("},");
                    }else{
                        bw.write("}");
                    }
                    bw.newLine();
                }

                bw.write("]");

            }else{
                bw.write("id|name|gross pay");
                bw.newLine();

                for (Employee employee : employees){
                    bw.write(employee.getEmployeeId() + "|" +
                            employee.getName() + "|" +
                            String.format("%.2f", employee.getGrossPay()));
                    bw.newLine();
                }
            }

            System.out.println("Payroll File created: " + outputFileName);


        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage().toString());
        }

//        //display employees
//        System.out.printf("%-6s %-20s %10s %n", "ID", "Name", "Gross Pay");
//        for (Employee eachEmployee : employees) {
//            System.out.printf("%-6d %-20s $%9.2f%n",
//                    eachEmployee.getEmployeeId(),
//                    eachEmployee.getName(),
//                    eachEmployee.getGrossPay());
//        }





    }

}
