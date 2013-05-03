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
@Table(name = "security_company")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "SecurityCompany.findAll", query = "SELECT s FROM SecurityCompany s"),
    @NamedQuery(name = "SecurityCompany.findById", query = "SELECT s FROM SecurityCompany s WHERE s.id = :id"),
    @NamedQuery(name = "SecurityCompany.findByName", query = "SELECT s FROM SecurityCompany s WHERE s.name = :name")
})
public class SecurityCompany implements Serializable
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "securityCompany")
    private List<ResidenceSecurity> residenceSecurityList;

    public SecurityCompany()
    {
    }

    public SecurityCompany(Integer id)
    {
        this.id = id;
    }

    public SecurityCompany(Integer id, String name)
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
        if (!(object instanceof SecurityCompany))
        {
            return false;
        }
        SecurityCompany other = (SecurityCompany) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.garscom.data.entity.SecurityCompany[ id=" + id + " ]";
    }
    
}
