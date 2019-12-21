/*
* tower of hanoi puzzle
* one stack to another while maintaining the order
* element below an element cannot go on the top the element
* */

import CommonUtils.Node;
import StackUtils.Stack;

import java.util.HashMap;
import java.util.Map;

public class TowerOfHanoi {

    private Stack source;
    private Stack middleStack;
    private Stack destination;
    private Integer counter;
    private Integer numberOfDisks;

    public TowerOfHanoi() {
        this.source = new Stack();
        this.middleStack = new Stack();
        this.destination = new Stack();
        this.counter = 0;
        this.numberOfDisks = 0;
    }

    public Stack towerOfHanoi(Integer diskNumber, Stack source, Stack destination, Stack middleStack){
        counter ++;
        while(counter < Math.pow(2, this.numberOfDisks)) {
            if (diskNumber == 1) {
                Object dataToPush = source.pop();
                System.out.println("Move " + dataToPush);
                destination.push(dataToPush);
                return destination;
            }
            towerOfHanoi(diskNumber - 1, source, middleStack, destination);
            Object dataToPush = source.pop();
            System.out.println("Move " + dataToPush);
            destination.push(dataToPush);
            towerOfHanoi(diskNumber - 1, middleStack, destination, source);
            return destination;
        }

        return destination;

    }

    public void logicForTowerOfHanoi(Integer diskNumber, String source, String destination, String middleStack){
        if(diskNumber == 1){
            System.out.println("Move Disk " + diskNumber + " from "+ source + " to " + destination);
            return;
        }
        logicForTowerOfHanoi(diskNumber - 1, source, middleStack, destination);
        System.out.println("Move Disk " + diskNumber + " from " + source + " to " + destination);
        logicForTowerOfHanoi(diskNumber - 1, middleStack, destination, source);
    }

    public static void main(String[] args) {
        String source = "Original Stack";
        String destination = "Final Stack";
        String middleStack = "Interim Stack";
        Integer numberOfDisks = 0;

        TowerOfHanoi towerOfHanoi = new TowerOfHanoi();

        for(int i = 3; i > 0; i --){
            towerOfHanoi.getSource().push(i);
            numberOfDisks ++;
        }
        towerOfHanoi.setNumberOfDisks(numberOfDisks);
//        OneStackToAnother oneStackToAnother = new OneStackToAnother();
//        Stack testStack = oneStackToAnother.usingTwoStacks(towerOfHanoi.getSource());
//        while(null != testStack.peek())
//            System.out.println(testStack.pop());
//        towerOfHanoi.setSource();
//        towerOfHanoi.logicForTowerOfHanoi(numberOfDisks,source,destination,middleStack);
        Stack solutionMap = towerOfHanoi.towerOfHanoi(numberOfDisks, towerOfHanoi.getSource(),towerOfHanoi.getDestination(), towerOfHanoi.getMiddleStack());
        System.out.println("destination map: ");
        while(null != solutionMap.peek())
            System.out.println(solutionMap.pop());

    }

    public Stack getSource() {
        return source;
    }

    public Stack getMiddleStack() {
        return middleStack;
    }

    public Stack getDestination() {
        return destination;
    }

    public void setSource(Stack source) {
        this.source = source;
    }

    public void setMiddleStack(Stack middleStack) {
        this.middleStack = middleStack;
    }

    public void setDestination(Stack destination) {
        this.destination = destination;
    }

    public Integer getNumberOfDisks() {
        return numberOfDisks;
    }

    public void setNumberOfDisks(Integer numberOfDisks) {
        this.numberOfDisks = numberOfDisks;
    }
}