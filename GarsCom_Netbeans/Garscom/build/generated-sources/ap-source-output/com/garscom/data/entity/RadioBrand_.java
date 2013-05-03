package com.garscom.data.entity;

import com.garscom.data.entity.RadioModel;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-04-20T14:15:27")
@StaticMetamodel(RadioBrand.class)
public class RadioBrand_ { 

    public static volatile SingularAttribute<RadioBrand, Integer> id;
    public static volatile SingularAttribute<RadioBrand, String> description;
    public static volatile SingularAttribute<RadioBrand, String> name;
    public static volatile ListAttribute<RadioBrand, RadioModel> radioModelList;

}