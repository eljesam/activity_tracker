import java.util.Objects;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void displayMenu(){
        System.out.println("0. Exit");
        System.out.println("1. Display all activities");
        System.out.println("2. Display all activities by natural ordering");
        System.out.println("3. Display activities based on the longest distance per time");
        System.out.println("4. Display all activities by type");
        System.out.println("5. Display all activities by duration");
//        System.out.println("6. Display all activities by date");
        System.out.println("6. Display all activities by distance");
        System.out.println("7. Display all activities by average heart rate");
        System.out.println("8. Display all activities by intensity");
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
        String filename = "";
        System.out.println("Enter filename");
        System.out.println("1. activity_data_10.csv");
        System.out.println("2. activity_data_50.csv");
        System.out.println("3. activity_data_100.csv");
        System.out.println("4. activity_data_1000.csv");

        int choice1 = input.nextInt();
        switch (choice1) {
            case 1:
                filename = "activity_data_10.csv";
                break;
            case 2:
                filename = "activity_data_50.csv";
                break;
            case 3:
                filename = "activity_data_100.csv";
                break;
            case 4:
                filename = "activity_data_1000.csv";
                break;
            default:
                System.out.println("Invalid choice");
        }



        readFile(filename, activities, true);
        a.activities = activities;
        displayMenu();
        int choice = input.nextInt();
        while (choice != 0) {
            switch (choice) {
                case 1:
                    a.display();
                    break;
                case 2:
                    a.displayByNaturalOrdering();
                    break;
                case 3:
                    a.displayByCalories();
                    break;
                case 4:
                    System.out.println("Enter type of activity");
                    String s = input.next();
                    a.displayByType(s);
                    if (a.displayByType(s).isEmpty()) {
                        System.out.println("No activities of this type");
                    } else {
                        for (Activity activity : a.displayByType(s)) {
                            System.out.println(activity);
                        }
                    }

                    break;
                case 5:
                    a.displayByDuration();
                    break;
//                case 6:
//                    a.displayByDate();
//                    break;
                case 6:
                    a.displayByDistance();
                    break;
                case 7:
                    a.displayByHeartRate();
                    break;
                case 8:
                    a.displayByIntensity();
                    break;

                default:
                    System.out.println("Invalid choice");
            }
            displayMenu();
            choice = input.nextInt();
        }


    }
}