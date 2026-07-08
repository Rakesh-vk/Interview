package interview.deloitte.Karat;

/*
===============================================================================
Q6 — Auction Bidding System
===============================================================================
Primary Pillar : Communication and Best Practices
Difficulty     : Intermediate

We are building an Auction Bidding System for an online marketplace.
Each item has a unique ID, a title, a category, and a status.
Bids are placed on items and the system tracks the highest bids.

Definitions:
1. AuctionItem — itemId (unique), title, category, status (ACTIVE/SOLD/EXPIRED)
2. Bid         — bidId, bidderName, amount, timestampSec
3. AuctionHouse — manages items and bids

===============================================================================
TASK 1  (Bug Fix)
===============================================================================
1-1) Read through and understand the code below.
1-2) The test for AuctionHouse is not passing due to a bug. Fix the bug.


===============================================================================
TASK 2
===============================================================================
Implement:
    placeBid(int itemId, Bid bid)

Rules:
- Place a bid on the given item.
- If the item does not exist OR is not ACTIVE, ignore the bid.

===============================================================================
TASK 3
===============================================================================
Implement:
    getHighestBidPerItem()

Return a Map<Integer, Double> mapping each itemId to the HIGHEST bid amount
placed on that item.

Rules:
- Only items that have at least one bid should appear in the result.
- If no bids exist, return an empty map.

Example:
  Item 1 bids: [$100, $250, $180]
  Item 2 bids: [$300]
  Item 3 bids: (none)

  getHighestBidPerItem() → { 1 → 250.0, 2 → 300.0 }
===============================================================================
*/

import java.util.*;
import org.junit.Assert;

// ─── Domain classes ──────────────────────────────────────────────────────────

enum ItemCategory { ELECTRONICS, FURNITURE, ART, COLLECTIBLES }
enum ItemStatus   { ACTIVE, SOLD, EXPIRED }

class AuctionItem {
    int itemId;
    String title;
    ItemCategory category;
    ItemStatus status;

    AuctionItem(int itemId, String title, ItemCategory category, ItemStatus status) {
        this.itemId = itemId;
        this.title = title;
        this.category = category;
        this.status = status;
    }
}

class Bid {
    int bidId;
    String bidderName;
    double amount;
    long timestampSec;

    Bid(int bidId, String bidderName, double amount, long timestampSec) {
        this.bidId = bidId;
        this.bidderName = bidderName;
        this.amount = amount;
        this.timestampSec = timestampSec;
    }
}

class AuctionStats {
    int totalItems;
    int activeItems;      // only ACTIVE
    double activeRate;

    AuctionStats(int totalItems, int activeItems, double activeRate) {
        this.totalItems = totalItems;
        this.activeItems = activeItems;
        this.activeRate = activeRate;
    }
}

// ─── Manager class ───────────────────────────────────────────────────────────

class AuctionHouse {
    List<AuctionItem> items = new ArrayList<>();
    Map<Integer, List<Bid>> bidMap = new HashMap<>();

    public Map<Integer,Double> getHighestBidPerItem(){
        Map<Integer,Double> result= new HashMap<>();
        for(Map.Entry<Integer,List<Bid>> bids:bidMap.entrySet()) {
            Double max=0.0;
            for (Bid bid : bids.getValue()) {
                if (max <bid.amount){
                    max=bid.amount;
                }
            }
            result.put(bids.getKey(), max);
        }
        return result;
    }

    public void placeBid(int itemId, Bid bid){
        for(AuctionItem ai:items){
            if(itemId==ai.itemId && ai.status==ItemStatus.ACTIVE){
                bidMap.computeIfAbsent(itemId,k-> new ArrayList<>()).add(bid);
                return;
            }
        }
    }


    void addItem(AuctionItem item) { items.add(item); }

    void updateItemStatus(int itemId, ItemStatus status) {
        for (AuctionItem item : items) {
            if (item.itemId == itemId) { item.status = status; break; }
        }
    }


    AuctionStats getAuctionStats() {
        int total = items.size();
        int active = 0;
        for (AuctionItem item : items) {
            // BUG: counts EXPIRED as active (should be ACTIVE only)
            if (item.status == ItemStatus.ACTIVE) {
                active++;
            }
        }
        double rate = (active / (double) total) * 100.0;
        return new AuctionStats(total, active, rate);
    }
}

// ─── Tests ───────────────────────────────────────────────────────────────────

