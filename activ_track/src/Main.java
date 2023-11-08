import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void mainMenu() {
        System.out.println("0. Exit");
        System.out.println("1. View Activities");
        System.out.println("2. View Activity Subsets");
        System.out.println("3. View Activity Statistics");
    }

    public static void activitiesMenu() {
        System.out.println("0. Go back to main menu");
        System.out.println("1. Display all activities");
        System.out.println("2. Display activities by natural ordering");
        System.out.println("3. Display by distance in ascending order");
        System.out.println("4. Display by distance in descending order");
        System.out.println("5. Display by duration in ascending order");
        System.out.println("6. Display by duration in descending order");
        System.out.println("7. Display by calories burnt in descending order");
        System.out.println("8. Display by type");
        System.out.println("9. Display by date in ascending order");
        System.out.println("10. Display by date in descending order");
        //subsets
    }

    public static void subsetMenu() {
        System.out.println("0. Go back to main menu");
        System.out.println("1. Display one type of activity");
        System.out.println("2. display activities above a certain distance");
        System.out.println("3. Display activities above a certain duration");
        System.out.println("4. Display activities on type of energy expended");
    }

    public static void statisticsMenu() {
        System.out.println("0. Go back to main menu");
        System.out.println("1. Average distance per activity");
        System.out.println("2. Average calories burned");

    }
    public static void searchMenu(){
        System.out.println("0. Go back to main menu");
        System.out.println("1. Search by type");
        System.out.println("2. Search by date");
        System.out.println("3. Search by duration");
        System.out.println("4. Search by distance");
        System.out.println("5. Search by average heart rate");
        System.out.println("6. Search by intensity");
    }
//        System.out.println("3. Display activities based on the longest distance per time");
//        System.out.println("4. Display data by type");
//        System.out.println("5. Display all activities by duration");
////        System.out.println("6. Display all activities by date");
//        System.out.println("6. Display all activities by distance");
//        System.out.println("7. Display all activities by average heart rate");
//        System.out.println("8. Display all activities by intensity");

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
        type = st.nextToken().trim();
        date = st.nextToken().trim();
        duration = Integer.parseInt(st.nextToken().trim());
        distance = Double.parseDouble(st.nextToken().trim());
        averageHeartRate = Integer.parseInt(st.nextToken().trim());
        if (Objects.equals(type, "Running")) {
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
        System.out.println("Chose File");
        System.out.println("1. activity_data_10.csv");
        System.out.println("2. activity_data_50.csv");
        System.out.println("3. activity_data_100.csv");
        System.out.println("4. activity_data_1000.csv");

        int fileChoice = input.nextInt();
        switch (fileChoice) {
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
        mainMenu();
        int mainChoice = input.nextInt();
        while (mainChoice != 0) {

            if (mainChoice == 1) {
                activitiesMenu();
                int activitiesChoice = input.nextInt();
                while (activitiesChoice != 0) {


                    switch (activitiesChoice) {
                        case 1:
                            a.display();
                            break;
                        case 2:
                            a.displayByNaturalOrdering();
                            break;
                        case 3:
                            a.displayByDistanceAsc();
                            break;
                        case 4:
                            a.displayByDistanceDesc();
                            break;
                        case 5:
                            a.displayByDurationAsc();
                            break;
                        case 6:
                            a.displayByDurationDesc();
                            break;
                        case 7:
                            a.displayByCalories();
                            break;
                        case 8:
                            a.displayAllByType();
                            break;
                        case 9:
                            a.displayByDateAsc();
                            break;
                        case 10:
                            a.displayByDateDesc();
                            break;
                        default:
                            System.out.println("Invalid choice");
                    }
                    activitiesMenu();
                    activitiesChoice = input.nextInt();
                }

            } else if (mainChoice == 2) {
                subsetMenu();
                int subsetChoice = input.nextInt();
                while (subsetChoice != 0) {


                    switch (subsetChoice) {
                        case 11:
                            System.out.println("Enter type of activity");
                            String s = input.next();
                            a.displayByTypeInput(s);
                            break;

                        case 12:
                            System.out.println("Enter distance");
                            int distance = input.nextInt();
                            a.displayAboveDistance(distance);
                            break;

                        case 13:
                            System.out.println("Enter duration");
                            int duration = input.nextInt();
                            a.displayAboveDuration(duration);
                            break;

                        case 14:
                            System.out.println("Select type of energy expended");
                            System.out.println("1. Very Light 2. Light 3. Moderate 4. Vigorous 5. Very Vigorous");
                            int typeChoice = input.nextInt();
                            switch (typeChoice) {
                                case 1:
                                    a.displayByTypeOfEnergy(Intensity.VERY_LIGHT);
                                    break;
                                case 2:
                                    a.displayByTypeOfEnergy(Intensity.LIGHT);
                                    break;
                                case 3:
                                    a.displayByTypeOfEnergy(Intensity.MODERATE);
                                    break;
                                case 4:
                                    a.displayByTypeOfEnergy(Intensity.VIGOROUS);
                                    break;
                                case 5:
                                    a.displayByTypeOfEnergy(Intensity.VERY_VIGOROUS);
                                    break;
                                default:
                                    System.out.println("Invalid choice");
                            }
                            subsetMenu();
                            subsetChoice = input.nextInt();
                    }
                }
            } else if (mainChoice == 3) {
                statisticsMenu();
                int statisticsChoice = input.nextInt();
                while (statisticsChoice != 0) {
                    switch (statisticsChoice) {
                        case 1:
                            a.averageDistancePerActivity(activities);
                            break;
                        case 2:
                            a.averageCaloriesBurned(activities);
                            break;
                        default:
                            System.out.println("Invalid choice");
                    }
                    statisticsMenu();
                    statisticsChoice = input.nextInt();
                }

            } else if ( mainChoice == 4) {


            }

/*
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
*/



            }


        }
    }