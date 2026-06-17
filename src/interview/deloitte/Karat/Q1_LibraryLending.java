package interview.deloitte.Karat;
/*
===============================================================================
Q1 — Library Book Lending System
===============================================================================
Primary Pillar : Technical Knowledge
Difficulty     : Intermediate

We are building a system to manage a library's book lending operations.
The library has multiple books, each with a unique ID, title, and category.
The system tracks lending records for each book.

Definitions:
1. Book      — bookId (unique), title, category
2. LendingRecord — recordId, borrowerName, borrowDay (1-365), returnDay (1-365)
     duration = returnDay – borrowDay
3. Library   — manages books and their lending records

===============================================================================
TASK 1  (Bug Fix)
===============================================================================
1-1) Read through and understand the code below.
1-2) The test for Library is not passing due to a bug in the code.


===============================================================================
TASK 2
===============================================================================
Implement:
    addLending(int bookId, LendingRecord record)

Rules:
- Associate a lending record with a book.
- If the book does not exist, ignore the record.

===============================================================================
TASK 3
===============================================================================
Implement:
    getFrequentBorrowers(int minCount)

Returns a List<String> of borrower NAMES who have borrowed books at least
minCount times across ALL books, sorted alphabetically.
The same borrower borrowing the same book multiple times counts separately.
If no borrowers meet the threshold, return an empty list.

Example:
  Book 10 records: [Alice, Bob, Alice]
  Book 20 records: [Bob, Charlie]

  getFrequentBorrowers(2) → ["Alice", "Bob"]
===============================================================================
*/

import java.util.*;
import org.junit.Assert;

// ─── Domain classes ──────────────────────────────────────────────────────────

enum BookCategory { FICTION, NON_FICTION, REFERENCE, CHILDREN }

class Book {
    int bookId;
    String title;
    BookCategory category;

    Book(int bookId, String title, BookCategory category) {
        this.bookId = bookId;
        this.title = title;
        this.category = category;
    }
}

class LendingRecord {
    int recordId;
    String borrowerName;
    int borrowDay;
    int returnDay;

    LendingRecord(int recordId, String borrowerName, int borrowDay, int returnDay) {
        this.recordId = recordId;
        this.borrowerName = borrowerName;
        this.borrowDay = borrowDay;
        this.returnDay = returnDay;
    }

    int getLendingDuration() { return returnDay - borrowDay; }
}

class LibraryStats {
    int totalBooks;
    int lendableBooks;
    double lendableRate;

    LibraryStats(int totalBooks, int lendableBooks, double lendableRate) {
        this.totalBooks = totalBooks;
        this.lendableBooks = lendableBooks;
        this.lendableRate = lendableRate;
    }
}

// ─── Manager class ───────────────────────────────────────────────────────────

class Library {
    List<Book> books = new ArrayList<>();
    Map<Integer, List<LendingRecord>> lendingMap = new HashMap<>();

    void addBook(Book book) { books.add(book); }

    public List<String> getFrequentBorrowers(int minCount) {

        Map<String, Integer> countMap = new HashMap<>();

        for (List<LendingRecord> records : lendingMap.values()) {
            for (LendingRecord record : records) {
                countMap.put(
                        record.borrowerName,
                        countMap.getOrDefault(record.borrowerName, 0) + 1
                );
            }
        }

        List<String> result = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() >= minCount) {
                result.add(entry.getKey());
            }
        }

        Collections.sort(result);

        return result;
    }
    public void addLending(int bookId, LendingRecord record) {
        for (Book book : books) {
            if (book.bookId == bookId) {
                lendingMap.computeIfAbsent(bookId, k -> new ArrayList<>())
                        .add(record);
                return;
            }
        }
    }

    LibraryStats getLibraryStats() {
        int total = books.size();
        int lendable = 0;
        for (Book b : books) {
            // Lendable = FICTION + NON_FICTION + CHILDREN  (REFERENCE is NOT lendable)

            if (b.category == BookCategory.FICTION
                    || b.category == BookCategory.NON_FICTION
                    || b.category == BookCategory.CHILDREN) {
                lendable++;
            }
        }
        double rate = (lendable / (double) total) * 100.0;
        return new LibraryStats(total, lendable, rate);
    }



}

