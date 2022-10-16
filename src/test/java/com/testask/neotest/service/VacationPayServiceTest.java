package com.testask.neotest.service;

import com.testask.neotest.dto.VacationPayDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VacationPayServiceTest {

    @Autowired
    private VacationPayService vacationPayService;

    @Test
    void calculationVacationPayTest() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String startVacationDateInString = "2022-05-01";
        String endVacationDateInString = "2022-05-10";

        double salary = 400000;
        Date startVacationDate = formatter.parse(startVacationDateInString);
        Date endVacationDate = formatter.parse(endVacationDateInString);
        VacationPayDTO vacationPayDTO = new VacationPayDTO(salary, startVacationDate, endVacationDate);

        BigDecimal expected = BigDecimal.valueOf(4550.63);
        BigDecimal result = vacationPayService.calculationVacationPay(vacationPayDTO);

        assertEquals(expected, result);
    }

    @Test
    void getNumberOfWorkingDaysTest() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String startVacationDateInString = "2022-05-01";
        String endVacationDateInString = "2022-05-10";

        double salary = 400000;
        Date startVacationDate = formatter.parse(startVacationDateInString);
        Date endVacationDate = formatter.parse(endVacationDateInString);
        VacationPayDTO vacationPayDTO = new VacationPayDTO(salary, startVacationDate, endVacationDate);

        int expected = 4;
        int result = vacationPayService.getNumberOfWorkingDays(vacationPayDTO);

        assertEquals(expected, result);
    }
}