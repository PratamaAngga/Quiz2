public class perpus20 {
    buku20[] daftarBuku;
    mahasiswa20[] daftarMahasiswa;
    int jumlahBuku, jumlahMahasiswa;

    public perpus20() {
        daftarBuku = new buku20[20];
        daftarMahasiswa = new mahasiswa20[10];
        jumlahBuku = 0;
        jumlahMahasiswa = 0;
    }

    public void tambahBuku(buku20 buku) {
        if (jumlahBuku < 20) {
            daftarBuku[jumlahBuku++] = buku;
        }
    }

    public void tambahMahasiswa(mahasiswa20 mahasiswa) {
        if (jumlahMahasiswa < 10) {
            daftarMahasiswa[jumlahMahasiswa++] = mahasiswa;
        }
    }

    public buku20 cariBuku(String kode) {
        for (int i = 0; i < jumlahBuku; i++) {
            if (daftarBuku[i].kodeBuku.equalsIgnoreCase(kode)) return daftarBuku[i];
        }
        return null;
    }

    public mahasiswa20 cariMahasiswa(String nim) {
        for (int i = 0; i < jumlahMahasiswa; i++) {
            if (daftarMahasiswa[i].nim.equalsIgnoreCase(nim)) return daftarMahasiswa[i];
        }
        return null;
    }

    public void tampilkanPinjam() {
        System.out.println("-------Daftar peminjaman buku-------");
        for(int i = 0; i < jumlahMahasiswa; i++) {
            if (daftarMahasiswa[i].jumlahPinjam > 0) {
                System.out.print(daftarMahasiswa[i].nama + " : ");
                for(int j = 0; j < daftarMahasiswa[i].jumlahPinjam; j++) {
                    System.out.print(daftarMahasiswa[i].bukuDipinjam[j].judul + ", ");
                }
                System.out.println();
            }
        }
    }

    public boolean pinjamBuku(String nim, String kodeBuku) {
        mahasiswa20 mahasiswa = cariMahasiswa(nim);
        buku20 buku = cariBuku(kodeBuku);

        if (mahasiswa == null || buku == null) {
            System.out.println("Mahasiswa atau buku tidak ditemukan.");
            return false;
        }

        if (buku.statusDipinjam) {
            System.out.println("Gagal meminjam buku: " + buku.judul + " karena sudah dipinjam orang lain.");
            return false;
        }

        if (mahasiswa.jumlahPinjam < 2) {
            mahasiswa.bukuDipinjam[mahasiswa.jumlahPinjam++] = buku;
            buku.statusDipinjam = true;
            System.out.println(mahasiswa.nama + " berhasil meminjam " + buku.judul);
            return true;
        } else {
            System.out.println("Gagal meminjam buku: Maksimal 2 buku.");
            return false;
        }
    }

    public void kembalikanBuku(String nim, String kodeBuku) {
        mahasiswa20 mahasiswa = cariMahasiswa(nim);
        buku20 buku = cariBuku(kodeBuku);

        if (mahasiswa == null || buku == null) {
            System.out.println("Mahasiswa atau buku tidak ditemukan.");
            return;
        }

        for (int i = 0; i < mahasiswa.jumlahPinjam; i++) {
            if (mahasiswa.bukuDipinjam[i] == buku) {
                buku.statusDipinjam = false;
                mahasiswa.bukuDipinjam[i] = mahasiswa.bukuDipinjam[--mahasiswa.jumlahPinjam];
                mahasiswa.bukuDipinjam[mahasiswa.jumlahPinjam] = null;
                System.out.println(mahasiswa.nama + " mengembalikan " + buku.judul);
                return;
            }
        }

        System.out.println(mahasiswa.nama + " tidak sedang meminjam buku ini.");
    }

}
