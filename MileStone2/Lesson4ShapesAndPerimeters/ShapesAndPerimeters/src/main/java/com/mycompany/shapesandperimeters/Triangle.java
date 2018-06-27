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
public class Triangle extends Shape{
    protected double base;
    protected double height;
    protected double area;
    protected double side2;
    protected double side;
    protected double perimeter;
    final protected double oneHalf = 0.5;
    
    public void getBase(double base){
        this.base = base;
    }
    
    public void getHeight(double height){
        this.height = height;
    }
    
    @Override
    public void getArea(){
        area = (oneHalf)* base * height;
        System.out.println(area);
    }
    
    @Override
    public void getPerimeter(){
        perimeter = side + base + side2;
        System.out.println(perimeter);
    }
}
