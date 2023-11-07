
public class Running extends Activity {
    private Intensity intensity;
    private double caloriesBurnt;
    private double energySpent;

    public Running(String type, int duration, String date, double distance, int averageHeartRate) {
        super(type, duration, date, distance, averageHeartRate);
        this.intensity= getIntensity();
        this.caloriesBurnt=getCaloriesBurned();
        this.energySpent=getEnergySpent();

    }

    public Intensity getIntensity()
    {

        //if speed is less than 4 km/h, return VERY_LIGHT
        if (getAverageSpeed(getDistance(),durationInHours()) <= 4) {
            return Intensity.VERY_LIGHT;
        } else if (getAverageSpeed(getDistance(),durationInHours()) <= 8) {
            return Intensity.LIGHT;
        } else if (getAverageSpeed(getDistance(),durationInHours()) <= 12) {
            return Intensity.MODERATE;
        } else if (getAverageSpeed(getDistance(),durationInHours()) <= 16) {
            return Intensity.VIGOROUS;
        } else if (getAverageSpeed(getDistance(),durationInHours()) <= 24)
            return Intensity.VERY_VIGOROUS;
        else{
            return null;
        }
    }

    public double getCaloriesBurned() {
        //intensity*duration in minutes
        return getEnergySpent()*getDuration();

    }

    public double getEnergySpent() {
        if (getIntensity() == Intensity.VERY_LIGHT) {
            return 4.1;
        } else if (getIntensity() == Intensity.LIGHT) {
            return 7.2;
        } else if (getIntensity() == Intensity.MODERATE) {
            return 10;
        } else if (getIntensity() == Intensity.VIGOROUS) {
            return 15.4;
        } else {
            return 20.8;
        }
    }

        public String toString(){
return "Running{"+super.toString()+"\tIntensity: "+intensity+"\tCalories Burnt: "+caloriesBurnt+"\tEnergy Spent: "+energySpent+"}";
        }




}
