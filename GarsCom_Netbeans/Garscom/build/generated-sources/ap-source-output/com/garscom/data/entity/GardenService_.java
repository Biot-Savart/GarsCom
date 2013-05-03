package com.garscom.data.entity;

import com.garscom.data.entity.ResidenceGardenService;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-04-20T14:15:27")
@StaticMetamodel(GardenService.class)
public class GardenService_ { 

    public static volatile SingularAttribute<GardenService, Integer> id;
    public static volatile SingularAttribute<GardenService, String> description;
    public static volatile SingularAttribute<GardenService, String> name;
    public static volatile ListAttribute<GardenService, ResidenceGardenService> residenceGardenServiceList;
    public static volatile SingularAttribute<GardenService, String> telephone;

}