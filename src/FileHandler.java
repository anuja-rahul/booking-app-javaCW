import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class FileHandler {

    final String rootPath = "tickets/";
    final File folderPath = new File("tickets");
    String fileName;
    String ticketContent;

    Ticket ticket;

    public FileHandler(Ticket ticket){
        createDirectory();
        this.ticket = ticket;
    }

    public void createDirectory(){
        if (!folderPath.exists()){
            folderPath.mkdirs();
        }
    }

    public void writeToFile(){
        // Do something
        String seat = this.ticket.getSeat();
        String fileName = rootPath + seat + ".txt";
        double price = this.ticket.getPrice();
        Person person = this.ticket.getPerson();
        String name =  person.getName();
        String surName = person.getSurname();
        String email = person.getEmail();

        String fileContent = """
                Seat:   %s
                Price:  $%.2f
                Name:   %s %s
                e-mail: %s
                """.formatted(seat, price, name, surName, email);

        try {
            FileWriter ticketFile = new FileWriter(fileName);
            ticketFile.write(fileContent);
            ticketFile.close();
        } catch (IOException e){
            System.out.println("Error writing to file !\n");
        }
    }

}
