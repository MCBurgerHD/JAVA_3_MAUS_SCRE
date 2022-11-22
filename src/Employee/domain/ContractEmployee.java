package Employee.domain;

public class ContractEmployee extends Employee {

    private long dailyRate;

    public ContractEmployee(String name) {
        super(name);
    }

    public ContractEmployee(String name, long dailyRate) {
        super(name);
        setDailyRate(dailyRate);
    }

    public void setDailyRate(long dailyRate) {
        if (dailyRate < 0) {
            throw new IllegalArgumentException("Daily Rate cannot be negative");
        } else {
            this.dailyRate = dailyRate;
        }
    }


    @Override
    public double calculateHourlyRate() {
        return (dailyRate * 1.00) / DEFAULT_WORK_HOURS_PER_DAY;
    }

    @Override
    public String toString() {
        return super.toString() + Payable.getFormattedPayment((dailyRate * 1.00) / 100);
    }
}
