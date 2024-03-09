public class Ticket {

    public static String[][] ticketPrices = {{"1", "6", "200"}, {"6", "10", "150"}, {"10", "15", "180"}};
    private String row;
    private String seat;
    private double price;
    private Person person;

    public Ticket(String row, String seat, double price, Person person){
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    public static double getPrice(String row){
        int currentRow = Integer.valueOf(row);
        double price = 0;
        for (String[] priceArray: ticketPrices){
            int lowerRange = Integer.valueOf(priceArray[0]);
            int upperRange = Integer.valueOf(priceArray[1]);
            if (currentRow >= lowerRange && currentRow < upperRange){
                price = Integer.valueOf(priceArray[2]);
                break;
            }
        }
        return price;
    }
}
