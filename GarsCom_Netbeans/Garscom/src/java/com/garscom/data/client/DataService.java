
package com.garscom.data.client;


import java.util.List;

import com.garscom.data.dto.BlockDTO;
import com.garscom.data.dto.UserDTO;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("Data")
public interface DataService extends RemoteService
{
   /**
    * @param name 
    * @param s
    * @return string
    * @throws IllegalArgumentException 
    */
   String greetServer(String name) throws IllegalArgumentException;
   
   /**
    * @param username
    * @param password
    * @param block
    * @return true if succesful else false
    */
   Boolean addBlock(String username, String password, BlockDTO block);  
   
   /**
    * @param username
    * @param password
    * @return list of BlockDTO
    */
   List<BlockDTO> getAllBlocks(String username, String password);
   
   /**
    * @param username
    * @param password
    * @param blockId
    * @return true if successful
    */
   Boolean deleteBlock(String username, String password, int blockId);
   
   
   /**
    * @param username
    * @param password
    * @param block
    * @return true if successful
    */
   Boolean updateBlock(String username, String password, BlockDTO block);
   
   
   /**
    * @param username
    * @param password
    * @return List of UserDTO
    */
   List<UserDTO> getAllUsers(String username, String password);
   
   /**
    * @param username
    * @param password
    * @param user
    * @return true if succesful else false
    */
   Boolean addUser(String username, String password, UserDTO user);
   
   /**
    * @param username
    * @param password
    * @param userId
    * @return true if successful
    */
   Boolean deleteUser(String username, String password, int userId);
   
   
   /**
    * @param username
    * @param password
    * @param user
    * @return true if successful
    */
   Boolean updateUser(String username, String password, UserDTO user);
}