// ─── Tests ───────────────────────────────────────────────────────────────────

public class Q1_LibraryLending {

    public static void main(String[] args) {
        testBook();
        testLibrary();
        // testAddLendingAndFrequentBorrowers();
        System.out.println("All tests passed.");
    }

    // ── TASK 1 tests ─────────────────────────────────────────────────────────

    public static void testBook() {
        System.out.println("Running testBook");
        Book b = new Book(1, "Java Programming", BookCategory.NON_FICTION);
        Assert.assertEquals(1, b.bookId);
        Assert.assertEquals("Java Programming", b.title);
        Assert.assertEquals(BookCategory.NON_FICTION, b.category);
    }

    public static void testLibrary() {
        System.out.println("Running testLibrary");
        Library lib = new Library();
        lib.addBook(new Book(1, "Novel A",        BookCategory.FICTION));
        lib.addBook(new Book(2, "Science B",      BookCategory.NON_FICTION));
        lib.addBook(new Book(3, "Encyclopedia C", BookCategory.REFERENCE));
        lib.addBook(new Book(4, "Kids Story D",   BookCategory.CHILDREN));
        lib.addBook(new Book(5, "Novel E",        BookCategory.FICTION));

        // Lendable = FICTION(2) + NON_FICTION(1) + CHILDREN(1) = 4  → 80 %
        LibraryStats stats = lib.getLibraryStats();
        Assert.assertEquals(5, stats.totalBooks);
        Assert.assertEquals(4, stats.lendableBooks);
        Assert.assertTrue(Math.abs(stats.lendableRate - 80.0) < 0.1);
    }

    // ── TASK 2 + TASK 3 tests ────────────────────────────────────────────────

    public static void testAddLendingAndFrequentBorrowers() {
        System.out.println("Running testAddLendingAndFrequentBorrowers");
        Library lib = new Library();
        lib.addBook(new Book(10, "Book A", BookCategory.FICTION));
        lib.addBook(new Book(20, "Book B", BookCategory.NON_FICTION));
        lib.addBook(new Book(30, "Book C", BookCategory.CHILDREN));

        LendingRecord r1 = new LendingRecord(1, "Alice",   10, 20);
        LendingRecord r2 = new LendingRecord(2, "Bob",     15, 30);
        LendingRecord r3 = new LendingRecord(3, "Alice",   35, 50);
        LendingRecord r4 = new LendingRecord(4, "Charlie", 40, 55);
        LendingRecord r5 = new LendingRecord(5, "Bob",     60, 80);
        LendingRecord r6 = new LendingRecord(6, "Alice",   90, 100);
        LendingRecord r7 = new LendingRecord(7, "Bob",    110, 130);
        LendingRecord r8 = new LendingRecord(8, "Dave",   140, 160);

        lib.addLending(10, r1);  // Alice → Book A
        lib.addLending(10, r2);  // Bob   → Book A
        lib.addLending(20, r3);  // Alice → Book B
        lib.addLending(20, r4);  // Charlie → Book B
        lib.addLending(30, r5);  // Bob   → Book C
        lib.addLending(10, r6);  // Alice → Book A (again)
        lib.addLending(30, r7);  // Bob   → Book C (again)
        lib.addLending(99, r8);  // Book 99 does NOT exist → ignored

        Assert.assertFalse(lib.lendingMap.containsKey(99));

        // Counts: Alice=3, Bob=3, Charlie=1, Dave=ignored
        List<String> freq2 = lib.getFrequentBorrowers(2);
        Assert.assertEquals(2, freq2.size());
        Assert.assertEquals("Alice", freq2.get(0));
        Assert.assertEquals("Bob",   freq2.get(1));

        List<String> freq3 = lib.getFrequentBorrowers(3);
        Assert.assertEquals(2, freq3.size());

        List<String> freq4 = lib.getFrequentBorrowers(4);
        Assert.assertTrue(freq4.isEmpty());
    }

}