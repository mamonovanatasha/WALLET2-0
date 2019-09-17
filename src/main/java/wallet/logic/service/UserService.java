package wallet.logic.service;

import wallet.domain.User;
import wallet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public void saveNewUser(User user) {
        userRepository.save(user);
    }

    public void editUser(User user) {
        userRepository.save(user);
    }
}
