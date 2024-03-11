/**
 * The java class Person holds the relevant user information after each purchase of a ticket.
 * <br><br>
 * <p> Usage:
 *     <pre>
 *     {@code
 *     Person person = new Person(name, surname, email);
 *     }
 *     </pre>
 * </p>
 * @author Anuja Rahul Gunasinghe
 * @since  2024-03-10
 * @version 1.0
 *
 */
public class Person {
    private String name;
    private String surname;
    private String email;

    public Person(String name, String surname, String email){
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    //Setters

    public void setName(String name){
        this.name = name;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public void setEmail(String email){
        this.email = email;
    }

    // Getters

    public String getName(){
        return this.name;
    }

    public String getSurname(){
        return this.surname;
    }

    public  String getEmail(){
        return this.email;
    }

}
