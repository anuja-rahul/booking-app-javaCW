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
}
