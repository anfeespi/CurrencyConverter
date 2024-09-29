package com.alura.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Converter {
    private double USD;
    private double EUR;
    private double ARS;
    private double BOB;
    private double BRL;
    private double CLP;
    private double COP;

    public Converter(){

    }

    public Converter(double USD, double EUR, double ARS, double BOB, double BRL, double CLP, double COP) {
        this.USD = USD;
        this.EUR = EUR;
        this.ARS = ARS;
        this.BOB = BOB;
        this.BRL = BRL;
        this.CLP = CLP;
        this.COP = COP;
    }

    public double getUSD() {
        return USD;
    }

    public void setUSD(double USD) {
        this.USD = USD;
    }

    public double getEUR() {
        return EUR;
    }

    public void setEUR(double EUR) {
        this.EUR = EUR;
    }

    public double getARS() {
        return ARS;
    }

    public void setARS(double ARS) {
        this.ARS = ARS;
    }

    public double getBOB() {
        return BOB;
    }

    public void setBOB(double BOB) {
        this.BOB = BOB;
    }

    public double getBRL() {
        return BRL;
    }

    public void setBRL(double BRL) {
        this.BRL = BRL;
    }

    public double getCLP() {
        return CLP;
    }

    public void setCLP(double CLP) {
        this.CLP = CLP;
    }

    public double getCOP() {
        return COP;
    }

    public void setCOP(double COP) {
        this.COP = COP;
    }
}
