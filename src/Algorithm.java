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
        if(limit >= 0) {
            while(pointer >= limit) {
                returnValue.add(grid.get(pointer));
                pointer -= columnsInGrid;
            }
        }
        return returnValue;
    }

    public ArrayList <Integer> getElementsBelowInGridColumn(ArrayList <Integer> grid, int columnsInGrid, int baseElement, int elementsToGet) {
        ArrayList <Integer> returnValue = new ArrayList<>();
        int limit = baseElement + (elementsToGet * columnsInGrid);
        int pointer = baseElement;
        if(limit < grid.size()) {
            while(pointer <= limit) {
                returnValue.add(grid.get(pointer));
                pointer += columnsInGrid;
            }
        }
        return returnValue;
    }

    public ArrayList <Integer> getElementsToRightInGridRow(ArrayList <Integer> grid, int itemsPerRow, int baseElement, int elementsToGet) {
        ArrayList <Integer> returnValue = new ArrayList<>();
        int limit = baseElement + elementsToGet;
        int pointer = baseElement;
        int lastElementOnFirstRow = itemsPerRow - 1;

        if(baseElement > lastElementOnFirstRow) {
            while(baseElement > lastElementOnFirstRow){
                lastElementOnFirstRow+=itemsPerRow;
            }
        }

        if(limit <= lastElementOnFirstRow){
            while(pointer <= limit) {
                returnValue.add(grid.get(pointer));
                pointer ++;
            }
        }
        return returnValue;
    }

    public ArrayList <Integer> getElementsToLeftInGridRow(ArrayList <Integer> grid, int itemsPerRow, int baseElement, int elementsToGet) {
        ArrayList <Integer> returnValue = new ArrayList<>();
        int limit = baseElement - elementsToGet;
        int pointer = baseElement;
        int firstElementOnFirstRow = 0;
        int lastElementOnFirstRow = itemsPerRow -1;


        while(!(baseElement < lastElementOnFirstRow)) {
            firstElementOnFirstRow+=itemsPerRow;
            lastElementOnFirstRow+=itemsPerRow;
        }

        if(limit >= firstElementOnFirstRow) {
            while(pointer >= limit) {
                returnValue.add(grid.get(pointer));
                pointer--;
            }
        }
        return returnValue;
    }

    public ArrayList <Integer> getUpwardDiagonallyRightElementsInGrid(ArrayList <Integer> grid, int itemsPerRow, int baseElement, int elementsToGet) {
        ArrayList <Integer> returnValue = new ArrayList<>();
        int limit = baseElement - (elementsToGet * (itemsPerRow - 1));
        int pointer = baseElement;
        int elementDirectlyAboveBase = baseElement - itemsPerRow;
        int firstElementInFirstRow = 0;
        int lastElementInFirstRow = itemsPerRow - 1;
        boolean outOfRange = false;

        if(elementDirectlyAboveBase > lastElementInFirstRow) {
            while (!(lastElementInFirstRow >= elementDirectlyAboveBase)) {
                lastElementInFirstRow += itemsPerRow;
            }
        }

        int counter = 0;
        while(counter < elementsToGet) {
            if((elementDirectlyAboveBase == lastElementInFirstRow) || (elementDirectlyAboveBase < firstElementInFirstRow)) {
                outOfRange = true;
            }
            elementDirectlyAboveBase -= itemsPerRow - 1;
            lastElementInFirstRow -= itemsPerRow;
            counter++;
        }

        if(!outOfRange) {
            while(pointer >= limit) {
                returnValue.add(grid.get(pointer));
                pointer-=(itemsPerRow - 1);
            }
        }
        return returnValue;
    }

    public ArrayList <Integer> getUpwardDiagonallyLeftElementsInGrid(ArrayList <Integer> grid, int itemsPerRow, int baseElement, int elementsToGet) {
        ArrayList <Integer> returnValue = new ArrayList<>();
        int limit = baseElement - (elementsToGet * (itemsPerRow + 1));
        int pointer = baseElement;
        boolean outOfRange = false;
        int firstElementInFirstRow = 0;
        int firstElementInRow = 0;
        int lastElementInFirstRow = itemsPerRow - 1;
        int elementDirectlyAboveBaseElement = baseElement - itemsPerRow;

        while(lastElementInFirstRow < elementDirectlyAboveBaseElement) {
            lastElementInFirstRow+= itemsPerRow;
            firstElementInRow+= itemsPerRow;
        }

        int count = 0;
        while(count < elementsToGet) {
            if((elementDirectlyAboveBaseElement == firstElementInRow) || (elementDirectlyAboveBaseElement < firstElementInFirstRow)) {
                outOfRange = true;
            }
            elementDirectlyAboveBaseElement -= itemsPerRow + 1;
            firstElementInRow -= itemsPerRow;
            count++;
        }

        if(!outOfRange) {
            while(pointer >= limit) {
                returnValue.add(grid.get(pointer));
                pointer-=(itemsPerRow + 1);
            }
        }
        return returnValue;
    }

    public ArrayList <Integer> getDownwardDiagonallyRightElementsInGrid(ArrayList <Integer> grid, int itemsPerRow, int baseElement, int elementsToGet) {
        ArrayList <Integer> returnValue = new ArrayList<>();
        int limit = baseElement + (elementsToGet * (itemsPerRow + 1));
        int pointer = baseElement;
        boolean outOfRange = false;
        int lastElementOnLastRow = grid.size() - 1;
        int lastElementOnFirstRow = itemsPerRow - 1;
        int elementDirectlyBelowBaseElement = baseElement + itemsPerRow;

        while(lastElementOnFirstRow < elementDirectlyBelowBaseElement) {
            lastElementOnFirstRow += itemsPerRow;
        }

        int counter = 0;
        while(counter < elementsToGet) {
            if((elementDirectlyBelowBaseElement == lastElementOnFirstRow) || (elementDirectlyBelowBaseElement > lastElementOnLastRow)) {
                outOfRange = true;
            }
            elementDirectlyBelowBaseElement += itemsPerRow + 1;
            lastElementOnFirstRow += itemsPerRow;
            counter++;
        }

        if(!outOfRange) {
            while(pointer <= limit) {
                returnValue.add(grid.get(pointer));
                pointer+=(itemsPerRow + 1);
            }
        }
        return returnValue;
    }

    public ArrayList <Integer> getDownwardDiagonallyLeftElementsInGrid(ArrayList <Integer> grid, int itemsPerRow, int baseElement, int elementsToGet) {
        ArrayList <Integer> returnValue = new ArrayList<>();
        int limit = (itemsPerRow * elementsToGet) + baseElement;
        int pointer = baseElement;
        int firstElementOnLastRow = grid.size() - itemsPerRow;
        int firstElementOnFirstRow = 0;
        int lastElementOnFirstRow = itemsPerRow - 1;
        int elementDirectlyBelowBaseElement = baseElement + itemsPerRow;
        boolean outOfRange = false;

        while(lastElementOnFirstRow < elementDirectlyBelowBaseElement) {
            lastElementOnFirstRow += itemsPerRow;
            firstElementOnFirstRow += itemsPerRow;
        }

        int counter = 0;
        while(counter < elementsToGet) {
            if(elementDirectlyBelowBaseElement == firstElementOnFirstRow || elementDirectlyBelowBaseElement > firstElementOnLastRow) {
                outOfRange = true;
            }
            elementDirectlyBelowBaseElement += (itemsPerRow - 1);
            firstElementOnFirstRow += itemsPerRow;
            counter++;
        }

        if(!outOfRange) {
            while(pointer <= limit) {
                returnValue.add(grid.get(pointer));
                pointer += (itemsPerRow -1);
            }
        }
        return returnValue;
    }
}


