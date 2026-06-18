package interview.deloitte.Karat;

/*
===============================================================================
Q4 — Hotel Room Reservation System
===============================================================================
Primary Pillar : Technical Knowledge
Difficulty     : Intermediate

We are building a Hotel Room Reservation System.
Each room has a unique ID, a room type, and a status.
The system records reservations and provides occupancy insights.

Definitions:
1. Room        — roomId (unique), roomType, status
2. Reservation — reservationId, guestName, checkInDay (1-365),
                  checkOutDay (1-365), nights = checkOutDay − checkInDay
3. Hotel       — manages rooms and reservations

===============================================================================
TASK 1  (Bug Fix)
===============================================================================
1-1) Read through and understand the code below.
1-2) The test for Hotel is not passing due to a bug


===============================================================================
TASK 2
===============================================================================
Implement:
    addReservation(int roomId, Reservation reservation)

Rules:
- Associate a reservation with a room.
- If the room does not exist, ignore the reservation.

===============================================================================
TASK 3
===============================================================================
Implement:
    getGuestNights()

Return a Map<String, Integer> mapping each guest NAME to the TOTAL number
of nights they have stayed across ALL rooms and reservations.

Rules:
- A guest may have multiple reservations across different rooms.
- Only rooms that exist should be counted.
- If no reservations exist, return an empty map.

Example:
  Room 1 reservations: [Alice 3 nights, Bob 5 nights]
  Room 2 reservations: [Alice 2 nights]

  getGuestNights() → { "Alice" → 5, "Bob" → 5 }
===============================================================================
*/

import java.util.*;
import org.junit.Assert;

// ─── Domain classes ──────────────────────────────────────────────────────────

enum RoomType   { SINGLE, DOUBLE, SUITE, PENTHOUSE }
enum RoomStatus { AVAILABLE, OCCUPIED, RESERVED, MAINTENANCE }

class Room {
    int roomId;
    RoomType type;
    RoomStatus status;

    Room(int roomId, RoomType type, RoomStatus status) {
        this.roomId = roomId;
        this.type = type;
        this.status = status;
    }
}

class Reservation {
    int reservationId;
    String guestName;
    int checkInDay;
    int checkOutDay;

    Reservation(int reservationId, String guestName,
                int checkInDay, int checkOutDay) {
        this.reservationId = reservationId;
        this.guestName = guestName;
        this.checkInDay = checkInDay;
        this.checkOutDay = checkOutDay;
    }

    int getNights() { return checkOutDay - checkInDay; }
}

class HotelStats {
    int totalRooms;
    int bookableRooms;
    double bookableRate;

    HotelStats(int totalRooms, int bookableRooms, double bookableRate) {
        this.totalRooms = totalRooms;
        this.bookableRooms = bookableRooms;
        this.bookableRate = bookableRate;
    }
}

// ─── Manager class ───────────────────────────────────────────────────────────

class Hotel {
    List<Room> rooms = new ArrayList<>();
    Map<Integer, List<Reservation>> reservationMap = new HashMap<>();

    void addRoom(Room room) { rooms.add(room); }

    void updateRoomStatus(int roomId, RoomStatus status) {
        for (Room r : rooms) {
            if (r.roomId == roomId) { r.status = status; break; }
        }
    }

    // TODO: Implement addReservation(int roomId, Reservation reservation)
    // TODO: Implement getGuestNights()
    public Map<String, Integer> getGuestNights(){
        Map<String,Integer> stays= new HashMap<>();
        for(List<Reservation> reservation: reservationMap.values()){
            for(Reservation r:reservation){
                stays.put(r.guestName
                        ,stays.getOrDefault(r.guestName,0)+r.getNights());

            }
        }
        return stays;
    }

    HotelStats getHotelStats() {
        int total = rooms.size();
        int bookable = 0;
        for (Room r : rooms) {
            if (r.status == RoomStatus.AVAILABLE
                    || r.status == RoomStatus.OCCUPIED
                    || r.status == RoomStatus.RESERVED) {
                bookable++;
            }
        }
        double rate = (bookable / (double) total) * 100.0;
        return new HotelStats(total, bookable, rate);
    }

