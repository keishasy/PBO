public class Main {
    public static void main(String[] args) {
        // Array of transportasi
        Transportasi[] transportasiArray = {
            new Kereta(),
            new Pesawat(),
            new Bus()
        };

        // Jarak yang dihitung
        int jarak = 100; // 100 km

        // Menggunakan Polymorphism
        for (Transportasi transportasi : transportasiArray) {
            transportasi.cetakInfo(jarak);
            System.out.println();
        }
    }
}
