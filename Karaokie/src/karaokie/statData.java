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
import java.sql.SQLException;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        ArrayList<String> temp = new ArrayList<String>();
        for (int i = 1; i <= 7; i++) {
            LocalDate currentDay = currentDate.with(DayOfWeek.of(i));
            temp.add(formatter.format(currentDay));
        }
        try {
            currentWeek.addAll(getConnection.getCostWeekly(temp));
        } catch (SQLException ex) {
            Logger.getLogger(statData.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("1");
    }
    public void getWeekInMonth() {
        ArrayList<String> temp = new ArrayList<String>();
        LocalDate currentMonday = currentDate.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        while (currentMonday.getMonth().equals(currentDate.getMonth())) {
            LocalDate currentSunday = currentMonday.with(DayOfWeek.SUNDAY);
            temp.add(formatter.format(currentMonday));
            temp.add(formatter.format(currentSunday));
            currentMonday = currentMonday.plusWeeks(1);
        }
        try {
            currentMonth.addAll(getConnection.getCostMonthly(temp));
        } catch (SQLException ex) {
            Logger.getLogger(statData.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("2");
    }
    public void getMonthInYear() {
        try {
            currentYear.addAll(getConnection.getCostYearly());
        } catch (SQLException ex) {
            Logger.getLogger(statData.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("3");
    }
    public ArrayList<Double> getCurrentWeek() {
        return this.currentWeek;
    }
    public ArrayList<Double> getCurrentMonth() {
        return this.currentMonth;
    }
    public ArrayList<Double> getCurrentYear() {
        return this.currentYear;
    }
    public static void main(String[] args) {
        new statData();
    }
}
