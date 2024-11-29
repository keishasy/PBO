public class Main {
    public static void main(String[] args) {
        // Membuat objek dari masing-masing subclass
        MakhlukHidup manusia = new Manusia();
        MakhlukHidup hewan = new Hewan();
        MakhlukHidup tumbuhan = new Tumbuhan();

        // Menjalankan metode pada setiap objek
        System.out.println("=== Manusia ===");
        manusia.bernapas();
        manusia.makan();
        manusia.berkembangBiak();

        System.out.println("\n=== Hewan ===");
        hewan.bernapas();
        hewan.makan();
        hewan.berkembangBiak();

        System.out.println("\n=== Tumbuhan ===");
        tumbuhan.bernapas();
        tumbuhan.makan();
        tumbuhan.berkembangBiak();
    }
}
