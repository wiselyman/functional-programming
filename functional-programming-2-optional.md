## 函数式编程2-Optional

本节我们讲一下`Optional`的使用，`Optional`主要用来对`null`的处理，我们将常规需要判断`null`的对象用`Optional`包装起来。

### 1.获取Optional对象的静态方法

- `Optional.of(value)`:value必须不能为空,

示例:`Optional<String> firstName = Optional.of(person.getFirstName());`

- `Optional.ofNullable(value):`value可以为空

示例：`Optional<String> middleName = Optional.ofNullable(person.getMiddleName());`

#### 2.Optional对象的主要方法

- `get()`
> `T get()`：获得Optional中的对象包装的`value`,`T`为`value`的类型.

示例：`String firstNameGreetings = firstNameOptional.get()`


- `isPresent()`
> `boolean isPresent()`:判断`Optional`中的`value`是否存在，返回值是boolean.

示例：`boolean isPresent = middleNameOptional.isPresent()`

- `ifPresent`
>`ifPresent(Consumer<? super T> consumer)`：如果`Optional`中的`value`存在，执行什么操作.
对比《函数式编程1-Lambda表达式》的`Function`和`BiFunction`，这里的`Consumer<T>`接口接受一个入参`T`类型，没有返回值.

示例：

``` java
firstNameOptional.ifPresent(name -> {
                            String firstNameGreetings = firstNameOptional.get().toUpperCase();
                            log.info("hello " + firstNameGreetings);
                          })

```


- `map()`
>`Optional<U> map(Function<? super T, ? extends U> mapper)`: 对`Optional`中的`value`(类型为`T)`进行处理并返回一个新的`Optional<U>`,`U`为返回值类型.

示例:

``` java
Optional<String> lastNameOptionalNew = lastNameOptional
								.map(name ->  name.toUpperCase());

```

- `orElse()`

>` T orElse(T other)`：和`get()`一样获得`value`的值，区别是有`value`的时候返回`value`，没有`value`的时候返回`other`.

示例

``` java
String middleNameGreetings = middleNameOptional
					.map(name ->  name.toUpperCase())
					.orElse("no middle name")

```

### 3.完整示例

- Person

``` java
@Data
public class Person {

    private String firstName;

    private String middleName;

    private String lastName;

}

```

``` java
@Bean
CommandLineRunner testOptional(){
    return p -> {
        Person person = new Person();

        person.setFirstName("Will");
        Optional<String> firstNameOptional = Optional.of(person.getFirstName());
        firstNameOptional.ifPresent(name -> {
                                        String firstNameGreetings = firstNameOptional.get().toUpperCase();
                                        log.info("hello " + firstNameGreetings);
                                      });



        Optional<String> middleNameOptional = Optional.ofNullable(person.getMiddleName());
        String middleNameGreetings = middleNameOptional
                .map(name ->  name.toUpperCase())
                .orElse("no middle name");
        log.info("hello " + middleNameGreetings);

        log.info(new Boolean(middleNameOptional.isPresent()).toString());


        person.setLastName("Smith");
        Optional<String> lastNameOptional = Optional.ofNullable(person.getLastName());
        Optional<String> lastNameOptionalNew = lastNameOptional
                                        .map(name ->  name.toUpperCase());
        log.info("hello " + lastNameOptionalNew.get());



    };
}

```