/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package karaokie;

/**
 *
 * @author sonra
 */
import database.getConnection;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.*;

public class statData {
    private ArrayList<Double> currentWeek = new ArrayList<Double>();
    private ArrayList<Double> currentMonth = new ArrayList<Double>();
    private ArrayList<Double> currentYear = new ArrayList<Double>();
    private final LocalDate currentDate = LocalDate.now();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public statData() {
        getDayInWeek();
        getWeekInMonth();
        getMonthInYear();
    }
    public void getDayInWeek() {
        for (int i = 1; i <= 7; i++) {
            LocalDate currentDay = currentDate.with(DayOfWeek.of(i));
            currentWeek.add(getConnection.getCost(formatter.format(currentDay)));
        }
    }
    public void getWeekInMonth() {
        LocalDate currentMonday = currentDate.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        while (currentMonday.getMonth().equals(currentDate.getMonth())) {
            LocalDate currentSunday = currentMonday.with(DayOfWeek.SUNDAY);
            currentMonth.add(getConnection.getCost(formatter.format(currentMonday), formatter.format(currentSunday)));
            currentMonday = currentMonday.plusWeeks(1);
        }
    }
    public void getMonthInYear() {
        for (int i = 1; i <= 12; i++) {
            currentYear.add(getConnection.getCost(i));
        }
    }
    public static void main(String[] args) {
        new statData();
    }
}
