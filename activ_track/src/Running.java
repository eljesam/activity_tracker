public class Running extends Activity {

    public Running(String type, int duration, String date, double distance, int averageHeartRate) {
        super(type, duration, date, distance, averageHeartRate);
    }

    public Intensity getIntensity(Activity r)
    {
        //if speed is less than 4 km/h, return VERY_LIGHT
        if (r.getAverageSpeed(r.getDistance(),r.durationInHours()) < 4) {
            return Intensity.VERY_LIGHT;
        } else if (r.getAverageSpeed(r.getDistance(),r.durationInHours()) >= 4 && r.getAverageSpeed(r.getDistance(),r.durationInHours()) < 8) {
            return Intensity.LIGHT;
        } else if (r.getAverageSpeed(r.getDistance(),r.durationInHours()) >= 8 && r.getAverageSpeed(r.getDistance(),r.durationInHours()) < 12) {
            return Intensity.MODERATE;
        } else if (r.getAverageSpeed(r.getDistance(),r.durationInHours()) >= 12 && r.getAverageSpeed(r.getDistance(),r.durationInHours()) < 16) {
            return Intensity.VIGOROUS;
        } else if (r.getAverageSpeed(r.getDistance(),r.durationInHours()) >= 16)
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


}
