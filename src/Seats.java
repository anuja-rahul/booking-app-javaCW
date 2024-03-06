
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

    public String[] getAllSeats(){
        return allSeats;
    }

    public void printAllSeats(){
        for(String seat: getAllSeats()){
            System.out.print(seat + ", ");
        }
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

    private String[] updateArray(String[] currentArray, String value){
        int newSize = currentArray.length +1;
        String[] newArray = new String[newSize];

        for(int count = 0; count < currentArray.length; count++){
            newArray[count] = currentArray[count];
        }
        newArray[newSize - 1] = value;
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
