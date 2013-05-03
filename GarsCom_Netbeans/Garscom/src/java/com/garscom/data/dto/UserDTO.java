/**
 * 
 */
package com.garscom.data.dto;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @author Ryno
 *
 */
public class UserDTO implements IsSerializable
{
   private int id;
   
   private String username;
   
   private String password;
   
   private Boolean activated;
   
   private int userTypeId;

   /**
    * @return the id
    */
   public int getId()
   {
      return id;
   }

   /**
    * @param id the id to set
    */
   public void setId(int id)
   {
      this.id = id;
   }

   /**
    * @return the username
    */
   public String getUsername()
   {
      return username;
   }

   /**
    * @param username the username to set
    */
   public void setUsername(String username)
   {
      this.username = username;
   }

   /**
    * @return the password
    */
   public String getPassword()
   {
      return password;
   }

   /**
    * @param password the password to set
    */
   public void setPassword(String password)
   {
      this.password = password;
   }

   /**
    * @return the activated
    */
   public Boolean getActivated()
   {
      return activated;
   }

   /**
    * @param activated the activated to set
    */
   public void setActivated(Boolean activated)
   {
      this.activated = activated;
   }

   /**
    * @return the userTypeId
    */
   public int getUserTypeId()
   {
      return userTypeId;
   }

   /**
    * @param userTypeId the userTypeId to set
    */
   public void setUserTypeId(int userTypeId)
   {
      this.userTypeId = userTypeId;
   }

}
