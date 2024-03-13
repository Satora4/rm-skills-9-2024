package ch.ergon.lernende.backend.user;

import ch.ergon.lernende.backend.user.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserResource {

    private final UserRepository userRepository;

    @Autowired
    public UserResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<UserDto> getUsers() {
        return userRepository.getAllUser();
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userRepository.createUser(userDto);
    }

    @PutMapping("{id}")
    public UserDto editUser(@RequestBody UserDto userDto, @PathVariable String id) {
        return userRepository.editUser(userDto, id);
    }

    @DeleteMapping("{id}")
    public HttpStatus deleteUser(@PathVariable Long id) {
        return userRepository.deleteUser(id);
    }
}
