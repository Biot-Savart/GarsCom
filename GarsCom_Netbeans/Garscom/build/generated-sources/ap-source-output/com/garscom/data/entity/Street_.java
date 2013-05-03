package com.garscom.data.entity;

import com.garscom.data.entity.Block;
import com.garscom.data.entity.Residence;
import com.garscom.data.entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-04-20T14:15:27")
@StaticMetamodel(Street.class)
public class Street_ { 

    public static volatile SingularAttribute<Street, Integer> id;
    public static volatile ListAttribute<Street, Block> blockList;
    public static volatile SingularAttribute<Street, String> name;
    public static volatile ListAttribute<Street, User> userList;
    public static volatile ListAttribute<Street, Residence> residenceList;

}