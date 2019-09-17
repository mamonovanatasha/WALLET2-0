package wallet.web.facade;

import wallet.domain.User;
import wallet.logic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFacade {


    @Autowired
    private UserService userService;


    public List<User> getUsers() {
        return userService.findUsers();
    }
}
