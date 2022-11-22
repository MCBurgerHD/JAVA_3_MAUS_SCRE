package Employee_Alt;

/**
 * Created: 22.09.2022
 *
 * @author Maximilian Ertl (maxer)
 */
public class PermanentEmployee extends Employee{

    private long salary;

    public PermanentEmployee(String name) {
        super(name);
    }

    @Override
    public double calculateHourlyRate() {
        return (salary / 12) / 24;
    }
}
