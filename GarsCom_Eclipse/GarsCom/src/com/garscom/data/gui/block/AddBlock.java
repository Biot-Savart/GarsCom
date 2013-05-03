/**
 * 
 */
package com.garscom.data.gui.block;

import java.util.ArrayList;
import java.util.List;

import com.garscom.data.client.GarsCom;
import com.garscom.data.dto.BlockDTO;
import com.garscom.data.dto.UserDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.HeaderItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ClickEvent;
import com.smartgwt.client.widgets.form.fields.events.ClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 * @author Ryno
 *
 */
public class AddBlock extends VLayout implements ClickHandler
{
   private DynamicForm form;
   
   private TextItem nameItem;
   
   private ComboBoxItem userItem;
   private int[] userIds;
   private String[] userNames;
   private List<UserDTO> users;
   
   HTML infoHtml;
   
   /**
    * 
    */
   public AddBlock()
   {
      form = new DynamicForm();      
      
      HeaderItem header = new HeaderItem();
      header.setDefaultValue("Create new Item");
      
      nameItem = new TextItem();
      nameItem.setName("name");
      nameItem.setTitle("Block Name");
      nameItem.setRequired(true); 
      
      userItem = new ComboBoxItem();
      userItem.setTitle("Block Leader");
      userItem.setName("leader");
      userItem.setType("comboBox");
      userItem.setRequired(false);      
      
      ButtonItem button = new ButtonItem("add", "Add Item");
      button.addClickHandler(this);
      
      form.setFields(header,nameItem,userItem,button);      
      
      addMember(form);
      
      infoHtml = new HTML();
      
      addMember(infoHtml);
      
      GarsCom.dataService.getAllUsers(GarsCom.username, GarsCom.password, getAllUsersCallback);
      
   }
   
   AsyncCallback<List<UserDTO>> getAllUsersCallback = new AsyncCallback<List<UserDTO>>()
      {
         
         @Override
         public void onSuccess(List<UserDTO> result)
         {
            users = result;
            
            userNames = new String[users.size()];
            userIds = new int[users.size()];

            int count = 0;
            for (UserDTO user : users)
            {
               userNames[count] = user.getUsername(); //TODO use resident name
               userIds[count] = user.getId();
               count++;
            }

            userItem.setValueMap(userNames);
            userItem.redraw();  
            
         }
         
         @Override
         public void onFailure(Throwable caught)
         {
            users = new ArrayList<UserDTO>();
            
         }
      };

   /* (non-Javadoc)
    * @see com.smartgwt.client.widgets.form.fields.events.ClickHandler#onClick(com.smartgwt.client.widgets.form.fields.events.ClickEvent)
    */
   @Override
   public void onClick(ClickEvent event)
   {
      if (!form.validate())
         return;
      
      UserDTO user = new UserDTO();
      
      for (UserDTO u : users)
      {
         if (!u.getUsername().equals(userItem.getValueAsString()))   //TODO change to resident name
            continue;
         
         user = u;
      }
      
      BlockDTO block = new BlockDTO();
      block.setName(nameItem.getValueAsString());
      
      List<UserDTO> leaders = new ArrayList<UserDTO>();
      leaders.add(user);
      block.setLeaders(leaders);
      
      GarsCom.dataService.addBlock(GarsCom.username, GarsCom.password, block, addBlockCallback);
      
   }
   
   AsyncCallback<Boolean> addBlockCallback = new AsyncCallback<Boolean>()
      {
         
         @Override
         public void onSuccess(Boolean result)
         {
            if (result)
               infoHtml.setHTML("<div style='color:green'>Block added successfully</div>");
            else
               infoHtml.setHTML("<div style='color:red'>Block not added</div>");
            
         }
         
         @Override
         public void onFailure(Throwable caught)
         {
            infoHtml.setHTML("<div style='color:red'>Block not added</div>");
            
         }
      };
}
