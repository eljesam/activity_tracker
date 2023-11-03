import java.util.Objects;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void displayMenu(){
        System.out.println("1. Display all activities");
    }
    public static void readFile(String filename, ArrayList<Activity> activities,
                                boolean hasHeaders) throws IOException {
        File file = new File(filename);
        Scanner in = new Scanner(file);
        String line;
        boolean headersRead = false;
        while (in.hasNextLine()) {
            line = in.nextLine();
            if (!hasHeaders || hasHeaders && headersRead) {
                if (line != " ") {
                    Activity a = parseLine(line);
                    activities.add(a);
                }
            } else {
                headersRead = true;
            }
        }
    }

    public static Activity parseLine(String line) {

        String type;
        int duration;
        String date;
        double distance;
        int averageHeartRate;
        StringTokenizer st = new StringTokenizer(line, ",");
        type = st.nextToken();
        date = st.nextToken();
        duration = Integer.parseInt(st.nextToken().trim());
        distance = Double.parseDouble(st.nextToken().trim());
        averageHeartRate = Integer.parseInt(st.nextToken().trim());
        if (Objects.equals(type, "Running")){
            return new Running(type, duration, date, distance, averageHeartRate);

        } else if (Objects.equals(type, "Cycling")) {
            return new Cycling(type, duration, date, distance, averageHeartRate);
        } else {
            return new Swimming(type, duration, date, distance, averageHeartRate);
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        User a = new User("John");
        ArrayList<Activity> activities = new ArrayList<>();
        readFile("activity_data_10.csv", activities, true);
        a.activities = activities;
        displayMenu();
        int choice = input.nextInt();
        while (choice != 0) {
            switch (choice) {
                case 1:
                    a.display();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
            displayMenu();
            choice = input.nextInt();
        }


    }
}