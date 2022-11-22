package Employee.domain;

public class PermanentEmployee extends Employee {
    private long salary;

    public PermanentEmployee(String name) {
        super(name);
    }

    public PermanentEmployee(String name, long salary) {
        super(name);
        setSalary(salary);
    }

    public void setSalary(long salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("salary cannot be negative");
        } else {
            this.salary = salary;
        }
    }

    @Override
    public double calculateHourlyRate() {
        return ((salary * 1.00) / DEFAULT_WORK_DAYS_PER_YEAR) / DEFAULT_WORK_HOURS_PER_DAY;
    }

    @Override
    public String toString() {
        return super.toString() + Payable.getFormattedPayment((salary * 1.00) / 100);
    }
}
