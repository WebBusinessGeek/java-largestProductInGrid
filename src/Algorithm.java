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
            if(elementDirectlyBelowBaseElement == firstElementOnFirstRow || (elementDirectlyBelowBaseElement > firstElementOnLastRow && counter != elementsToGet -1)) {
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

    public int getProductOfIntegerArrayList(ArrayList <Integer> arrayListToGetProductFrom) {
        int returnValue = 1;
        int counter = 0;
        while(counter < arrayListToGetProductFrom.size()) {
            returnValue *= arrayListToGetProductFrom.get(counter);
            counter++;
        }
        return returnValue;
    }

    public int findLargestProductInGrid(String convertIntoIntArray, int maxIntegers, int itemsPerRow) {
        int returnValue = 0;

        ArrayList <Integer> grid = this.convertStringIntoIntegerArray(convertIntoIntArray);
        int limit = grid.size() - 1;
        int counter = 0;
        int elementsToGet = maxIntegers - 1;
        while(counter <= limit) {
            ArrayList <Integer> up = this.getElementsAboveInGridColumn(grid, itemsPerRow, counter, elementsToGet);
            ArrayList <Integer> down = this.getElementsBelowInGridColumn(grid, itemsPerRow, counter, elementsToGet);
            ArrayList <Integer> right = this.getElementsToRightInGridRow(grid, itemsPerRow, counter, elementsToGet);
            ArrayList <Integer> left = this.getElementsToLeftInGridRow(grid, itemsPerRow, counter, elementsToGet);
            ArrayList <Integer> rightDiagonalUp = this.getUpwardDiagonallyRightElementsInGrid(grid, itemsPerRow, counter, elementsToGet);
            ArrayList <Integer> rightDiagonalDown = this.getDownwardDiagonallyRightElementsInGrid(grid, itemsPerRow, counter, elementsToGet);
            ArrayList <Integer> leftDiagonalUp = this.getUpwardDiagonallyLeftElementsInGrid(grid, itemsPerRow, counter, elementsToGet);
            ArrayList <Integer> leftDiagonalDown = this.getDownwardDiagonallyLeftElementsInGrid(grid, itemsPerRow, counter, elementsToGet);
            ArrayList <ArrayList <Integer> > elementsReturned = new ArrayList<>();
            elementsReturned.add(up);
            elementsReturned.add(down);
            elementsReturned.add(right);
            elementsReturned.add(left);
            elementsReturned.add(rightDiagonalUp);
            elementsReturned.add(rightDiagonalDown);
            elementsReturned.add(leftDiagonalUp);
            elementsReturned.add(leftDiagonalDown);

            int subCounter = 0;
            while(subCounter < elementsReturned.size()) {
                int product = this.getProductOfIntegerArrayList(elementsReturned.get(subCounter));
                returnValue = returnValue < product ? product : returnValue;
                subCounter++;
            }
            counter++;
        }
        return returnValue;
    }
}


