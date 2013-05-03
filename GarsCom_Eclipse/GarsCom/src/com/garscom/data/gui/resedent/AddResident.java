/**
 * 
 */
package com.garscom.data.gui.resedent;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.HeaderItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.validator.RegExpValidator;
import com.smartgwt.client.widgets.layout.Layout;

/**
 * @author Ryno
 *
 */
public class AddResident extends Layout
{
   //private DataSource datasource;
   private DynamicForm form;
   
   public AddResident()
   {
      setAlign(Alignment.CENTER);
      
      form = new DynamicForm();
      //form.setDataSource(datasource);
      //form.setUseAllDataSourceFields(true);
      form.setNumCols(4); 
      form.setGroupTitle("Resident Details");  
      form.setIsGroup(true);
      form.setPadding(5);
      form.setCanDragResize(true);  
      form.setResizeFrom("R");  

      HeaderItem header = new HeaderItem();
      header.setDefaultValue("Create new User");

      TextItem nameItem = new TextItem();
      nameItem.setName("name");
      nameItem.setTitle("Name");    
      nameItem.setRequired(true);
      
      TextItem surnameItem = new TextItem();
      surnameItem.setName("surname");
      surnameItem.setTitle("Surname");  
      surnameItem.setRequired(true);
      
      TextItem emailItem = new TextItem();
      emailItem.setName("email");
      emailItem.setTitle("Email"); 
      emailItem.setColSpan(4);
      
      RegExpValidator emailValidator = new RegExpValidator();
      emailValidator.setErrorMessage("Invalid email address");
      emailValidator.setExpression("^([a-zA-Z0-9_.\\-+])+@(([a-zA-Z0-9\\-])+\\.)+[a-zA-Z0-9]{2,4}$");
      
      emailItem.setValidators(emailValidator);   
      
      ComboBoxItem streetItem = new ComboBoxItem();  
      streetItem.setTitle("Street");        
      streetItem.setType("comboBox");  
      streetItem.setValueMap("Cat", "Dog", "Giraffe", "Goat", "Marmoset", "Mouse"); 
      streetItem.setRequired(true);

      TextItem streetNumberItem = new TextItem();
      streetNumberItem.setName("streetNumber");      
      streetNumberItem.setTitle("Street Number");
      streetNumberItem.setRequired(true);
      
      
      ComboBoxItem residentTypeItem = new ComboBoxItem();  
      residentTypeItem.setTitle("Resident Type");        
      residentTypeItem.setType("comboBox");  
      residentTypeItem.setValueMap("Cat", "Dog", "Giraffe", "Goat", "Marmoset", "Mouse");
      residentTypeItem.setColSpan(4);
      residentTypeItem.setRequired(true);
      
      TextItem landLineItem = new TextItem();
      landLineItem.setName("landline");
      landLineItem.setTitle("LandLine");  
      landLineItem.setColSpan(4);
     
      TextItem mobileItem = new TextItem();
      mobileItem.setName("mobile");
      mobileItem.setTitle("Mobile");
      mobileItem.setColSpan(4);
      
      RegExpValidator mobileValidator = new RegExpValidator();
      mobileValidator.setErrorMessage("Invalid mobile number");
      mobileValidator.setExpression("^[0-9+]{10,12}$");
      
      mobileItem.setValidators(mobileValidator);
      
      ComboBoxItem  occupationItem = new ComboBoxItem ();  
      occupationItem.setType("comboBox");
      occupationItem.setTitle("Occupation");  
      occupationItem.setValueMap("Ea", "Pkt", "Bag", "Ctn");
      occupationItem.setName("occupation");
      occupationItem.setColSpan(4);
      
      
      ComboBoxItem  securityItem = new ComboBoxItem ();  
      securityItem.setType("comboBox");
      securityItem.setTitle("Security Company");  
      securityItem.setValueMap("Ea", "Pkt", "Bag", "Ctn"); 
      securityItem.setName("security");
      securityItem.setColSpan(4);
      
      
      form.setFields(header,nameItem,surnameItem,streetItem,streetNumberItem,residentTypeItem,landLineItem,mobileItem, emailItem,securityItem,occupationItem);
      
      

     /* Button submitButton = new Button();
      submitButton.setTitle("Submit");
      submitButton.addClickHandler(new Clicker()); */  

     

      addMember(form); 
    //  addMember(submitButton);
       
      
      
   }
   
   public class Clicker implements ClickHandler
   {

      /*
       * (non-Javadoc)
       * 
       * @see
       * com.smartgwt.client.widgets.events.ClickHandler#onClick(com.smartgwt
       * .client.widgets.events.ClickEvent)
       */
      @Override
      public void onClick(ClickEvent event)
      {
         FormItem[] item = form.getFields();
         String username = item[1].getDisplayValue();

         if (username != "")
         {
           // GarsCom.dataService.securityService.userNameAvailable(username, userNameAvailableCallback);
         }
         else
         {
            form.validate(false);
         }
      }
   }

}
