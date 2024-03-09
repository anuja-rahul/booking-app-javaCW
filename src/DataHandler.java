public class DataHandler {

    String[] bookedSeats;
    String[] availableSeats = Functions.assignAllSeats();;
    String[] allSeats = Functions.assignAllSeats();
    String[][] seatRecord = new String[52][2];

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

    public  String[][] initSeatRecord(){
        String[][] tempRecord = new String[52][2];
        int idx = 0;
        for (String seat: allSeats){
            tempRecord[idx][0] = seat;
            tempRecord[idx][1] = "-1";
            idx ++;
        }
        return tempRecord;
    }

    public void updateSeatRecord(String[] seat){
        int idx = Functions.getIndex(allSeats, seat[0]);
        seatRecord[idx][1] = "1";
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
