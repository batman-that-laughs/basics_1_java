import StackUtils.Stack;


import java.util.ArrayList;
import java.util.List;

public class TowerOfHanoiIterative {

    public List<Integer> towerOfHanoiIterativeStringSolution(String sourceName, String destinationName, String extraName, List<Integer> source, List<Integer> destination, List<Integer> extraStack){

        Integer sizeOfTower = source.size();
        List<Integer> result = null;
        if(sizeOfTower % 2 == 0)
            result = evenSolution(sizeOfTower,sourceName, destinationName,extraName,source,destination,extraStack);
        else
            result = oddSolution(sizeOfTower,sourceName, destinationName,extraName,source,destination,extraStack);

        return result;
    }

    public List<Integer> evenSolution(Integer sizeOfTower, String sourceName, String destinationName, String extraName, List<Integer> source, List<Integer> destination, List<Integer> extraStack){
        Integer counter = 0;
        while(destination.size() < sizeOfTower){
            counter ++;
            if(counter % 3 == 1){
                if(null != fromSource(source, extraStack) && fromSource(source,extraStack)) {
                    System.out.println("Moving " + source.get(0) + " from " + sourceName + " to " + extraName);
                    extraStack.add(0, source.get(0));
                    source.remove(0);
                }else if(null != fromSource(source, extraStack) && !fromSource(source,extraStack)){
                    System.out.println("Moving " + extraStack.get(0) + " from " + extraName + " to " + sourceName);
                    source.add(0, extraStack.get(0));
                    extraStack.remove(0);
                }
            }else if(counter % 3 == 2) {
                if(null != fromSource(source, destination) && fromSource(source,destination)) {
                    System.out.println("Moving " + source.get(0) + " from " + sourceName + " to " + destinationName);
                    destination.add(0, source.get(0));
                    source.remove(0);
                }else if(null != fromSource(source, destination) && !fromSource(source,destination)){
                    System.out.println("Moving " + destination.get(0) + " from " + destinationName + " to " + sourceName);
                    source.add(0, destination.get(0));
                    destination.remove(0);
                }
            }else {
                if(null != fromSource(extraStack, destination) && fromSource(extraStack,destination)) {
                    System.out.println("Moving " + destination.get(0) + " from " + destinationName + " to " + extraName);
                    destination.add(0, extraStack.get(0));
                    extraStack.remove(0);
                }else if(null != fromSource(extraStack, destination) && !fromSource(extraStack,destination)){
                    System.out.println("Moving " + extraStack.get(0) + " from " + extraName + " to " + destinationName);
                    extraStack.add(0, destination.get(0));
                    destination.remove(0);
                }
            }
        }

        return destination;
    }

    public List<Integer> oddSolution(Integer sizeOfTower, String sourceName, String destinationName, String extraName, List<Integer> source, List<Integer> destination, List<Integer> extraStack){
        Integer counter = 0;
        while(destination.size() < sizeOfTower){
            counter ++;
            if(counter % 3 == 1){
                if(null != fromSource(source, destination) && fromSource(source,destination)) {
                    System.out.println("Moving " + source.get(0) + " from " + sourceName + " to " + destinationName);
                    destination.add(0, source.get(0));
                    source.remove(0);
                }else if(null != fromSource(source, destination) && !fromSource(source,destination)){
                    System.out.println("Moving " + destination.get(0) + " from " + destinationName + " to " + sourceName);
                    source.add(0, source.get(0));
                    destination.remove(0);
                }
            }else if(counter % 3 == 2) {
                if(null != fromSource(source, extraStack) && fromSource(source,extraStack)) {
                    System.out.println("Moving " + source.get(0) + " from " + sourceName + " to " + extraName);
                    extraStack.add(0, source.get(0));
                    source.remove(0);
                }else if(null != fromSource(source, extraStack) && !fromSource(source,extraStack)){
                    System.out.println("Moving " + extraStack.get(0) + " from " + extraName + " to " + sourceName);
                    source.add(0, source.get(0));
                    extraStack.remove(0);
                }
            }else {
                if(null != fromSource(extraStack, destination) && fromSource(extraStack,destination)) {
                    System.out.println("Moving " + source.get(0) + " from " + extraName + " to " + destinationName);
                    destination.add(0, extraStack.get(0));
                    extraStack.remove(0);
                }else if(null != fromSource(extraStack, destination) && !fromSource(extraStack,destination)){
                    System.out.println("Moving " + destination.get(0) + " from " + destinationName + " to " + extraName);
                    extraStack.add(0, destination.get(0));
                    destination.remove(0);
                }
            }
        }
        return destination;
    }

    public Boolean fromSource(List<Integer> source, List<Integer> destination){
        if(!source.isEmpty() && destination.isEmpty()) {
            return true;
        }
        else if(!destination.isEmpty() && source.isEmpty())
            return false;
        else if(!destination.isEmpty() && !source.isEmpty()){
            if(destination.get(0) > source.get(0))
                return true;
            else
                return false;
        }else
            return null;
    }
    public Boolean fromSourceStack(Stack source, Stack destination){
        if(null != source.peek() && null == destination.peek()) {
            return true;
        }
        else if(null != destination.peek() && null == source.peek())
            return false;
        else if(null != destination.peek() && null != source.peek()){
            if(Integer.parseInt(destination.peek()+"") > Integer.parseInt(source.peek()+""))
                return true;
            else
                return false;
        }else
            return null;
    }

