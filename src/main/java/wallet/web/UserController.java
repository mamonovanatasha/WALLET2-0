package wallet.web;

import wallet.domain.User;
import wallet.logic.service.UserService;
import wallet.web.facade.UserFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserFacade facade;
    @Autowired
    private UserService userService;


    @ResponseBody
    @GetMapping(value = "users")
    public ResponseEntity<List<User>> getUsers() {
        log.info("Receive GET request /api/users.");

        List<User> records = facade.getUsers();
        return ResponseEntity.ok(records);
    }

    @PostMapping("/delete-user/{userId}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("userId") Long userId) {
        log.info("Start delete user with user id: {}", userId);
        userService.deleteUser(userId);
        return ResponseEntity.ok(true);
    }
    @ResponseBody
    @PostMapping(value = "save-new-user")
    public ResponseEntity<Boolean> saveUser(@RequestBody User user) {
        log.info("Start save new user from json: {}.", user);

        userService.saveNewUser(user);

        return ResponseEntity.ok(true);

    }


    @ResponseBody
    @PostMapping(value = "edit-user")
    public ResponseEntity<String> editUser(@RequestBody User user) {
        log.info("Start edit user from json: {}.", user);

        userService.editUser(user);

        return ResponseEntity.ok("OK");
    }
}
