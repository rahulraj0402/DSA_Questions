package Arrays;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaExpression {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("Hello, World!");
        runnable.run();

        // single parameter
        Consumer<String> greet = (name)->System.out.println("my name is " + name);

        // multiple parameter | single statement
        BinaryOperator<Integer> add = (a,b) -> a + b ;
        add.apply(10,10);
        System.out.println(add.apply(10,10));

        // if we have more then one statement use curly braces then return the keyword
        Predicate<Integer> isEven = (Integer n) -> {
            if (n % 2 == 0){
                return true;
            }else {
                return false;
            }
        };
        System.out.println(isEven.test(10));
        System.out.println(isEven.test(9));


    }
}
