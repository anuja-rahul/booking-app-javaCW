public class Seats {
    private char row;
    private String column;
    private String seat;

    String[] columns = {"1", "2", "3", "4", "5", "6", "7", "8", "8", "9", "10", "11", "12", "13", "14"};
    String[] rows = {"A", "B", "C", "D"};
    String[] shortRows = {"B", "C"};
    String[] shortColumns = {"13", "14"};

    private String[] bookedSeats = {};

    public String[] allSeats = assignAllSeats();

    public String[] availableSeats = {};

    public Seats(char row, String column){
        this.row = row;
        this.column = column;
        this.seat = row + column;
    }

    // Getters

    public char getRow(){
        return row;
    }

    public String getColumn(){
        return column;
    }

    public String getSeat(){
        return seat;
    }

    public String[] getAllSeats(){
        return allSeats;
    }

    public String[] getBookedSeats(){
        return bookedSeats;
    }

    public String[] getAvailableSeats(){
        return availableSeats;
    }

    public void printArrays(String[] array){
        for(String item: array){
            System.out.print(item + ", ");
        }
    }

    // Setters

    public void setRow(char row){
        this.row = row;
    }

    public void setColumn(String column){
        this.column = column;
    }

    public void setSeat(){
        this.seat = row + column;
    }

    // Public Methods

    public void updateAvailableSeats(){
        // Do something
        for(String openSeat: allSeats){
            if(!Functions.checkArrayValues(openSeat, bookedSeats)){
                // Method update only the current seat
                // Previous bookings not registered
                availableSeats = Functions.updateArray(availableSeats, openSeat);
                // Fix this
            }
        }
    }

    public void addBooking(){
        if(!Functions.checkArrayValues(this.seat, bookedSeats)){
            bookedSeats = Functions.updateArray(bookedSeats, this.seat);
        }else{
            // DO nothing
        }
    }

    // Private Methods

    private String[] assignAllSeats(){
        String[] allSeats = {};
        for(String row: rows){
            for(String column: columns){
                if(Functions.checkArrayValues(row, shortRows)){
                    if(Functions.checkArrayValues(column, shortColumns)){
                        // Do nothing
                        continue;
                    }else{
                        String newSeat = row + column;
                        allSeats = Functions.updateArray(allSeats, newSeat);
                    }
                }else{
                    String newSeat = row + column;
                    allSeats = Functions.updateArray(allSeats, newSeat);
                }
            }
        }
        return  allSeats;
    }


}
