package Modul2;

import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    String name;
    String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}

class MyContact {
    ArrayList<Contact> contacts;

    public MyContact() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(String name, String phoneNumber) {
        Contact newContact = new Contact(name, phoneNumber);
        contacts.add(newContact);
        System.out.println("Kontak berhasil ditambahkan!");
    }

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Daftar kontak kosong.");
        } else {
            System.out.println("Daftar Kontak:");
            for (int i = 0; i < contacts.size(); i++) {
                Contact contact = contacts.get(i);
                System.out.println((i + 1) + ". " + contact.name + " - " + contact.phoneNumber);
            }
        }
    }

    public void searchContact(String name) {
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.name.equalsIgnoreCase(name)) {
                System.out.println("Kontak ditemukan!");
                System.out.println("Nama: " + contact.name);
                System.out.println("Nomor Telepon: " + contact.phoneNumber);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Kontak tidak ditemukan.");
        }
    }
}

public class Tugas1 {
    public static void main(String[] args) {
        MyContact contactManager = new MyContact();
        int choice;
        Scanner scanner = new Scanner(System.in);

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
