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
@Table(name = "radio_brand")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "RadioBrand.findAll", query = "SELECT r FROM RadioBrand r"),
    @NamedQuery(name = "RadioBrand.findById", query = "SELECT r FROM RadioBrand r WHERE r.id = :id"),
    @NamedQuery(name = "RadioBrand.findByName", query = "SELECT r FROM RadioBrand r WHERE r.name = :name"),
    @NamedQuery(name = "RadioBrand.findByDescription", query = "SELECT r FROM RadioBrand r WHERE r.description = :description")
})
public class RadioBrand implements Serializable
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "radioBrandId")
    private List<RadioModel> radioModelList;

    public RadioBrand()
    {
    }

    public RadioBrand(Integer id)
    {
        this.id = id;
    }

    public RadioBrand(Integer id, String name)
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
    public List<RadioModel> getRadioModelList()
    {
        return radioModelList;
    }

    public void setRadioModelList(List<RadioModel> radioModelList)
    {
        this.radioModelList = radioModelList;
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
        if (!(object instanceof RadioBrand))
        {
            return false;
        }
        RadioBrand other = (RadioBrand) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.garscom.data.entity.RadioBrand[ id=" + id + " ]";
    }
    
}
