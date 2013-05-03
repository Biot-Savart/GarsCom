/**
 * 
 */
package com.garscom.data.gui.resedent;

import com.smartgwt.client.types.Side;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;
import com.smartgwt.client.widgets.tab.events.TabSelectedEvent;
import com.smartgwt.client.widgets.tab.events.TabSelectedHandler;

/**
 * @author Ryno
 *
 */
public class ResidentTabs extends TabSet implements TabSelectedHandler
{
   /**
    * @author Ryno
    *
    */
   public enum Type
   {
      /**
       * 
       */
      RESIDENTGRID,    
      
      /**
       * 
       */
      ADDRESIDENT      
   }
    
    
    Tab gridTab;
    Tab addTab;    
    
    ResidentGrid objectGrid;
    AddResident addObject;    
   
    /**
     * 
     */
    public ResidentTabs()
    {
       setTabBarPosition(Side.LEFT);
       setSize("100%", "100%");
       
       int[] tabIds = new int[] {1,2};
       
       if (tabIds.length == 0)
          return;      
       
       Type[] types = Type.values();
       
       for (int x = 0; x < tabIds.length; x++)
       {
          Tab tab = null;
          
          switch (types[tabIds[x]-1])
          {
              case RESIDENTGRID:
                 gridTab = new Tab("", "view_columns.png");
                 gridTab.setPrompt("Resident Grid");
                 tab = gridTab;
              break;             
              
              case ADDRESIDENT:
                 addTab = new Tab("", "add.png");
                 addTab.setPrompt("Add Resident");
                 tab = addTab;
              break;       
              
              
          }//switch     
          
          if (tab == null)
             continue;
          
          addTab(tab);
          tab.addTabSelectedHandler(this);
       }//for
    }

    
    @Override
    public void onTabSelected(TabSelectedEvent event)
    {
       if (gridTab == event.getTab())
       {
          objectGrid = new ResidentGrid();
          gridTab.setPane(objectGrid);
       } //if       
       else if (addTab == event.getTab() && addObject == null)
       {
          addObject = new AddResident();
          addTab.setPane(addObject);
       } //if
       
       
    }

}
