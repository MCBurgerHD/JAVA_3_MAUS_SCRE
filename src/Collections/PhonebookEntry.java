package Collections;

/**
 * Created: 20.10.2022
 *
 * @author Maximilian Ertl (maxer)
 */
public  class  PhonebookEntry {
    private  String  number;
    private  String  name;

    public PhonebookEntry() {}

    public PhonebookEntry(String number) {
        setNumber(number);
    }
    public PhonebookEntry(String number, String name) {
        setNumber(number);
        setName(name);
    }

    @Override
    public boolean equals(Object str) {
        if (this == str) {
            return true;
        }
        if (str == null || getClass() != str.getClass()) {
            return false;
        }
        PhonebookEntry ergebnis = (PhonebookEntry) str;
        return this.number.equals(ergebnis.number);
    }

    @Override
    public int hashCode() {
        return number.hashCode();
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name ist NULL!");
        }
        else {
            this.name = name;
        }
    }

    public void setNumber(String number) {
        if (number == null) {
            throw new IllegalArgumentException("Nummer ist NULL!");
        }
        if (number.matches("^0[1-9][0-9]+$") || number.matches("^00[1-9][0-9]*$") ||
                number.matches("^\\+[1-9][0-9]*$")) {
            this.number = number;
        }
        else {
            throw new IllegalArgumentException("Nummer ist ungueltig!");
        }
    }

    @Override
    public String toString() {
        return name + " : " + number;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public int compareTo(PhonebookEntry phonebookEntry) {
        return this.name.compareToIgnoreCase(phonebookEntry.getName());
    }
}
