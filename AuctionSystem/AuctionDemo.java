public class AuctionDemo {
    public static void main(String[] args) {
        // Membuat objek Auction
        Auction auction = new Auction();
        
        // Membuat beberapa objek Person (bidder)
        Person Ariana = new Person("Ariana Grande");
        Person Olivia = new Person("Olivia Rodrigo");

        // Menambahkan lot ke dalam lelang
        auction.enterLot("Famous Painting");
        auction.enterLot("Vintage Bag");
        
        // Melakukan bid pada Lot
        auction.makeABid(1, Ariana, 1000); // Ariana bid $1000 on Lot 1
        auction.makeABid(1, Olivia, 1200); // Olivia bid $1200 on Lot 1
        auction.makeABid(2, Ariana, 2000); // Ariana bid $2000 on Lot 2
        
        // Menampilkan semua lot dan bid tertinggi mereka
        auction.showLots();
    }
}
