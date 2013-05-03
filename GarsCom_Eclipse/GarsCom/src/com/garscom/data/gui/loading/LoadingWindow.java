/**
 * 
 */
package com.garscom.data.gui.loading;

import com.smartgwt.client.types.AnimationEffect;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.layout.VLayout;
import com.google.gwt.user.client.ui.HTML;

/**
 * @author Ryno
 *
 */
public class LoadingWindow extends Window
{
   /**
    * 
    */
   public LoadingWindow()
   {
      super();
      setWidth(150);  
      setHeight(60);  
      setTitle("Loading");  
      setShowMinimizeButton(false);  
      setShowCloseButton(false);     
      setIsModal(true);  
      setShowModalMask(true);  
      centerInPage(); 
      
      HTML html = new HTML("<div align='center'><img src='images/bar_yellow.gif'></img></div>");    
      
      VLayout layout = new VLayout();
      layout.addChild(html);
      layout.setTop(30);
      layout.setLeft(5);
      
      addChild(layout);
   }
   
   /**
    * 
    */
   public void hideLoading()
   {
      animateHide(AnimationEffect.SLIDE);      
   }
   
   /**
    * 
    */
   public void showLoading()
   {
      animateShow(AnimationEffect.SLIDE);       
   }

}
