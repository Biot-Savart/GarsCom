
package com.garscom.data.client;


import java.util.List;

import com.garscom.data.dto.BlockDTO;
import com.garscom.data.dto.UserDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface DataServiceAsync
{
   /**
    * @param username
    * @param password
    * @param block
    * @param callback
    */
   void addBlock(String username, String password, BlockDTO block,
            AsyncCallback<Boolean> callback);

   /**
    * @param username
    * @param password
    * @param callback
    */
   void getAllUsers(String username, String password,
            AsyncCallback<List<UserDTO>> callback);

   /**
    * @param username
    * @param password
    * @param callback
    */
   void getAllBlocks(String username, String password,
            AsyncCallback<List<BlockDTO>> callback);

   /**
    * @param username
    * @param password
    * @param blockId
    * @param callback
    */
   void deleteBlock(String username, String password, int blockId,
            AsyncCallback<Boolean> callback);

   /**
    * @param username
    * @param password
    * @param block
    * @param callback
    */
   void updateBlock(String username, String password, BlockDTO block,
            AsyncCallback<Boolean> callback);

   /**
    * @param username
    * @param password
    * @param user
    * @param callback
    */
   void addUser(String username, String password, UserDTO user,
            AsyncCallback<Boolean> callback);

   /**
    * @param username
    * @param password
    * @param userId
    * @param callback
    */
   void deleteUser(String username, String password, int userId,
            AsyncCallback<Boolean> callback);

   /**
    * @param username
    * @param password
    * @param user
    * @param callback
    */
   void updateUser(String username, String password, UserDTO user,
            AsyncCallback<Boolean> callback);

   /**
    * @param name 
    * @param s
    * @param callback
    * @throws IllegalArgumentException 
    */
   void greetServer(String name, AsyncCallback<String> callback) throws IllegalArgumentException;
}