    public void addReservation(int roomId, Reservation reservation) {
        for(Room room:rooms){
            if(room.roomId==roomId){
                reservationMap.computeIfAbsent(roomId,k-> new ArrayList<>()).add(reservation);
            }
        }
    }
}

// ─── Tests ───────────────────────────────────────────────────────────────────

public class Q4_HotelReservation {

    public static void main(String[] args) {
        testRoom();
        testHotel();
        testAddReservationAndGuestNights();
        System.out.println("All tests passed.");
    }

    // ── TASK 1 tests ─────────────────────────────────────────────────────────

    public static void testRoom() {
        System.out.println("Running testRoom");
        Room r = new Room(101, RoomType.DOUBLE, RoomStatus.AVAILABLE);
        Assert.assertEquals(101, r.roomId);
        Assert.assertEquals(RoomType.DOUBLE, r.type);
        Assert.assertEquals(RoomStatus.AVAILABLE, r.status);
    }

    public static void testHotel() {
        System.out.println("Running testHotel");
        Hotel hotel = new Hotel();
        hotel.addRoom(new Room(1, RoomType.SINGLE,    RoomStatus.AVAILABLE));
        hotel.addRoom(new Room(2, RoomType.DOUBLE,    RoomStatus.OCCUPIED));
        hotel.addRoom(new Room(3, RoomType.SUITE,     RoomStatus.RESERVED));
        hotel.addRoom(new Room(4, RoomType.SINGLE,    RoomStatus.MAINTENANCE));
        hotel.addRoom(new Room(5, RoomType.PENTHOUSE, RoomStatus.AVAILABLE));

        // Bookable = AVAILABLE(2) + OCCUPIED(1) + RESERVED(1) = 4  → 80 %
        HotelStats stats = hotel.getHotelStats();
        Assert.assertEquals(5, stats.totalRooms);
        Assert.assertEquals(4, stats.bookableRooms);
        Assert.assertTrue(Math.abs(stats.bookableRate - 80.0) < 0.1);
    }

    // ── TASK 2 + TASK 3 tests ────────────────────────────────────────────────

    public static void testAddReservationAndGuestNights() {
        System.out.println("Running testAddReservationAndGuestNights");
        Hotel hotel = new Hotel();
        hotel.addRoom(new Room(10, RoomType.SINGLE, RoomStatus.AVAILABLE));
        hotel.addRoom(new Room(20, RoomType.DOUBLE, RoomStatus.AVAILABLE));
        hotel.addRoom(new Room(30, RoomType.SUITE,  RoomStatus.AVAILABLE));

        Reservation rv1 = new Reservation(1, "Alice",   100, 103); // 3 nights
        Reservation rv2 = new Reservation(2, "Bob",     110, 115); // 5 nights
        Reservation rv3 = new Reservation(3, "Alice",   120, 122); // 2 nights
        Reservation rv4 = new Reservation(4, "Charlie", 130, 133); // 3 nights
        Reservation rv5 = new Reservation(5, "Bob",     140, 142); // 2 nights
        Reservation rv6 = new Reservation(6, "Dave",    150, 155); // 5 nights

        hotel.addReservation(10, rv1);  // Alice  → Room 10
        hotel.addReservation(10, rv2);  // Bob    → Room 10
        hotel.addReservation(20, rv3);  // Alice  → Room 20
        hotel.addReservation(30, rv4);  // Charlie → Room 30
        hotel.addReservation(20, rv5);  // Bob    → Room 20
        hotel.addReservation(99, rv6);  // Room 99 doesn't exist → ignored

        Assert.assertFalse(hotel.reservationMap.containsKey(99));

        // Alice=3+2=5, Bob=5+2=7, Charlie=3
        Map<String, Integer> gn = hotel.getGuestNights();
        Assert.assertEquals(Integer.valueOf(5), gn.get("Alice"));
        Assert.assertEquals(Integer.valueOf(7), gn.get("Bob"));
        Assert.assertEquals(Integer.valueOf(3), gn.get("Charlie"));
        Assert.assertFalse(gn.containsKey("Dave"));
    }

}