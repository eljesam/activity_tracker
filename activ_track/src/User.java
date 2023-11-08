import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import static java.util.Collections.binarySearch;

public class User {
    private String name;
    ArrayList<Activity> activities = new ArrayList<Activity>();

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public void display() {
        //display activities as a table
        System.out.printf("%20s %30s %30s %30s %30s %30s %30s %30s\n", "Type", "Date", "Duration", "Distance", "Average Heart Rate", "Intensity", "Calories Burnt", "Energy Expended");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Activity activities : activities) {
            System.out.printf("%20s %30s %30d %30.2f %30d %30s %30.2f %30.2f\n", activities.getType(), activities.getDate(), activities.getDuration(), activities.getDistance(), activities.getAverageHeartRate(), activities.getIntensity(), activities.getCaloriesBurned(), activities.getEnergySpent());
        }
    }

    public void displayByNaturalOrdering() {
Collections.sort(activities);
        display();
    }

    public void displayByCalories() {
        //calories burnt in descending order
        Collections.sort(activities,
                (Activity a, Activity b) -> {
                    return (int) (b.getCaloriesBurned() - a.getCaloriesBurned());
                });
        display();
    }

    public void displayByTypeInput(String s) {
        //sort by type and display as a table
        System.out.printf("%20s %30s %30s %30s %30s %30s %30s %30s\n", "Type", "Date", "Duration", "Distance", "Average Heart Rate", "Intensity", "Calories Burnt", "Energy Expended");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Activity activities : activities) {
            if (activities.getType().equals(s)) {
                System.out.printf("%20s %30s %30d %30.2f %30d %30s %30.2f %30.2f\n", activities.getType(), activities.getDate(), activities.getDuration(), activities.getDistance(), activities.getAverageHeartRate(), activities.getIntensity(), activities.getCaloriesBurned(), activities.getEnergySpent());
            }
        }
    }

    public void displayAllByType() {
        //sort table by type
        Collections.sort(activities,
                (Activity a, Activity b) -> {
                    return a.getType().compareTo(b.getType());
                });
        display();
    }

    public void displayByDateAsc() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Collections.sort(activities,
                (Activity a, Activity b) -> LocalDate.parse(a.getDate(), formatter).
                        compareTo(LocalDate.parse(b.getDate(), formatter)));
        display();
    }

    public void displayByDateDesc() {
        //use compare method to sort by date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Collections.sort(activities,
                (Activity a, Activity b) -> LocalDate.parse(b.getDate(), formatter).
                        compareTo(LocalDate.parse(a.getDate(), formatter)));
        display();

        display();
    }

    public void displayAboveDistance(int distance) {
        //take in distance and display activities above that distance as a table
        System.out.printf("%20s %30s %30s %30s %30s %30s %30s %30s\n", "Type", "Date", "Duration", "Distance", "Average Heart Rate", "Intensity", "Calories Burnt", "Energy Expended");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Activity activities : activities) {
            if (activities.getDistance() > distance) {
                System.out.printf("%20s %30s %30d %30.2f %30d %30s %30.2f %30.2f\n", activities.getType(), activities.getDate(), activities.getDuration(), activities.getDistance(), activities.getAverageHeartRate(), activities.getIntensity(), activities.getCaloriesBurned(), activities.getEnergySpent());
            }
        }
    }

    public void displayAboveDuration(int duration) {
        //take in duration and display activities above that duration as a table
        System.out.printf("%20s %30s %30s %30s %30s %30s %30s %30s\n", "Type", "Date", "Duration", "Distance", "Average Heart Rate", "Intensity", "Calories Burnt", "Energy Expended");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Activity activities : activities) {
            if (activities.getDuration() > duration) {
                System.out.printf("%20s %30s %30d %30.2f %30d %30s %30.2f %30.2f\n", activities.getType(), activities.getDate(), activities.getDuration(), activities.getDistance(), activities.getAverageHeartRate(), activities.getIntensity(), activities.getCaloriesBurned(), activities.getEnergySpent());
            }
        }
    }

    public void displayByDuration() {
        Collections.sort(activities,
                (Activity a, Activity b) -> {
                    return b.getDuration() - a.getDuration();
                });
        display();
    }

    public void displayByHeartRate() {
        Collections.sort(activities,
                (Activity a, Activity b) -> {
                    return b.getAverageHeartRate() - a.getAverageHeartRate();
                });
        display();
    }

    public void displayByDistanceAsc() {
        Collections.sort(activities,
                (Activity a, Activity b) -> {
                    return (int) (a.getDistance() - b.getDistance());
                });
        display();
    }

    public void displayByDistanceDesc() {
        Collections.sort(activities,
                (Activity a, Activity b) -> {
                    return (int) (b.getDistance() - a.getDistance());
                });
        display();
    }

    public void displayByIntensity() {
        Collections.sort(activities,
                Comparator.comparing(Activity::getIntensity));
        display();
    }

    public void displayByDurationAsc() {
        Collections.sort(activities,
                (Activity a, Activity b) -> {
                    return a.getDuration() - b.getDuration();
                });
        display();
    }

    public void displayByDurationDesc() {
        Collections.sort(activities,
                (Activity a, Activity b) -> {
                    return b.getDuration() - a.getDuration();
                });
        display();
    }

    public void displayByTypeOfEnergy(Intensity EnergyType) {
//take in intensity and display activities of that intensity as a table
        System.out.printf("%20s %30s %30s %30s %30s %30s %30s %30s\n", "Type", "Date", "Duration", "Distance", "Average Heart Rate", "Intensity", "Calories Burnt", "Energy Expended");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Activity activities : activities) {
            if (activities.getIntensity().equals(EnergyType)) {
                System.out.printf("%20s %30s %30d %30.2f %30d %30s %30.2f %30.2f\n", activities.getType(), activities.getDate(), activities.getDuration(), activities.getDistance(), activities.getAverageHeartRate(), activities.getIntensity(), activities.getCaloriesBurned(), activities.getEnergySpent());
            }
        }
    }

    public void averageDistancePerActivity(ArrayList<Activity> activities) {
        //calculate average distance per activity type
        double totalRunningDistance = 0;
        double totalCyclingDistance = 0;
        double totalSwimmingDistance = 0;
        int runningCount = 0;
        int cyclingCount = 0;
        int swimmingCount = 0;
        for (Activity activity : activities) {
           if (activity.getType().equals("Running")) {
                totalRunningDistance += activity.getDistance();
                runningCount++;
            } else if (activity.getType().equals("Cycling")) {
                totalCyclingDistance += activity.getDistance();
                cyclingCount++;
            } else  {
                totalSwimmingDistance += activity.getDistance();
                swimmingCount++;
            }
        }
        System.out.println("Average distance for Running: " + totalRunningDistance / runningCount);
        System.out.println("Average distance for Cycling: " + totalCyclingDistance / cyclingCount);
        System.out.println("Average distance for Swimming: " + totalSwimmingDistance / swimmingCount);

    }

    public void averageCaloriesBurned(ArrayList<Activity> activities) {
        //calculate average calories burnt in total
        double totalCaloriesBurned = 0;
        for (Activity activity : activities) {
            totalCaloriesBurned += activity.getCaloriesBurned();
        }
        System.out.println("Average calories burnt: " + totalCaloriesBurned / activities.size());
    }

    int binarySearch(ArrayList<Activity> activities, String date) {
        //binary search for date
        int left = 0;
        int right = activities.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int res = date.compareTo(activities.get(mid).getDate());
            if (res == 0)
                return mid;
            if (res > 0)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
public void searchByDate(){
        //using binary search to search for activities by date
    Scanner sc = new Scanner(System.in);
    Collections.sort(activities);
    System.out.println("Enter date to search for (in format dd/mm/yyyy: ");
    String date = sc.nextLine();
    int result = binarySearch(activities, date);
    if (result == -1)
        System.out.println("Activity not found");
    else
        System.out.println(activities.get(result));
}
}



//    public void displayByDate() {
//        Collections.sort(activities,
//                (Activity a, Activity b) -> {
//                    return a.getDate().compareTo(b.getDate());
//                });
//        display();
//    }


