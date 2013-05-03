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
@Table(name = "garden_service")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "GardenService.findAll", query = "SELECT g FROM GardenService g"),
    @NamedQuery(name = "GardenService.findById", query = "SELECT g FROM GardenService g WHERE g.id = :id"),
    @NamedQuery(name = "GardenService.findByName", query = "SELECT g FROM GardenService g WHERE g.name = :name"),
    @NamedQuery(name = "GardenService.findByDescription", query = "SELECT g FROM GardenService g WHERE g.description = :description"),
    @NamedQuery(name = "GardenService.findByTelephone", query = "SELECT g FROM GardenService g WHERE g.telephone = :telephone")
})
public class GardenService implements Serializable
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
    @Column(name = "name")
    private String name;
    @Size(max = 100)
    @Column(name = "description")
    private String description;
    @Size(max = 13)
    @Column(name = "telephone")
    private String telephone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gardenService")
    private List<ResidenceGardenService> residenceGardenServiceList;

    public GardenService()
    {
    }

    public GardenService(Integer id)
    {
        this.id = id;
    }

    public GardenService(Integer id, String name)
    {
        this.id = id;
        this.name = name;
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

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getTelephone()
    {
        return telephone;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
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
        if (!(object instanceof GardenService))
        {
            return false;
        }
        GardenService other = (GardenService) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.garscom.data.entity.GardenService[ id=" + id + " ]";
    }
    
}
