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
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.FieldType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DrawEvent;
import com.smartgwt.client.widgets.events.DrawHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.events.ItemChangedEvent;
import com.smartgwt.client.widgets.form.events.ItemChangedHandler;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 * @author Ryno
 *
 */
public class BlockGrid extends ListGrid
{
   private DataSource dataSource;
   
   private List<UserDTO> users;
   
   /**
    * 
    */
   public BlockGrid()
   {
      ListGridField idField = new ListGridField("id");      
      idField.setHidden(true);
      idField.setCanFilter(false);
      
      ListGridField nameField = new ListGridField("name");
      nameField.setCanFilter(true);
      
      ListGridField leaderField = new ListGridField("leader");
      leaderField.setCanFilter(true);
      
      ListGridField leaderIdField = new ListGridField("leaderId");
      leaderIdField.setCanFilter(true);
      
      setFields(idField,nameField,leaderField,leaderIdField);
      
      dataSource = new DataSource();
      dataSource.setClientOnly(true);
      
      DataSourceField idFieldd = new DataSourceField("id",
               FieldType.INTEGER);
      idFieldd.setPrimaryKey(true);
      idFieldd.setHidden(true);
      idFieldd.setCanFilter(true);

      DataSourceField nameFieldd = new DataSourceField("name",
               FieldType.TEXT);
      nameFieldd.setCanFilter(true);
      
      DataSourceField leaderFieldd = new DataSourceField("leader",
               FieldType.TEXT);
      leaderFieldd.setCanFilter(true);
      
      DataSourceField leaderIdFieldd = new DataSourceField("leaderId",
               FieldType.INTEGER);      
      leaderIdFieldd.setHidden(true);
      leaderIdFieldd.setCanFilter(true);
      
      dataSource.addField(idFieldd);
      dataSource.addField(nameFieldd);   
      dataSource.addField(leaderFieldd);
      dataSource.addField(leaderIdFieldd);
      
      setAutoFetchData(false);         
      
      setCanExpandRecords(true);       
      setShowFilterEditor(true);
      setFilterOnKeypress(true);
      setCanSort(true);
      setFetchDelay(1000);       
      
      setDataSource(dataSource);
      
      GarsCom.loading.showLoading();
      
      GarsCom.dataService.getAllBlocks(GarsCom.username, GarsCom.password, getAllBlocksCallback); 
      
   }
   
   
   AsyncCallback<List<BlockDTO>> getAllBlocksCallback = new AsyncCallback<List<BlockDTO>>()
      {
         
         @Override
         public void onSuccess(List<BlockDTO> blocks)
         {
            for (BlockDTO block : blocks)
            {
               Record record = new Record();
               record.setAttribute("id", block.getId());
               record.setAttribute("name", block.getName());
               if (block.getLeaders() != null)
               {
                  for (UserDTO user : block.getLeaders())
                  {
                     record.setAttribute("leader", user.getUsername()); //TODO replace with name
                     record.setAttribute("leaderId", user.getId());
                  }
               }
               else
               {
                  record.setAttribute("leader", "");
                  record.setAttribute("leaderId", 0);
               }
               
               dataSource.addData(record);
            }    
            
            fetchData();  
            
            GarsCom.dataService.getAllUsers(GarsCom.username, GarsCom.password, getAllUsersCallback);
            
         }
         
         @Override
         public void onFailure(Throwable caught)
         {
            GarsCom.loading.hideLoading();
            
         }
      };
      
