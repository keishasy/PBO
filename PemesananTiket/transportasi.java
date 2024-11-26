abstract class Transportasi {
    protected String namaTransportasi;

    public Transportasi(String namaTransportasi) {
        this.namaTransportasi = namaTransportasi;
    }

    // Abstract method untuk menghitung harga tiket
    public abstract double hitungHarga(int jarak);

    public void cetakInfo(int jarak) {
        System.out.println("Transportasi: " + namaTransportasi);
        System.out.println("Harga untuk jarak " + jarak + " km: Rp " + hitungHarga(jarak));
    }
}
