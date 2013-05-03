package com.garscom.data.entity;

import com.garscom.data.entity.Resident;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-04-20T14:15:27")
@StaticMetamodel(Designation.class)
public class Designation_ { 

    public static volatile SingularAttribute<Designation, Integer> id;
    public static volatile SingularAttribute<Designation, String> description;
    public static volatile ListAttribute<Designation, Resident> residentList;

}