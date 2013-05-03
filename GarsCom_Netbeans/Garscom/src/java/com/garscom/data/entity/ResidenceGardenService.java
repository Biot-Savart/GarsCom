/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.garscom.data.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ryno
 */
@Entity
@Table(name = "residence_garden_service")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "ResidenceGardenService.findAll", query = "SELECT r FROM ResidenceGardenService r"),
    @NamedQuery(name = "ResidenceGardenService.findByGardenServiceId", query = "SELECT r FROM ResidenceGardenService r WHERE r.residenceGardenServicePK.gardenServiceId = :gardenServiceId"),
    @NamedQuery(name = "ResidenceGardenService.findByWeekDaysId", query = "SELECT r FROM ResidenceGardenService r WHERE r.residenceGardenServicePK.weekDaysId = :weekDaysId"),
    @NamedQuery(name = "ResidenceGardenService.findByResidenceId", query = "SELECT r FROM ResidenceGardenService r WHERE r.residenceGardenServicePK.residenceId = :residenceId")
})
public class ResidenceGardenService implements Serializable
{
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ResidenceGardenServicePK residenceGardenServicePK;
    @JoinColumn(name = "residence_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Residence residence;
    @JoinColumn(name = "week_days_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private WeekDays weekDays;
    @JoinColumn(name = "garden_service_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private GardenService gardenService;

    public ResidenceGardenService()
    {
    }

    public ResidenceGardenService(ResidenceGardenServicePK residenceGardenServicePK)
    {
        this.residenceGardenServicePK = residenceGardenServicePK;
    }

    public ResidenceGardenService(int gardenServiceId, int weekDaysId, int residenceId)
    {
        this.residenceGardenServicePK = new ResidenceGardenServicePK(gardenServiceId, weekDaysId, residenceId);
    }

    public ResidenceGardenServicePK getResidenceGardenServicePK()
    {
        return residenceGardenServicePK;
    }

    public void setResidenceGardenServicePK(ResidenceGardenServicePK residenceGardenServicePK)
    {
        this.residenceGardenServicePK = residenceGardenServicePK;
    }

    public Residence getResidence()
    {
        return residence;
    }

    public void setResidence(Residence residence)
    {
        this.residence = residence;
    }

    public WeekDays getWeekDays()
    {
        return weekDays;
    }

    public void setWeekDays(WeekDays weekDays)
    {
        this.weekDays = weekDays;
    }

    public GardenService getGardenService()
    {
        return gardenService;
    }

    public void setGardenService(GardenService gardenService)
    {
        this.gardenService = gardenService;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (residenceGardenServicePK != null ? residenceGardenServicePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResidenceGardenService))
        {
            return false;
        }
        ResidenceGardenService other = (ResidenceGardenService) object;
        if ((this.residenceGardenServicePK == null && other.residenceGardenServicePK != null) || (this.residenceGardenServicePK != null && !this.residenceGardenServicePK.equals(other.residenceGardenServicePK)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.garscom.data.entity.ResidenceGardenService[ residenceGardenServicePK=" + residenceGardenServicePK + " ]";
    }
    
}
