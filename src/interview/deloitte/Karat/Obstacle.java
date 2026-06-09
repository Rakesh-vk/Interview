package interview.deloitte.Karat;



/*
        We are writing software to collect and manage data on how fast racers can complete obstacle courses. An obstacle course is a series of difficult physical challenges (like walls, hurdles, and ponds) that a racer must go through.

        Each course consists of multiple obstacles. The software stores how long it takes for racers to finish each obstacle, and provides useful statistics based on those times.

        Definitions:
        * A ""run"" is a particular attempt to complete an entire obstacle course
        * A ""run collection"" is a group of runs on a particular course by the user.
        * An ""obstacle"" is a portion of a course. We track how long it takes to finish each portion of the course

        For example, here are sometimes for an obstacle course with four obstacles:

        Obstacles:    O1  O2  O3  O4
        Run 1:      3   4   5   6    (total: 18 seconds)
        Run 2:      4   4   4   5    (total: 17 seconds)
        Run 3:      4   5   4   6    (total: 19 seconds)
        Run 4:      5   5   3        (13 seconds, but run is incomplete)

        All of these runs for one obstacle course (including the incomplete run) make up a run collection.

        2) We would like to implement a new function in RunCollection called ""bestOfBests"". This is a measure of how fast a run could be if everything went perfectly, and is determined by taking the fastest times for each obstacle across all runs (even incomplete ones) and summing them. In the run collection above, the times 3, 4, 3, and 5 combine to make a best of bests run of 15 seconds.

        Implement this function, and add a test to verify that it works. */
import java.util.*;

class Course {
    public String title;
    public int obstacleCount;

    public Course(String courseTitle, int obstacles) {
        title = courseTitle;
        obstacleCount = obstacles;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Course)) {
            return false;
        }
        Course c = (Course) o;
        return Objects.equals(c.title, this.title)
                && c.obstacleCount == this.obstacleCount;
    }

    @Override
    public int hashCode() {
        return (title == null ? 0 : title.hashCode()) * obstacleCount;
    }
}

class Run {
    public Course course;
    public boolean complete;
    public List<Integer> obstacleTimes;

    public Run(Course runCourse) {
        course = runCourse;
        complete = false;
        obstacleTimes = new ArrayList<>();
    }

    public void addObstacleTime(int obstacleTime) {
        if (complete) {
            throw new IllegalStateException("Cannot add obstacle to complete run");
        }
        obstacleTimes.add(obstacleTime);
        if (obstacleTimes.size() == course.obstacleCount) {
            complete = true;
        }
    }

    public int getRunTime() {
        if (obstacleTimes.size() != course.obstacleCount)
            return Integer.MAX_VALUE;
        return obstacleTimes.stream().mapToInt(Integer::intValue).sum();
    }
}

class RunCollection {
    public Course course;
    public List<Run> runs;

    public RunCollection(Course collectionCourse) {
        course = collectionCourse;
        runs = new ArrayList<>();
    }

    public int getNumRuns() {
        return runs.size();
    }

    public void addRun(Run run) {
        if (!run.course.equals(course)) {
            throw new IllegalArgumentException("run's Course is not the same as the RunCollection's");
        }
        runs.add(run);
    }

    public int personalBest() {
        return runs.stream().filter(x -> x.complete)
                .mapToInt(v -> v.getRunTime())
                .min()
                .orElse(Integer.MAX_VALUE);
    }


    public int bestOfBests() {
        int n = course.obstacleCount;

        int total = 0;

        for (int i = 0; i < n; i++) {

            int best = Integer.MAX_VALUE;
            for (Run run : runs) {
                if (run.obstacleTimes.size() > i) {

                    best = Math.min(best, run.obstacleTimes.get(i));

                }

            }

            total += best;
        }
        return total;
    }

    public double chanceOfPersonalBest(Run run) {
        int trials = 10000;
        int success = 0;
        Random rand = new Random();

        int personalBest = personalBest();
        int completed = run.obstacleTimes.size();

        for (int i = 0; i < trials; i++) {
            int total = run.getRunTime();

            // Fill remaining obstacles
            for (int j = completed; j < course.obstacleCount; j++) {

                List<Integer> possibleTimes = new ArrayList<>();

                // Collect all available times for obstacle j
                for (Run r : runs) {
                    if (r.obstacleTimes.size() > j) {
                        possibleTimes.add(r.obstacleTimes.get(j));
                    }
                }

                // If no data exists, skip (or could break)
                if (possibleTimes.isEmpty()) continue;

                // Pick one random time
                int randomTime = possibleTimes.get(rand.nextInt(possibleTimes.size()));
                total += randomTime;
            }

            if (total <= personalBest) {
                success++;
            }
        }

        return (double) success / trials;
    }

}

