package com.testask.neotest.service;

import com.testask.neotest.dto.VacationPayDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class VacationPayService {
    private static final int MONTHS = 12;
    private static final double AVG_DAYS_IN_MONTHS = 29.3;

    public BigDecimal calculationVacationPay(VacationPayDTO vacationPayDTO){
        return new BigDecimal(vacationPayDTO.salary / MONTHS / AVG_DAYS_IN_MONTHS * vacationPayDTO.days).setScale(2, RoundingMode.HALF_UP);
    }
}
