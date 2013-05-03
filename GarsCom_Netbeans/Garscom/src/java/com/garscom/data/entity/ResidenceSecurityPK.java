/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.garscom.data.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Ryno
 */
@Embeddable
public class ResidenceSecurityPK implements Serializable
{
    @Basic(optional = false)
    @NotNull
    @Column(name = "residence_id")
    private int residenceId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "security_company_id")
    private int securityCompanyId;

    public ResidenceSecurityPK()
    {
    }

    public ResidenceSecurityPK(int residenceId, int securityCompanyId)
    {
        this.residenceId = residenceId;
        this.securityCompanyId = securityCompanyId;
    }

    public int getResidenceId()
    {
        return residenceId;
    }

    public void setResidenceId(int residenceId)
    {
        this.residenceId = residenceId;
    }

    public int getSecurityCompanyId()
    {
        return securityCompanyId;
    }

    public void setSecurityCompanyId(int securityCompanyId)
    {
        this.securityCompanyId = securityCompanyId;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) residenceId;
        hash += (int) securityCompanyId;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResidenceSecurityPK))
        {
            return false;
        }
        ResidenceSecurityPK other = (ResidenceSecurityPK) object;
        if (this.residenceId != other.residenceId)
        {
            return false;
        }
        if (this.securityCompanyId != other.securityCompanyId)
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.garscom.data.entity.ResidenceSecurityPK[ residenceId=" + residenceId + ", securityCompanyId=" + securityCompanyId + " ]";
    }
    
}
