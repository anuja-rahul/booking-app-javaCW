![Java](https://img.shields.io/badge/java-000?style=for-the-badge&logo=openjdk&logoColor=f89820)

### Booking App (SD-02) `coursework`  

---

#### Note

- As per the rules of coursework no dynamic arrays or any external
packages were used.

- Only some of the basic data types were used:
    - char
    - double
    - boolean
    - int
    - String
    - String[]
    - String[][]

---

![Mermaid](https://img.shields.io/badge/Mermaid-000?style=for-the-badge&logo=mermaid)
![Markdown](https://img.shields.io/badge/Markdown-000?style=for-the-badge&logo=markdown)


```mermaid

classDiagram
    
    note "* This is a class diagram representation of the booking app"
    note "+ public"
    note "- private"
    
    direction RL
    
  W20530884_20232268_booking_app -- Ticket
  Functions <.. DataHandler
  Functions <.. Ticket
  Functions <.. FileHandler
  W20530884_20232268_booking_app ..> DataHandler
  W20530884_20232268_booking_app -- Person
  W20530884_20232268_booking_app ..> Functions
  Ticket *-- Person
  FileHandler *-- Ticket
  
  W20530884_20232268_booking_app: +String[] args
  W20530884_20232268_booking_app: -buySeat(DataHandler)
  W20530884_20232268_booking_app: -cancelSeat(DataHandler)
  W20530884_20232268_booking_app: -printTickets(DataHandler)
  W20530884_20232268_booking_app: -searchTickets(DataHandler)
  W20530884_20232268_booking_app: -getChoice(int)
  W20530884_20232268_booking_app: -getUserInfo()
  W20530884_20232268_booking_app: -getSeatInfo()
  W20530884_20232268_booking_app: -manageTicket(String, String, Person, DataHandler, boolean)
  
  class DataHandler{
    +String[] bookedSeats
    +String[] availableSeats
    +String[] allSeats
    +String[][] seatRecord
    +String[][] ticketRecord
    +getBookedSeats() String[]
    +initRecords(boolean) String[][]
    +updateSeatRecord(String[], boolean) 
    +updateTicketRecord(String[], boolean)
    +getTotalSales() double
    +addNewBookedSeat(String[]) 
    +removeBookedSeat(String[])
    +updateAvailableSeats(boolean)
    +getFirstAvailableSeat() String
    +getSeatInformation(String[]) String[]
  }

  class FileHandler{
    +String rootPath
    +File folderPath
    +Ticket ticket
    -createDirectory()
    +writeToFile(boolean)
  }

  class Ticket{
    +String row
    +String seat
    +double price
    +Person person
    +getTicketPrice(String)
    +generateTicket()
    +saveTicket(boolean)
    +getTickets(String[][], double)
    +getTicket()
  }

  class Person{
    +String name
    +String surname
    +String email
    +getName()
    +getSurname()
    +getEmail()
    +getPerson()
  }

  class Functions{
    +String[] rows
    +String[] columns
    +String[] shortRows
    +String[] shortColumns
    +updateArray(String[], String)
    +removeFromArray(String[], String)
    +checkArrayValues(String, String[])
    +getIndex(String[], String)
    +assignAllSeats()
    +printSeatingPlan(String[][])
    +validateSeatInputs(String, String)
    +printArrays(String[])
    +formatTicket(String[])
  }

  

```

---




