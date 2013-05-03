/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.garscom.data.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ryno
 */
@Entity
@Table(name = "residence_security")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "ResidenceSecurity.findAll", query = "SELECT r FROM ResidenceSecurity r"),
    @NamedQuery(name = "ResidenceSecurity.findByResidenceId", query = "SELECT r FROM ResidenceSecurity r WHERE r.residenceSecurityPK.residenceId = :residenceId"),
    @NamedQuery(name = "ResidenceSecurity.findBySecurityCompanyId", query = "SELECT r FROM ResidenceSecurity r WHERE r.residenceSecurityPK.securityCompanyId = :securityCompanyId"),
    @NamedQuery(name = "ResidenceSecurity.findByStartdate", query = "SELECT r FROM ResidenceSecurity r WHERE r.startdate = :startdate"),
    @NamedQuery(name = "ResidenceSecurity.findByEnddate", query = "SELECT r FROM ResidenceSecurity r WHERE r.enddate = :enddate")
})
public class ResidenceSecurity implements Serializable
{
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ResidenceSecurityPK residenceSecurityPK;
    @Column(name = "startdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startdate;
    @Column(name = "enddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enddate;
    @JoinColumn(name = "security_company_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SecurityCompany securityCompany;
    @JoinColumn(name = "residence_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Residence residence;

    public ResidenceSecurity()
    {
    }

    public ResidenceSecurity(ResidenceSecurityPK residenceSecurityPK)
    {
        this.residenceSecurityPK = residenceSecurityPK;
    }

    public ResidenceSecurity(int residenceId, int securityCompanyId)
    {
        this.residenceSecurityPK = new ResidenceSecurityPK(residenceId, securityCompanyId);
    }

    public ResidenceSecurityPK getResidenceSecurityPK()
    {
        return residenceSecurityPK;
    }

    public void setResidenceSecurityPK(ResidenceSecurityPK residenceSecurityPK)
    {
        this.residenceSecurityPK = residenceSecurityPK;
    }

    public Date getStartdate()
    {
        return startdate;
    }

    public void setStartdate(Date startdate)
    {
        this.startdate = startdate;
    }

    public Date getEnddate()
    {
        return enddate;
    }

    public void setEnddate(Date enddate)
    {
        this.enddate = enddate;
    }

    public SecurityCompany getSecurityCompany()
    {
        return securityCompany;
    }

    public void setSecurityCompany(SecurityCompany securityCompany)
    {
        this.securityCompany = securityCompany;
    }

    public Residence getResidence()
    {
        return residence;
    }

    public void setResidence(Residence residence)
    {
        this.residence = residence;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (residenceSecurityPK != null ? residenceSecurityPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResidenceSecurity))
        {
            return false;
        }
        ResidenceSecurity other = (ResidenceSecurity) object;
        if ((this.residenceSecurityPK == null && other.residenceSecurityPK != null) || (this.residenceSecurityPK != null && !this.residenceSecurityPK.equals(other.residenceSecurityPK)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.garscom.data.entity.ResidenceSecurity[ residenceSecurityPK=" + residenceSecurityPK + " ]";
    }
    
}
