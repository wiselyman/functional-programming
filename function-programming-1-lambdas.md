### 函数式编程1-Lambda表达式

lambda表达式又称为匿名函数，可以让函数作为其他方法的参数，先举例两个简单的接口：

- `java.util.function.Function<T, R>`：`T`为入参类型，`R`为返回值类型；
- `java.util.function.BiFunction<T, U, R>`：`T`为第一个参数类型，`U`为第二个参数类型，`R`为返回值类型。

我们可以这样定一个匿名函数：

``` java
Function<Integer,Integer> compute = a -> a + 1;

BiFunction<Integer,Integer,Integer> = (a, b) -> a + b;

```

其中`->`前的为入参，后面为计算，若只有一行计算可不用花括号，也不用显式`return`结果。

下面演示两个方法，分别接受`Function`,`BiFunction`作为入参的示例：

``` java
public class DemoLambdas {
    public static Integer computeOne(Function<Integer,Integer> function, Integer value){
        return function.apply(value);
    }


    public static Integer computeTwo(BiFunction<Integer,Integer,Integer> function, Integer value, Integer value2){
        return function.apply(value,value2);
    }

}

```

在调用处，我们可以通过动态实现Function来实现不同的算法：

``` java
log.info(DemoLambdas.computeOne(a -> -a, 5).toString());
log.info(DemoLambdas.computeOne(a -> a - 1, 5).toString());
log.info(DemoLambdas.computeTwo((a, b) -> a + b,10,5).toString());
log.info(DemoLambdas.computeTwo((a, b) -> { Integer c = a - b;
                                            return c + a + b; } ,10,5).toString());

```