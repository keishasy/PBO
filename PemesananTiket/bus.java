class Bus extends Transportasi {
    public Bus() {
        super("Bus");
    }

    @Override
    public double hitungHarga(int jarak) {
        return 3000 * jarak;
    }
}
