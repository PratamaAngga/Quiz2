public class mahasiswa20 {
    String nim, nama;
    buku20[] bukuDipinjam;
    int jumlahPinjam = 0;

    public mahasiswa20(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
        this.bukuDipinjam = new buku20[2];
        this.jumlahPinjam = 0;
    }
}
