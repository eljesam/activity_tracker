import java.util.ArrayList;

public class User {
    private String name;
    ArrayList<Activity> activities = new ArrayList<>();

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
}
