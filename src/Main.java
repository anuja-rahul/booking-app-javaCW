import java.util.*;
public class Main {
    // Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {

        String[] bookedSeats = {};

        // construct a new DataHandler object to store all bookings and seat data
        DataHandler dataBase = new DataHandler(bookedSeats);

        int choice = -1;
        while(choice !=0){
            Scanner scan = new Scanner(System.in);
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
                if(choice != 0){
                    System.out.println("\nProceeding !\n");
                    System.out.print("\nEnter your first name: ");
                    String firstName = scan.next();
                    System.out.print("\nEnter your surname: ");
                    String surName = scan.next();
                    System.out.print("\nEnter your email: ");
                    String email = scan.next();
                    Person user = new Person(firstName, surName, email);

                    /*
                    Seats seat = new Seats('1', "A");
                    seat.printAllSeats();
                    */

                    switch (choice){
                        case 1:
                            System.out.print("\nEnter the row (A-D): ");
                            char row = scan.next().charAt(0);
                            System.out.print("\nEnter the column (1-14): ");
                            String column = scan.next();

                            String[] newBooking = {row + column};
                            dataBase.addNewBookedSeat(newBooking);
                            dataBase.updateAvailableSeats();

                            String[] currentlyAvailableSeats = dataBase.getAvailableSeats();
                            Functions.printArrays(currentlyAvailableSeats);

                            /*
                            Seats boughtSeat = new Seats(row, column);
                            boughtSeat.addBooking();
                            boughtSeat.updateAvailableSeats();
                            String[] availableSeat = boughtSeat.getAvailableSeats();
                            String[] booked = boughtSeat.getBookedSeats();
                            boughtSeat.printArrays(booked);
                            System.out.println("\n\n\n");
                            boughtSeat.printArrays(availableSeat);
                             */

                            // Do something more

                        case 2:

                            // Do something else
                    }

                    
                }else{
                    System.out.println("\nClosing !\n");
                    break;
                }
            }else{
                System.out.println("\nInvalid response !\n");
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
}