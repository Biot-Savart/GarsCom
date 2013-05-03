package com.garscom.data.entity;

import com.garscom.data.entity.Radio;
import com.garscom.data.entity.RadioBrand;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-04-20T14:15:27")
@StaticMetamodel(RadioModel.class)
public class RadioModel_ { 

    public static volatile SingularAttribute<RadioModel, Integer> id;
    public static volatile SingularAttribute<RadioModel, RadioBrand> radioBrandId;
    public static volatile SingularAttribute<RadioModel, String> description;
    public static volatile SingularAttribute<RadioModel, String> name;
    public static volatile ListAttribute<RadioModel, Radio> radioList;

}