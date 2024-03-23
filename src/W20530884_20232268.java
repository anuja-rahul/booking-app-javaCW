/*
I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
Any code taken from other sources is referenced below my code.
IIT Student ID: 20232268
UoW Student ID: w20530884
Date: 09/03/2024
*/


import java.util.*;

/**
 * W20530884_20232268 class of the booking-app package.<br><br>
 * The class (W20530884_20232268) includes: <br><br>
 * {@link #getChoice(int) getChoice} <br>
 * {@link #getUserInfo() getUserInfo} <br>
 * {@link #getSeatInfo() getSeatInfo} <br>
 * {@link #manageTicket(String, String, Person, DataHandler, boolean) manageTicket} <br>
 * <br> <br>
 * For additional information, visit the
 * <a href="https://github.com/anuja-rahul/booking-app-javaCW/blob/main/README.md">Documentation</a> or
 * <a href="../Documentation/index.html">Javadoc</a>. <br><br>
 *
 * @author Anuja Rahul Gunasinghe
 * @version 1.0
 */
public class W20530884_20232268 {

    /**
     * Handles every input and output
     * @param args any
     */
    public static void main(String[] args) {

        String[] bookedSeats = {};

        // construct a new DataHandler object to store all bookings and seat data
        DataHandler dataBase = new DataHandler(bookedSeats);
        dataBase.seatRecord = dataBase.initRecords(true);
        dataBase.ticketRecord = dataBase.initRecords(false);

        int choice = -1;
        while(choice !=0){
            Scanner scan = new Scanner(System.in);
            try {
                System.out.println("""

                **********************************************
                *                 MENU OPTIONS               *
                **********************************************
                   1) Buy a seat
                   2) Cancel a seat
                   3) Find first available seat
                   4) Show seating plan
                   5) Print tickets information and total sales
                   6) Search ticket
                   0) Quit
                **********************************************
                
                Enter your response:
                """);

                choice = scan.nextInt();

                if(getChoice(choice)){
                    System.out.println("\nProceeding !\n");

                    if(choice != 0){
                        switch (choice){

                            case 1:
                                String[] userInfo = getUserInfo();
                                Person person = new Person(userInfo[0], userInfo[1], userInfo[2]);
                                // newSeat = {row, column} ex: {"A", "1"}
                                String[] newSeat = getSeatInfo();
                                // newBooking = {row column} ex: {"A1"}
                                String[] newBooking = {newSeat[0] + newSeat[1]};

                                if (Functions.validateSeatInputs(newSeat[0], newSeat[1])){
                                    if (Functions.checkArrayValues(newBooking[0], dataBase.availableSeats)){
                                        dataBase.addNewBookedSeat(newBooking);
                                        dataBase.updateAvailableSeats(true);
                                        dataBase.updateSeatRecord(newBooking, true);

                                        Ticket ticket = manageTicket(newSeat[1], newSeat[0], person, dataBase, true);
                                        FileHandler newTicketFile = new FileHandler(ticket);
                                        newTicketFile.writeToFile(true);
                                        System.out.println("\nBooking Successful !\n");
                                    } else {
                                        System.out.println("\nSeat Unavailable !\n");
                                    }
                                }else {
                                    System.out.println("\nInvalid Seat !\n");
                                }
                                break;

                            case 2:
                                // removeSeat = {row, column} ex: {"A", "1"}
                                String[] removeSeat = getSeatInfo();
                                // removeBooking = {row column} ex: {"A1"}
                                String[] removeBooking = {removeSeat[0] + removeSeat[1]};

                                if (Functions.validateSeatInputs(removeSeat[0], removeSeat[1])){
                                    if (Functions.checkArrayValues(removeBooking[0], dataBase.getBookedSeats())){
                                        // double price = Ticket.getTicketPrice(removeSeat[1]);
                                        // System.out.println("\n" + price + "\n");
                                        dataBase.updateAvailableSeats(false);
                                        dataBase.removeBookedSeat(removeBooking);
                                        dataBase.updateSeatRecord(removeBooking, false);

                                        Person delPerson = new Person("name", "surname", "email");
                                        Ticket ticket = manageTicket(removeSeat[1], removeSeat[0], delPerson, dataBase, false);
                                        FileHandler newTicketFile = new FileHandler(ticket);
                                        newTicketFile.writeToFile(false);

                                    } else {
                                        System.out.println("\nSeat not booked !\n");
                                    }
                                }else {
                                    System.out.println("\nInvalid Seat !\n");
                                }
                                break;

                            case 3:
                                System.out.println("\nNext available seat is: " + dataBase.getFirstAvailableSeat() + "\n");
                                break;

                            case 4:
                                Functions.printSeatingPlan(dataBase.seatRecord);
                                break;

                            case 5:
                                double totalSales = dataBase.getTotalSales();
                                Functions.printArrays(Ticket.getTickets(dataBase.ticketRecord, totalSales));

                                break;

                            case 6:
                                String[] checkSeat = getSeatInfo();
                                String[] seatStatus = dataBase.getSeatInformation(checkSeat);
                                if (seatStatus.length == 1){
                                    System.out.println("\n" + seatStatus[0] + "\n");
                                }else {
                                    System.out.println("\nTicket Information\n__________________\n");
                                    String ticketContent = Functions.formatTicket(seatStatus);
                                    System.out.println(ticketContent + "\n\n");


                                }
                                break;
                        }
                    }else{
                        System.out.println("\nClosing !\n");
                        break;
                    }
                }else{
                    System.out.println("\nInvalid response !\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInput out of range !\n");
            }
        }
    }

    /**
     * Checks the given value against a predetermined set of data.
     * @param choice
     *          integer value of the inputted choice.
     * @return
     *          boolean value depending on the availability of the choice
     */
    private static boolean getChoice(int choice){
        int[] responses = {0, 1, 2, 3, 4, 5, 6};
        boolean present = false;

        for (int response : responses) {
            if (response == choice) {
                present = true;
                break;
            }
        }
        return present;
    }

    /**
     * Prompts the user and requests to input their firstname, surname and email.
     * and returns the taken values as a string array.
     * @return
     *          a string array of inputs
     */
    private static String[] getUserInfo(){
        Scanner scan = new Scanner(System.in);

        System.out.print("\nEnter your first name: ");
        String firstName = scan.next();

        System.out.print("\nEnter your surname: ");
        String surName = scan.next();

        System.out.print("\nEnter your email: ");
        String email = scan.next();

        return new String[]{firstName, surName, email};
    }

    /**
     * Prompts the user and requests to input their choice of seat row and column.
     * and returns the taken values as a string array.
     * @return
     *          a string array of inputs
     */
    private static String[] getSeatInfo(){
        Scanner scan = new Scanner(System.in);

        System.out.print("\nEnter the row (A-D): ");
        char row = scan.next().charAt(0);
        String currentRow = String.valueOf(row).toUpperCase();

        System.out.print("\nEnter the column (1-14): ");
        int column = scan.nextInt();
        String currentColumn = String.valueOf(column);

        return new String[]{currentRow, currentColumn};
    }

    /**
     * Creates a new Ticket object, generate new tickets and update the ticketRecord database.
     * @param column
     *              seat column of user choice
     * @param row
     *              seat row of user choice
     * @param person
     *              a Person object representing the currently active user
     * @param dataBase
     *              a DataHandler object to keep track of every sale and ticket
     * @param bought
     *              if true, ticket will be considered bought and vise versa
     * @return
     *              A new Ticket object containing the all the seat information and a Person object
     */
    private static Ticket manageTicket(String column, String row, Person person, DataHandler dataBase, boolean bought){
        double price = Ticket.getTicketPrice(column);
        Ticket newTicket = new Ticket(column, (row + column), price, person);
        String[] currentTicket = newTicket.generateTicket();
        dataBase.updateTicketRecord(currentTicket, bought);

        return newTicket;
    }
}


/*
References:

    - For further documentation and class diagrams visit:
             https://github.com/anuja-rahul/booking-app-javaCW/blob/main/README.md

    - java record classes:
            https://docs.oracle.com/en/java/javase/22/language/records.html#GUID-6699E26F-4A9B-4393-A08B-1E47D4B2D263
            https://docs.oracle.com/javase/specs/jls/se22/html/jls-8.html#jls-8.10

    -java commenting and documentation:
            https://docs.oracle.com/javase/specs/jls/se22/html/jls-3.html#jls-3.7
*/
