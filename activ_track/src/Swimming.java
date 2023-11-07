public class Swimming extends Activity{
    private Intensity intensity;
    private double caloriesBurnt;
    private double energySpent;
    public Swimming(String type, int duration, String date, double distance, int averageHeartRate) {
        super(type, duration, date, distance, averageHeartRate);
        this.intensity= getIntensity();
        this.caloriesBurnt=getCaloriesBurned();
        this.energySpent=getEnergySpent();
    }
    public Intensity getIntensity() {
        if (getAverageSpeed(getDistance(),durationInHours()) <= 0.5) {
            return Intensity.VERY_LIGHT;
        } else if (getAverageSpeed(getDistance(),durationInHours()) <= 1.25) {
            return Intensity.LIGHT;
        } else if (getAverageSpeed(getDistance(),durationInHours()) <= 2) {
            return Intensity.MODERATE;
        } else if (getAverageSpeed(getDistance(),durationInHours()) <=2.75) {
            return Intensity.VIGOROUS;
        } else if (getAverageSpeed(getDistance(),durationInHours()) >2.75)
            return Intensity.VERY_VIGOROUS;
        else{
            return null;
        }
    }

    public double getCaloriesBurned() {
        return getEnergySpent()*getDuration();
    }


    public double getEnergySpent() {
        if (getIntensity() == Intensity.VERY_LIGHT) {
            return 5;
        } else if (getIntensity() == Intensity.LIGHT) {
            return 6.3;
        } else if (getIntensity() == Intensity.MODERATE) {
            return 7.6;
        } else if (getIntensity() == Intensity.VIGOROUS) {
            return 8.9;
        } else {
            return 10.2;
        }
    }
    public String toString(){
        return "Swimming{"+super.toString()+"\tIntensity: "+intensity+"\tCalories Burnt: "+caloriesBurnt+"\tEnergy Spent: "+energySpent+"}";
    }
}
