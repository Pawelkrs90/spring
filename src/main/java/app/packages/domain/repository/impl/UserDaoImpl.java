package app.packages.domain.repository.impl;

import app.packages.domain.User;
import app.packages.domain.repository.UserDao;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{
    
    private static final Logger logger =  Logger.getLogger(UserDaoImpl.class);
    
    private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

    @Override
    public void addUser(User user) {
    
        Session session = sessionFactory.getCurrentSession();
        //Transaction transaction = session.getTransaction();;
        session.persist(user);
        
        
      /*  try{
            transaction.begin();
            
            User u = new User();
            u.setFirstName("sdasasd");
            session.save(u);
            u.setLastName("dddddd");
            
            transaction.commit();
            
        }
        catch(Exception e){
            
           e.printStackTrace();
           transaction.rollback();
        } finally {
            
            session.close();
        }*/
        
    }

    @Override
    public User getUserById(int Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> getUserList() {
       
        Session session = this.sessionFactory.getCurrentSession();
		List<User> userList = session.createQuery("from User").list();
		
		return userList;
    }
    
}
