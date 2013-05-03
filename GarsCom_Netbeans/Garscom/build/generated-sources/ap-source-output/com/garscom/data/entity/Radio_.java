package com.garscom.data.entity;

import com.garscom.data.entity.RadioModel;
import com.garscom.data.entity.Resident;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-04-20T14:15:28")
@StaticMetamodel(Radio.class)
public class Radio_ { 

    public static volatile SingularAttribute<Radio, Integer> id;
    public static volatile SingularAttribute<Radio, String> other;
    public static volatile SingularAttribute<Radio, String> reason;
    public static volatile SingularAttribute<Radio, String> callSign;
    public static volatile SingularAttribute<Radio, String> sequenceType;
    public static volatile SingularAttribute<Radio, RadioModel> radioModelId;
    public static volatile ListAttribute<Radio, Resident> residentList;
    public static volatile SingularAttribute<Radio, String> icasaLicenseNumber;
    public static volatile SingularAttribute<Radio, String> serial;
    public static volatile SingularAttribute<Radio, String> garscomSequence;

}