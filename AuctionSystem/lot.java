public class Lot {
    private Bid highestBid;
    private int number;
    private String description;

    public Lot(int number, String description) {
        this.number = number;
        this.description = description;
        this.highestBid = null;
    }

    public int getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }

    public Bid getHighestBid() {
        return highestBid;
    }

    // Method to handle bidding logic
    public boolean bidFor(Bid bid) {
        if (highestBid == null) { // There is no previous bid.
            highestBid = bid;
            return true;
        } else if (bid.getValue() > highestBid.getValue()) { // The bid is better than the previous one.
            highestBid = bid;
            return true;
        } else { // The bid is not better.
            return false;
        }
    }

    @Override
    public String toString() {
        if (highestBid != null) {
            return "Lot " + number + ": " + description + " (Highest Bid: " + highestBid.getValue() + ")";
        } else {
            return "Lot " + number + ": " + description + " (No bids yet)";
        }
    }
}
