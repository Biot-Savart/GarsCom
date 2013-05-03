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
@Table(name = "complex")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Complex.findAll", query = "SELECT c FROM Complex c"),
    @NamedQuery(name = "Complex.findById", query = "SELECT c FROM Complex c WHERE c.id = :id"),
    @NamedQuery(name = "Complex.findByName", query = "SELECT c FROM Complex c WHERE c.name = :name")
})
public class Complex implements Serializable
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
    @OneToMany(mappedBy = "complexId")
    private List<Residence> residenceList;

    public Complex()
    {
    }

    public Complex(Integer id)
    {
        this.id = id;
    }

    public Complex(Integer id, String name)
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
    public List<Residence> getResidenceList()
    {
        return residenceList;
    }

    public void setResidenceList(List<Residence> residenceList)
    {
        this.residenceList = residenceList;
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
        if (!(object instanceof Complex))
        {
            return false;
        }
        Complex other = (Complex) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.garscom.data.entity.Complex[ id=" + id + " ]";
    }
    
}
