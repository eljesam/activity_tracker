import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
public class Main {
    public static void readFile(String filename, Arraylist<Activity> acitivity, boolean hasHeaders) throws IOException {
        File file = new File(filename);
        Scanner in = new Scanner(file);
        String line;
        boolean headersRead = false;
        while (in.hasNextLine()) {
            line = in.nextLine();
            if (!hasHeaders || hasHeaders && headersRead) {
                if (line != " ") {
                    Activity a = parseLine(line);
                    activity.add(a);
                }
            } else {
                headersRead = true;
            }
        }
    }

    public static Acitivity parseLine(String line){

    }
}