package Employee_Alt;

/**
 * Created: 22.09.2022
 *
 * @author Maximilian Ertl (maxer)
 */
public class ContractEmployee extends Employee{

    private long dailyRate;

    public ContractEmployee(String name) {
        super(name);
    }

    @Override
    public double calculateHourlyRate() {
        return dailyRate / 24;
    }
}
