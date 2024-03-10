public class Ticket {

    public static String[][] ticketPrices = {{"1", "6", "200"}, {"6", "10", "150"}, {"10", "15", "180"}};
    private  String row;
    private  String seat;
    private  double price;
    private  Person person;

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

    public void setRow(String row){
        this.row = row;
    }

    public void setSeat(String seat){
        this.seat = seat;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setPerson(Person person){
        this.person = person;
    }


    public static double getPrice(String column){
        int currentRow = Integer.parseInt(column);
        double price = 0;
        for (String[] priceArray: ticketPrices){
            int lowerRange = Integer.parseInt(priceArray[0]);
            int upperRange = Integer.parseInt(priceArray[1]);
            if (currentRow >= lowerRange && currentRow < upperRange){
                price = Integer.parseInt(priceArray[2]);
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
                String[] dataArray = {record[0], record[2], record[3], record[4], record[5]};

                String currentTicket = Functions.formatTicket(dataArray);
                ticketContents = Functions.updateArray(ticketContents, currentTicket);
            }
        }
        return ticketContents;
    }

}
