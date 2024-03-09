/*
I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
Any code taken from other sources is referenced below my code.
IIT Student ID: 20232268
UoW Student ID: w20530884
Date: 09/03/2024
 */


import java.util.*;

/**
 * Main class for booking-app package.<br>
 * The class (Main) includes: <br>
 * {@linkplain #getChoice(int) getChoice} <br>
 * {@linkplain #getUserInfo() getUserInfo} <br>
 * {@linkplain #getSeatInfo() getSeatInfo} <br>
 *
 * <br> <br>
 * For additional information, visit the
 * <a href="https://github.com/anuja-rahul/booking-app-javaCW/blob/main/README.md">Documentation</a>.
 *
 * @author
 *          Anuja Rahul Gunasinghe
 */
public class Main {
    // Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {

        String[] bookedSeats = {};

        // construct a new DataHandler object to store all bookings and seat data
        DataHandler dataBase = new DataHandler(bookedSeats);
        // System.out.print(dataBase.allSeats.length);
        dataBase.seatRecord = dataBase.initRecords();
        dataBase.ticketRecord = dataBase.initRecords();

        String[] userInfo = getUserInfo();
        Person person = new Person(userInfo[0], userInfo[1], userInfo[2]);

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

                    /*
                    Seats seat = new Seats('1', "A");
                    seat.printAllSeats();
                    */

                        switch (choice){
                            case 1:
                                // newSeat = {row, column} ex: {"A", "1"}
                                String[] newSeat = getSeatInfo();
                                // newBooking = {row column} ex: {"A1"}
                                String[] newBooking = {newSeat[0] + newSeat[1]};

                                if (Functions.validateSeatInputs(newSeat[0], newSeat[1])){

                                    double price = Ticket.getPrice(newSeat[0]);
                                    Ticket addTicket = new Ticket(newSeat[0], newBooking[0], price, person);
                                    dataBase.addNewBookedSeat(newBooking);
                                    dataBase.updateAvailableSeats(true);

                                    // String[] currentlyAvailableSeats = dataBase.getAvailableSeats();
                                    // Functions.printArrays(currentlyAvailableSeats);
                                    dataBase.updateSeatRecord(newBooking, true);
                                }else {
                                    System.out.println("\nInvalid Seat !\n");
                                }
                                // Functions.printDoubleArrays(dataBase.seatRecord);
                                break;

                            case 2:
                                // removeSeat = {row, column} ex: {"A", "1"}
                                String[] removeSeat = getSeatInfo();
                                // removeBooking = {row column} ex: {"A1"}
                                String[] removeBooking = {removeSeat[0] + removeSeat[1]};
                                if (Functions.validateSeatInputs(removeSeat[0], removeSeat[1])){

                                    double price = Ticket.getPrice(removeSeat[0]);
                                    Ticket deleteTicket = new Ticket(removeSeat[0], removeBooking[0], price, person);

                                    dataBase.removeBookedSeat(removeBooking);
                                    dataBase.updateSeatRecord(removeBooking, false);
                                }else {
                                    System.out.println("\nInvalid Seat !\n");
                                }
                                break;

                            // Do something else

                            case 3:
                                System.out.println("\nNext available seat is: " + dataBase.getFirstAvailableSeat() + "\n");
                                // Do something else
                                break;

                            case 4:
                                Functions.printSeatingPlan(dataBase.seatRecord);
                                break;

                            case 5:
                                // Make ticket class
                                break;

                            case 6:
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
                System.out.println("\nInput must be in range (0-6)");
            }
        }

    }

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

    private static String[] getSeatInfo(){
        Scanner scan = new Scanner(System.in);

        System.out.print("\nEnter the row (A-D): ");
        char row = scan.next().charAt(0);
        String currentRow = String.valueOf(row).toUpperCase();

        System.out.print("\nEnter the column (1-14): ");
        String column = scan.next();

        return new String[]{currentRow, column};
    }
}


/*
For further references, control flow diagrams and documentation visit:
    https://github.com/anuja-rahul/booking-app-javaCW/blob/main/README.md
 */
