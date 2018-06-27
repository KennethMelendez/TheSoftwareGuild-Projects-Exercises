/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.javadatetimeapi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author kmlnd
 */
public class App {
    public static void main(String[] args) {
        
        //===================Video: Creating and Formatting Dates===================
        
        /*
        default date is iso formatt
        */
        
        //output todays date
        LocalDate ld = LocalDate.now();
        System.out.println(ld);
        
        //outputting your date
        ld = LocalDate.parse("2016-01-01");
        System.out.println(ld);
        
        ///<
        ld = LocalDate.parse("02/07/2010",DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        System.out.println(ld);
        
        //use this so you can store date
        //putting into a string
        String isoDate = ld.toString();
        System.out.println(isoDate);
        
        ld = LocalDate.parse(isoDate);
        System.out.println(ld);
        
        String formatted = ld.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        System.out.println(formatted);
        
        //can make up own pattern
        //would not recommend
        formatted = ld.format(DateTimeFormatter.ofPattern("MM=dd=yyy+=+=+="));
        System.out.println(formatted);
        
        //shows full localized formatt
        formatted = ld.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
        formatted = ld.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
        System.out.println(formatted);
        
        //=============== Video: Future, Past, and Date Difference  ===================
        
        //Subtracting days and formatt past date
        //takes care of month arithmetic
        LocalDate past = ld.minusDays(8);
        formatted = past.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
        System.out.println(formatted);
        
        past = ld.minusMonths(3);
        formatted = past.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
        System.out.println(formatted);
        
        //hey i bought this thing i want to see how old something is.
        //You can use this faytime api!
        //period is just a period of time
        
        Period diff = ld.until(past);
        System.out.println(diff);
        //p minus 3 months
        System.out.println(diff.getMonths());
        diff = past.until(ld);
        System.out.println(diff);
        
        //=============== Video: LocalDateTime and Date Conversion  ===================
        //local date times
        //good for time stamps
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        //can make own pattern
        //local date time
        formatted = ldt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
        System.out.println(formatted);
        
        //how to convert legacy dates
        
        //date for right now
        //we have a date and a gregorian calendar
        Date legacyDate = new Date();
        System.out.println(legacyDate);
        
        GregorianCalendar legacyCalendar = new GregorianCalendar();
        System.out.println(legacyCalendar);
        
        //taking instant and feeding into a factory method
        ZonedDateTime zdt = ZonedDateTime.ofInstant(legacyDate.toInstant(), ZoneId.systemDefault());
        ld = zdt.toLocalDate();
        System.out.println(ld);
        
        zdt = legacyCalendar.toZonedDateTime();
        ld = zdt.toLocalDate();
        System.out.println(ld);
        
        //if using legacy must convert
        //very quick tour on daytime api
    }
}
