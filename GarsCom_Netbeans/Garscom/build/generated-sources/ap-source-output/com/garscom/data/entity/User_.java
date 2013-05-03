package com.garscom.data.entity;

import com.garscom.data.entity.Activity;
import com.garscom.data.entity.Block;
import com.garscom.data.entity.Resident;
import com.garscom.data.entity.Street;
import com.garscom.data.entity.UserType;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-04-20T14:15:28")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SingularAttribute<User, String> username;
    public static volatile ListAttribute<User, Block> blockList;
    public static volatile SingularAttribute<User, Boolean> activated;
    public static volatile ListAttribute<User, Resident> residentList;
    public static volatile ListAttribute<User, Activity> activityList;
    public static volatile ListAttribute<User, Street> streetList;
    public static volatile SingularAttribute<User, UserType> userTypeId;
    public static volatile SingularAttribute<User, String> password;

}