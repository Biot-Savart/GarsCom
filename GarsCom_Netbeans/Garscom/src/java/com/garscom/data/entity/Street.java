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
@Table(name = "street")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Street.findAll", query = "SELECT s FROM Street s"),
    @NamedQuery(name = "Street.findById", query = "SELECT s FROM Street s WHERE s.id = :id"),
    @NamedQuery(name = "Street.findByName", query = "SELECT s FROM Street s WHERE s.name = :name")
})
public class Street implements Serializable
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
    @JoinTable(name = "street_leader_map", joinColumns =
    {
        @JoinColumn(name = "street_id", referencedColumnName = "id")
    }, inverseJoinColumns =
    {
        @JoinColumn(name = "leader_id", referencedColumnName = "id")
    })
    @ManyToMany
    private List<User> userList;
    @ManyToMany(mappedBy = "streetList")
    private List<Block> blockList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "streetId")
    private List<Residence> residenceList;

    public Street()
    {
    }

    public Street(Integer id)
    {
        this.id = id;
    }

    public Street(Integer id, String name)
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
    public List<User> getUserList()
    {
        return userList;
    }

    public void setUserList(List<User> userList)
    {
        this.userList = userList;
    }

    @XmlTransient
    public List<Block> getBlockList()
    {
        return blockList;
    }

    public void setBlockList(List<Block> blockList)
    {
        this.blockList = blockList;
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
        if (!(object instanceof Street))
        {
            return false;
        }
        Street other = (Street) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.garscom.data.entity.Street[ id=" + id + " ]";
    }
    
}
