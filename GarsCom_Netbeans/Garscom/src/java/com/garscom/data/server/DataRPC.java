
package com.garscom.data.server;


import com.garscom.data.beans.ResidenceBean;
import com.garscom.data.beans.SecurityBean;
import com.garscom.data.client.DataService;
import com.garscom.data.dto.BlockDTO;
import com.garscom.data.dto.UserDTO;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.util.List;
import javax.ejb.EJB;

/**
 * The server side implementation of the RPC service.
 */
public class DataRPC extends RemoteServiceServlet implements DataService
{
    
    @EJB
    private SecurityBean securityBean;
    
    @EJB
    private ResidenceBean residenceBean;
    
    @Override
    public String greetServer(String s)
    {
        return s;
    }

    @Override
    public Boolean addBlock(String username, String password, BlockDTO block)
    {
        if (!securityBean.validateUser(username, password))
            return false;
        
        return residenceBean.addBlock(block);       
    }

    @Override
    public List<BlockDTO> getAllBlocks(String username, String password)
    {
        if (!securityBean.validateUser(username, password))
            return null;
        
        return residenceBean.getAllBlocks();
    }

    @Override
    public Boolean deleteBlock(String username, String password, int blockId)
    {
        if (!securityBean.validateUser(username, password))
            return false;
        
        return residenceBean.deleteBlock(blockId);
    }

    @Override
    public Boolean updateBlock(String username, String password, BlockDTO block)
    {
        if (!securityBean.validateUser(username, password))
            return false;
        
        return residenceBean.updateBlock(block);
    }

    @Override
    public List<UserDTO> getAllUsers(String username, String password)
    {
        if (!securityBean.validateUser(username, password))
            return null;
        
        return securityBean.getAllUsers();
    }

    @Override
    public Boolean addUser(String username, String password, UserDTO user)
    {
        if (!securityBean.validateUser(username, password))
            return false;
        
        return securityBean.addUser(user);
    }

    @Override
    public Boolean deleteUser(String username, String password, int userId)
    {
        if (!securityBean.validateUser(username, password))
            return false;
        
        return securityBean.deleteUser(userId);
    }

    @Override
    public Boolean updateUser(String username, String password, UserDTO user)
    {
        if (!securityBean.validateUser(username, password))
            return false;
        
        return securityBean.updateUser(user);
    }

   
}
