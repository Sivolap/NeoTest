package com.testask.neotest.dto;

import java.time.LocalDate;

public class VacationPayDTO {
    public final double salary;
    public final int days;
    public final LocalDate startDate;
    public final LocalDate endDate;

    public VacationPayDTO(double salary, int days, LocalDate startDate, LocalDate endDate) {
        this.salary = salary;
        this.days = days;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