    public Stack towerOfHanoiIterativeSolution(Integer sizeOfTower, String sourceName, String destinationName, String extraName, Stack source, Stack destination, Stack extraStack){
        if(sizeOfTower % 2 == 0)
            return evenSolutionStack(sizeOfTower, sourceName, destinationName, extraName, source, destination, extraStack);
        else
            return oddSolutionStack(sizeOfTower, sourceName, destinationName, extraName, source, destination, extraStack);
    }


    public Stack evenSolutionStack(Integer sizeOfTower, String sourceName, String destinationName, String extraName, Stack source, Stack destination, Stack extraStack){
        Integer counter = 0;
        while(counter < Math.pow(2,sizeOfTower) - 1 ){
            counter ++;
            if(counter % 3 == 1){
                if(null != fromSourceStack(source, extraStack) && fromSourceStack(source,extraStack)) {
                    System.out.println("Moving " + source.peek() + " from " + sourceName + " to " + extraName);
                    extraStack.push(source.pop());
                }else if(null != fromSourceStack(source, extraStack) && !fromSourceStack(source,extraStack)){
                    System.out.println("Moving " + extraStack.peek() + " from " + extraName + " to " + sourceName);
                    source.push(extraStack.pop());
                }
            }else if(counter % 3 == 2) {
                if(null != fromSourceStack(source, destination) && fromSourceStack(source,destination)) {
                    System.out.println("Moving " + source.peek() + " from " + sourceName + " to " + destinationName);
                    destination.push(source.pop());
                }else if(null != fromSourceStack(source, destination) && !fromSourceStack(source,destination)){
                    System.out.println("Moving " + destination.peek() + " from " + destinationName + " to " + sourceName);
                    source.push(destination.pop());
                }
            }else {
                if(null != fromSourceStack(extraStack, destination) && fromSourceStack(extraStack,destination)) {
                    System.out.println("Moving " + destination.peek() + " from " + destinationName + " to " + extraName);
                    destination.push(extraStack.pop());
                }else if(null != fromSourceStack(extraStack, destination) && !fromSourceStack(extraStack,destination)){
                    System.out.println("Moving " + extraStack.peek() + " from " + extraName + " to " + destinationName);
                    extraStack.push(destination.pop());
                }
            }
        }

        return destination;
    }

    public Stack oddSolutionStack(Integer sizeOfTower, String sourceName, String destinationName, String extraName, Stack source, Stack destination, Stack extraStack){
        Integer counter = 0;
        while(counter < Math.pow(2,sizeOfTower) - 1 ){
            counter ++;
            if(counter % 3 == 1){
                if(null != fromSourceStack(source, destination) && fromSourceStack(source,destination)) {
                    System.out.println("Moving " + source.peek() + " from " + sourceName + " to " + destinationName);
                    destination.push(source.pop());
                }else if(null != fromSourceStack(source, extraStack) && !fromSourceStack(source,extraStack)){
                    System.out.println("Moving " + extraStack.peek() + " from " + destinationName + " to " + sourceName);
                    source.push(destination.pop());
                }
            }else if(counter % 3 == 2) {
                if(null != fromSourceStack(source, extraStack) && fromSourceStack(source,extraStack)) {
                    System.out.println("Moving " + source.peek() + " from " + sourceName + " to " + extraName);
                    extraStack.push(source.pop());
                }else if(null != fromSourceStack(source, destination) && !fromSourceStack(source,destination)){
                    System.out.println("Moving " + destination.peek() + " from " + extraName + " to " + sourceName);
                    source.push(extraStack.pop());
                }
            }else {
                if(null != fromSourceStack(extraStack, destination) && fromSourceStack(extraStack,destination)) {
                    System.out.println("Moving " + destination.peek() + " from " + destinationName + " to " + extraName);
                    destination.push(extraStack.pop());
                }else if(null != fromSourceStack(extraStack, destination) && !fromSourceStack(extraStack,destination)){
                    System.out.println("Moving " + extraStack.peek() + " from " + extraName + " to " + destinationName);
                    extraStack.push(destination.pop());
                }
            }
        }

        return destination;
    }

    public static void main(String[] args) {
        String source = "Original Stack";
        String destination = "Final Stack";
        String middleStack = "Extra Stack";
        Integer numberOfDisks = 0;
        List<Integer> sourceList = new ArrayList<>();
        List<Integer> extraList = new ArrayList<>();
        List<Integer> destinationList = new ArrayList<>();
        Stack<Integer> sourceStack = new Stack<>();
        Stack<Integer> extraStack = new Stack<>();
        Stack<Integer> destinationStack = new Stack<>();

        TowerOfHanoiIterative towerOfHanoi = new TowerOfHanoiIterative();

        for(Integer index = 4; index > 0; index --){
            sourceList.add(0, index);
            sourceStack.push(index);
            numberOfDisks ++;
        }
//        System.out.println(sourceList);
//        System.out.println(towerOfHanoi.towerOfHanoiIterativeStringSolution(source,destination,middleStack,sourceList,destinationList,extraList));
        Stack<Integer> result = towerOfHanoi.towerOfHanoiIterativeSolution(numberOfDisks,source,destination,middleStack,sourceStack,destinationStack,extraStack);
        while(null != result.peek())
            System.out.println(result.pop());
    }
}
