package com.garscom.data.entity;

import com.garscom.data.entity.Street;
import com.garscom.data.entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-04-20T14:15:27")
@StaticMetamodel(Block.class)
public class Block_ { 

    public static volatile SingularAttribute<Block, Integer> id;
    public static volatile SingularAttribute<Block, String> name;
    public static volatile ListAttribute<Block, User> userList;
    public static volatile ListAttribute<Block, Street> streetList;

}