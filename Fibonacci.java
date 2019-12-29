import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    static int fibonacciUsingRecursion(int n){
        int result ;
        if(n == 1  || n == 2) {
            return 1;
        }

        result = fibonacciUsingRecursion(n-1) + fibonacciUsingRecursion(n-2);
        return result ;

    }

    static int fibonacciUsingRecursionAndMemoization(int n, Map<Integer, Integer> memo){
        int result ;
        if(n == 1  || n == 2) {
            return 1;
        }
        if(memo.containsKey(n)) { // check for result in memo
            return memo.get(n); 
        }

        result = fibonacciUsingRecursionAndMemoization(n-1, memo) + fibonacciUsingRecursionAndMemoization(n-2, memo);
        memo.put(n, result); // put in memo
        return result ;

    }

    static int fibonacciWithoutRecursion(int n) {
        int a = 0, b = 1, c;
        if (n == 0)
            return a;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String args[]){
        System.out.println("Fibonacci of int 5 - "+ fibonacciUsingRecursion(5));
        System.out.println("Fibonacci of int 5 - "+ fibonacciWithoutRecursion(5));
        System.out.println("Fibonacci of int 5 - "+ fibonacciUsingRecursionAndMemoization(5, new HashMap<Integer, Integer>()));
    }
}