public class Obstacle {
    public static void main(String[] argv) {
        testRun();
        testRunCollection();
        //testChanceOfPersonalBest();
    }

    public static void testRun() {
        System.out.println("Running testRun");
        Course testCourse = new Course("Test course", 2);
        Run testRun = new Run(testCourse);
        testRun.addObstacleTime(3);
        assert !testRun.complete;
        testRun.addObstacleTime(5);
        assert testRun.complete;
        assert testRun.getRunTime() == 8;

        try {
            testRun.addObstacleTime(4);
            assert false;
        } catch (IllegalStateException e) {
            // expected
        }
    }

    public static RunCollection makeRunCollection(Course course, int[][] obstacleData) {
        RunCollection runCollection = new RunCollection(course);
        for (int[] runData : obstacleData) {
            Run run = new Run(course);
            for (int obstacleTime : runData) {
                run.addObstacleTime(obstacleTime);
            }
            runCollection.addRun(run);
        }
        return runCollection;
    }

    public static void testRunCollection() {
        System.out.println("Running testRunCollection");

        int[][] obstacleData = new int[][]{
                {3, 4, 5, 6},
                {4, 4, 4, 5},
                {5, 5, 3}
        };

        Course testCourse = new Course("Test course", 4);
        RunCollection runCollection = makeRunCollection(testCourse, obstacleData);

        assert runCollection.getNumRuns() == 3;
        assert runCollection.personalBest() == 17;

        // ✅ New test
        assert runCollection.bestOfBests() == 15
                : "bestOfBests should be 15, was " + runCollection.bestOfBests();
    }

  /*public static void testChanceOfPersonalBest() {
    System.out.println("Running testChanceOfPersonalBest");

    // Test 1 (optional uncomment)
    int[][] obstacleData = new int[][] { { 3, 3, 2 }, { 3, 3, 3 } };
    Course testCourse1 = new Course("Test Course", 3);
    RunCollection runCollection1 = makeRunCollection(testCourse1, obstacleData);
    Run testRun1 = new Run(testCourse1);
      testRun1.addObstacleTime(3);
      testRun1.addObstacleTime(3);

    double chance1 = runCollection1.chanceOfPersonalBest(testRun1);
    assert .48 <= chance1 && chance1 <= .52;

    // Test 2


    Course testCourse = new Course("Test Course", 4);
    RunCollection runCollection = makeRunCollection(testCourse, obstacleData);
    Run testRun = new Run(testCourse);
    testRun.addObstacleTime(3);
    testRun.addObstacleTime(3);

    double chance = runCollection.chanceOfPersonalBest(testRun);
    System.out.println(chance);

    assert .81333 <= chance && chance <= .85333;

    // Test 3
    obstacleData = new int[][] {
        { 32, 37 },
        { 31, 29, 34, 25, 25, 39 },
        { 25, 34, 38, 24, 26, 39, 33 },
        { 39, 21, 39, 34, 39, 29, 31, 22, 28, 20 },
        { 23, 22, 35, 33, 36, 21, 29, 37, 24, 34 },
        { 28, 34, 28, 22, 40, 28, 31, 33, 25, 20 },
        { 20, 38, 40, 28, 34, 22 },
        { 36, 39, 20, 32, 38, 24, 22 },
        { 40, 20, 21, 37, 32, 30, 40, 25, 37, 30 },
        { 21, 35, 30, 37, 32, 40, 26, 29, 29 }
    };

    testCourse = new Course("Test Course", 10);
    runCollection = makeRunCollection(testCourse, obstacleData);
    testRun = new Run(testCourse);
    testRun.addObstacleTime(19);
    testRun.addObstacleTime(19);
    testRun.addObstacleTime(19);

    chance = runCollection.chanceOfPersonalBest(testRun);
    System.out.println(chance);

    assert .92813 <= chance && chance <= .96813;
  }*/
}


