package org.ivanov.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.var;
import org.ivanov.domains.entities.Car;
import org.ivanov.domains.entities.Coming;
import org.ivanov.domains.repositories.CarRepository;
import org.ivanov.domains.repositories.ComingRepository;
import org.ivanov.services.ComingService;
import org.ivanov.services.utils.CommonUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ComingServiceImpl implements ComingService {
    public static final double FUND_MAINTENANCE_RATIO = 0.18;
    public static final double FUND_REPAIRS_RATIO = 0.4;
    public static final double PARTNER_COMMISSION_RATIO = 0.07;
    public static final double DRIVER_SALARY_RATIO = 0.6;
    public static final double CONTROL_COMMISSION_RATIO = 0.25;
    public static final double HRN_PER_USD = 35.5;
    public static final int WEEKS_PER_YEAR = 52;

    final ComingRepository comingRepository;
    final CarRepository carRepository;

    @Override
    public Coming create(Coming coming, int carId) {
        Car car = findCar(carId);
        coming.setCar(car);
        setStartDate(coming);
        setExpenses(coming);

        setCapitalizationStart(coming, car);

        coming.setCapitalizationMaintenanceEnd(coming.calculateCapitalizationMaintenanceEnd());
        coming.setCapitalizationRepairsEnd(coming.calculateCapitalizationRepairsEnd());

        setExpenses2(coming);

        return comingRepository.save(coming);
    }

    private void setCapitalizationStart(Coming coming, Car car) {
        var allComingsByCar = comingRepository.findAllByCar(car);
        if (allComingsByCar.size() == 0) {
            coming.setCapitalizationMaintenanceStart(0);
            coming.setCapitalizationRepairsStart(0);
        } else {
            coming.setCapitalizationMaintenanceStart(allComingsByCar.get(allComingsByCar.size() - 1).getCapitalizationMaintenanceEnd());
            coming.setCapitalizationRepairsStart(allComingsByCar.get(allComingsByCar.size() - 1).getCapitalizationRepairsEnd());
        }
    }

    private void setExpenses(Coming coming) {
        coming.setFundMaintenance(round(coming.getMileage() * FUND_MAINTENANCE_RATIO));
        coming.setFundRepairs(round(coming.getMileage() * FUND_REPAIRS_RATIO));
        coming.setCommissionPartner(round((coming.getIncome() + coming.getBonus()) * PARTNER_COMMISSION_RATIO));
        coming.setDriverSalary(round(coming.getIncome() * DRIVER_SALARY_RATIO));
        coming.setConsumptionOneKm(round(coming.getFuelCosts() / (double) coming.getMileage()));
    }

    private void setExpenses2(Coming coming) {
        coming.setCommissionControl(round(coming.getProfit() * CONTROL_COMMISSION_RATIO));
        coming.setInvestorIncome(round(coming.getProfit() - coming.getCommissionControl()));
        coming.setDepreciation((coming.getCar().getPriceStart() * HRN_PER_USD - coming.getCar().getPriceEnd() * HRN_PER_USD) / WEEKS_PER_YEAR);
        coming.setNetinvestorIncome(round(coming.getInvestorIncome() - coming.getDepreciation()));
    }

    private void setStartDate(Coming coming) {
        coming.setStartDate(LocalDate.parse(coming.getStartDateDto(),
                DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }

    @Override
    public Coming edit(Coming coming, Integer carId) {
        Car car = findCar(carId);
        coming.setCar(car);
        setStartDate(coming);
        setExpenses(coming);

        coming.setCapitalizationMaintenanceEnd(coming.calculateCapitalizationMaintenanceEnd());
        coming.setCapitalizationRepairsEnd(coming.calculateCapitalizationRepairsEnd());

        setExpenses2(coming);

        return comingRepository.save(coming);
    }

    private Car findCar(int carId) {
        return carRepository.findById(carId).orElseThrow(() ->
                new NoSuchElementException(
                        "Car id=" + carId + " is not exist in the database"
                )
        );
    }

    private double round(double value) {
        return CommonUtil.round2(value);
    }
}
