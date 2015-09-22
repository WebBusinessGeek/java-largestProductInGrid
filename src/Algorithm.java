import java.util.ArrayList;

public class Algorithm {

    private String testsAreWorkingMessage = "Tests are working";

    public String getTestsAreWorkingMessage() {
        return this.testsAreWorkingMessage;
    }

    public ArrayList <Integer> convertStringIntoIntegerArray(String stringToConvert) {
        ArrayList <Integer> convertedIntegers = new ArrayList<>();
        String[] breakUpString = stringToConvert.split("\\s+");
        int counter = 0;
        while(counter < breakUpString.length) {
            if(breakUpString[counter].substring(0,1) == "0") {
                 breakUpString[counter] = breakUpString[counter].substring(1);
            }
            int convertToInt = Integer.parseInt(breakUpString[counter]);
            convertedIntegers.add(convertToInt);
            counter++;
        }
    return convertedIntegers;
    }
}


