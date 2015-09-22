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

    public String[] convertStringIntoIntegerArray(String stringToConvert) {
        String[] breakUpString = stringToConvert.split("\\s+");
        int counter = 0;
        while(counter < breakUpString.length) {
            if(breakUpString[counter].substring(0,1) == "0") {
                
            }
            counter++;
        }

    }
}


