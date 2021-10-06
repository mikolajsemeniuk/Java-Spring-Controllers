package application.program.inputs;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserInput {
    @NotNull(message = "first name cannot be null")
    @Size(min = 4, max = 16, message = "allowed size is between 4 and 16")
    @Getter @Setter
    private String firstName;
    @NotNull(message = "first name cannot be null")
    @Size(min = 4, max = 16, message = "allowed size is between 4 and 16")
    @Getter @Setter
    private String lastName;
    @NotNull(message = "first name cannot be null")
    @Email
    @Getter @Setter
    private String email;
}
