package ro.siit;

public class Person {
    String firstName;
    String lastName;
    String month;

    public String getFirstName() {
        return firstName;
    }

    public Person(String firstName, String lastName, String month) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.month = month;
    }

    @Override
    public String toString() {
        return "\nFirst name: " + firstName + "\n"
                + "Last name: " + lastName + "\n";
    }
}




