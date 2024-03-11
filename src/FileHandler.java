import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The java class FileHandler holds all the methods related to
 * creation, editing and deletion of ticket text files.
 * {@link #createDirectory() createDirectory} <br>
 * {@link #writeToFile(boolean) writeToFile} <br>
 * <br><br>
 *  <p> Usage:
 *      <pre>
 *      {@code
 *      FileHandler fileHandler = new FileHandler(ticket);
 *      // Creates a file
 *      fileHandler.writeToFile(true);
 *      // Deletes a file
 *      fileHandler.writeToFile(false);
 *      }
 *      </pre>
 *  </p>
 * @author Anuja Rahul Gunasinghe
 * @since  2024-03-10
 * @version 1.0
 *
 */
public class FileHandler {

    final String rootPath = "tickets/";
    final File folderPath = new File("tickets");
    Ticket ticket;

    public FileHandler(Ticket ticket){
        createDirectory();
        this.ticket = ticket;
    }

    private void createDirectory(){
        if (!folderPath.exists()){
            folderPath.mkdirs();
        }
    }

    public void writeToFile(boolean write){

        String seat = this.ticket.getSeat();
        String fileName = rootPath + seat + ".txt";
        double price = this.ticket.getPrice();

        Person person = this.ticket.getPerson();
        String name =  person.getName();
        String surName = person.getSurname();
        String email = person.getEmail();
        String[] dataArray = {seat, "1", String.valueOf(price), name, surName, email};

        if (write){
            String fileContent = Functions.formatTicket(dataArray);

            try {
                FileWriter ticketFile = new FileWriter(fileName);
                ticketFile.write(fileContent);
                ticketFile.close();
            } catch (IOException e){
                System.out.println("Error writing to file !\n");
            }
        }else {
            File ticketFile = new File(fileName);
            if (ticketFile.exists()){
                ticketFile.delete();
            }
        }
    }



}
