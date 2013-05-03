package com.garscom.data.entity;

import com.garscom.data.entity.Resident;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-04-20T14:15:28")
@StaticMetamodel(ResidentType.class)
public class ResidentType_ { 

    public static volatile SingularAttribute<ResidentType, Integer> id;
    public static volatile SingularAttribute<ResidentType, String> description;
    public static volatile SingularAttribute<ResidentType, String> name;
    public static volatile ListAttribute<ResidentType, Resident> residentList;

}