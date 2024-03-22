/**
 * The record Person holds the relevant user information after the purchasing of a ticket.
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

}
