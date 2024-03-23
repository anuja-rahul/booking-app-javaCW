/**
 * The java class DataHandler holds the records of each ticket, purchase, status and
 * contains the methods to modify and update each of these records. <br>
 * {@link #initRecords(boolean) initRecords} <br>
 * {@link #updateSeatRecord(String[], boolean) updateSeatRecord} <br>
 * {@link #updateTicketRecord(String[], boolean) updateTicketRecord} <br>
 * {@link #getTotalSales() getTotalSales} <br>
 * {@link #addNewBookedSeat(String[]) addNewBookedSeat} <br>
 * {@link #removeBookedSeat(String[]) removeBookedSeat} <br>
 * {@link #updateAvailableSeats(boolean) updateAvailableSeats} <br>
 * {@link #getFirstAvailableSeat() getFirstAvailableSeat} <br>
 * {@link #getSeatInformation(String[]) getSeatInformation} <br>
 * <br><br>
 * 
 * Usage:
 *     <pre>
 *     {@code
 *     // Initializing an object and assigning default values to seat & ticket records
 *     DataHandler dataBase = new DataHandler(bookedSeats);
 *     dataBase.seatRecord = dataBase.initRecords(true);
 *     dataBase.ticketRecord = dataBase.initRecords(false);
 *
 *
 *     // Adding a new booking record
 *     database.addNewBookedSeat(newSeatArray);
 *     database.updateAvailableSeats(true);
 *     database.updateSeatRecord(seat, true);
 *     dataBase.updateTicketRecord(currentTicket, true);
 *
 *     // Removing an existing booking record
 *     database.removeBookedSeat(removedSeatArray);
 *     database.updateAvailableSeats(false);
 *     database.updateSeatRecord(seat, false);
 *     dataBase.updateTicketRecord(currentTicket, false);
 *
 *     // Getting the first available seat
 *     String seat = database.getFirstAvailableSeat();
 *
 *     // Checking seat availability
 *     String[] result = database.getSeatInformation(seatInfo);
 *
 *     // Get the total of all sold tickets
 *     double sales =  database.getTotalSales();
 *
 *     }
 *     </pre>
 *
 * @author Anuja Rahul Gunasinghe
 * @version 1.0
 */
public class DataHandler {

    String[] bookedSeats;
    String[] availableSeats = Functions.assignAllSeats();
    String[] allSeats = Functions.assignAllSeats();
    String[][] seatRecord = new String[52][2];

    String[][] ticketRecord = new String[52][3];

    /**
     * constructor for the DataHandler class
     * @param bookedSeats
     *                  an array containing booked seats of current instance
     */
    public DataHandler(String[] bookedSeats){
        this.bookedSeats = bookedSeats;
    }

    // Getters
    public String[] getBookedSeats(){
        return this.bookedSeats;
    }

