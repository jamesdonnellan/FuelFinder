package ie.atu.cicdproject.ffmainapp;
// Test JD

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserInformation
{
    @NotBlank // Ensures that the fields cannot be left blank
    private String userName, email, phone, userID;
}
