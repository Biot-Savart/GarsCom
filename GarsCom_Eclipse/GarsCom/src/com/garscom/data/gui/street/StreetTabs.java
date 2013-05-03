/**
 * 
 */
package com.garscom.data.gui.street;

import com.smartgwt.client.types.Side;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;
import com.smartgwt.client.widgets.tab.events.TabSelectedEvent;
import com.smartgwt.client.widgets.tab.events.TabSelectedHandler;

/**
 * @author Ryno
 *
 */
public class StreetTabs extends TabSet implements TabSelectedHandler
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
      STREETGRID,    
      
      /**
       * 
       */
      ADDSTREET      
   }
    
    
    Tab gridTab;
    Tab addTab;    
    
    StreetGrid objectGrid;
    AddStreet addObject;    
   
    /**
     * 
     */
    public StreetTabs()
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
              case STREETGRID:
                 gridTab = new Tab("", "view_columns.png");
                 gridTab.setPrompt("Street Grid");
                 tab = gridTab;
              break;             
              
              case ADDSTREET:
                 addTab = new Tab("", "add.png");
                 addTab.setPrompt("Add Street");
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
          objectGrid = new StreetGrid();
          gridTab.setPane(objectGrid);
       } //if       
       else if (addTab == event.getTab() && addObject == null)
       {
          addObject = new AddStreet();
          addTab.setPane(addObject);
       } //if
       
       
    }

}
