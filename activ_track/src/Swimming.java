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

    public double getCaloriesBurned(Activity s) {
        return s.getEnergySpent(s)*s.getDuration();
    }


    public double getEnergySpent(Activity s) {
        if (s.getIntensity(s) == Intensity.VERY_LIGHT) {
            return 5;
        } else if (s.getIntensity(s) == Intensity.LIGHT) {
            return 6.3;
        } else if (s.getIntensity(s) == Intensity.MODERATE) {
            return 7.6;
        } else if (s.getIntensity(s) == Intensity.VIGOROUS) {
            return 8.9;
        } else {
            return 10.2;
        }
    }
}
