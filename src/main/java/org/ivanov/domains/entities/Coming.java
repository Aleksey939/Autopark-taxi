package org.ivanov.domains.entities;

import lombok.Data;
import org.ivanov.domains.entities.listeners.ComingListener;
import org.ivanov.services.utils.CommonUtil;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@Entity
@EntityListeners(ComingListener.class)
public class Coming {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private LocalDate startDate;
    @Transient
    private String startDateDto;

    private double   income;
    private double   bonus;
    private double   commissionPartner;
    private double   driverSalary;
    private Integer  mileage;
    private double   consumptionOneKm;
    private double   fuelCosts;
    private double   profitOneKm;
    private double   fundMaintenance;
    private double   costsOfMaintenance;
    private double   capitalizationMaintenanceStart;
    private double   capitalizationMaintenanceEnd;
    private double   fundRepairs;
    private double   costsOfRepairs;
    private double   capitalizationRepairsStart;
    private double   capitalizationRepairsEnd;
    private double   currentExpenses;
    private double   carWash;
    private double   profit;
    private double   commissionControl;
    private double   investorIncome;
    private double   depreciation;
    private double   netinvestorIncome;
    private boolean  payment=false;

    @Column(columnDefinition = "timestamp")
    private LocalDateTime time;
    @ManyToOne(optional = false)
    private Car car;

    public double calculateProfit() {
        return CommonUtil.round2(getIncome()
                + getBonus()
                - getCommissionPartner()
                - getDriverSalary()
                - getFuelCosts()
                - getFundMaintenance()
                - getFundRepairs()
                - getCurrentExpenses()
                - getCarWash());
    }

    public double calculateCapitalizationMaintenanceEnd() {
        return CommonUtil.round2(getCapitalizationMaintenanceStart() +
                getFundMaintenance() - getCostsOfMaintenance());
    }

    public double calculateCapitalizationRepairsEnd() {
        return CommonUtil.round2(getCapitalizationRepairsStart() +
                getFundRepairs() - getCostsOfRepairs());
    }
}
