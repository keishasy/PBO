class Pesawat extends Transportasi {
    public Pesawat() {
        super("Pesawat");
    }

    @Override
    public double hitungHarga(int jarak) {
        return 20000 * jarak;
    }
}
