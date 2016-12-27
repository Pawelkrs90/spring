package app.packages.service;

import app.packages.domain.User;
import java.util.List;


public interface UserDaoService {
    
    public void addUser(User user);
    public User getUserById(int Id);
    public List<User> getUserList();
    
}
