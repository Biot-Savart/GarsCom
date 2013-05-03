/**
 * 
 */
package com.garscom.data.gui.complex;

import com.smartgwt.client.types.Side;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;
import com.smartgwt.client.widgets.tab.events.TabSelectedEvent;
import com.smartgwt.client.widgets.tab.events.TabSelectedHandler;

/**
 * @author Ryno
 *
 */
public class ComplexTabs extends TabSet implements TabSelectedHandler
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
      COMPLEXGRID,    
      
      /**
       * 
       */
      ADDCOMPLEX      
   }
    
    
    Tab gridTab;
    Tab addTab;    
    
    ComplexGrid objectGrid;
    AddComplex addObject;    
   
    /**
     * 
     */
    public ComplexTabs()
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
              case COMPLEXGRID:
                 gridTab = new Tab("", "view_columns.png");
                 gridTab.setPrompt("Complex Grid");
                 tab = gridTab;
              break;             
              
              case ADDCOMPLEX:
                 addTab = new Tab("", "add.png");
                 addTab.setPrompt("Add Complex");
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
          objectGrid = new ComplexGrid();
          gridTab.setPane(objectGrid);
       } //if       
       else if (addTab == event.getTab() && addObject == null)
       {
          addObject = new AddComplex();
          addTab.setPane(addObject);
       } //if
       
       
    }

}
