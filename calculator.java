import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numbers1, numbers2, choice;
        double result = 0;  
        boolean validOperation = true;  

        System.out.println("Program Kalkulator Sederhana");
        System.out.println("1. Penjumlahan");
        System.out.println("2. Pengurangan");
        System.out.println("3. Pembagian");
        System.out.println("4. Perkalian");
        System.out.println("5. Sisa Bagi");
        System.out.println("-----------------------------");

        // Input data
        System.out.print("Masukan Angka Pertama: ");
        numbers1 = input.nextInt();
        System.out.print("Masukan Angka Kedua: ");
        numbers2 = input.nextInt();

        // Pilihan Operasi
        System.out.print("Masukan Operasi: ");
        choice = input.nextInt();

        switch (choice) {
            case 1:
                result = numbers1 + numbers2;
                break;
            case 2:
                result = numbers1 - numbers2;
                break;
            case 3:
                if (numbers2 != 0) {
                    result = (double) numbers1 / numbers2;  
                } else {
                    System.out.println("Error: Pembagian dengan angka 0 tidak diperbolehkan.");
                    validOperation = false;
                }
                break;
            case 4:
                result = numbers1 * numbers2;
                break;
            case 5:
                if (numbers2 != 0) {
                    result = numbers1 % numbers2;
                } else {
                    System.out.println("Error: Modulo dengan angka 0 tidak diperbolehkan.");
                    validOperation = false;
                }
                break;
            default:
                System.out.println("Salah Memasukan Pilihan Harap Baca Pilihan di Menu");
                validOperation = false;
        }

        if (validOperation) {
            System.out.println("Hasil: " + result);
        }

        input.close();  
    }
}
