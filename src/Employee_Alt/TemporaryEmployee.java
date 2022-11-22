package Employee_Alt;

/**
 * Created: 22.09.2022
 *
 * @author Maximilian Ertl (maxer)
 */
public class TemporaryEmployee extends Employee{

    private long hourlyRate;

    public TemporaryEmployee(String name) {
        super(name);
    }
    
    @Override
    public double calculateHourlyRate() {
        return hourlyRate;
    }

}
