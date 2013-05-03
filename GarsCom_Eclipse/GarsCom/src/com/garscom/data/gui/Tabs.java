/**
 * 
 */
package com.garscom.data.gui;

import com.garscom.data.gui.block.BlockTabs;
import com.garscom.data.gui.complex.ComplexTabs;
import com.garscom.data.gui.resedent.AddResident;
import com.garscom.data.gui.residence.ResidenceTabs;
import com.garscom.data.gui.street.StreetTabs;
import com.smartgwt.client.types.Side;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;
import com.smartgwt.client.widgets.tab.events.TabSelectedEvent;
import com.smartgwt.client.widgets.tab.events.TabSelectedHandler;

/**
 * @author Ryno
 *
 */
public class Tabs extends TabSet implements TabSelectedHandler
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
      RESIDENTFORM,
      
      /**
       * 
       */
      BLOCK,
      
      /**
       * 
       */
      STREET,
      
      /**
       * 
       */
      COMPLEX,
      
      /**
       * 
       */
      RESIDENCE
      
      
   }
   
   
   /*
    * Tabs
    */
   Tab residentTab;
   Tab blockTab;
   Tab streetTab;
   Tab residenceTab;
   Tab complexTab;
   
   /*
    * Layouts
    */
   AddResident residentForm;
   BlockTabs blockTabs;
   StreetTabs streetTabs;
   ResidenceTabs residenceTabs;
   ComplexTabs complexTabs;
   
   
   /**
    * 
    */
   public Tabs()
   {
      setTabBarPosition(Side.TOP);
      setSize("100%", "100%");
      
      int[] tabIds = new int[] {1,2,3,4,5};
      
      if (tabIds.length == 0)
         return;      
      
      Type[] types = Type.values();
      
      for (int x = 0; x < tabIds.length; x++)
      {
         Tab tab = null;
         
         switch (types[tabIds[x]-1])
         {
             case RESIDENTFORM:
                residentTab = new Tab("Resident Information Form", "shield.png");
                residentTab.setPrompt("Resident Information Form");
                tab = residentTab;
             break;             
             
             case BLOCK:
                blockTab = new Tab("Block", "shield.png");
                blockTab.setPrompt("Block");
                tab = blockTab;
             break;
             
             case STREET:
                streetTab = new Tab("Street", "shield.png");
                streetTab.setPrompt("Street");
                tab = streetTab;
             break;
             
             case COMPLEX:
                complexTab = new Tab("Complex", "shield.png");
                complexTab.setPrompt("Complex");
                tab = complexTab;
             break;
             
             case RESIDENCE:
                residenceTab = new Tab("Residence", "shield.png");
                residenceTab.setPrompt("Residence");
                tab = residenceTab;
             break;
             
             
         }//switch     
         
         if (tab == null)
            continue;
         
         addTab(tab);
         tab.addTabSelectedHandler(this);
      }//for    
      
      setPaneMargin(0);
   }
   
   @Override
   public void onTabSelected(TabSelectedEvent event)
   {
      if (residentTab == event.getTab())
      {
         residentForm = new AddResident();
         residentTab.setPane(residentForm);
      } //if       
      else if (blockTab == event.getTab() && blockTabs == null)
      {
         blockTabs = new BlockTabs();
         blockTab.setPane(blockTabs);
      } //if
      else if (streetTab == event.getTab() && streetTabs == null)
      {
         streetTabs = new StreetTabs();
         streetTab.setPane(streetTabs);
      } //if
      else if (complexTab == event.getTab() && complexTabs == null)
      {
         complexTabs = new ComplexTabs();
         complexTab.setPane(complexTabs);
      } //if
      else if (residenceTab == event.getTab() && residenceTabs == null)
      {
         residenceTabs = new ResidenceTabs();
         residenceTab.setPane(residenceTabs);
      } //if
      
   }

}
