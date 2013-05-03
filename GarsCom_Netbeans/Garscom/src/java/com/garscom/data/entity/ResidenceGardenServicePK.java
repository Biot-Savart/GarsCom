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
public class ResidenceGardenServicePK implements Serializable
{
    @Basic(optional = false)
    @NotNull
    @Column(name = "garden_service_id")
    private int gardenServiceId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "week_days_id")
    private int weekDaysId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "residence_id")
    private int residenceId;

    public ResidenceGardenServicePK()
    {
    }

    public ResidenceGardenServicePK(int gardenServiceId, int weekDaysId, int residenceId)
    {
        this.gardenServiceId = gardenServiceId;
        this.weekDaysId = weekDaysId;
        this.residenceId = residenceId;
    }

    public int getGardenServiceId()
    {
        return gardenServiceId;
    }

    public void setGardenServiceId(int gardenServiceId)
    {
        this.gardenServiceId = gardenServiceId;
    }

    public int getWeekDaysId()
    {
        return weekDaysId;
    }

    public void setWeekDaysId(int weekDaysId)
    {
        this.weekDaysId = weekDaysId;
    }

    public int getResidenceId()
    {
        return residenceId;
    }

    public void setResidenceId(int residenceId)
    {
        this.residenceId = residenceId;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) gardenServiceId;
        hash += (int) weekDaysId;
        hash += (int) residenceId;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResidenceGardenServicePK))
        {
            return false;
        }
        ResidenceGardenServicePK other = (ResidenceGardenServicePK) object;
        if (this.gardenServiceId != other.gardenServiceId)
        {
            return false;
        }
        if (this.weekDaysId != other.weekDaysId)
        {
            return false;
        }
        if (this.residenceId != other.residenceId)
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.garscom.data.entity.ResidenceGardenServicePK[ gardenServiceId=" + gardenServiceId + ", weekDaysId=" + weekDaysId + ", residenceId=" + residenceId + " ]";
    }
    
}
