public class Swimming extends Activity{

    public Swimming(String type, int duration, String date, double distance, int averageHeartRate) {
        super(type, duration, date, distance, averageHeartRate);
    }
    public Intensity getIntensity(Activity s) {
        if (s.getAverageSpeed(s.getDistance(),s.durationInHours()) < 4) {
            return Intensity.VERY_LIGHT;
        } else if (s.getAverageSpeed(s.getDistance(),s.durationInHours()) >= 4 && s.getAverageSpeed(s.getDistance(),s.durationInHours()) < 8) {
            return Intensity.LIGHT;
        } else if (s.getAverageSpeed(s.getDistance(),s.durationInHours()) >= 8 && s.getAverageSpeed(s.getDistance(),s.durationInHours()) < 12) {
            return Intensity.MODERATE;
        } else if (s.getAverageSpeed(s.getDistance(),s.durationInHours()) >= 12 && s.getAverageSpeed(s.getDistance(),s.durationInHours()) < 16) {
            return Intensity.VIGOROUS;
        } else if (s.getAverageSpeed(s.getDistance(),s.durationInHours()) >= 16)
            return Intensity.VERY_VIGOROUS;
        else{
            return null;
        }
    }

    public double getCaloriesBurned() {
        return 0;
    }


    public double getEnergySpent() {
        return 0;

}
