/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.shapesandperimeters;

/**
 *
 * @author kmlnd
 */
public class Square extends Shape {
    
    protected double area;
    protected double width;
    protected double height;
    protected double sides;
    protected double perimeter;
    
    public void getWidth(double width){
        this.width = width;
    }
    
    public void getHeight(double height){
        this.height = height;
    }
    
    public void getSides(double sides){
        this.sides = sides;
    }
    
    @Override
    public void getArea(){
        area = width * height;
    }
    
    @Override
    public void getPerimeter(){
        perimeter = sides * width;
        System.out.println(perimeter);
    }
}
