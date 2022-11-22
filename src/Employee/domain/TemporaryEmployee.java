package Employee.domain;

public class TemporaryEmployee extends Employee {
    private long hourlyRate;

    public TemporaryEmployee(String name) {
        super(name);
    }

    public TemporaryEmployee(String name, long hourlyRate) {
        super(name);
        setHourlyRate(hourlyRate);
    }

    public void setHourlyRate(long hourlyRate) {
        if (hourlyRate < 0) {
            throw new IllegalArgumentException("Hourly Rate cannot be negative");
        } else {
            this.hourlyRate = hourlyRate;
        }
    }

    @Override
    public double calculateHourlyRate() {
        return this.hourlyRate * 1.00;
    }

    @Override
    public String toString() {
        return super.toString() + Payable.getFormattedPayment((hourlyRate * 1.00) / 100);
    }
}
