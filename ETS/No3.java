import java.util.Scanner;

public class ParkingTicketMachine {
    // Atribut
    private int balance;       
    private int ticketPrice;   
    private int ticketTime;    

    // Konstruktor 
    public ParkingTicketMachine(int ticketPrice) {
        this.ticketPrice = ticketPrice;
        this.balance = 0;
        this.ticketTime = 0;
    }

    // Metode untuk menambahkan uang ke saldo
    public void insertMoney(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Uang berhasil dimasukkan: Rp" + amount);
        } else {
            System.out.println("Jumlah uang tidak valid.");
        }
    }

    // Metode untuk mengeluarkan tiket dan menghitung waktu parkir
    public void issueTicket() {
        if (balance >= ticketPrice) {
            ticketTime = balance / ticketPrice;
            balance = balance % ticketPrice; 
            System.out.println("Tiket berhasil dikeluarkan untuk " + ticketTime + " jam.");
        } else {
            System.out.println("Saldo tidak cukup. Silakan tambahkan uang.");
        }
    }

    // Metode untuk mengembalikan jumlah jam yang telah dibeli
    public int getTimePurchased() {
        return ticketTime;
    }

    // Metode untuk mendapatkan saldo saat ini
    public int getBalance() {
        return balance;
    }

    // Main Program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan harga tiket parkir per jam: ");
        int pricePerHour = scanner.nextInt();

        ParkingTicketMachine machine = new ParkingTicketMachine(pricePerHour);

        while (true) {
            System.out.println("\n=== Mesin Tiket Parkir ===");
            System.out.println("1. Masukkan uang");
            System.out.println("2. Keluarkan tiket");
            System.out.println("3. Lihat saldo dan Jam Parkir");
            System.out.println("4. Keluar");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan jumlah uang: ");
                    int amount = scanner.nextInt();
                    machine.insertMoney(amount);
                    break;
                case 2:
                    machine.issueTicket();
                    break;
                case 3:
                    System.out.println("Saldo saat ini: Rp" + machine.getBalance());
                    System.out.println("Jam parkir dibeli: " + machine.getTimePurchased() + " jam");
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan mesin tiket parkir.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        }
    }
}
