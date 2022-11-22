package Employee.service;

import Employee.domain.Employee;
import Employee.domain.PermanentEmployee;

import java.io.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    private final List<Employee> employees = new ArrayList<>();

    /**
     * Reads all employees from a given csv-File. Log is written to given logfile.
     *
     * @param srcFilename the file containing the
     * @param logFilename the file the log is written to
     * @throws IOException file may be formatted wrong
     */
    public EmployeeService(String srcFilename, String logFilename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(srcFilename));
             PrintWriter writer = new PrintWriter(logFilename)) {
            writer.println(String.format("%s: %s", Instant.now(), srcFilename));
            reader.readLine();  // read the header
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    addEmployee(Employee.of(line));
                } catch (Exception e) {
                    writer.println(String.format("%s: Error creating object", Instant.now()));
                }

            }
        }
    }

    /**
     * Creates an EmployeeService without any employees.
     */
    public EmployeeService() {
    }

    /**
     * Writes all saved employeedata to the given file.
     *
     * @param filename the file to write
     */
    public void writeToFile(String filename) throws IOException {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filename)))) {
            for (Employee employee : employees) {
                writer.println(employee);
            }
        }
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    /**
     * Adds an employee to the Service.
     *
     * @param e the employee to be added
     */
    public void addEmployee(Employee e) {
        employees.add(e);
    }

    /**
     * Counts all managed employees.
     *
     * @return the number of employees
     */
    public int countAll() {
        return employees.size();
    }

    /**
     * Counts all permanent employees.
     *
     * @return the number of permanent employees
     */
    public long countPermanentEmployees() {
        long permanentEmployeesCounter = 0;
        for (Employee employee : employees) {
            if (employee instanceof PermanentEmployee) {
                permanentEmployeesCounter++;
            }
        }
        return permanentEmployeesCounter;
    }
}
