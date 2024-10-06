import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Activity {
    String name;
    double hours;

    Activity(String name, double hours) {
        this.name = name;
        this.hours = hours;
    }

    public String toString() {
        return name + " - " + hours + " hours";
    }
}

public class SportsTracker {
    private List<Activity> activities;

    public SportsTracker() {
        activities = new ArrayList<>();
    }

    public void logActivity(String name, double hours) {
        activities.add(new Activity(name, hours));
    }

    public void viewActivities() {
        if (activities.isEmpty()) {
            System.out.println("No activities logged yet.");
        } else {
            System.out.println("Logged Activities:");
            for (Activity activity : activities) {
                System.out.println(activity);
            }
        }
    }

    public double calculateTotalTime() {
        double totalTime = 0;
        for (Activity activity : activities) {
            totalTime += activity.hours;
        }
        return totalTime;
    }

    public static void main(String[] args) {
        SportsTracker tracker = new SportsTracker();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Log a new activity");
            System.out.println("2. View logged activities");
            System.out.println("3. Calculate total time spent on sports");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter activity name: ");
                    String name = scanner.next();
                    System.out.print("Enter hours spent: ");
                    double hours = scanner.nextDouble();
                    tracker.logActivity(name, hours);
                    break;
                case 2:
                    tracker.viewActivities();
                    break;
                case 3:
                    System.out.println("Total time spent: " + tracker.calculateTotalTime() + " hours");
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

