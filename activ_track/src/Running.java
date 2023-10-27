public class Running extends Activity {

    public Running(String type, int duration, String date, double distance, int averageHeartRate) {
        super(type, duration, date, distance, averageHeartRate);
    }
    public Intensity getIntensity() {
        return null;
    }

    public double getCaloriesBurned() {
        return 0;
    }

    public double getEnergySpent() {
        return 0;
    }

}
