/**
 * 
 */
package com.garscom.data.dto;

import com.google.gwt.user.client.rpc.IsSerializable;
import java.util.List;

/**
 * @author Ryno
 *
 */
public class BlockDTO implements IsSerializable
{
   private int id;
   
   private String name;
   
   private List<UserDTO> leaders;

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
    * @return the name
    */
   public String getName()
   {
      return name;
   }

   /**
    * @param name the name to set
    */
   public void setName(String name)
   {
      this.name = name;
   }

   
    /**
     * @return the leaders
     */
    public List<UserDTO> getLeaders()
    {
        return leaders;
    }

    /**
     * @param leaders the leaders to set
     */
    public void setLeaders(List<UserDTO> leaders)
    {
        this.leaders = leaders;
    }
}
