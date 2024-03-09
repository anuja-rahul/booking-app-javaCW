public class Functions {

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

        for(int count = 0; count < currentArray.length; count++){
            newArray[count] = currentArray[count];
        }
        newArray[newLength - 1] = value;
        return newArray;
    }

    public static String[][] updateDoubleArray(String[][] currentArray, String[] value){
        int newLength = currentArray.length +1;
        String[][] newArray = new String[newLength][2];

        for(int count = 0; count < currentArray.length; count++){
            newArray[count] = currentArray[count];
        }
        newArray[newLength - 1] = value;
        return newArray;
    }

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


    public static String[] assignAllSeats(){
        String[] columns = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14"};
        String[] rows = {"A", "B", "C", "D"};
        String[] shortRows = {"B", "C"};
        String[] shortColumns = {"13", "14"};
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

    public static void printArrays(String[] array){
        for(String item: array){
            System.out.print(item + ", ");
        }
    }

    public static void printDoubleArrays(String[][] array){
        System.out.print("\n\n");
        for(String[] item: array){
            System.out.print(item[0] + ", " + item[1] + "\n");
        }
    }
}
