/**
 * The record Person holds the relevant user information after the purchasing of a ticket.<br><br>
 * {@link #getPerson() getPerson}
 * <br><br>
 *
 * Usage:
 * <pre>
 *     {@code
 *     Person person = new Person(name, surname, email);
 *     }
 *     </pre>
 *
 * @author Anuja Rahul Gunasinghe
 * @version 1.0
 */
public record Person(String name, String surname, String email) {
    /**
     * Instantiate a new Person object
     *
     * @param name    first name of the person
     * @param surname surname of the person
     * @param email   email of the person
     */
    public Person {}

    // Getters
    /**
     * gets the name attribute of the Person object
     * @return
     *          name attribute
     */
    public String getName() {
        return this.name;
    }

    /**
     * gets the surname attribute of the Person object
     * @return
     *          surname attribute
     */
    public String getSurname() {
        return this.surname;
    }

    /**
     * gets the email attribute of the Person object
     * @return
     *          email attribute
     */
    public String getEmail() {
        return this.email;
    }

    // And since Person is a record there will be no setters

    // As per the requirements of task 7
    // A method that prints out the person object
    /**
     * Prints out a formatted text containing all the attributes of a Person object
     */
    public void getPerson(){
        System.out.println("\n" + this.name + " " + this.surname + "\n" + this.email);
    }
}
