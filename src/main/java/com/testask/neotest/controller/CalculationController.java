package com.testask.neotest.controller;

import com.testask.neotest.dto.VacationPayDTO;
import com.testask.neotest.service.VacationPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CalculationController {
    @Autowired
    private VacationPayService vacationPayService;

    @GetMapping("/calculate")
    public BigDecimal getCalculation(@RequestBody VacationPayDTO vacationPayDTO){
        return vacationPayService.calculationVacationPay(vacationPayDTO);
    }
}
