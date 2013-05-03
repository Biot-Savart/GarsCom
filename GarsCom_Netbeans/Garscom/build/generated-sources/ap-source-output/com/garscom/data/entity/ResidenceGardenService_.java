package com.garscom.data.entity;

import com.garscom.data.entity.GardenService;
import com.garscom.data.entity.Residence;
import com.garscom.data.entity.ResidenceGardenServicePK;
import com.garscom.data.entity.WeekDays;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-04-20T14:15:27")
@StaticMetamodel(ResidenceGardenService.class)
public class ResidenceGardenService_ { 

    public static volatile SingularAttribute<ResidenceGardenService, Residence> residence;
    public static volatile SingularAttribute<ResidenceGardenService, ResidenceGardenServicePK> residenceGardenServicePK;
    public static volatile SingularAttribute<ResidenceGardenService, GardenService> gardenService;
    public static volatile SingularAttribute<ResidenceGardenService, WeekDays> weekDays;

}