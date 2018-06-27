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
public class Rectangle extends Shape {
    
    protected double width;
    protected double height;
    protected double perimeter;
    protected double area;
    protected double side;
    protected double length;
    
    public void Rectangle(){
        
    }
    
    
    @Override
    public void getArea(){
        area = width * length;
    }
    
    @Override
    public void getPerimeter(){
        perimeter = 2 * (width + height);
    }
}
