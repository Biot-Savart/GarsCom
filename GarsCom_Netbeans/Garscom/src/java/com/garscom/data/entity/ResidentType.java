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
@Table(name = "resident_type")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "ResidentType.findAll", query = "SELECT r FROM ResidentType r"),
    @NamedQuery(name = "ResidentType.findById", query = "SELECT r FROM ResidentType r WHERE r.id = :id"),
    @NamedQuery(name = "ResidentType.findByName", query = "SELECT r FROM ResidentType r WHERE r.name = :name"),
    @NamedQuery(name = "ResidentType.findByDescription", query = "SELECT r FROM ResidentType r WHERE r.description = :description")
})
public class ResidentType implements Serializable
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "residentTypeId")
    private List<Resident> residentList;

    public ResidentType()
    {
    }

    public ResidentType(Integer id)
    {
        this.id = id;
    }

    public ResidentType(Integer id, String name)
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

    @XmlTransient
    public List<Resident> getResidentList()
    {
        return residentList;
    }

    public void setResidentList(List<Resident> residentList)
    {
        this.residentList = residentList;
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
        if (!(object instanceof ResidentType))
        {
            return false;
        }
        ResidentType other = (ResidentType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.garscom.data.entity.ResidentType[ id=" + id + " ]";
    }
    
}
