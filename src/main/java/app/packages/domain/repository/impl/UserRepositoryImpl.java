
package app.packages.domain.repository.impl;

import app.packages.domain.User;
import app.packages.domain.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository{
    
    private List<User> userList;
    
    public UserRepositoryImpl(){
        
        userList = new ArrayList<>();
        
        userList.add(new User(1, "Pawel", "Malek"));
        userList.add(new User(2, "Michał", "Malek"));
        userList.add(new User(3, "Kinga", "Ruszczak"));
        userList.add(new User(4, "Karolina", "Szwedo"));
        userList.add(new User(5, "Hubert", "Zubik"));
        userList.add(new User(6, "Piotr", "Pietrzuszka"));
        userList.add(new User(7, "Karolina", "Kulińska"));
        userList.add(new User(8, "Agnieszka", "Nawrot"));
        userList.add(new User(9, "Karol", "Depa"));
        userList.add(new User(10, "Łukasz", "Kwiecień"));
        
        
    }

    @Override
    public void addUser(User user) {
        
        this.userList.add(user);
    }

    @Override
    public User getUserById(int Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> getUserList() {
        
        return this.userList;
    }
    
}
