
package com.garscom.data.client;


import com.garscom.data.gui.Tabs;
import com.garscom.data.gui.loading.LoadingWindow;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GarsCom implements EntryPoint
{  

   /**
    * Create a remote service proxy to talk to the server-side Greeting service.
    */
   public static final DataServiceAsync dataService = GWT
            .create(DataService.class);
   
   public static String username = "ryno";
   public static String password = "test";
   
   public static LoadingWindow loading;
   
   public HLayout content;

   /**
    * This is the entry point method.
    */
   public void onModuleLoad()
   {
      loading = new LoadingWindow();
      
      VLayout main = new VLayout();
      main.setWidth("100%");
      main.setHeight100();
      main.setAlign(Alignment.CENTER);
      
      Layout imgLayout = new Layout();
      content = new HLayout();
      content.setHeight100();
      
      Img header = new Img("GarsComLogo.jpg");
      header.setWidth(600);
      header.setHeight(130);
      header.setAlign(Alignment.CENTER);
      imgLayout.addMember(header); 
      imgLayout.setWidth("100%");
      imgLayout.setAlign(Alignment.CENTER);
      
      main.addMember(imgLayout);
      main.addMember(content);
      
      Tabs tabs = new Tabs();
      content.addMember(tabs);   
      
      main.draw();

   }
}
