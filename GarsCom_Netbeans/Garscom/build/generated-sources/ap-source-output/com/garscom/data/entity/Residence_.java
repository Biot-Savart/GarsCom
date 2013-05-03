package com.garscom.data.entity;

import com.garscom.data.entity.Complex;
import com.garscom.data.entity.ResidenceGardenService;
import com.garscom.data.entity.ResidenceSecurity;
import com.garscom.data.entity.Resident;
import com.garscom.data.entity.Street;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-04-20T14:15:27")
@StaticMetamodel(Residence.class)
public class Residence_ { 

    public static volatile SingularAttribute<Residence, Integer> id;
    public static volatile SingularAttribute<Residence, Integer> complexNumber;
    public static volatile SingularAttribute<Residence, Complex> complexId;
    public static volatile ListAttribute<Residence, ResidenceSecurity> residenceSecurityList;
    public static volatile SingularAttribute<Residence, Street> streetId;
    public static volatile ListAttribute<Residence, ResidenceGardenService> residenceGardenServiceList;
    public static volatile SingularAttribute<Residence, String> propertyNo;
    public static volatile ListAttribute<Residence, Resident> residentList;
    public static volatile SingularAttribute<Residence, String> longitude;
    public static volatile SingularAttribute<Residence, Integer> streetNumber;
    public static volatile SingularAttribute<Residence, String> latitude;
    public static volatile SingularAttribute<Residence, String> notes;

}