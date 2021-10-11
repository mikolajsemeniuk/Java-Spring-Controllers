package application.program.controllers;

import application.program.inputs.UserInput;
import application.program.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {

    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    // or @RequestParam(value = "limit", required = false, defaultValue = "0") int limit
    // or @RequestParam(value = "limit", required = false) Optional<Integer> limit
    public String GetUser(@RequestParam(value = "page") int page, @RequestParam(value = "limit", required = false) Optional<Integer> limit) {
        return String.format("page: %d, limit: %d", page, limit.orElse(0));
    }

    // allow produce application response in json or xml only if header accept: application/xml or json was provided
    // @GetMapping(path = "/{userId}", produces = { MediaType.ALL_VALUE })
    @GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<User> GetUser(@PathVariable String userId) {
        User user = new User();
        user.setFirstName("mike");
        user.setLastName("mock");
        user.setEmail("mike@mock.com");
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PostMapping(consumes = {
            // Content-type: application/json application/xml
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    }, produces = {
            // Accept: application/json application/xml
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    })
    public ResponseEntity<User> CreateUser(@Valid @RequestBody UserInput input) {

        User user = new User();
        user.setUserId("1");
        user.setFirstName(input.getFirstName());
        user.setLastName(input.getLastName());
        user.setEmail(input.getEmail());
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<String> handleConstraintViolationException(MethodArgumentNotValidException e) {
        return new ResponseEntity(e.getBindingResult().getAllErrors(), HttpStatus.BAD_REQUEST);
    }

    @PatchMapping
    public String UpdateUser() {
        String s = null;
        s.length();
        return "update user";
    }

    @DeleteMapping
    public String RemoveUser() { return "remove user"; }
}
