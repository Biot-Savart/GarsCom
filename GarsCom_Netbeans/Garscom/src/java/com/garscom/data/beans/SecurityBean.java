/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.garscom.data.beans;

import com.garscom.data.dto.BlockDTO;
import com.garscom.data.dto.UserDTO;
import com.garscom.data.entity.User;
import com.garscom.data.entity.UserType;
import com.garscom.data.password.HashPassword;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Ryno
 */
@Stateless
@LocalBean
public class SecurityBean
{
    @PersistenceContext(unitName = "GarscomPU")
    EntityManager em;
    
    public Boolean validateUser(String username, String password)
    {
        User user = getUser(username, password);
        
        if (user == null)
            return false;
        
        return true;
    }
    
    public User getUser(String username, String password)
    {
        try
        {            
            password = HashPassword.hashPassword(password);
            
            TypedQuery<User> query = em.createQuery(
                    "SELECT u FROM User u "
                    + "WHERE u.username = :username AND u.password = :password",
                    User.class);
            query.setParameter("username", username);
            query.setParameter("password", password);
            User user = query.getSingleResult();

            em.refresh(user);

            return user;
        } catch (Exception ex)
        {
            return null;
        }
    }
    
    public List<UserDTO> getAllUsers()
    {
        try
        {
            List<User> users = fetchAll();
            
            List<UserDTO> us = new ArrayList<UserDTO>();
            
            for (User user : users)
            {
                us.add(convert(user));
            }
            
            return us;
        }
        catch (Exception ex)
        {
            return null;
        }
    }
    
    public Boolean addUser(UserDTO user)
    {
        try
        {
            user.setPassword(HashPassword.hashPassword(user.getPassword()));
            
            User u = new User();
            u.setActivated(user.getActivated());
            u.setPassword(user.getPassword());
            u.setUserTypeId(em.find(UserType.class, user.getUserTypeId()));
            u.setUsername(user.getUsername());
            
            em.persist(u);
            em.flush();
            
            return true;
        }
        catch (Exception ex)
        {
            return false;
        }
    }
    
    public Boolean deleteUser(int userId)
    {
        try
        {
            User user = em.find(User.class, userId);
            em.remove(user);
            em.flush();
            
            return true;
        }
        catch (Exception ex)
        {
            return false;
        }
    }
    
    public Boolean updateUser(UserDTO user)
    {
        try
        {
            String unHashedPassword = user.getPassword();
            
            
            User u = em.find(User.class, user.getId());
            u.setActivated(user.getActivated());
            
            if (unHashedPassword.length() != user.getPassword().length())   //if password in object isn't hashed thos means new password
                u.setPassword(user.getPassword());
            
            u.setUserTypeId(em.find(UserType.class, user.getUserTypeId()));
            u.setUsername(user.getUsername());
            
            em.persist(u);
            em.flush();
            
            return true;
            
        }
        catch (Exception ex)
        {
            return false;
        }
    }
    
   private List<User> fetchAll()
   {
      //criteria
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<User> cq = cb.createQuery(User.class);
      Root<User> node = cq.from(User.class);

      //build
      cq.select(node);

      //query
      TypedQuery<User> query = em.createQuery(cq);
      List<User> userss = query.getResultList();

      return userss;
   }
   
   public UserDTO convert(User user)
   {
       try
       {
           UserDTO u = new UserDTO();
           u.setActivated(user.getActivated());
           u.setId(user.getId());
           u.setPassword(user.getPassword());
           u.setUserTypeId(user.getUserTypeId().getId());
           u.setUsername(user.getUsername());
           
           return u;
       }
       catch (Exception ex)
       {
           return null;
       }
   }
    
}
