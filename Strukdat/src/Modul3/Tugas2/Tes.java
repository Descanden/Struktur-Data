package Modul3.Tugas2;

class Ticket {
    public String name;
    public int quantity;
    public int ticketNumber;

    public Ticket(String name, int quantity, int ticketNumber) {
        this.name = name;
        this.quantity = quantity;
        this.ticketNumber = ticketNumber;
    }

    public void displayTicket() {
        System.out.println("Ticket Number: " + ticketNumber + ", Name: " + name + ", Quantity: " + quantity);
    }
}

class Link {
    public Ticket data;
    public Link next;

    public Link(Ticket data) {
        this.data = data;
    }

    public void displayLink() {
        data.displayTicket();
    }
}

class FirstLastList {
    public Link first;
    public Link last;

    public FirstLastList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertLast(Ticket dd) {
        Link newLink = new Link(dd);
        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
        }
        last = newLink;
    }

    public Ticket deleteFirst() {
        if (!isEmpty()) {
            Ticket temp = first.data;
            first = first.next;
            if (first == null) {
                last = null;
            }
            return temp;
        }
        throw new IllegalStateException("List is empty");
    }

    public void displayList() {
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }
}

class LinkQueue {
    public FirstLastList theList;

    public LinkQueue() {
        theList = new FirstLastList();
    }

    public boolean isEmpty() {
        return theList.isEmpty();
    }

    public void enqueue(String name, int quantity) {
        Ticket newTicket = new Ticket(name, quantity, theList.last != null ? theList.last.data.ticketNumber + 1 : 1);
        theList.insertLast(newTicket);
        System.out.println("Ticket number " + newTicket.ticketNumber + " added to the queue.");
    }

    public Ticket dequeue() {
        return theList.deleteFirst();
    }

    public void displayQueue() {
        System.out.println("Current Tickets in Queue:");
        theList.displayList();
    }
}

public class Tes {
    public static void main(String[] args) {
        LinkQueue ticketQueue = new LinkQueue();
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String choice;

        do {
            System.out.println("\nOptions:");
            System.out.println("1. Book Ticket");
            System.out.println("2. Display Tickets in Queue");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter quantity of tickets: ");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    ticketQueue.enqueue(name, quantity);
                    break;
                case "2":
                    ticketQueue.displayQueue();
                    break;
                case "3":
                    Ticket canceledTicket = ticketQueue.dequeue();
                    if (canceledTicket != null) {
                        System.out.println("Ticket number " + canceledTicket.ticketNumber + " has been canceled.");
                    }
                    break;
                case "4":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter again.");
            }
        } while (!choice.equals("4"));

        scanner.close();
    }
}
