/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.howmanydaysuntilfriday;

import java.util.Scanner;

/**
 *
 * @author kmlnd
 */
public class UserIOimpl implements UserIO {

    Scanner sc = new Scanner(System.in);

    @Override
    public void Display(String msg) {
        System.out.println(msg);
    }

    @Override
    public String readStringPrompt(String msg) {
        String result = "";
        while (result.equals("")) {
            System.out.println(msg);
            result = sc.nextLine();
            if (result.equalsIgnoreCase("")){
                System.out.println("Please fill in the feild");
            }
        }
        return result;
    }

}
