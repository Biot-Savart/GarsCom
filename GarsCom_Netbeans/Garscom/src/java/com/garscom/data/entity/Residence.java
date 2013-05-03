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
@Table(name = "residence")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Residence.findAll", query = "SELECT r FROM Residence r"),
    @NamedQuery(name = "Residence.findById", query = "SELECT r FROM Residence r WHERE r.id = :id"),
    @NamedQuery(name = "Residence.findByStreetNumber", query = "SELECT r FROM Residence r WHERE r.streetNumber = :streetNumber"),
    @NamedQuery(name = "Residence.findByComplexNumber", query = "SELECT r FROM Residence r WHERE r.complexNumber = :complexNumber"),
    @NamedQuery(name = "Residence.findByNotes", query = "SELECT r FROM Residence r WHERE r.notes = :notes"),
    @NamedQuery(name = "Residence.findByLatitude", query = "SELECT r FROM Residence r WHERE r.latitude = :latitude"),
    @NamedQuery(name = "Residence.findByLongitude", query = "SELECT r FROM Residence r WHERE r.longitude = :longitude"),
    @NamedQuery(name = "Residence.findByPropertyNo", query = "SELECT r FROM Residence r WHERE r.propertyNo = :propertyNo")
})
public class Residence implements Serializable
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
    @Column(name = "street_number")
    private int streetNumber;
    @Column(name = "complex_number")
    private Integer complexNumber;
    @Size(max = 45)
    @Column(name = "notes")
    private String notes;
    @Size(max = 45)
    @Column(name = "latitude")
    private String latitude;
    @Size(max = 45)
    @Column(name = "longitude")
    private String longitude;
    @Size(max = 10)
    @Column(name = "property_no")
    private String propertyNo;
    @JoinTable(name = "residence_resident", joinColumns =
    {
        @JoinColumn(name = "residence_id", referencedColumnName = "id")
    }, inverseJoinColumns =
    {
        @JoinColumn(name = "resident_id", referencedColumnName = "id")
    })
    @ManyToMany
    private List<Resident> residentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "residence")
    private List<ResidenceGardenService> residenceGardenServiceList;
    @JoinColumn(name = "complex_id", referencedColumnName = "id")
    @ManyToOne
    private Complex complexId;
    @JoinColumn(name = "street_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Street streetId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "residence")
    private List<ResidenceSecurity> residenceSecurityList;

    public Residence()
    {
    }

    public Residence(Integer id)
    {
        this.id = id;
    }

    public Residence(Integer id, int streetNumber)
    {
        this.id = id;
        this.streetNumber = streetNumber;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public int getStreetNumber()
    {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber)
    {
        this.streetNumber = streetNumber;
    }

    public Integer getComplexNumber()
    {
        return complexNumber;
    }

    public void setComplexNumber(Integer complexNumber)
    {
        this.complexNumber = complexNumber;
    }

    public String getNotes()
    {
        return notes;
    }

    public void setNotes(String notes)
    {
        this.notes = notes;
    }

    public String getLatitude()
    {
        return latitude;
    }

    public void setLatitude(String latitude)
    {
        this.latitude = latitude;
    }

    public String getLongitude()
    {
        return longitude;
    }

    public void setLongitude(String longitude)
    {
        this.longitude = longitude;
    }

    public String getPropertyNo()
    {
        return propertyNo;
    }

    public void setPropertyNo(String propertyNo)
    {
        this.propertyNo = propertyNo;
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

    @XmlTransient
    public List<ResidenceGardenService> getResidenceGardenServiceList()
    {
        return residenceGardenServiceList;
    }

    public void setResidenceGardenServiceList(List<ResidenceGardenService> residenceGardenServiceList)
    {
        this.residenceGardenServiceList = residenceGardenServiceList;
    }

    public Complex getComplexId()
    {
        return complexId;
    }

    public void setComplexId(Complex complexId)
    {
        this.complexId = complexId;
    }

    public Street getStreetId()
    {
        return streetId;
    }

    public void setStreetId(Street streetId)
    {
        this.streetId = streetId;
    }

    @XmlTransient
    public List<ResidenceSecurity> getResidenceSecurityList()
    {
        return residenceSecurityList;
    }

    public void setResidenceSecurityList(List<ResidenceSecurity> residenceSecurityList)
    {
        this.residenceSecurityList = residenceSecurityList;
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
        if (!(object instanceof Residence))
        {
            return false;
        }
        Residence other = (Residence) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.garscom.data.entity.Residence[ id=" + id + " ]";
    }
    
}
