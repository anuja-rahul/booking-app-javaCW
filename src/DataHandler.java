public class DataHandler {

    String[] bookedSeats;
    String[] availableSeats = Functions.assignAllSeats();;
    String[] allSeats = Functions.assignAllSeats();
    String[][] seatRecord;

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

    public void updateSeatRecord(String seat){
        int idx = Functions.getIndex(allSeats, seat);
        if (idx != -1){
            String[] tempArray = {seat, String.valueOf(idx)};
            seatRecord = Functions.updateDoubleArray(seatRecord, tempArray);
        }else{
            System.out.println("\nNo such seat found !\n");
        }
    }


    public void addNewBookedSeat(String[] newSeatArray){
        for(String seat: newSeatArray){
            if(Functions.checkArrayValues(seat, availableSeats)){
                this.bookedSeats = Functions.updateArray(this.bookedSeats, seat);
            }
        }
    }

    public void updateAvailableSeats(){
        for (String seat: allSeats){
            if (Functions.checkArrayValues(seat, this.bookedSeats)){
                availableSeats = Functions.removeFromArray(availableSeats, seat);
            }
        }
    }


}
