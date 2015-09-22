import java.util.*;
import java.lang.reflect.Array;
/**
 * Created by MacBookEr on 9/22/15.
 */
public class Algorithm {

    private String testsAreWorkingMessage = "Tests are working";

    public String getTestsAreWorkingMessage() {
        return this.testsAreWorkingMessage;
    }

    public ArrayList <Integer> convertStringIntoGrid(String stringToConvert) {
        ArrayList <Integer> result = new ArrayList<>();
        String[] converted = stringToConvert.split(" ");
        int counter = 0;
        while(counter < converted.length) {
            String frontOfInt = converted[counter][0];
            int convertedToInt = Integer.parseInt(converted[counter].trim());
            result.add(convertedToInt);
            counter++;
        }
        return result;
    }
}


