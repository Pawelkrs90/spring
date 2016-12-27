
package app.packages.domain.repository;

import app.packages.domain.User;
import java.util.List;

public interface UserRepository {
    
    public void addUser(User user);
    public User getUserById(int Id);
    public List<User> getUserList();
     
}
