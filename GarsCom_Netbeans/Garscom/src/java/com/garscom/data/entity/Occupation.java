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
@Table(name = "occupation")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Occupation.findAll", query = "SELECT o FROM Occupation o"),
    @NamedQuery(name = "Occupation.findById", query = "SELECT o FROM Occupation o WHERE o.id = :id"),
    @NamedQuery(name = "Occupation.findByName", query = "SELECT o FROM Occupation o WHERE o.name = :name")
})
public class Occupation implements Serializable
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
    @OneToMany(mappedBy = "occupationId")
    private List<Resident> residentList;

    public Occupation()
    {
    }

    public Occupation(Integer id)
    {
        this.id = id;
    }

    public Occupation(Integer id, String name)
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
        if (!(object instanceof Occupation))
        {
            return false;
        }
        Occupation other = (Occupation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.garscom.data.entity.Occupation[ id=" + id + " ]";
    }
    
}