public class Q6_AuctionBidding {

    public static void main(String[] args) {
        testAuctionItem();
        testAuctionStats();
        testPlaceBidAndHighestBid();
        System.out.println("All tests passed.");
    }

    // ── TASK 1 tests ─────────────────────────────────────────────────────────

    public static void testAuctionItem() {
        System.out.println("Running testAuctionItem");
        AuctionItem a = new AuctionItem(1, "Vintage Clock",
                ItemCategory.COLLECTIBLES, ItemStatus.ACTIVE);
        Assert.assertEquals(1, a.itemId);
        Assert.assertEquals("Vintage Clock", a.title);
        Assert.assertEquals(ItemCategory.COLLECTIBLES, a.category);
        Assert.assertEquals(ItemStatus.ACTIVE, a.status);
    }

    public static void testAuctionStats() {
        System.out.println("Running testAuctionStats");
        AuctionHouse ah = new AuctionHouse();
        ah.addItem(new AuctionItem(1, "Laptop",  ItemCategory.ELECTRONICS,  ItemStatus.ACTIVE));
        ah.addItem(new AuctionItem(2, "Painting",ItemCategory.ART,          ItemStatus.ACTIVE));
        ah.addItem(new AuctionItem(3, "Desk",    ItemCategory.FURNITURE,    ItemStatus.SOLD));
        ah.addItem(new AuctionItem(4, "Coin",    ItemCategory.COLLECTIBLES, ItemStatus.EXPIRED));
        ah.addItem(new AuctionItem(5, "Phone",   ItemCategory.ELECTRONICS,  ItemStatus.ACTIVE));

        // Active = 3 (items 1, 2, 5)  → 60 %
        AuctionStats stats = ah.getAuctionStats();
        Assert.assertEquals(5, stats.totalItems);
        Assert.assertEquals(3, stats.activeItems);
        Assert.assertTrue(Math.abs(stats.activeRate - 60.0) < 0.1);
    }

    // ── TASK 2 + TASK 3 tests ────────────────────────────────────────────────

    public static void testPlaceBidAndHighestBid() {
        System.out.println("Running testPlaceBidAndHighestBid");
        AuctionHouse ah = new AuctionHouse();
        ah.addItem(new AuctionItem(10, "Laptop",   ItemCategory.ELECTRONICS,  ItemStatus.ACTIVE));
        ah.addItem(new AuctionItem(20, "Painting", ItemCategory.ART,          ItemStatus.ACTIVE));
        ah.addItem(new AuctionItem(30, "Desk",     ItemCategory.FURNITURE,    ItemStatus.SOLD));
        ah.addItem(new AuctionItem(40, "Coin",     ItemCategory.COLLECTIBLES, ItemStatus.ACTIVE));

        Bid b1 = new Bid(1, "Alice",   100.0,  1000);
        Bid b2 = new Bid(2, "Bob",     250.0,  2000);
        Bid b3 = new Bid(3, "Charlie", 180.0,  3000);
        Bid b4 = new Bid(4, "Alice",   300.0,  4000);
        Bid b5 = new Bid(5, "Bob",      50.0,  5000);
        Bid b6 = new Bid(6, "Dave",    400.0,  6000);
        Bid b7 = new Bid(7, "Eve",     500.0,  7000);

        ah.placeBid(10, b1);  // Laptop : Alice $100
        ah.placeBid(10, b2);  // Laptop : Bob $250
        ah.placeBid(10, b3);  // Laptop : Charlie $180
        ah.placeBid(20, b4);  // Painting : Alice $300
        ah.placeBid(40, b5);  // Coin : Bob $50
        ah.placeBid(30, b6);  // Desk is SOLD → ignored
        ah.placeBid(99, b7);  // Item 99 doesn't exist → ignored

        Assert.assertFalse(ah.bidMap.containsKey(30));
        Assert.assertFalse(ah.bidMap.containsKey(99));

        // Highest bids: Laptop=250, Painting=300, Coin=50
        Map<Integer, Double> highest = ah.getHighestBidPerItem();
        Assert.assertEquals(3, highest.size());
        Assert.assertEquals(250.0, highest.get(10), 0.001);
        Assert.assertEquals(300.0, highest.get(20), 0.001);
        Assert.assertEquals(50.0,  highest.get(40), 0.001);
        Assert.assertFalse(highest.containsKey(30));
        Assert.assertFalse(highest.containsKey(99));
    }

}