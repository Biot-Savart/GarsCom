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
@Table(name = "week_days")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "WeekDays.findAll", query = "SELECT w FROM WeekDays w"),
    @NamedQuery(name = "WeekDays.findById", query = "SELECT w FROM WeekDays w WHERE w.id = :id"),
    @NamedQuery(name = "WeekDays.findByName", query = "SELECT w FROM WeekDays w WHERE w.name = :name")
})
public class WeekDays implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "weekDays")
    private List<ResidenceGardenService> residenceGardenServiceList;

    public WeekDays()
    {
    }

    public WeekDays(Integer id)
    {
        this.id = id;
    }

    public WeekDays(Integer id, String name)
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
        if (!(object instanceof WeekDays))
        {
            return false;
        }
        WeekDays other = (WeekDays) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.garscom.data.entity.WeekDays[ id=" + id + " ]";
    }
    
}
