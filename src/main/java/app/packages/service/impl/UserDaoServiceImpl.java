package app.packages.service.impl;

import app.packages.domain.User;
import app.packages.domain.repository.UserDao;
import app.packages.domain.repository.UserRepository;
import app.packages.service.UserDaoService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDaoServiceImpl implements UserDaoService{
    
   // @Autowired
    private UserDao userDao;
    public void setUserDao(UserDao dao){
        this.userDao = dao;
    }
    
    @Override
    @Transactional
    public void addUser(User user) {
        
        userDao.addUser(user);
    }

    @Override
    @Transactional
    public User getUserById(int Id) {
        
        return userDao.getUserById(Id);
    }

    @Override
    @Transactional
    public List<User> getUserList() {
        
        return userDao.getUserList();
    }  
}
