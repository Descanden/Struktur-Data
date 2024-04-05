package Modul2;

class ContactNode {
    String name;
    String phoneNumber;
    ContactNode next;

    public ContactNode(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.next = null;
    }
}

class MyContact {
    ContactNode head;

    public MyContact() {
        this.head = null;
    }

    public void addContact(String name, String phoneNumber) {
        ContactNode newNode = new ContactNode(name, phoneNumber);
        if (head == null) {
            head = newNode;
        } else {
            ContactNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Kontak berhasil ditambahkan!");
    }

    public void displayContacts() {
        if (head == null) {
            System.out.println("Daftar kontak kosong.");
        } else {
            ContactNode temp = head;
            int count = 1;
            System.out.println("Daftar Kontak:");
            while (temp != null) {
                System.out.println(count + ". " + temp.name + " " + temp.phoneNumber);
                temp = temp.next;
                count++;
            }
        }
    }

    public void searchContact(String name) {
        if (head == null) {
            System.out.println("Daftar kontak kosong.");
        } else {
            ContactNode temp = head;
            boolean found = false;
            while (temp != null) {
                if (temp.name.equalsIgnoreCase(name)) {
                    System.out.println("Kontak ditemukan!");
                    System.out.println("Nama: " + temp.name);
                    System.out.println("Nomor Telepon: " + temp.phoneNumber);
                    found = true;
                    break;
                }
                temp = temp.next;
            }
            if (!found) {
                System.out.println("Kontak tidak ditemukan.");
            }
        }
    }
}

public class Tugas2
 {
    public static void main(String[] args) {
        MyContact
     contactManager = new MyContact
    ();
        int choice;
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        do {
            System.out.println("Selamat datang di Manajemen Kontak!");
            System.out.println("1. Tambah Kontak");
            System.out.println("2. Tampilkan Kontak");
            System.out.println("3. Cari Kontak");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1/2/3/4): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan nama kontak: ");
                    String name = scanner.next();
                    System.out.print("Masukkan nomor telepon: ");
                    String phoneNumber = scanner.next();
                    contactManager.addContact(name, phoneNumber);
                    break;
                case 2:
                    contactManager.displayContacts();
                    break;
                case 3:
                    System.out.print("Masukkan nama kontak yang ingin dicari: ");
                    String searchName = scanner.next();
                    contactManager.searchContact(searchName);
                    break;
                case 4:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih menu yang sesuai.");
            }
        } while (choice != 4);
    }
}