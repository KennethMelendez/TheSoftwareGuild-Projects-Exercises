/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author kmlnd
 */
public class UserIOImpl implements UserIO {

    Scanner sc = new Scanner(System.in);

    @Override
    public void Display(String msg) {
        System.out.println(msg);
    }

    @Override
    public String PromptString(String msg) {
        String result = "";

        Display(msg);
        result = sc.nextLine();

        return result;
    }

    //Date as String using the API
    public String PromptStringTime() {
        String result = "";
        LocalDate ld = LocalDate.now();
        Display("Insert Release Date as \"MM/dd/yyyy\" format");
        result = sc.nextLine();
        ld = LocalDate.parse(result,DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        String isoDate = ld.toString();
        return isoDate;
    }

    @Override
    public int PromptInt(String msg) {
        int result = 0;

        while (result == 0) {
            String input = PromptString(msg);
            result = Integer.parseInt(input);
        }
        return result;
    }

}
