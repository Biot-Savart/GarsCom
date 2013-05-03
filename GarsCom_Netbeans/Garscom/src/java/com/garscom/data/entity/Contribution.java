/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.garscom.data.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ryno
 */
@Entity
@Table(name = "contribution")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Contribution.findAll", query = "SELECT c FROM Contribution c"),
    @NamedQuery(name = "Contribution.findById", query = "SELECT c FROM Contribution c WHERE c.id = :id"),
    @NamedQuery(name = "Contribution.findByAmount", query = "SELECT c FROM Contribution c WHERE c.amount = :amount"),
    @NamedQuery(name = "Contribution.findByNote", query = "SELECT c FROM Contribution c WHERE c.note = :note")
})
public class Contribution implements Serializable
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
    @Column(name = "amount")
    private double amount;
    @Size(max = 45)
    @Column(name = "note")
    private String note;
    @JoinColumn(name = "contribution_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ContributionType contributionTypeId;
    @JoinColumn(name = "resident_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Resident residentId;

    public Contribution()
    {
    }

    public Contribution(Integer id)
    {
        this.id = id;
    }

    public Contribution(Integer id, double amount)
    {
        this.id = id;
        this.amount = amount;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public double getAmount()
    {
        return amount;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    public String getNote()
    {
        return note;
    }

    public void setNote(String note)
    {
        this.note = note;
    }

    public ContributionType getContributionTypeId()
    {
        return contributionTypeId;
    }

    public void setContributionTypeId(ContributionType contributionTypeId)
    {
        this.contributionTypeId = contributionTypeId;
    }

    public Resident getResidentId()
    {
        return residentId;
    }

    public void setResidentId(Resident residentId)
    {
        this.residentId = residentId;
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
        if (!(object instanceof Contribution))
        {
            return false;
        }
        Contribution other = (Contribution) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.garscom.data.entity.Contribution[ id=" + id + " ]";
    }
    
}
