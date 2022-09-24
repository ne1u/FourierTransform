package com.cekn;

public class ComplexNumber {
    double real;
    double imaginary;
    ComplexNumber(double real,double imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }

    ComplexNumber add(ComplexNumber c){
        double re = this.real + c.real;
        double im = this.imaginary + c.imaginary;
        return new ComplexNumber(re, im);
    }

    ComplexNumber subtraction(ComplexNumber c){
        double re = this.real - c.real;
        double im = this.imaginary - c.imaginary;
        return new ComplexNumber(re, im);
    }

    ComplexNumber multiplication(ComplexNumber c){
        double re = this.real * c.real - this.imaginary * c.imaginary;
        double im = this.real * c.imaginary + this.imaginary * c.real;
        return new ComplexNumber(re, im);
    }

    ComplexNumber division(ComplexNumber c){
        ComplexNumber c1 = new ComplexNumber(this.real, this.imaginary);
        ComplexNumber c2 = new ComplexNumber(c.real, -c.imaginary);
        ComplexNumber c3 = c1.multiplication(c2);
        ComplexNumber c4 = c.multiplication(c2);
        return new ComplexNumber(c3.real/c4.real, c3.imaginary/c4.real);
    }
}