    // Setters were implemented as per the rules of coursework
    // Even though there are no use cases in this particular class
    public void setBookedSeats(String[] bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    /**
     * assign records for seatRecord and ticketRecord class attributes.
     * @param seats
     *              if true, proceeds for seatRecord and if false, proceeds for ticketRecord
     * @return
     *              a temporary array containing placeholder values until new values are assigned
     */
    public  String[][] initRecords(boolean seats){
        String[][] tempRecord = new String[52][2];
        if (!seats){
            tempRecord = new String[52][6];
        }
        int idx = 0;
        for (String seat: allSeats){
            tempRecord[idx][0] = seat;
            tempRecord[idx][1] = "-1";
            if (!seats){
                tempRecord[idx][2] = "0";
                tempRecord[idx][3] = "0";
                tempRecord[idx][4] = "0";
                tempRecord[idx][5] = "0";
            }
            idx ++;
        }
        return tempRecord;
    }

    /**
     * Updates the seatRecord according to the given parameters
     * @param seat
     *              an array containing the seat row and column
     * @param booked
     *              assigns a validation mark depending on true/false <br>
     *              (1) for booked and (-1) for available
     */
    public void updateSeatRecord(String[] seat, boolean booked){
        int idx = Functions.getIndex(allSeats, seat[0]);
        if (booked){
            seatRecord[idx][1] = "1";
        }else{
            seatRecord[idx][1] = "-1";
        }
    }

    /**
     * Updates the seatRecord according to the given parameters
     * @param ticket
     *              an array containing the ticket's information
     * @param bought
     *              assigns a validation mark depending on true/false
     */
    public void updateTicketRecord(String[] ticket, boolean bought){
        int idx = Functions.getIndex(allSeats, ticket[0]);
        if (bought){
            ticketRecord[idx] = ticket;
        }else {
            ticketRecord[idx] = new String[]{allSeats[idx], "-1", "0", "0", "0", "0"};
        }
    }

    /**
     * Calculates the total sales amount
     * @return
     *          the double value of total sales
     */
    public double getTotalSales(){
        int idx = 0;
        double total = 0;
        for (String[] ticket: ticketRecord){
            if (Functions.checkArrayValues("1", ticket)){
                String[] currentRecord = ticketRecord[idx];
                double currentRecordValue = Double.parseDouble(currentRecord[2]);
                total = total + currentRecordValue;
            }
            idx ++;
        }
        return total;
    }

    /**
     * Adds a new booking to the object attribute bookedSeats
     * @param newSeatArray
     *              an array containing the seat row and column
     */
    public void addNewBookedSeat(String[] newSeatArray){
        for(String seat: newSeatArray){
            if(Functions.checkArrayValues(seat, availableSeats)){
                this.bookedSeats = Functions.updateArray(this.bookedSeats, seat);
            }
        }
    }

    /**
     * removes a pre-existing booking from the object attribute bookedSeats
     * @param removedSeatArray
     *              an array containing the seat row and column
     */
    public void removeBookedSeat(String[] removedSeatArray){
        for (String seat: removedSeatArray){
            if (!Functions.checkArrayValues(seat, availableSeats)){
                this.bookedSeats = Functions.removeFromArray(this.bookedSeats, seat);
            }
        }
    }

    /**
     * updates the class attribute availableSeats according to the updated object attribute bookedSeats
     * @param booking
     *              if true, removes the seat from availableSeats and vise versa
     */
    public void updateAvailableSeats(boolean booking){
        for (String seat: allSeats){
            if (Functions.checkArrayValues(seat, this.bookedSeats)){
                if (booking){
                    availableSeats = Functions.removeFromArray(availableSeats, seat);
                } else {
                    availableSeats = Functions.updateArray(availableSeats, seat);
                }
                break;
            }
        }
    }

    /**
     * sorts through the seatRecord and checks for predetermined validation markers. <br>
     * if (-1), seat is available and if (1), seat is booked.
     * @return
     *          the first ever record that comes across with a validation marker (-1)
     */
    public String getFirstAvailableSeat(){
        String result = "0";
        for (String[] record: seatRecord){
            if (record[1].equals("-1")){
                result = record[0];
                break;
            }
        }
        return result;
    }

    /**
     * Sorts through the ticketRecord and checks to see if the given seat is available or booked. <br>
     * if booked, returns the information about the ticket and user.
     * @param seatInfo
     *              an array containing the seat row and column
     * @return
     *              an array containing the booking information or the availability of the seat
     */
    public String[] getSeatInformation(String[] seatInfo){
        String[] result;
        String[] currentSeat = {};
        String seatName = seatInfo[0] + seatInfo[1];
        for (String[] seat: ticketRecord){
            if (seat[0].equals(seatName)){
                currentSeat = seat;
                break;
            }
        }
        if (currentSeat[1].equals("1")){
            result = currentSeat;
        }else {
            result = new String[]{"This seat is available !"};
        }
        return result;
    }


}
