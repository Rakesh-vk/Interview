package interview.deloitte.Karat;

/*
===============================================================================
Q5 — Music Streaming Analytics
===============================================================================
Primary Pillar : Communication and Best Practices
Difficulty     : Intermediate

We are building a Music Streaming Analytics platform.
Songs are catalogued, and every time a user plays a song a PlayEvent is logged.
The system provides insights about listening behaviour.

Definitions:
1. Song      — songId (unique), title, artist, genre
2. PlayEvent — eventId, userId (listener's name), durationSec (time listened)
3. MusicPlatform — manages songs and play events

===============================================================================
TASK 1  (Bug Fix)
===============================================================================
1-1) Read through and understand the code below.
1-2) The test for MusicPlatform is not passing due to a bug in.Fix the bug.

===============================================================================
TASK 2
===============================================================================
Implement:
    logPlay(int songId, PlayEvent event)

Rules:
- Log a play event for the given song.
- If the song does not exist, ignore the event.

===============================================================================
TASK 3
===============================================================================
Implement:
    getTopListeners(int n)

Return a List<String> of the top N user names ranked by their TOTAL
listening time (sum of durationSec across all songs), in descending order
of total time.

Rules:
- If two users have the same total time, sort them alphabetically.
- If fewer than n users exist, return all of them.
- If no play events exist, return an empty list.

Example:
  Song 1 plays: [Alice 120s, Bob 200s, Alice 80s]
  Song 2 plays: [Bob 150s, Charlie 300s]

  Totals: Alice=200, Bob=350, Charlie=300

  getTopListeners(2) → ["Bob", "Charlie"]
===============================================================================
*/

import java.util.*;
import org.junit.Assert;

// ─── Domain classes ──────────────────────────────────────────────────────────

enum Genre { POP, ROCK, JAZZ, CLASSICAL, HIPHOP }

class Song {
    int songId;
    String title;
    String artist;
    Genre genre;

    Song(int songId, String title, String artist, Genre genre) {
        this.songId = songId;
        this.title = title;
        this.artist = artist;
        this.genre = genre;
    }
}

class PlayEvent {
    int eventId;
    String userId;      // listener's user name
    int durationSec;    // how long they listened

    PlayEvent(int eventId, String userId, int durationSec) {
        this.eventId = eventId;
        this.userId = userId;
        this.durationSec = durationSec;
    }
}

// ─── Manager class ───────────────────────────────────────────────────────────

class MusicPlatform {
    Map<Integer, Song> songs = new HashMap<>();
    Map<Integer, List<PlayEvent>> playMap = new HashMap<>();

    public List<String> getTopListeners(int n){

        Map<String,Integer> totalTime= new HashMap<>();
        for(List<PlayEvent> p: playMap.values()){
            for(PlayEvent p1:p){
                totalTime.put(p1.userId,totalTime.getOrDefault(p1.userId,0)+p1.durationSec);
            }
        }
        List<Map.Entry<String, Integer>> listeners =
                new ArrayList<>(totalTime.entrySet());

        listeners.sort((a, b) -> {
            if (!a.getValue().equals(b.getValue())) {
                return b.getValue() - a.getValue(); // descending time
            }
            return a.getKey().compareTo(b.getKey()); // alphabetical
        });

        List<String> result = new ArrayList<>();

        for (int i = 0; i < Math.min(n, listeners.size()); i++) {
            result.add(listeners.get(i).getKey());
        }

        return result;
    }

    public void logPlay(int songId, PlayEvent event) {
        if (!songs.containsKey(songId)) {
            return;
        }

        playMap.computeIfAbsent(songId, k -> new ArrayList<>())
                .add(event);
    }

    void addSong(Song s) { songs.put(s.songId, s); }


    int getTotalListeningTime(int songId) {
        int total = 0;
        List<PlayEvent> events = playMap.get(songId);
        if (events != null) {
            for (PlayEvent e : events) {
                total += e.durationSec;
            }
        }
        return total;
    }
}

