import java.util.Scanner;
public class main20 {
    public static void main(String[] args) {
        perpus20 perpus = new perpus20();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu Perpustakaan:");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Tambah Mahasiswa");
            System.out.println("3. Pinjam Buku");
            System.out.println("4. Kembalikan Buku");
            System.out.println("5. Tampilkan Peminjaman");
            System.out.println("6. Keluar");
            System.out.print("Pilih opsi: ");
            int pilihan = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan kode buku: ");
                    String kode = sc.nextLine();
                    System.out.print("Masukkan judul buku: ");
                    String judul = sc.nextLine();
                    System.out.print("Masukkan penulis buku: ");
                    String penulis = sc.nextLine();
                    perpus.tambahBuku(new buku20(kode, judul, penulis));
                    break;
                case 2:
                    System.out.print("Masukkan NIM mahasiswa: ");
                    String nim = sc.nextLine();
                    System.out.print("Masukkan nama mahasiswa: ");
                    String nama = sc.nextLine();
                    perpus.tambahMahasiswa(new mahasiswa20(nim, nama));
                    break;
                case 3:
                    System.out.print("Masukkan NIM mahasiswa: ");
                    nim = sc.nextLine();
                    System.out.print("Masukkan kode buku: ");
                    kode = sc.nextLine();
                    perpus.cariMahasiswa(nim);
                    perpus.cariBuku(kode);
                    perpus.pinjamBuku(nim, kode);
                    break;
                case 4:
                    System.out.print("Masukkan NIM mahasiswa: ");
                    nim = sc.nextLine();
                    System.out.print("Masukkan kode buku: ");
                    kode = sc.nextLine();
                    perpus.cariMahasiswa(nim);
                    perpus.cariBuku(kode);
                    perpus.kembalikanBuku(nim, kode);
                    break;
                case 5:
                    perpus.tampilkanPinjam();
                    break;
                case 6:
                    System.out.println("Terima kasih telah menggunakan sistem perpus20!");
                    sc.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        }
    }
}
