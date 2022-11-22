package Employee.domain;

import Employee.service.EmployeeService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created: 23.09.2022
 *
 * @author Maximilian Ertl (maxer)
 */
public class EmployeeMain {
    public static void main(String[] args) {
        try {
            Scanner fileScanner = new Scanner(new File("resource\\Employee\\validEmployees.csv"));
            List<Payable> EmployeeData = new ArrayList<>();
            fileScanner.nextLine();
            while(fileScanner.hasNextLine()){
                EmployeeService service = new EmployeeService();
                service.addEmployee(new TemporaryEmployee("A", 1));
                EmployeeData.add(Employee.of(fileScanner.nextLine()));
            }
            System.out.println(Payable.calculateAverageHourlyRate(EmployeeData));
            fileScanner.close();
        } catch (Exception e) {
            System.out.println("Fehler");
            System.out.println(e);
        }
    }
}
