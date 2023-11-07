import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class User {
    private String name;
    ArrayList<Activity> activities = new ArrayList<Activity>();

    public User(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    public void display(){
        //display activities as a table
        System.out.printf("%20s %30s %30s %30s %30s %30s %30s %30s\n", "Type", "Date", "Duration", "Distance", "Average Heart Rate", "Intensity", "Calories Burnt", "Energy Expended");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for(Activity activities : activities){
            System.out.printf("%20s %30s %30d %30.2f %30d %30s %30.2f %30.2f\n", activities.getType(), activities.getDate(), activities.getDuration(), activities.getDistance(), activities.getAverageHeartRate(), activities.getIntensity(),activities.getCaloriesBurned(), activities.getEnergySpent());
        }
    }

public void displayByNaturalOrdering(){
Collections.sort(activities);
display();
}

    public void displayByCalories(){
       //calories burnt in descending order
        Collections.sort(activities,
                (Activity a, Activity b) -> {
                    return (int) (b.getCaloriesBurned() - a.getCaloriesBurned());
                });
        display();
    }

    public void displayByTypeInput(String s){
        //sort by type and display as a table
        System.out.printf("%20s %30s %30s %30s %30s %30s %30s %30s\n", "Type", "Date", "Duration", "Distance", "Average Heart Rate", "Intensity", "Calories Burnt", "Energy Expended");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for(Activity activities : activities){
            if(activities.getType().equals(s)){
                System.out.printf("%20s %30s %30d %30.2f %30d %30s %30.2f %30.2f\n", activities.getType(), activities.getDate(), activities.getDuration(), activities.getDistance(), activities.getAverageHeartRate(), activities.getIntensity(),activities.getCaloriesBurned(), activities.getEnergySpent());
            }
        }
    }
    public void displayAllByType(){
        //sort table by type
        Collections.sort(activities,
                (Activity a, Activity b) -> {
                    return a.getType().compareTo(b.getType());
                });
        display();
    }

    public void displayByDateAsc(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Collections.sort(activities,
                (Activity a, Activity b) -> LocalDate.parse(a.getDate(), formatter).
                compareTo(LocalDate.parse(b.getDate(), formatter)));
        display();
    }

    public void displayByDateDesc(){
       //use compare method to sort by date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Collections.sort(activities,
                (Activity a, Activity b) -> LocalDate.parse(b.getDate(), formatter).
                        compareTo(LocalDate.parse(a.getDate(), formatter)));
        display();

        display();
    }

    public void displayAboveDistance(int distance){
        //take in distance and display activities above that distance as a table
System.out.printf("%20s %30s %30s %30s %30s %30s %30s %30s\n", "Type", "Date", "Duration", "Distance", "Average Heart Rate", "Intensity", "Calories Burnt", "Energy Expended");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for(Activity activities : activities) {
            if (activities.getDistance() > distance) {
                System.out.printf("%20s %30s %30d %30.2f %30d %30s %30.2f %30.2f\n", activities.getType(), activities.getDate(), activities.getDuration(), activities.getDistance(), activities.getAverageHeartRate(), activities.getIntensity(), activities.getCaloriesBurned(), activities.getEnergySpent());
            }
        }
    }

        public void displayAboveDuration(int duration){
        //take in duration and display activities above that duration as a table
System.out.printf("%20s %30s %30s %30s %30s %30s %30s %30s\n", "Type", "Date", "Duration", "Distance", "Average Heart Rate", "Intensity", "Calories Burnt", "Energy Expended");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for(Activity activities : activities){
            if(activities.getDuration() > duration){
                System.out.printf("%20s %30s %30d %30.2f %30d %30s %30.2f %30.2f\n", activities.getType(), activities.getDate(), activities.getDuration(), activities.getDistance(), activities.getAverageHeartRate(), activities.getIntensity(),activities.getCaloriesBurned(), activities.getEnergySpent());
            }
        }
    }
    public void displayByDuration(){
        Collections.sort(activities,
                (Activity a, Activity b) -> {
                    return b.getDuration() - a.getDuration();
                });
        display();
    }

    public void displayByHeartRate(){
        Collections.sort(activities,
                (Activity a, Activity b) -> {
                    return b.getAverageHeartRate() - a.getAverageHeartRate();
                });
        display();
    }

    public void displayByDistanceAsc(){
        Collections.sort(activities,
                (Activity a, Activity b) -> {
                    return (int) (a.getDistance() - b.getDistance());
                });
        display();
    }

    public void displayByDistanceDesc(){
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

    public void displayByDurationAsc(){
        Collections.sort(activities,
                (Activity a, Activity b) -> {
                    return a.getDuration() - b.getDuration();
                });
        display();
    }

public void displayByDurationDesc(){
        Collections.sort(activities,
                (Activity a, Activity b) -> {
                    return b.getDuration() - a.getDuration();
                });
        display();
    }



//    public void displayByDate() {
//        Collections.sort(activities,
//                (Activity a, Activity b) -> {
//                    return a.getDate().compareTo(b.getDate());
//                });
//        display();
//    }

}
