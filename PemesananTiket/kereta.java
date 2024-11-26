class Kereta extends Transportasi {
    public Kereta() {
        super("Kereta");
    }

    @Override
    public double hitungHarga(int jarak) {
        return 5000 * jarak;
    }
}
