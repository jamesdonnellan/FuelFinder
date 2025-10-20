package ie.atu.cicdproject.ffmainapp.Controllers;

import ie.atu.cicdproject.ffmainapp.Models.UserInformation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController
{
    private List<UserInformation> users = new ArrayList<>();

    public UserController(UserService service)
    {
        this.service = service;
    }

    @GetMapping // Gets all Users Information
    public ResponseEntity<List<UserInformation>> findAll()
    {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}") // Gets one user by their ID
    public ResponseEntity<UserInformation> getOne(@PathVariable String id)
    {
        Optional<UserInformation> maybe = service.findById(id);
        if(maybe.isPresent())
        {
            return ResponseEntity.ok(maybe.get());
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping // Updated Method for create user
    public ResponseEntity<UserInformation> create(@Valid @RequestBody UserInformation user)
    {
        UserInformation created = service.create(user);
        return ResponseEntity
                .created(URI.create("/api/passengers" + created.getUserID()))
                .body(created);
    }

    @PutMapping("/{id}") // New method for updating user data
    public ResponseEntity<UserInformation> update(@PathVariable String id, @Valid @RequestBody UserInformation updated)
    {
        Optional<UserInformation> maybe = service.update(id, updated);
        return maybe.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
    }

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
