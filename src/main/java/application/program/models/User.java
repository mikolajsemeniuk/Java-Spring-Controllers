package application.program.models;

import lombok.Getter;
import lombok.Setter;

public class User {
    @Getter @Setter
    private String firstName;
    @Getter @Setter
    private String lastName;
    @Getter @Setter
    private String email;
    @Getter @Setter
    private String userId;
}
