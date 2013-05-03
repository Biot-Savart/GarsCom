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
@Table(name = "activity_type")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "ActivityType.findAll", query = "SELECT a FROM ActivityType a"),
    @NamedQuery(name = "ActivityType.findById", query = "SELECT a FROM ActivityType a WHERE a.id = :id"),
    @NamedQuery(name = "ActivityType.findByDescription", query = "SELECT a FROM ActivityType a WHERE a.description = :description"),
    @NamedQuery(name = "ActivityType.findByActivityTypecol", query = "SELECT a FROM ActivityType a WHERE a.activityTypecol = :activityTypecol")
})
public class ActivityType implements Serializable
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
    @Size(min = 1, max = 100)
    @Column(name = "description")
    private String description;
    @Size(max = 45)
    @Column(name = "activity_typecol")
    private String activityTypecol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "activityTypeId")
    private List<Activity> activityList;

    public ActivityType()
    {
    }

    public ActivityType(Integer id)
    {
        this.id = id;
    }

    public ActivityType(Integer id, String description)
    {
        this.id = id;
        this.description = description;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getActivityTypecol()
    {
        return activityTypecol;
    }

    public void setActivityTypecol(String activityTypecol)
    {
        this.activityTypecol = activityTypecol;
    }

    @XmlTransient
    public List<Activity> getActivityList()
    {
        return activityList;
    }

    public void setActivityList(List<Activity> activityList)
    {
        this.activityList = activityList;
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
        if (!(object instanceof ActivityType))
        {
            return false;
        }
        ActivityType other = (ActivityType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.garscom.data.entity.ActivityType[ id=" + id + " ]";
    }
    
}
