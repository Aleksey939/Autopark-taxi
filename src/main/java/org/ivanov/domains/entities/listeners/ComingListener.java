package org.ivanov.domains.entities.listeners;

import org.ivanov.domains.entities.Coming;
import org.ivanov.services.utils.CommonUtil;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class ComingListener {

    @PrePersist
    public void onCreate(Coming coming) { setOnCreateAndUpdate(coming);}

    @PreUpdate
    public void onUpdate(Coming coming) {
        setOnCreateAndUpdate(coming);
    }

    private void setOnCreateAndUpdate(Coming coming) {
        coming.setProfit(coming.calculateProfit());
        coming.setProfitOneKm(CommonUtil.round2(coming.getIncome() / (double) coming.getMileage()));
    }
}
