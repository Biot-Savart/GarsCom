package com.garscom.data.entity;

import com.garscom.data.entity.Contribution;
import com.garscom.data.entity.Designation;
import com.garscom.data.entity.Language;
import com.garscom.data.entity.Occupation;
import com.garscom.data.entity.Radio;
import com.garscom.data.entity.Residence;
import com.garscom.data.entity.ResidentType;
import com.garscom.data.entity.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-04-20T14:15:28")
@StaticMetamodel(Resident.class)
public class Resident_ { 

    public static volatile SingularAttribute<Resident, Date> moveInDate;
    public static volatile SingularAttribute<Resident, String> organazation;
    public static volatile SingularAttribute<Resident, Boolean> streetMeeting;
    public static volatile SingularAttribute<Resident, String> surname;
    public static volatile ListAttribute<Resident, Contribution> contributionList;
    public static volatile SingularAttribute<Resident, Integer> id;
    public static volatile SingularAttribute<Resident, Boolean> registerdGarscom;
    public static volatile SingularAttribute<Resident, Boolean> indemnity;
    public static volatile SingularAttribute<Resident, String> name;
    public static volatile SingularAttribute<Resident, User> userId;
    public static volatile SingularAttribute<Resident, Date> captureDate;
    public static volatile SingularAttribute<Resident, String> note;
    public static volatile SingularAttribute<Resident, String> idNumber;
    public static volatile ListAttribute<Resident, Residence> residenceList;
    public static volatile SingularAttribute<Resident, Date> moveOutDate;
    public static volatile SingularAttribute<Resident, String> cpfName;
    public static volatile ListAttribute<Resident, Designation> designationList;
    public static volatile SingularAttribute<Resident, String> code;
    public static volatile SingularAttribute<Resident, Boolean> board;
    public static volatile SingularAttribute<Resident, Language> languageId;
    public static volatile SingularAttribute<Resident, Boolean> rules;
    public static volatile SingularAttribute<Resident, Occupation> occupationId;
    public static volatile ListAttribute<Resident, Radio> radioList;
    public static volatile SingularAttribute<Resident, String> email;
    public static volatile SingularAttribute<Resident, ResidentType> residentTypeId;
    public static volatile SingularAttribute<Resident, String> telephoneNumber;
    public static volatile SingularAttribute<Resident, Boolean> confirm;
    public static volatile SingularAttribute<Resident, String> mobile;

}