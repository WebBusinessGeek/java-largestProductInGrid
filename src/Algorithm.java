import java.lang.reflect.Array;
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

    public ArrayList <Integer> getElementsAboveInGridColumn(ArrayList <Integer> grid, int columnsInGrid, int baseElement, int elementsToGet) {
        ArrayList<Integer> returnValue = new ArrayList<>();
        int limit = baseElement - (elementsToGet * columnsInGrid);
        int pointer = baseElement;
        while(pointer >= limit) {
            returnValue.add(grid.get(pointer));
            pointer -= columnsInGrid;
        }
        return returnValue;
    }

    public ArrayList <Integer> getElementsBelowInGridColumn(ArrayList <Integer> grid, int columnsInGrid, int baseElement, int elementsToGet) {
        ArrayList <Integer> returnValue = new ArrayList<>();
        int limit = baseElement + (elementsToGet * columnsInGrid);
        int pointer = baseElement;
        while(pointer <= limit) {
            returnValue.add(grid.get(pointer));
            pointer += columnsInGrid;
        }
        return returnValue;
    }

    public ArrayList <Integer> getElementsToRightInGridRow(ArrayList <Integer> grid, int baseElement, int elementsToGet) {
        ArrayList <Integer> returnValue = new ArrayList<>();
        int limit = baseElement + elementsToGet;
        int pointer = baseElement;
        while(pointer <= limit) {
            returnValue.add(grid.get(pointer));
            pointer ++;
        }
        return returnValue;
    }

    public ArrayList <Integer> getElementsToLeftInGridRow(ArrayList <Integer> grid, int baseElement, int elementsToGet) {
        ArrayList <Integer> returnValue = new ArrayList<>();
        int limit = baseElement - elementsToGet;
        int pointer = baseElement;
        while(pointer >= limit) {
            returnValue.add(grid.get(pointer));
            pointer--;
        }
        return returnValue;
    }
}


