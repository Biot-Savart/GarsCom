/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.garscom.data.beans;

import com.garscom.data.dto.BlockDTO;
import com.garscom.data.dto.UserDTO;
import com.garscom.data.entity.Block;
import com.garscom.data.entity.Street;
import com.garscom.data.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
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
public class ResidenceBean
{
    @PersistenceContext(unitName = "GarscomPU")
    EntityManager em;
    
    @EJB
    private SecurityBean securityBean;
    
    public Boolean addBlock(BlockDTO block)
    {
        try
        {
            Block b = new Block();
            b.setName(block.getName());
            
            List<User> leaders = new ArrayList<User>();
            if (block.getLeaders() != null)
            {
                for (UserDTO l : block.getLeaders())
                leaders.add(em.find(User.class, l.getId()));
            }
                b.setUserList(leaders);            
            
            b.setStreetList(new ArrayList<Street>());
            
            em.persist(b);
            em.flush();
            
            return true;
        }
        catch (Exception ex)
        {
            return false;
        }
    }
    
    public List<BlockDTO> getAllBlocks()
    {
        List<Block> blocks = fetchAll();
        
        List<BlockDTO> bs = new ArrayList<BlockDTO>();
        
        for (Block block : blocks)
        {
            bs.add(convert(block));
        }
        
        return bs;
    }
    
    public Boolean deleteBlock(int blockId)
    {
        try
        {
            Block block = em.find(Block.class, blockId);
            em.remove(block);
            em.flush();
            
            return true;
        }
        catch (Exception ex)
        {
            return false;
        }
    }
    
    public Boolean updateBlock(BlockDTO block)
    {
        try
        {
            Block b = em.find(Block.class, block.getId());
            b.setName(block.getName());            
            
            List<User> leaders = new ArrayList<User>();
            if (block.getLeaders() != null)
            {
                for (UserDTO l : block.getLeaders())
                leaders.add(em.find(User.class, l.getId()));
            }
            b.setUserList(leaders);
            
            em.persist(b);
            em.flush();
            
            return true;
        }
        catch (Exception ex)
        {
            return false;
        }
    }
    
    
   private List<Block> fetchAll()
   {
      //criteria
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<Block> cq = cb.createQuery(Block.class);
      Root<Block> node = cq.from(Block.class);

      //build
      cq.select(node);

      //query
      TypedQuery<Block> query = em.createQuery(cq);
      List<Block> blocks = query.getResultList();

      return blocks;
   }
   
   public BlockDTO convert(Block block)
   {
       try
       {
           BlockDTO b = new BlockDTO();
           b.setId(block.getId());
           b.setName(block.getName());           
           
           List<UserDTO> users = new ArrayList<UserDTO>();           
           for (User u : block.getUserList())
           {
               users.add(securityBean.convert(u));
           }
           
           b.setLeaders(users);
           
           
           
           return b;
       }
       catch (Exception ex)
       {
           return null;
       }
   }
}
