import java.util.Stack;

public class EvaluateReversePolishNotation {
   
   public static int evalRPN(String[] tokens) {
      int value = 0;
      String operators = "+-*/";
      Stack<String> stack = new Stack<String>();

      for(String t : tokens) {
         if(!operators.contains(t)) {
            stack.push(t);
         }
         else {
            int a = Integer.valueOf(stack.pop());
            int b = Integer.valueOf(stack.pop());
            int index = operators.indexOf(t);   
            // index of the operator, it will be used in the switch statement to perform the operation

            switch(index) {
               case 0:
                  stack.push(String.valueOf(a + b));
                  break;
               case 1:
                  stack.push(String.valueOf(b - a));
                  break;
               case 2:
                  stack.push(String.valueOf(a * b));
                  break;
               case 3:
                  stack.push(String.valueOf(b / a));
                  break;
            }
         }
      }
      value = Integer.valueOf(stack.pop());
      return value;
   }

   public static void main(String[] args) {
      String[] tokens1 = {"2", "1", "+", "3", "*"};
      System.out.println(evalRPN(tokens1));

      String[] tokens2 = {"4", "13", "5", "/", "+"};
      System.out.println(evalRPN(tokens2));
   }
}
