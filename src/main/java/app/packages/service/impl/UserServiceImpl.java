
package app.packages.service.impl;

import app.packages.domain.User;
import app.packages.domain.repository.UserDao;
import app.packages.domain.repository.UserRepository;
import app.packages.service.UserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public void addUser(User user) {
        
        userRepository.addUser(user);
    }

    @Override
    public User getUserById(int Id) {
        
        return userRepository.getUserById(Id);
    }

    @Override
    public List<User> getUserList() {
        
        return userRepository.getUserList();
    }
}
