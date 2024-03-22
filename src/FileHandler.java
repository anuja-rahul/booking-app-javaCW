import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The java class FileHandler holds all the methods related to
 * creation, editing and deletion of ticket text files.
 * {@link #createDirectory() createDirectory} <br>
 * {@link #writeToFile(boolean) writeToFile} <br>
 * <br><br>
 *
 *  Usage:
 *      <pre>
 *      {@code
 *      FileHandler fileHandler = new FileHandler(ticket);
 *      // Creates a file
 *      fileHandler.writeToFile(true);
 *      // Deletes a file
 *      fileHandler.writeToFile(false);
 *      }
 *      </pre>
 *
 * @author Anuja Rahul Gunasinghe
 * @version 1.0
 *
 */
public class FileHandler {

    final String rootPath = "tickets/";
    final File folderPath = new File("tickets");
    Ticket ticket;

    /**
     * Instantiate a new FileHandler object
     * @param ticket
     *              a new Ticket object
     */
    public FileHandler(Ticket ticket){
        createDirectory();
        this.ticket = ticket;
    }

    /**
     * Checks for a specific directory  and if it doesn't exist, <br>
     * creates the directory each time an object is instantiated.
     */
    private void createDirectory(){
        if (!folderPath.exists()){
            folderPath.mkdirs();
        }
    }

    /**
     * Either creates a new ticket file or deletes a pre-existing ticket file depending on the given parameters.
     * @param write
     *              if true, creates a new ticket file and vise versa.
     */
    public void writeToFile(boolean write){

        String seat = this.ticket.seat();
        String fileName = rootPath + seat + ".txt";
        double price = this.ticket.price();

        Person person = this.ticket.person();
        String name =  person.name();
        String surName = person.surname();
        String email = person.email();
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
