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

//@Repository
public class UserDaoImpl implements UserDao{
    
    
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user) {
    
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.getTransaction();
        //session.persist(user);
        
        
        try{
            transaction.begin();
            
            session.persist(user);
            
            transaction.commit();
            
        }
        catch(Exception e){
            
           e.printStackTrace();
           transaction.rollback();
        } finally {
            
            session.close();
        }
        
    }

    @Override
    public User getUserById(int Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> getUserList() {
        
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.getTransaction();

        try{
            transaction.begin();
            
           
	    List<User> userList = session.createQuery("from User").list();

            transaction.commit();
            
            return userList;
        }
        catch(Exception e){
            
           e.printStackTrace();
           transaction.rollback();
        } finally {
            
            session.close();
        }
        return null;
    }
    
}
