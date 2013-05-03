package com.garscom.data.entity;

import com.garscom.data.entity.Residence;
import com.garscom.data.entity.ResidenceSecurityPK;
import com.garscom.data.entity.SecurityCompany;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-04-20T14:15:27")
@StaticMetamodel(ResidenceSecurity.class)
public class ResidenceSecurity_ { 

    public static volatile SingularAttribute<ResidenceSecurity, SecurityCompany> securityCompany;
    public static volatile SingularAttribute<ResidenceSecurity, Date> startdate;
    public static volatile SingularAttribute<ResidenceSecurity, Residence> residence;
    public static volatile SingularAttribute<ResidenceSecurity, ResidenceSecurityPK> residenceSecurityPK;
    public static volatile SingularAttribute<ResidenceSecurity, Date> enddate;

}