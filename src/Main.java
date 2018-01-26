import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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
                //Debug, change
                //System.out.println("Result is"+factorial(Integer.parseInt(input)));
                char[] chars = input.toCharArray();
                ArrayList<String> terms = new ArrayList<String>();
                StringBuilder currentTerm = new StringBuilder();
                for (int i = 0; i < chars.length; i++) {

                    if(Character.isDigit(chars[i])){
                        currentTerm.append(chars[i]);
                    }else if(chars[i]==' '){
                        terms.add(currentTerm.toString());
                        //Check this, not sure if it will empty the StringBuilder correctly.
                        currentTerm = new StringBuilder();

                    }else if(isSymbol(chars[i])){

                    }

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

    private static int factorial(int input){
        int prox = 1;
        for (int i = 1; i < input+1; i++) {
            prox = prox * i;
            System.out.println("DEBUG prox = "+prox + ", i = "+i);
        }
        return prox;
    }

}
