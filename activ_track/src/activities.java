public class activities {
    //field type of activity
    private String type;

    //field duration
    private int duration;

    //field date
    private String date;

    //field distance
    private double distance;

    //field average heart rate
    private int averageHeartRate;

    //field energy
    private int energy;

    //field calories burnt
    private int caloriesBurnt;
    //default constructor
    public activities(){
        type = " ";
        duration = 0;
        date = " ";
        distance = 0.0;
        averageHeartRate = 0;
        energy = 0;
        caloriesBurnt = 0;
    }
    //constructor
    public activities(String type, int duration, String date, double distance, int averageHeartRate, int energy, int caloriesBurnt){
        this.type = type;
        this.duration = duration;
        this.date = date;
        this.distance = distance;
        this.averageHeartRate = averageHeartRate;
        this.energy = energy;
        this.caloriesBurnt = caloriesBurnt;
    }

    //getters
    public String getType() {
        return type;
    }
    public int getDuration(){
        return duration;
    }
    public String getDate(){
        return date;
    }
    public double getDistance(){
        return distance;
    }
    public int getAverageHeartRate(){
        return averageHeartRate;
    }
    public int getEnergy(){
        return energy;
    }
    public int getCaloriesBurnt(){
        return caloriesBurnt;
    }
    //setters
    public void setType(String type){
        this.type = type;
    }
    public void setDuration(int duration){
        this.duration = duration;
    }
    public void setDate(String date){
        this.date = date;
    }
    public void setDistance(double distance){
        this.distance = distance;
    }
    public void setAverageHeartRate(int averageHeartRate){
        this.averageHeartRate = averageHeartRate;
    }
    public void setEnergy(int energy){
        this.energy = energy;
    }
    public void setCaloriesBurnt(int caloriesBurnt){
        this.caloriesBurnt = caloriesBurnt;
    }
    //toString method

    @Override
    public String toString(){
        return "Type: " + type + "\nDuration: " + duration + "\nDate: " + date + "\nDistance: " + distance + "\nAverage Heart Rate: " + averageHeartRate + "\nEnergy: " + energy + "\nCalories Burnt: " + caloriesBurnt;
    }



}
