package com.testask.neotest.dto;

import java.util.Date;

public class VacationPayDTO {
    public final double salary;
    public final Date startVacationDate;
    public final Date endVacationDate;

    public VacationPayDTO(double salary, Date startVacationDate, Date endVacationDate) {
        this.salary = salary;
        this.startVacationDate = startVacationDate;
        this.endVacationDate = endVacationDate;
    }
}
