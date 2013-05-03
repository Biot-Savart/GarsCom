package com.garscom.data.entity;

import com.garscom.data.entity.ContributionType;
import com.garscom.data.entity.Resident;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-04-20T14:15:27")
@StaticMetamodel(Contribution.class)
public class Contribution_ { 

    public static volatile SingularAttribute<Contribution, Integer> id;
    public static volatile SingularAttribute<Contribution, Double> amount;
    public static volatile SingularAttribute<Contribution, Resident> residentId;
    public static volatile SingularAttribute<Contribution, ContributionType> contributionTypeId;
    public static volatile SingularAttribute<Contribution, String> note;

}