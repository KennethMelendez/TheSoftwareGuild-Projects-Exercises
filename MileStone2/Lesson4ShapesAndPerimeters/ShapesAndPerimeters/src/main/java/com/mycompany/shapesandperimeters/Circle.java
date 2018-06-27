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
public class Circle extends Shape {
    
    protected double radius;
    protected double area;
    protected double diameter;
    protected double perimeter;
    final double pi = 3.14159265359;
    
    public void getRadius(double radius){
        this.radius = radius;
    }
    
    public void getDiameter(double diameter){
        this.diameter = diameter;
    }
    
    @Override
    public void getArea(){
        double square = radius * radius;
        area = (pi) * square;
        System.out.println(area);
    }
    
    @Override
    public void getPerimeter(){
        perimeter = pi * diameter;
        System.out.println(perimeter);
    }
}
