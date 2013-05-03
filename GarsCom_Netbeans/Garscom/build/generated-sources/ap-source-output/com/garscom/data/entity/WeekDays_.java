package com.garscom.data.entity;

import com.garscom.data.entity.ResidenceGardenService;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-04-20T14:15:27")
@StaticMetamodel(WeekDays.class)
public class WeekDays_ { 

    public static volatile SingularAttribute<WeekDays, Integer> id;
    public static volatile SingularAttribute<WeekDays, String> name;
    public static volatile ListAttribute<WeekDays, ResidenceGardenService> residenceGardenServiceList;

}