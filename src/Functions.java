/**
 * The class (Functions) includes: <br>
 * {@linkplain #updateArray(String[], String) updateArray} <br>
 * {@linkplain #updateDoubleArray(String[][], String[]) updateDoubleArray} <br>
 * {@linkplain #removeFromArray(String[], String) removeFromArray} <br>
 * {@linkplain #checkArrayValues(String, String[]) checkArrayValues} <br>
 * {@linkplain #getIndex(String[], String) getIndex} <br>
 * {@linkplain #assignAllSeats() assignAllSeats} <br>
 * {@linkplain #printSeatingPlan(String[][]) printSeatingPlan} <br>
 * {@linkplain #validateSeatInputs(String, String) validateSeatInputs} <br>
 * {@linkplain #printArrays(String[]) printArrays} <br>
 * {@linkplain #printDoubleArrays(String[][]) printDoubleArrays} <br>
 *
 * @author
 *          Anuja Rahul Gunasinghe
 */
public class Functions {
    static String[] rows = {"A", "B", "C", "D"};
    static String[] columns = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14"};
    static String[] shortRows = {"B", "C"};
    static String[] shortColumns = {"13", "14"};

    /**
     * Adds a given item to the current array by assigning all the elements of
     * the current array and the new value to a new array with a greater length than
     * the current array and returns the new array.

     * @param currentArray
     *              array that need to be updated.
     * @param value
     *              new value that need to be added to the given array.
     * @return
     *              newly updated array.
     */
    // Since dynamics arrays are prohibited in this coursework.
    public static String[] updateArray(String[] currentArray, String value){
        int newLength = currentArray.length +1;
        String[] newArray = new String[newLength];

        System.arraycopy(currentArray, 0, newArray, 0, currentArray.length);
        newArray[newLength - 1] = value;
        return newArray;
    }

    /**
     * Adds a given value to a specified 2D array.
     * @param currentArray
     *              The 2D array that needs to be changed.
     * @param value
     *              The value array that need to be added to the array.
     * @return
     *              New array containing the given value and the previous array.
     */
    public static String[][] updateDoubleArray(String[][] currentArray, String[] value){
        int newLength = currentArray.length +1;
        String[][] newArray = new String[newLength][2];

        System.arraycopy(currentArray, 0, newArray, 0, currentArray.length);
        newArray[newLength - 1] = value;
        return newArray;
    }

    /**
     * removes a given value from an existing array.
     * @param currentArray
     *              The array that needs to change.
     * @param value
     *              The value that need to be removed from array.
     * @return
     *              the new array without the given value.
     */
    public static String[] removeFromArray(String[] currentArray, String value){
        int count = 0;
        for (String item: currentArray){
            if (item.equals(value)){
                count++;
            }
        }

        String[] newArray = new String[currentArray.length - count];
        int idx = 0;
        for (String item: currentArray){
            if (!item.equals(value)){
                newArray[idx++] = item;
            }
        }
        return newArray;
    }

    /**
     * Checks a given value against a given array and returns true
     * if present and returns false if not found.
     * @param value
     *          the value to be checked against the array.
     * @param array
     *          the array to be checked against the value.
     * @return
     *          true or false depending on the availability of value.
     */
    public static boolean checkArrayValues(String value, String[] array){
        boolean result = false;
        for(String item: array){
            if(item.equals(value)){
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Compare a given String value against a given String[] array
     * and if found, returns the int index of the value in the array.
     * @param array
     *              the given array of Strings.
     * @param value
     *              the string value that need to be checked.
     * @return
     *              int index of the value.
     */
    public static int getIndex(String[] array, String value){
        int index = -1;
        for (int count = 0; count < array.length; count++){
            if (value.equals(array[count])){
                index = count;
                break;
            }
        }
        return index;
    }


    /**
     * returns string[] array of all the seats.
     * from A1 to D14
     * @return
     *          a string array of seat ids.
     */
    public static String[] assignAllSeats(){
        String[] allSeats = {};
        for(String row: rows){
            for(String column: columns){
                if(Functions.checkArrayValues(row, shortRows)){
                    if (!Functions.checkArrayValues(column, shortColumns)) {
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


    /**
     * Depending on the seat record, print the seating plan
     * categorized by availability (O or X).
     * @param seatRecord
     *              String[][] class attribute seatRecord of the DataHandler class.
     */
    public static void printSeatingPlan(String[][] seatRecord){
        System.out.println("\n");
        System.out.print("    1  2  3  4  5  6  7  8  9  10 11 12 13 14\n");
        System.out.print("   __________________________________________\n");
        int count = 0;
        for (String[] record: seatRecord){
            if (count == 0){
                System.out.print("A | ");
            }else if (count == 14){
                System.out.print("\nB | ");
            }else if (count == 26){
                System.out.print("\nC | ");
            } else if (count == 38) {
                System.out.print("\nD | ");
            } else if (count == 52) {
                System.out.print("\n");
            }

            if (!record[1].equals("-1")){
                System.out.print("X  ");
            }else {
                System.out.print("O  ");
            }

            count ++;
        }
        System.out.println("\n");
    }

    public static boolean validateSeatInputs(String row, String column){
        row =  row.toUpperCase();
        boolean result = false;

        if (checkArrayValues(row, rows)){
            if (checkArrayValues(column, columns)){
                String tempSeat = row + column;
                if (checkArrayValues(tempSeat, assignAllSeats())){
                    result = true;
                }
            }
        }
        return result;
    }


    /**
     * Prints out any given string array
     * (for debugging purposes)
     * @param array
     *              The array that needs to be printed.
     */
    public static void printArrays(String[] array){
        for(String item: array){
            System.out.print(item + ", ");
        }
    }

    /**
     * Prints out any given 2D string array
     *        (for debugging purposes)
     * @param array
     *              The 2D array that needs to be printed.
     */
    public static void printDoubleArrays(String[][] array){
        System.out.print("\n\n");
        for(String[] item: array){
            System.out.print(item[0] + ", " + item[1] + "\n");
        }
    }
}
