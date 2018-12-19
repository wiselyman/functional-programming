package top.wisely.functionalprogramming;



import lombok.Setter;

import java.util.Optional;

@Setter
public class Person {

    private String firstName = "Will";

    private String middleName ;

    private String lastName = "Smith";

    public Optional<String> getFirstName() {
        return Optional.of(this.firstName);
    }


    public  Optional<String> getMiddleName() {
        return Optional.ofNullable(this.middleName);
    }

    public Optional<String> getLastName() {
        return Optional.ofNullable(this.lastName);
    }
}
