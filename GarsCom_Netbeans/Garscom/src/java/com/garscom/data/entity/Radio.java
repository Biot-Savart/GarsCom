/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.garscom.data.entity;

import java.io.Serializable;
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
@Table(name = "radio")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Radio.findAll", query = "SELECT r FROM Radio r"),
    @NamedQuery(name = "Radio.findById", query = "SELECT r FROM Radio r WHERE r.id = :id"),
    @NamedQuery(name = "Radio.findBySerial", query = "SELECT r FROM Radio r WHERE r.serial = :serial"),
    @NamedQuery(name = "Radio.findByCallSign", query = "SELECT r FROM Radio r WHERE r.callSign = :callSign"),
    @NamedQuery(name = "Radio.findByIcasaLicenseNumber", query = "SELECT r FROM Radio r WHERE r.icasaLicenseNumber = :icasaLicenseNumber"),
    @NamedQuery(name = "Radio.findByReason", query = "SELECT r FROM Radio r WHERE r.reason = :reason"),
    @NamedQuery(name = "Radio.findBySequenceType", query = "SELECT r FROM Radio r WHERE r.sequenceType = :sequenceType"),
    @NamedQuery(name = "Radio.findByGarscomSequence", query = "SELECT r FROM Radio r WHERE r.garscomSequence = :garscomSequence"),
    @NamedQuery(name = "Radio.findByOther", query = "SELECT r FROM Radio r WHERE r.other = :other")
})
public class Radio implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "serial")
    private String serial;
    @Size(max = 45)
    @Column(name = "call_sign")
    private String callSign;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "icasa_license_number")
    private String icasaLicenseNumber;
    @Size(max = 45)
    @Column(name = "reason")
    private String reason;
    @Size(max = 45)
    @Column(name = "sequence_type")
    private String sequenceType;
    @Size(max = 45)
    @Column(name = "garscom_sequence")
    private String garscomSequence;
    @Size(max = 45)
    @Column(name = "other")
    private String other;
    @JoinTable(name = "resident_radio", joinColumns =
    {
        @JoinColumn(name = "radio_id", referencedColumnName = "id")
    }, inverseJoinColumns =
    {
        @JoinColumn(name = "resident_id", referencedColumnName = "id")
    })
    @ManyToMany
    private List<Resident> residentList;
    @JoinColumn(name = "radio_model_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RadioModel radioModelId;

    public Radio()
    {
    }

    public Radio(Integer id)
    {
        this.id = id;
    }

    public Radio(Integer id, String serial, String icasaLicenseNumber)
    {
        this.id = id;
        this.serial = serial;
        this.icasaLicenseNumber = icasaLicenseNumber;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getSerial()
    {
        return serial;
    }

    public void setSerial(String serial)
    {
        this.serial = serial;
    }

    public String getCallSign()
    {
        return callSign;
    }

    public void setCallSign(String callSign)
    {
        this.callSign = callSign;
    }

    public String getIcasaLicenseNumber()
    {
        return icasaLicenseNumber;
    }

    public void setIcasaLicenseNumber(String icasaLicenseNumber)
    {
        this.icasaLicenseNumber = icasaLicenseNumber;
    }

    public String getReason()
    {
        return reason;
    }

    public void setReason(String reason)
    {
        this.reason = reason;
    }

    public String getSequenceType()
    {
        return sequenceType;
    }

    public void setSequenceType(String sequenceType)
    {
        this.sequenceType = sequenceType;
    }

    public String getGarscomSequence()
    {
        return garscomSequence;
    }

    public void setGarscomSequence(String garscomSequence)
    {
        this.garscomSequence = garscomSequence;
    }

    public String getOther()
    {
        return other;
    }

    public void setOther(String other)
    {
        this.other = other;
    }

    @XmlTransient
    public List<Resident> getResidentList()
    {
        return residentList;
    }

    public void setResidentList(List<Resident> residentList)
    {
        this.residentList = residentList;
    }

    public RadioModel getRadioModelId()
    {
        return radioModelId;
    }

    public void setRadioModelId(RadioModel radioModelId)
    {
        this.radioModelId = radioModelId;
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
        if (!(object instanceof Radio))
        {
            return false;
        }
        Radio other = (Radio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.garscom.data.entity.Radio[ id=" + id + " ]";
    }
    
}
