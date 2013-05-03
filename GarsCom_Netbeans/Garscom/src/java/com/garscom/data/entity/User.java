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
@Table(name = "user")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByActivated", query = "SELECT u FROM User u WHERE u.activated = :activated")
})
public class User implements Serializable
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
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activated")
    private boolean activated;
    @ManyToMany(mappedBy = "userList")
    private List<Street> streetList;
    @ManyToMany(mappedBy = "userList")
    private List<Block> blockList;
    @OneToMany(mappedBy = "userId")
    private List<Resident> residentList;
    @JoinColumn(name = "user_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UserType userTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<Activity> activityList;

    public User()
    {
    }

    public User(Integer id)
    {
        this.id = id;
    }

    public User(Integer id, String username, String password, boolean activated)
    {
        this.id = id;
        this.username = username;
        this.password = password;
        this.activated = activated;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public boolean getActivated()
    {
        return activated;
    }

    public void setActivated(boolean activated)
    {
        this.activated = activated;
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
    public List<Resident> getResidentList()
    {
        return residentList;
    }

    public void setResidentList(List<Resident> residentList)
    {
        this.residentList = residentList;
    }

    public UserType getUserTypeId()
    {
        return userTypeId;
    }

    public void setUserTypeId(UserType userTypeId)
    {
        this.userTypeId = userTypeId;
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
        if (!(object instanceof User))
        {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.garscom.data.entity.User[ id=" + id + " ]";
    }
    
}
