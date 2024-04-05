package Modul1;
import java.util.Scanner;

enum JenisBarang {
    SANDANG, PANGAN, PAPAN
}

class Barang<T, V> {
    private T namaBarang;
    private V hargaBarang;
    
    public Barang(T namaBarang, V hargaBarang, JenisBarang jenisBarang) {
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
        System.out.println("\nJenis   : " + jenisBarang);
    }

    public T getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(T namaBarang) {
        this.namaBarang = namaBarang;
    }

    public V getHargaBarang() {
        return hargaBarang;
    }

    public void setHargaBarang(V hargaBarang) {
        this.hargaBarang = hargaBarang;
    }
}

public class Tugas1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan Nama   : ");
        String namaBarang = sc.nextLine();
        

        System.out.print("Masukkan Harga  : ");
        int hargaBarang = sc.nextInt();

        System.out.print("Pilih jenis barang :\n0. SANDANG\n1. PANGAN\n2. PAPAN\nMasukkan Pilihan : ");
        int jenisBarangIndex = sc.nextInt();
        JenisBarang jenisBarang = JenisBarang.values()[jenisBarangIndex];

        Barang<String, Integer> barang = new Barang<>(namaBarang, hargaBarang, jenisBarang);
        System.out.println("Nama    : " + barang.getNamaBarang());
        System.out.println("Harga   : " + barang.getHargaBarang());
    }
}
