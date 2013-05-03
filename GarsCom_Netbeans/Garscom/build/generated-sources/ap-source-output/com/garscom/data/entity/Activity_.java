package com.garscom.data.entity;

import com.garscom.data.entity.ActivityType;
import com.garscom.data.entity.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-04-20T14:15:27")
@StaticMetamodel(Activity.class)
public class Activity_ { 

    public static volatile SingularAttribute<Activity, Integer> id;
    public static volatile SingularAttribute<Activity, Date> timestamp;
    public static volatile SingularAttribute<Activity, ActivityType> activityTypeId;
    public static volatile SingularAttribute<Activity, String> description;
    public static volatile SingularAttribute<Activity, User> userId;

}