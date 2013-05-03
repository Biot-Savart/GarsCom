/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.garscom.data.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ryno
 */
@Entity
@Table(name = "resident")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Resident.findAll", query = "SELECT r FROM Resident r"),
    @NamedQuery(name = "Resident.findById", query = "SELECT r FROM Resident r WHERE r.id = :id"),
    @NamedQuery(name = "Resident.findByName", query = "SELECT r FROM Resident r WHERE r.name = :name"),
    @NamedQuery(name = "Resident.findBySurname", query = "SELECT r FROM Resident r WHERE r.surname = :surname"),
    @NamedQuery(name = "Resident.findByTelephoneNumber", query = "SELECT r FROM Resident r WHERE r.telephoneNumber = :telephoneNumber"),
    @NamedQuery(name = "Resident.findByMobile", query = "SELECT r FROM Resident r WHERE r.mobile = :mobile"),
    @NamedQuery(name = "Resident.findByEmail", query = "SELECT r FROM Resident r WHERE r.email = :email"),
    @NamedQuery(name = "Resident.findByIdNumber", query = "SELECT r FROM Resident r WHERE r.idNumber = :idNumber"),
    @NamedQuery(name = "Resident.findByCode", query = "SELECT r FROM Resident r WHERE r.code = :code"),
    @NamedQuery(name = "Resident.findByOrganazation", query = "SELECT r FROM Resident r WHERE r.organazation = :organazation"),
    @NamedQuery(name = "Resident.findByStreetMeeting", query = "SELECT r FROM Resident r WHERE r.streetMeeting = :streetMeeting"),
    @NamedQuery(name = "Resident.findByRegisterdGarscom", query = "SELECT r FROM Resident r WHERE r.registerdGarscom = :registerdGarscom"),
    @NamedQuery(name = "Resident.findByNote", query = "SELECT r FROM Resident r WHERE r.note = :note"),
    @NamedQuery(name = "Resident.findByMoveInDate", query = "SELECT r FROM Resident r WHERE r.moveInDate = :moveInDate"),
    @NamedQuery(name = "Resident.findByMoveOutDate", query = "SELECT r FROM Resident r WHERE r.moveOutDate = :moveOutDate"),
    @NamedQuery(name = "Resident.findByCaptureDate", query = "SELECT r FROM Resident r WHERE r.captureDate = :captureDate"),
    @NamedQuery(name = "Resident.findByCpfName", query = "SELECT r FROM Resident r WHERE r.cpfName = :cpfName"),
    @NamedQuery(name = "Resident.findByIndemnity", query = "SELECT r FROM Resident r WHERE r.indemnity = :indemnity"),
    @NamedQuery(name = "Resident.findByRules", query = "SELECT r FROM Resident r WHERE r.rules = :rules"),
    @NamedQuery(name = "Resident.findByBoard", query = "SELECT r FROM Resident r WHERE r.board = :board"),
    @NamedQuery(name = "Resident.findByConfirm", query = "SELECT r FROM Resident r WHERE r.confirm = :confirm")
})
public class Resident implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "surname")
    private String surname;
    @Size(max = 13)
    @Column(name = "telephone_number")
    private String telephoneNumber;
    @Size(max = 13)
    @Column(name = "mobile")
    private String mobile;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @Size(max = 13)
    @Column(name = "id_number")
    private String idNumber;
    @Size(max = 45)
    @Column(name = "code")
    private String code;
    @Size(max = 45)
    @Column(name = "organazation")
    private String organazation;
    @Column(name = "street_meeting")
    private Boolean streetMeeting;
    @Basic(optional = false)
    @NotNull
    @Column(name = "registerd_garscom")
    private boolean registerdGarscom;
    @Size(max = 45)
    @Column(name = "note")
    private String note;
    @Basic(optional = false)
    @NotNull
    @Column(name = "move_in_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date moveInDate;
    @Column(name = "move_out_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date moveOutDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "capture_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date captureDate;
    @Size(max = 45)
    @Column(name = "cpf_name")
    private String cpfName;
    @Column(name = "indemnity")
    private Boolean indemnity;
    @Column(name = "rules")
    private Boolean rules;
    @Column(name = "board")
    private Boolean board;
    @Column(name = "confirm")
    private Boolean confirm;
    @JoinTable(name = "resident_designation", joinColumns =
    {
        @JoinColumn(name = "resident_id", referencedColumnName = "id")
    }, inverseJoinColumns =
    {
        @JoinColumn(name = "designation_id", referencedColumnName = "id")
    })
    @ManyToMany
    private List<Designation> designationList;
    @ManyToMany(mappedBy = "residentList")
    private List<Radio> radioList;
    @ManyToMany(mappedBy = "residentList")
    private List<Residence> residenceList;
    @JoinColumn(name = "language_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Language languageId;
    @JoinColumn(name = "occupation_id", referencedColumnName = "id")
    @ManyToOne
    private Occupation occupationId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private User userId;
    @JoinColumn(name = "resident_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ResidentType residentTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "residentId")
    private List<Contribution> contributionList;

    public Resident()
    {
    }

    public Resident(Integer id)
    {
        this.id = id;
    }

    public Resident(Integer id, String name, String surname, boolean registerdGarscom, Date moveInDate, Date captureDate)
    {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.registerdGarscom = registerdGarscom;
        this.moveInDate = moveInDate;
        this.captureDate = captureDate;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public String getTelephoneNumber()
    {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber)
    {
        this.telephoneNumber = telephoneNumber;
    }

    public String getMobile()
    {
        return mobile;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getIdNumber()
    {
        return idNumber;
    }

    public void setIdNumber(String idNumber)
    {
        this.idNumber = idNumber;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getOrganazation()
    {
        return organazation;
    }

    public void setOrganazation(String organazation)
    {
        this.organazation = organazation;
    }

    public Boolean getStreetMeeting()
    {
        return streetMeeting;
    }

    public void setStreetMeeting(Boolean streetMeeting)
    {
        this.streetMeeting = streetMeeting;
    }

    public boolean getRegisterdGarscom()
    {
        return registerdGarscom;
    }

    public void setRegisterdGarscom(boolean registerdGarscom)
    {
        this.registerdGarscom = registerdGarscom;
    }

    public String getNote()
    {
        return note;
    }

    public void setNote(String note)
    {
        this.note = note;
    }

    public Date getMoveInDate()
    {
        return moveInDate;
    }

    public void setMoveInDate(Date moveInDate)
    {
        this.moveInDate = moveInDate;
    }

    public Date getMoveOutDate()
    {
        return moveOutDate;
    }

    public void setMoveOutDate(Date moveOutDate)
    {
        this.moveOutDate = moveOutDate;
    }

    public Date getCaptureDate()
    {
        return captureDate;
    }

    public void setCaptureDate(Date captureDate)
    {
        this.captureDate = captureDate;
    }

    public String getCpfName()
    {
        return cpfName;
    }

    public void setCpfName(String cpfName)
    {
        this.cpfName = cpfName;
    }

    public Boolean getIndemnity()
    {
        return indemnity;
    }

    public void setIndemnity(Boolean indemnity)
    {
        this.indemnity = indemnity;
    }

    public Boolean getRules()
    {
        return rules;
    }

    public void setRules(Boolean rules)
    {
        this.rules = rules;
    }

    public Boolean getBoard()
    {
        return board;
    }

    public void setBoard(Boolean board)
    {
        this.board = board;
    }

    public Boolean getConfirm()
    {
        return confirm;
    }

    public void setConfirm(Boolean confirm)
    {
        this.confirm = confirm;
    }

    @XmlTransient
    public List<Designation> getDesignationList()
    {
        return designationList;
    }

    public void setDesignationList(List<Designation> designationList)
    {
        this.designationList = designationList;
    }

    @XmlTransient
    public List<Radio> getRadioList()
    {
        return radioList;
    }

    public void setRadioList(List<Radio> radioList)
    {
        this.radioList = radioList;
    }

    @XmlTransient
    public List<Residence> getResidenceList()
    {
        return residenceList;
    }

    public void setResidenceList(List<Residence> residenceList)
    {
        this.residenceList = residenceList;
    }

    public Language getLanguageId()
    {
        return languageId;
    }

    public void setLanguageId(Language languageId)
    {
        this.languageId = languageId;
    }

    public Occupation getOccupationId()
    {
        return occupationId;
    }

    public void setOccupationId(Occupation occupationId)
    {
        this.occupationId = occupationId;
    }

    public User getUserId()
    {
        return userId;
    }

    public void setUserId(User userId)
    {
        this.userId = userId;
    }

    public ResidentType getResidentTypeId()
    {
        return residentTypeId;
    }

    public void setResidentTypeId(ResidentType residentTypeId)
    {
        this.residentTypeId = residentTypeId;
    }

    @XmlTransient
    public List<Contribution> getContributionList()
    {
        return contributionList;
    }

    public void setContributionList(List<Contribution> contributionList)
    {
        this.contributionList = contributionList;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resident))
        {
            return false;
        }
        Resident other = (Resident) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.garscom.data.entity.Resident[ id=" + id + " ]";
    }
    
}
