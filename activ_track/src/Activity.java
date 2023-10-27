public abstract class Activity {
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
        return "Type: " + type + "\nDuration: " + duration + "\nDate: " + date + "\nDistance: " + distance + "\nAverage Heart Rate: " + averageHeartRate;
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


    public abstract Intensity getIntensity();
   public abstract double getCaloriesBurned();

    public abstract double getEnergySpent();



}





