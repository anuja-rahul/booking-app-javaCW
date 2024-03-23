/**
 * The record Ticket holds the relevant tickets information and
 * handles the generation and pricing of tickets.
 * <br><br>
 *
 * Usage:
 * <pre>
 *     {@code
 *     Ticket ticket = new Ticket(row, seat, price, person);
 *     }
 *     </pre>
 *
 * @author Anuja Rahul Gunasinghe
 * @version 1.0
 */
public record Ticket(String row, String seat, double price, Person person) {

    public static String[][] ticketPrices = {{"1", "6", "200"}, {"6", "10", "150"}, {"10", "15", "180"}};

    /**
     * Instantiates a new Ticket object
     *
     * @param row    ticket row (A-D)
     * @param seat   ticket column (1-14)
     * @param price  price of the ticket
     * @param person a new Person object of the current user
     */
    public Ticket {
    }

    // Getters were implemented as per the rules of coursework
    // Even though there are no use cases in this particular record
    // And since Ticket is a record there will be no setters
    public String getRow() {
        return row;
    }
    public String getSeat() {
        return seat;
    }
    public double getPrice() {
        return price;
    }
    public Person getPerson() {
        return person;
    }

    /**
     * when the column is given, sorts through the class attribute
     * ticketPrices and returns the price of the ticket.
     * @param column
     *              column of the relevant ticket
     * @return
     *              double value of the price
     */
    public static double getTicketPrice(String column) {
        int currentRow = Integer.parseInt(column);
        double price = 0;
        for (String[] priceArray : ticketPrices) {
            int lowerRange = Integer.parseInt(priceArray[0]);
            int upperRange = Integer.parseInt(priceArray[1]);
            if (currentRow >= lowerRange && currentRow < upperRange) {
                price = Integer.parseInt(priceArray[2]);
                break;
            }
        }
        return price;
    }

    // Getters and Setters were not implemented since there are no use cases for them.

    /**
     * Generates an array including the ticket information.
     * @return a string array of ticket's information
     */
    public String[] generateTicket() {
        // {seat, 1, name, surname, price}
        return new String[]{this.seat, "1", String.valueOf(this.price), this.person.getName(),
                this.person.getSurname(), this.person.getEmail()};
    }

    /**
     * Generates and returns a 2D array of all the ticket sales and user data
     * @param ticketRecord
     *                  Class attribute ticketRecord of the DataHandler class
     * @param totalSales
     *                  Sum of all the ticket sales
     * @return
     *                  a 2D array of ticket sales and user data
     */
    public static String[] getTickets(String[][] ticketRecord, double totalSales) {
        String[] ticketContents = {};
        System.out.println("\nTickets Information\n___________________\n");
        System.out.println("Total Sales: $" + totalSales + "\n\n");

        for (String[] record : ticketRecord) {
            if (Functions.checkArrayValues("1", record)) {
                String currentTicket = Functions.formatTicket(record);
                ticketContents = Functions.updateArray(ticketContents, currentTicket);
            }
        }
        return ticketContents;
    }

}
