package Employee_Alt;

import java.util.Objects;

public abstract class Employee implements Payable{
    private String name;

    public Employee(String name) {
        if (name == null || name == "") {
            throw new IllegalArgumentException("Name ist NULL oder NICHT Vorhanden!");
        }
        this.name = name;
    }

    /**
     * Creates an employee from a given csv-String.
     *
     * @param csv the csv Values: type, name, payment
     * @return the newly created employee
     */
    public static Employee of(String csv) {
        String[] str = csv.split(",");
       // Employee employee = new Employee(str[1]);
        //return employee;
        throw new UnsupportedOperationException("TODO");
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
    public abstract double calculateHourlyRate();
}
