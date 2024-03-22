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
    - int[]
    - String
    - String[]
    - String[][]

---

<!--

```mermaid

pie
    title data distribution
    "food" : 60
    "water" : 40
```

-->

```mermaid

classDiagram
    W20530884_20232268 <|-- DataHandler
    W20530884_20232268 <|-- FileHandler
    W20530884_20232268 <|-- Ticket
    W20530884_20232268 <|-- Person
    W20530884_20232268 <|-- Functions
    W20530884_20232268 : +String[] args
    W20530884_20232268: +getChoice()
    W20530884_20232268: +getUserInfo()
    W20530884_20232268: +getSeatInfo()
    class DataHandler{
      +String[] bookedSeats
      +String[] availableSeats
      +String[] allSeats
      +String[][] seatRecord
      +String[][] ticketRecord
      +initRecords(boolean)
      +updateSeatRecord(String[], boolean)
      +updateTicketRecord(String[], boolean)
      +getTotalSales()
      +addNewBookedSeat(String[])
      +removeBookedSeat(String[])
      +updateAvailableSeats(boolean)
      +getFirstAvailableSeat()
      +getSeatInformation(String[])
    }

    class FileHandler{
      -String rootPath
      -File folderPath
      -Ticket ticket
      -createDirectory()
      -writeToFile(boolean)
    }

    class Ticket{
        -String row
        -String seat
        -double price
        -Person person
        +getTicketPrice(String)
        +generateTicket()
        +getTickets(String[][], double)
    }

    class Person{
        -String name
        -String surname
        -String email
        +getName()
        +getSurname()
        +getEmail()
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





