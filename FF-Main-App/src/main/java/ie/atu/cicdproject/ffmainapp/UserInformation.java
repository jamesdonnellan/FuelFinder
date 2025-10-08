package ie.atu.cicdproject.ffmainapp;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserInformation
{
    @NotBlank // Ensures that the fields cannot be left blank
    private String userName;

    @Email(message = "Invalid email format") //optional message that will display later on
    private String email;

    @Size(min = 6, message = "Password must contain 6 characters") //optional message that will display later on
    private String password;

}
