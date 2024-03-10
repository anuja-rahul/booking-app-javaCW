public class Ticket {

    public static String[][] ticketPrices = {{"1", "6", "200"}, {"6", "10", "150"}, {"10", "15", "180"}};
    private final String row;
    private final String seat;
    private final double price;
    private final Person person;

    public Ticket(String row, String seat, double price, Person person){
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    // Getters

    public String getRow(){
        return this.row;
    }

    public String getSeat(){
        return this.seat;
    }

    public double getPrice(){
        return this.price;
    }

    public Person getPerson(){
        return this.person;
    }

    // Setters

    public static double getPrice(String column){
        int currentRow = Integer.valueOf(column);
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

    public String[] generateTicket(){
        // {seat, 1, price}
        return new String[]{this.seat, "1", String.valueOf(this.price), this.person.getName(),
                this.person.getSurname(), this.person.getEmail()};
    }

    public static String[] getTickets(String[][] ticketRecord, double totalSales){
        String[] ticketContents = {};
        System.out.println("\nTickets Information\n___________________\n");
        System.out.println("Total Sales: $" + totalSales + "\n\n");

        for (String[] record: ticketRecord){
            if (Functions.checkArrayValues("1", record)){

                String seat = record[0];
                double price = Double.valueOf(record[2]);
                String name = record[3];
                String surName = record[4];
                String email = record[5];

                String currentTicket = Functions.formatTicket(seat, name, surName, email, price);
                ticketContents = Functions.updateArray(ticketContents, currentTicket);
            }
        }
        return ticketContents;
    }

}
