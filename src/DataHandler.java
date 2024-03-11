/**
 * The java class DataHandler holds the records of each ticket, purchase, status and
 * contains the methods to modify and update each of these records.
 * <br><br>
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
 * <p> Usage:
 *     <pre>
 *     {@code
 *     // Initializing an object and seat/ticket records
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
 *     // Removing a existing booking record
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
 * </p>
 * @author Anuja Rahul Gunasinghe
 * @since  2024-03-10
 * @version 1.0
 */
public class DataHandler {

    String[] bookedSeats;
    String[] availableSeats = Functions.assignAllSeats();
    String[] allSeats = Functions.assignAllSeats();
    String[][] seatRecord = new String[52][2];

    String[][] ticketRecord = new String[52][3];

    public DataHandler(String[] bookedSeats){
        this.bookedSeats = bookedSeats;
    }

    // Getters
    public String[] getBookedSeats(){
        return this.bookedSeats;
    }

    public String[] getAvailableSeats(){
        return this.availableSeats;
    }

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

    public void updateSeatRecord(String[] seat, boolean booked){
        int idx = Functions.getIndex(allSeats, seat[0]);
        if (booked){
            seatRecord[idx][1] = "1";
        }else{
            seatRecord[idx][1] = "-1";
        }
    }

    public void updateTicketRecord(String[] ticket, boolean bought){
        int idx = Functions.getIndex(allSeats, ticket[0]);
        if (bought){
            ticketRecord[idx] = ticket;
        }else {
            ticketRecord[idx] = new String[]{allSeats[idx], "-1", "0", "0", "0", "0"};
        }
    }

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

    public void addNewBookedSeat(String[] newSeatArray){
        for(String seat: newSeatArray){
            if(Functions.checkArrayValues(seat, availableSeats)){
                this.bookedSeats = Functions.updateArray(this.bookedSeats, seat);
            }
        }
    }

    public void removeBookedSeat(String[] removedSeatArray){
        for (String seat: removedSeatArray){
            if (!Functions.checkArrayValues(seat, availableSeats)){
                this.bookedSeats = Functions.removeFromArray(this.bookedSeats, seat);
            }
        }
    }

    public void updateAvailableSeats(boolean booking){
        for (String seat: allSeats){
            if (booking){
                if (Functions.checkArrayValues(seat, this.bookedSeats)){
                    availableSeats = Functions.removeFromArray(availableSeats, seat);
                }
            }else {
                if (!Functions.checkArrayValues(seat, this.bookedSeats)){
                    availableSeats = Functions.updateArray(availableSeats, seat);
                }
            }
        }
    }


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
