package ie.atu.cicdproject.ffmainapp;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private List<UserInformation> users = new ArrayList<>();

    //list all users
    @GetMapping("/getUsers")
    public List<UserInformation> getUsers() {
        return users;
    }
    //Register new user
    @PostMapping("/register")
    public UserInformation registerUser(@Valid @RequestBody UserInformation user)
    {
        users.add(user);
        return user;
    }

    //Count registered users
    @GetMapping("/count")
    public int getUserCount()
    {
        return users.size();
    }

}
