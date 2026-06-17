package interview.deloitte.Karat;

/*
===============================================================================
Q3 — Warehouse Inventory Manager
===============================================================================
Primary Pillar : Problem-Solving Ability
Difficulty     : Intermediate

We are building a Warehouse Inventory Manager that tracks products and
stock movements (IN / OUT).

Definitions:
1. Product        — productId (unique), name, unitPrice
2. StockMovement  — movementId, productId, type (IN or OUT), quantity, timestampSec
3. Warehouse      — manages products and stock movements

===============================================================================
TASK 1  (Bug Fix)
===============================================================================
1-1) Read through and understand the code below.
1-2) The test for Warehouse is not passing due to a bug in
     Fix the bug.

===============================================================================
TASK 2
===============================================================================
Implement:
    recordMovement(int productId, StockMovement movement)

Rules:
- Record a stock movement for the given product.
- If the product does not exist, ignore the movement.

===============================================================================
TASK 3
===============================================================================
Implement:
    getLowStockProducts(int threshold)

Return a List<String> of product NAMES whose current stock (total IN − total OUT)
is LESS THAN OR EQUAL to the threshold, sorted alphabetically.

Rules:
- Products with no movements have stock = 0 and should be included
  if 0 <= threshold.
- If no products meet the criteria, return an empty list.

Example:
  Apple  : IN 50, OUT 45 → stock = 5
  Banana : IN 20, OUT 10 → stock = 10
  Cherry : (no movements) → stock = 0

  getLowStockProducts(5) → ["Apple", "Cherry"]
===============================================================================
*/

import java.util.*;
import org.junit.Assert;

// ─── Domain classes ──────────────────────────────────────────────────────────

enum MovementType { IN, OUT }

class Product {
    int productId;
    String name;
    double unitPrice;

    Product(int productId, String name, double unitPrice) {
        this.productId = productId;
        this.name = name;
        this.unitPrice = unitPrice;
    }
}

class StockMovement {
    int movementId;
    int productId;
    MovementType type;
    int quantity;
    long timestampSec;

    StockMovement(int movementId, int productId, MovementType type,
                  int quantity, long timestampSec) {
        this.movementId = movementId;
        this.productId = productId;
        this.type = type;
        this.quantity = quantity;
        this.timestampSec = timestampSec;
    }
}

// ─── Manager class ───────────────────────────────────────────────────────────

class Warehouse {
    Map<Integer, Product> products = new HashMap<>();
    List<StockMovement> movements = new ArrayList<>();

    void addProduct(Product p) { products.put(p.productId, p); }

    void addMovement(StockMovement m) { movements.add(m); }



    int getCurrentStock(int productId) {
        int stock = 0;
        for (StockMovement m : movements) {
            if (m.productId == productId) {
                if (m.type == MovementType.IN) {
                    stock += m.quantity;
                }

            }
        }
        return stock;
    }
}

// ─── Tests ───────────────────────────────────────────────────────────────────

public class Q3_WarehouseInventory {

    public static void main(String[] args) {
        testProduct();
        testCurrentStock();
        // testRecordMovementAndLowStock();
        System.out.println("All tests passed.");
    }

    // ── TASK 1 tests ─────────────────────────────────────────────────────────

    public static void testProduct() {
        System.out.println("Running testProduct");
        Product p = new Product(1, "Widget", 9.99);
        Assert.assertEquals(1, p.productId);
        Assert.assertEquals("Widget", p.name);
        Assert.assertTrue(Math.abs(p.unitPrice - 9.99) < 0.001);
    }

    public static void testCurrentStock() {
        System.out.println("Running testCurrentStock");
        Warehouse wh = new Warehouse();
        wh.addProduct(new Product(1, "Apple",  1.50));
        wh.addProduct(new Product(2, "Banana", 0.75));

        wh.addMovement(new StockMovement(101, 1, MovementType.IN,  50, 1000));
        wh.addMovement(new StockMovement(102, 1, MovementType.OUT, 15, 2000));
        wh.addMovement(new StockMovement(103, 2, MovementType.IN,  30, 3000));
        wh.addMovement(new StockMovement(104, 1, MovementType.OUT, 10, 4000));

        // Apple : 50 − 15 − 10 = 25
        Assert.assertEquals(25, wh.getCurrentStock(1));
        // Banana: 30
        Assert.assertEquals(30, wh.getCurrentStock(2));
        // Non-existent
        Assert.assertEquals(0, wh.getCurrentStock(999));
    }

    // ── TASK 2 + TASK 3 tests ────────────────────────────────────────────────
    /*
    public static void testRecordMovementAndLowStock() {
        System.out.println("Running testRecordMovementAndLowStock");
        Warehouse wh = new Warehouse();
        wh.addProduct(new Product(10, "Apple",  1.50));
        wh.addProduct(new Product(20, "Banana", 0.75));
        wh.addProduct(new Product(30, "Cherry", 3.00));

        StockMovement m1 = new StockMovement(1, 10, MovementType.IN,  50, 1000);
        StockMovement m2 = new StockMovement(2, 10, MovementType.OUT, 45, 2000);
        StockMovement m3 = new StockMovement(3, 20, MovementType.IN,  20, 3000);
        StockMovement m4 = new StockMovement(4, 20, MovementType.OUT, 10, 4000);
        StockMovement m5 = new StockMovement(5, 99, MovementType.IN,  100, 5000);

        wh.recordMovement(10, m1);  // Apple IN 50
        wh.recordMovement(10, m2);  // Apple OUT 45  → stock = 5
        wh.recordMovement(20, m3);  // Banana IN 20
        wh.recordMovement(20, m4);  // Banana OUT 10 → stock = 10
        wh.recordMovement(99, m5);  // Product 99 doesn't exist → ignored

        // Cherry has no movements → stock = 0

        Assert.assertFalse(
            wh.movements.stream().anyMatch(m -> m.productId == 99)
        );

        // getLowStockProducts(5) → Apple(5), Cherry(0)
        List<String> low5 = wh.getLowStockProducts(5);
        Assert.assertEquals(2, low5.size());
        Assert.assertEquals("Apple",  low5.get(0));
        Assert.assertEquals("Cherry", low5.get(1));

        // getLowStockProducts(10) → Apple(5), Banana(10), Cherry(0)
        List<String> low10 = wh.getLowStockProducts(10);
        Assert.assertEquals(3, low10.size());
        Assert.assertEquals("Apple",  low10.get(0));
        Assert.assertEquals("Banana", low10.get(1));
        Assert.assertEquals("Cherry", low10.get(2));

        // getLowStockProducts(-1) → empty (no negative stock)
        List<String> none = wh.getLowStockProducts(-1);
        Assert.assertTrue(none.isEmpty());
    }
    */
}