package com.garscom.data.entity;

import com.garscom.data.entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-04-20T14:15:27")
@StaticMetamodel(UserType.class)
public class UserType_ { 

    public static volatile SingularAttribute<UserType, Integer> id;
    public static volatile SingularAttribute<UserType, String> description;
    public static volatile ListAttribute<UserType, User> userList;

}