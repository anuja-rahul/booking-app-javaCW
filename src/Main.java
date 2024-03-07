import java.util.*;
public class Main {
    // Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {

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