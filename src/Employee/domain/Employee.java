package Employee.domain;

import java.util.Objects;

public abstract class Employee implements Payable {
    private final String name;

    public Employee(String name) {
        if ((name == null) || (name.isEmpty() || name.isBlank())) {
            throw new IllegalArgumentException("name cannot be null or empty string");
        } else {
            this.name = name;
        }
    }

    /**
     * Creates an employee from a given csv-String.
     *
     * @param csv the csv Values: type, name, payment
     * @return the newly created employee
     */
    public static Employee of(String csv) {
        String[] employeeData = csv.split(",");
        if (employeeData.length != 3) {
            throw new IllegalArgumentException("input formatted wrong");
        }
        long moneyAsLong;
        try {
            double money = Double.parseDouble(employeeData[2]);
            moneyAsLong = Double.valueOf(money * 100.00).longValue();

        } catch (Exception e) {
            throw new IllegalArgumentException("input formatted wrong");
        }

        switch (employeeData[0]) {
            default -> throw new IllegalArgumentException("input formatted wrong");

            case ("P") -> {
                return new PermanentEmployee(employeeData[1], moneyAsLong);
            }

            case ("T") -> {
                return new TemporaryEmployee(employeeData[1], moneyAsLong);
            }

            case ("C") -> {
                return new ContractEmployee(employeeData[1], moneyAsLong);
            }
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Employee employee = (Employee) o;
        return name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return String.format("%s, ", name);
    }
}
