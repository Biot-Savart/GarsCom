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
@Table(name = "contribution_type")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "ContributionType.findAll", query = "SELECT c FROM ContributionType c"),
    @NamedQuery(name = "ContributionType.findById", query = "SELECT c FROM ContributionType c WHERE c.id = :id"),
    @NamedQuery(name = "ContributionType.findByDescription", query = "SELECT c FROM ContributionType c WHERE c.description = :description")
})
public class ContributionType implements Serializable
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
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contributionTypeId")
    private List<Contribution> contributionList;

    public ContributionType()
    {
    }

    public ContributionType(Integer id)
    {
        this.id = id;
    }

    public ContributionType(Integer id, String description)
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

    @XmlTransient
    public List<Contribution> getContributionList()
    {
        return contributionList;
    }

    public void setContributionList(List<Contribution> contributionList)
    {
        this.contributionList = contributionList;
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
        if (!(object instanceof ContributionType))
        {
            return false;
        }
        ContributionType other = (ContributionType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.garscom.data.entity.ContributionType[ id=" + id + " ]";
    }
    
}
