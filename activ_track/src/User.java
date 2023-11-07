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
        Collections.sort(activities, new Comparator<Activity>(){
            public int compare(Activity a, Activity b){
                return (int) (a.getCaloriesBurned() - b.getCaloriesBurned());

            }
        });
        display();
    }

    public ArrayList<Activity> displayByType(String s){
        ArrayList<Activity> temp = new ArrayList<Activity>();
        for(Activity activity : activities){
            if(activity.getType().equalsIgnoreCase(s)){
                temp.add(activity);
            }
        }
        return temp;
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

    public void displayByDistance(){
        Collections.sort(activities,
                (Activity a, Activity b) -> {
                    return Double.compare(b.getDistance(), a.getDistance());
                });
        display();
    }

    public void displayByIntensity() {
        Collections.sort(activities,
                Comparator.comparing(Activity::getIntensity));
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
