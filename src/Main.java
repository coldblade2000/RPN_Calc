import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static char[] symbols = new char[]{'+','-','+','/','^','|','v','~','s','c','t'};
    public static void main(String[] args) {
        System.out.println("Hello to the calculator program!\n");
        Scanner scan = new Scanner(System.in);

        /**
         * Two-operand:
         * Addition (+),
         * Subtraction (-),
         * Multiplication (*),
         * Division (/), and
         * Exponentiation (^)
         *
         One-operand:
         Absolute Value (|),
         Square Root (v),
         Round to closest integer (~),
         Sine (s),
         Cosine (c), and
         Tangent (t)

         */
        boolean bContinue = true;
        while(bContinue){
            System.out.println("What do you want to evaluate?\n");
            String input = scan.nextLine();
            if(input.equalsIgnoreCase("quit")){
                bContinue = false;
            }else{
                Stack<String> terms = new Stack<String>();
                char[] chars = input.toCharArray();
                //ArrayList<String> terms = new ArrayList<String>();
                StringBuilder currentTerm = new StringBuilder();
                for (int i = 0; i < chars.length; i++) {

                    if (Character.isDigit(chars[i])) {
                        currentTerm.append(chars[i]);
                    } else if (chars[i] == ' ') {
                        terms.push(currentTerm.toString());
                        //Check this, not sure if it will empty the StringBuilder correctly.
                        currentTerm = new StringBuilder();
                    }else if (isSymbol(chars[i])){
                        if(Arrays.asList(symbols).indexOf(chars[i])<=4){
                            terms.push(String.valueOf(calculate(chars[i], Double.parseDouble(terms.pop()),Double.parseDouble(terms.pop()))));
                        }else{
                            terms.push(String.valueOf(calculate(chars[i], Double.parseDouble(terms.pop()))));
                        }
                    }

                }
                terms.push(currentTerm.toString());
                for(String a: terms){
                    System.out.println(a+" ");
                }
            }
        }
    }
    private static boolean isSymbol(char character){
        for(char a: symbols){
            if(a == character){
                return true;
            }
        }
        return false;
    }
    //'+','-','+','/','^','|','v','~','s','c','t'
    private static double calculate(char operator, double op1, double op2) {
        if (operator == symbols[0]) {  //+
            return op1 + op2;
        } else if (operator == symbols[1]) {  // -
            return op2 - op1;
        } else if (operator == symbols[2]) {  // *
            return op2 * op1;
        } else if (operator == symbols[3]) {  // /
            return op2 / op1;
        } else if (operator == symbols[4]) {  // ^
            return Math.pow(op2, op1);
        } return 0;
    }
    private static double calculate(char operator, double op1){
        if (operator == symbols[5]) {  // |
            return Math.abs(op1);
        } else if (operator == symbols[6]) {  // v
            return Math.sqrt(op1);
        } else if (operator == symbols[7]) {  // ~
            return Math.round(op1);
        } else if (operator == symbols[8]) {  // s
            return Math.sin(op1);
        } else if (operator == symbols[9]) {  // c
            return Math.cos(op1);
        } else if (operator == symbols[10]) {  // t
            return Math.tan(op1);
        } return 0;
    }
        /**
         * Two-operand:
         * Addition (+),
         * Subtraction (-),
         * Multiplication (*),
         * Division (/), and
         * Exponentiation (^)
         *
         One-operand:
         Absolute Value (|),
         Square Root (v),
         Round to closest integer (~),
         Sine (s),
         Cosine (c), and
         Tangent (t)

         */
    /*private static double process(ArrayList<String> terms){

    }*/

}
