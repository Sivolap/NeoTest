package com.testask.neotest.service;

import com.groupstp.isdayoff.IsDayOff;
import com.groupstp.isdayoff.IsDayOffDateType;
import com.groupstp.isdayoff.enums.DayType;
import com.testask.neotest.dto.VacationPayDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class VacationPayService {

    private static final int MONTHS = 12;
    private static final double AVG_DAYS_IN_MONTHS = 29.3;

    public BigDecimal calculationVacationPay(VacationPayDTO vacationPayDTO) {
        return new BigDecimal(vacationPayDTO.salary / MONTHS / AVG_DAYS_IN_MONTHS *
                getNumberOfWorkingDays(vacationPayDTO)).setScale(2, RoundingMode.HALF_UP);
    }

    public int getNumberOfWorkingDays(VacationPayDTO vacationPayDTO) {
        int count = 0;

        IsDayOff isDayOff = IsDayOff.Builder().build();
        List<IsDayOffDateType> listOfDays =
                isDayOff.daysTypeByRange(vacationPayDTO.startVacationDate, vacationPayDTO.endVacationDate);
        for (IsDayOffDateType day : listOfDays) {
            if (day.getDayType().equals(DayType.WORKING_DAY) || day.getDate().getDay() == 6 ||
                    day.getDate().getDay() == 7) {
                count++;
            }
        }
        return count;
    }
}