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
@Table(name = "block")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Block.findAll", query = "SELECT b FROM Block b"),
    @NamedQuery(name = "Block.findById", query = "SELECT b FROM Block b WHERE b.id = :id"),
    @NamedQuery(name = "Block.findByName", query = "SELECT b FROM Block b WHERE b.name = :name")
})
public class Block implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @JoinTable(name = "block_leader_map", joinColumns =
    {
        @JoinColumn(name = "block_id", referencedColumnName = "id")
    }, inverseJoinColumns =
    {
        @JoinColumn(name = "leader_id", referencedColumnName = "id")
    })
    @ManyToMany
    private List<User> userList;
    @JoinTable(name = "block_street", joinColumns =
    {
        @JoinColumn(name = "block_id", referencedColumnName = "id")
    }, inverseJoinColumns =
    {
        @JoinColumn(name = "street_id", referencedColumnName = "id")
    })
    @ManyToMany
    private List<Street> streetList;

    public Block()
    {
    }

    public Block(Integer id)
    {
        this.id = id;
    }

    public Block(Integer id, String name)
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
    public List<Street> getStreetList()
    {
        return streetList;
    }

    public void setStreetList(List<Street> streetList)
    {
        this.streetList = streetList;
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
        if (!(object instanceof Block))
        {
            return false;
        }
        Block other = (Block) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.garscom.data.entity.Block[ id=" + id + " ]";
    }
    
}
