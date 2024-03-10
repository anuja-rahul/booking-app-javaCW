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


}
