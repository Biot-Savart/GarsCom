package com.garscom.data.entity;

import com.garscom.data.entity.ResidenceSecurity;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-04-20T14:15:27")
@StaticMetamodel(SecurityCompany.class)
public class SecurityCompany_ { 

    public static volatile SingularAttribute<SecurityCompany, Integer> id;
    public static volatile ListAttribute<SecurityCompany, ResidenceSecurity> residenceSecurityList;
    public static volatile SingularAttribute<SecurityCompany, String> name;

}