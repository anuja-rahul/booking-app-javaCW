
public class Seats {
    private char row;
    private String column;
    private String seat;

    public String[] allSeats = assignAllSeats();

    public Seats(char row, String column){
        this.row = row;
        this.column = column;
        this.seat = row + column;
    }

    // Getters

    public String[] getAllSeats(){
        return allSeats;
    }

    public char getRow(){
        return row;
    }

    public String getColumn(){
        return column;
    }

    public String getSeat(){
        return seat;
    }

    public void printAllSeats(){
        for(String seat: getAllSeats()){
            System.out.print(seat + ", ");
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

    private String[] assignAllSeats(){
        String[] columns = {"1", "2", "3", "4", "5", "6", "7", "8", "8", "9", "10", "11", "12", "13", "14"};
        String[] rows = {"A", "B", "C", "D"};
        String[] shortRows = {"B", "C"};
        String[] shortColumns = {"13", "14"};
        String[] allSeats = {};

        for(String row: rows){
            for(String column: columns){
                if(checkArrayValues(row, shortRows)){
                    if(checkArrayValues(column, shortColumns)){
                        // Do nothing
                        continue;
                    }else{
                        String newSeat = row + column;
                        allSeats = updateArray(allSeats, newSeat);
                    }
                }else{
                    String newSeat = row + column;
                    allSeats = updateArray(allSeats, newSeat);
                }
            }
        }
        return  allSeats;
    }

    /**
     * Adds a given item to the current array by assigning all the elements of
     * the current array and the new value to a new array with a greater length than
     * the current array and returns the new array.

     * @param currentArray
     *              array that need to be updated.
     * @param value
     *              new value that need to be added to the given array.
     */
    // Since dynamics arrays are prohibited in this coursework.
    private String[] updateArray(String[] currentArray, String value){
        int newLength = currentArray.length +1;
        String[] newArray = new String[newLength];

        for(int count = 0; count < currentArray.length; count++){
            newArray[count] = currentArray[count];
        }
        newArray[newLength - 1] = value;
        return newArray;
    }

    private boolean checkArrayValues(String value, String[] array){
        boolean result = false;
        for(String item: array){
            if(item.equals(value)){
                result = true;
                break;
            }
        }
        return result;
    }
}
