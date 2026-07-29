import java.util.Stack;

public class NaiveApproach {

   public static int evalRPN(String[] tokens) {
      int returnValue = 0;
      String operators = "+-*/";
      Stack<String> stack = new Stack<String>();
      
      for(String t : tokens) {
         if(!operators.contains(t)) {
            stack.push(t);
         }
         else {
            int a = Integer.valueOf(stack.pop());
            int b = Integer.valueOf(stack.pop());
            switch(t) {
               case "+":
                  stack.push(String.valueOf(a + b));
                  break;
               case "-":
                  stack.push(String.valueOf(b - a));
                  break;
               case "*":
                  stack.push(String.valueOf(a * b));
                  break;
               case "/":
                  stack.push(String.valueOf(b / a));
                  break;
            }
         }
      }
      returnValue = Integer.valueOf(stack.pop());
      return returnValue;
   }

   public static void main(String[] args) {
      String[] tokens1 = {"2", "1", "+", "3", "*"};
      System.out.println(evalRPN(tokens1));

      String[] tokens2 = {"4", "13", "5", "/", "+"};
      System.out.println(evalRPN(tokens2));
   }
}
