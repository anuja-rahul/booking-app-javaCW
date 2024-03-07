public class DataHandler {

    String[] bookedSeats;
    String[] availableSeats = Functions.assignAllSeats();;
    String[] allSeats = Functions.assignAllSeats();

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
