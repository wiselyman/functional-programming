package top.wisely.functionalprogramming;


import java.util.function.BiFunction;
import java.util.function.Function;

public class DemoLambdas {
    public static Integer computeOne(Function<Integer,Integer> function, Integer value){
        return function.apply(value);
    }


    public static Integer computeTwo(BiFunction<Integer,Integer,Integer> function, Integer value, Integer value2){
        return function.apply(value,value2);
    }

}