// ─── Tests ───────────────────────────────────────────────────────────────────

public class Q5_MusicStreaming {

    public static void main(String[] args) {
        testSong();
        testTotalListeningTime();
        testLogPlayAndTopListeners();
        System.out.println("All tests passed.");
    }

    // ── TASK 1 tests ─────────────────────────────────────────────────────────

    public static void testSong() {
        System.out.println("Running testSong");
        Song s = new Song(1, "Bohemian Rhapsody", "Queen", Genre.ROCK);
        Assert.assertEquals(1, s.songId);
        Assert.assertEquals("Bohemian Rhapsody", s.title);
        Assert.assertEquals("Queen", s.artist);
        Assert.assertEquals(Genre.ROCK, s.genre);
    }

    public static void testTotalListeningTime() {
        System.out.println("Running testTotalListeningTime");
        MusicPlatform mp = new MusicPlatform();
        mp.addSong(new Song(1, "Song A", "Artist X", Genre.POP));

        // Manually add play events for the test
        mp.playMap.put(1, new ArrayList<>());
        mp.playMap.get(1).add(new PlayEvent(101, "Alice", 120));
        mp.playMap.get(1).add(new PlayEvent(102, "Bob",   200));
        mp.playMap.get(1).add(new PlayEvent(103, "Alice",  80));

        // Expected: 120 + 200 + 80 = 400
        Assert.assertEquals(400, mp.getTotalListeningTime(1));
        // Non-existent song
        Assert.assertEquals(0, mp.getTotalListeningTime(999));
    }

    // ── TASK 2 + TASK 3 tests ────────────────────────────────────────────────

    public static void testLogPlayAndTopListeners() {
        System.out.println("Running testLogPlayAndTopListeners");
        MusicPlatform mp = new MusicPlatform();
        mp.addSong(new Song(10, "Song A", "Artist X", Genre.POP));
        mp.addSong(new Song(20, "Song B", "Artist Y", Genre.ROCK));
        mp.addSong(new Song(30, "Song C", "Artist Z", Genre.JAZZ));

        PlayEvent e1 = new PlayEvent(1, "Alice",   120);
        PlayEvent e2 = new PlayEvent(2, "Bob",     200);
        PlayEvent e3 = new PlayEvent(3, "Alice",    80);
        PlayEvent e4 = new PlayEvent(4, "Bob",     150);
        PlayEvent e5 = new PlayEvent(5, "Charlie", 300);
        PlayEvent e6 = new PlayEvent(6, "Alice",   100);
        PlayEvent e7 = new PlayEvent(7, "Dave",     50);

        mp.logPlay(10, e1);  // Alice 120 on Song A
        mp.logPlay(10, e2);  // Bob 200 on Song A
        mp.logPlay(20, e3);  // Alice 80 on Song B
        mp.logPlay(20, e4);  // Bob 150 on Song B
        mp.logPlay(30, e5);  // Charlie 300 on Song C
        mp.logPlay(10, e6);  // Alice 100 on Song A
        mp.logPlay(99, e7);  // Song 99 doesn't exist → ignored

        Assert.assertFalse(mp.playMap.containsKey(99));

        // Totals: Alice=120+80+100=300, Bob=200+150=350, Charlie=300
        // Top 2 → ["Bob"(350), "Alice"(300)]  (Alice & Charlie tie at 300 → "Alice" < "Charlie")
        List<String> top2 = mp.getTopListeners(2);
        Assert.assertEquals(2, top2.size());
        Assert.assertEquals("Bob",   top2.get(0));
        Assert.assertEquals("Alice", top2.get(1));

        // Top 10 (more than available) → all 3 users
        List<String> topAll = mp.getTopListeners(10);
        Assert.assertEquals(3, topAll.size());
        Assert.assertEquals("Bob",     topAll.get(0));
        Assert.assertEquals("Alice",   topAll.get(1));
        Assert.assertEquals("Charlie", topAll.get(2));

    }

}