      AsyncCallback<List<UserDTO>> getAllUsersCallback = new AsyncCallback<List<UserDTO>>()
         {
            
            @Override
            public void onSuccess(List<UserDTO> result)
            {
               users = result;
               
               GarsCom.loading.hideLoading();
               
            }
            
            @Override
            public void onFailure(Throwable caught)
            {
               GarsCom.loading.hideLoading();
               
            }
         };
      
      
      @Override
      protected Canvas getExpansionComponent(final ListGridRecord record)
      {
         
         
         final ListGrid grid = this;
         VLayout layout = new VLayout(5);
         layout.setPadding(5);    
         layout.setHeight("210px");
         
         if (users == null)
            return layout;
         
         
         final DynamicForm df = new DynamicForm();
         df.setNumCols(6);
         //df.setDataSource(dataSource);
         
         TextItem nameItem = new TextItem();
         nameItem.setName("name");
         nameItem.setTitle("Block Name");
         nameItem.setRequired(true);
         nameItem.setValue(record.getAttributeAsString("name"));
         
         ComboBoxItem userItem = new ComboBoxItem("leader", "Leader");
         
         //if (users.size() > 0)
        // {
         
         final String[] userNames;
         final int[] userIds;
         
         int count = 0;
         
         if (record.getAttributeAsString("leader") == "")
         {
            userNames = new String[users.size()+1];
            userIds = new int[users.size()+1];
         
            userNames[0] = record.getAttributeAsString("leader");
            userIds[0] = record.getAttributeAsInt("leaderId");
            
            count = 1;
         }
         else
         {
            userNames = new String[users.size()];
            userIds = new int[users.size()];
         }
         
            
            for (UserDTO user : users)
            {
               userNames[count] = user.getUsername(); //TODO use resident name
               userIds[count] = user.getId();
               count++;
            }
       //  }

         userItem.setValueMap(userNames);
         
        
         
         df.setFields(nameItem,userItem);
         
         df.addDrawHandler(new DrawHandler()
         {
            @Override
            public void onDraw(DrawEvent event)
            {
               df.editRecord(record);   
               //df.getField("leader").disable();                         
            }
         });        
         

         df.addItemChangedHandler(new ItemChangedHandler()
         {

            @Override
            public void onItemChanged(ItemChangedEvent event)
            {
               try
               {
                  record.setAttribute("name", df.getValueAsString("name"));
                  record.setAttribute("leader", df.getValueAsString("leader")); 
                  
                  String l = df.getValueAsString("leader");
                  int x = 0;
                  for (String leader : userNames)
                  {
                     if (leader.equals(l))
                        record.setAttribute("leaderId", userIds[x]); 
                     
                     x++;
                  }
                  
                  
               }
               catch (Exception ex)
               {
                     //
               }

            }
         });
         
         IButton saveButton = new IButton("Save");
         saveButton.addClickHandler(new ClickHandler()
         {
            @Override
            public void onClick(ClickEvent event)
            {
               grid.collapseRecord(record);
               df.saveData();
               saveData(record);

            }

            
         });

         IButton cancelButton = new IButton("Done");
         cancelButton.addClickHandler(new ClickHandler()
         {
            @Override
            public void onClick(ClickEvent event)
            {
               grid.collapseRecord(record);
            }
         });       
         
         HLayout hLayout = new HLayout(10);
         hLayout.setAlign(Alignment.CENTER);
         hLayout.addMember(saveButton);      
         hLayout.addMember(cancelButton);      

         layout.addMember(df);      
         layout.addMember(hLayout);        
         
         return layout;
      }
      
      
      private void saveData(ListGridRecord record)
      {        
         GarsCom.loading.showLoading();
         
         BlockDTO block = new BlockDTO();
         block.setId(record.getAttributeAsInt("id"));
         block.setName(record.getAttributeAsString("name"));
         
         UserDTO user = new UserDTO();
         user.setId(record.getAttributeAsInt("leaderId"));
         
         List<UserDTO> leaders = new ArrayList<UserDTO>();
         leaders.add(user);
         block.setLeaders(leaders);        
         
         //GarsCom.dataService.updateUser(GarsCom.username, GarsCom.password, user, updateUserCallback);
         
         GarsCom.dataService.updateBlock(GarsCom.username, GarsCom.password, block, updateBlockCallback);
      
      }
      
      AsyncCallback<Boolean> updateBlockCallback = new AsyncCallback<Boolean>()
         {
            
            @Override
            public void onSuccess(Boolean result)
            {
               GarsCom.loading.hideLoading();
               
            }
            
            @Override
            public void onFailure(Throwable caught)
            {
               GarsCom.loading.hideLoading();
               
            }
         };

}
