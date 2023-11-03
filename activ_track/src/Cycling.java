public class Cycling extends Activity{

    public Cycling(String type, int duration, String date, double distance, int averageHeartRate) {
        super(type, duration, date, distance, averageHeartRate);
    }
    public Intensity getIntensity(Activity c) {
        if (c.getAverageSpeed(c.getDistance(),c.durationInHours()) < 4) {
            return Intensity.VERY_LIGHT;
        } else if (c.getAverageSpeed(c.getDistance(),c.durationInHours()) >= 4 && c.getAverageSpeed(c.getDistance(),c.durationInHours()) < 8) {
            return Intensity.LIGHT;
        } else if (c.getAverageSpeed(c.getDistance(),c.durationInHours()) >= 8 && c.getAverageSpeed(c.getDistance(),c.durationInHours()) < 12) {
            return Intensity.MODERATE;
        } else if (c.getAverageSpeed(c.getDistance(),c.durationInHours()) >= 12 && c.getAverageSpeed(c.getDistance(),c.durationInHours()) < 16) {
            return Intensity.VIGOROUS;
        } else if (c.getAverageSpeed(c.getDistance(),c.durationInHours()) >= 16)
            return Intensity.VERY_VIGOROUS;
        else{
            return null;
        }
    }

    public double getCaloriesBurned(Activity c) {
        return c.getEnergySpent(c)*c.getDuration();
    }

    public double getEnergySpent(Activity c) {
        if (c.getIntensity(c) == Intensity.VERY_LIGHT) {
            return 2;
        } else if (c.getIntensity(c) == Intensity.LIGHT) {
            return 5;
        }else if (c.getIntensity(c)==Intensity.MODERATE){
            return 7;
        } else if (c.getIntensity(c)==Intensity.VIGOROUS){
            return 13;
        } else {
            return 15;
    }

}}
