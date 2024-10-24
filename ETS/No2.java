class Book {
    // Atribut kelas
    private String judul;
    private String penulis;
    private int tahunTerbit;
    private String namaPenerbit;  
    private String kategoriBuku;  

    // Konstruktor untuk menginisialisasi atribut
    public Book(String judul, String penulis, int tahunTerbit, String namaPenerbit, String kategoriBuku) {
        this.judul = judul;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
        this.namaPenerbit = namaPenerbit;
        this.kategoriBuku = kategoriBuku;
    }

    // Metode untuk mencetak detail buku
    public void printDetails() {
        System.out.println("Judul           : " + judul);
        System.out.println("Penulis         : " + penulis);
        System.out.println("Tahun Terbit    : " + tahunTerbit);
        System.out.println("Penerbit        : " + namaPenerbit);
        System.out.println("Kategori        : " + kategoriBuku);
    }

    // Main method untuk menjalankan program
    public static void main(String[] args) {
        // Membuat objek dari kelas Book
        Book buku1 = new Book(
            "Harry Potter",
            "J.K. Rowling",
            2019,
            "Bloomsbury",
            "Fiksi"
        );

        // Memanggil metode printDetails() untuk menampilkan informasi buku
        buku1.printDetails();
    }
}
