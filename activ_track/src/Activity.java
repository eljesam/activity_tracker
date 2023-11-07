import java.util.ArrayList;

public abstract class Activity implements Comparable<Activity> {
    //field type of activity
    private String type;
    private String date;
    //field duration
    private int duration;


    //field date


    //field distance
    private double distance;

    //field average heart rate
    private int averageHeartRate;


    //default constructor
    public Activity() {
        type = " ";
        duration = 0;
        date = " ";
        distance = 0.0;
        averageHeartRate = 0;
    }

    //constructor
    public Activity(String type, int duration, String date, double distance, int averageHeartRate) {
        this.type = type;
        this.duration = duration;
        this.date = date;
        this.distance = distance;
        this.averageHeartRate = averageHeartRate;
    }

    //getters
    public String getType() {
        return type;
    }

    public int getDuration() {
        return duration;
    }

    public String getDate() {
        return date;
    }

    public double getDistance() {
        return distance;
    }

    public int getAverageHeartRate() {
        return averageHeartRate;
    }

    //setters
    public void setType(String type) {
        this.type = type;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setAverageHeartRate(int averageHeartRate) {
        this.averageHeartRate = averageHeartRate;
    }

    //toString method

    @Override
    public String toString() {
        return "Type: " + type + "\tDuration: " + duration + "\tDate: " + date + "\tDistance: " + distance + "\tAverage Heart Rate: " + averageHeartRate;
    }
    //equals to method

    @Override
    public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Activity)) return false;
            Activity activity = (Activity) o;
            return getDuration() == activity.getDuration() &&
                    Double.compare(activity.getDistance(), getDistance()) == 0 &&
                    getAverageHeartRate() == activity.getAverageHeartRate() &&
                    getType().equals(activity.getType()) &&
                    getDate().equals(activity.getDate());
    }

    @Override
    public int compareTo(Activity a) {
        if (this.getCaloriesBurned() > a.getCaloriesBurned()) {
            return -1;
        } else if (this.getCaloriesBurned() < a.getCaloriesBurned()) {
            return 1;
        } else {
            return 0;
        }
    }
    //calculate the duration from minutes to hours
    public double durationInHours(){
        return duration/60.0;
    }

    //calculate the average speed
    public  double getAverageSpeed(double distance, double durationInHours){
        return distance/durationInHours();
    }

    public abstract Intensity getIntensity();
   public abstract double getCaloriesBurned();

    public abstract double getEnergySpent();




}





