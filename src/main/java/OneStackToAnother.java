
/*
* using 3 stacks
* using 2 stacks
* */

import CommonUtils.Node;
import StackUtils.Stack;

public class OneStackToAnother {

    public Stack usingThreeStacks(Stack originalStack){
      Stack interimStack = new Stack();
      while(null != originalStack.peek()){
          interimStack.push(originalStack.pop());
      }

      Stack finalStack = new Stack();
      while(null != interimStack.peek()){
          finalStack.push(interimStack.pop());
      }
      return finalStack;
    }

    public Stack usingTwoStacks(Stack originalStack){
        Stack finalStack = new Stack();
        Object dataToPush = originalStack.pop();;
        if(null != originalStack.peek()){
            finalStack = usingTwoStacks(originalStack);
        }
        finalStack.push(dataToPush);
        return finalStack;
    }

    public static void main(String[] args) {
        Stack<Integer> integerStack= new Stack<>();
        for(int i = 0; i < 10; i++){
            integerStack.push(i);
        }
        OneStackToAnother oneStackToAnother = new OneStackToAnother();
        Stack<Integer> finalStackUsingThreeStacks = oneStackToAnother.usingThreeStacks(integerStack);
        Stack<Integer> finalStackUsingTwoStacks = oneStackToAnother.usingTwoStacks(finalStackUsingThreeStacks);
//        System.out.println("using 3 stacks");
//        while(null != finalStackUsingThreeStacks.peek()){
//            System.out.println(finalStackUsingThreeStacks.pop());
//        }
        System.out.println("using 2 stacks");
        while(null != finalStackUsingTwoStacks.peek()){
            System.out.println(finalStackUsingTwoStacks.pop());
        }
    }

}
