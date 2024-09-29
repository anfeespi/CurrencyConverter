package com.alura.model;

import java.time.LocalDateTime;

public class ConverterDTO {
    private String fromCode;
    private String toCode;
    private double fromValue;
    private double toValue;
    private LocalDateTime dateTime;

    public ConverterDTO() {

    }
    public ConverterDTO(String fromCode, String toCode, double fromValue, double toValue) {
        this.fromCode = fromCode;
        this.toCode = toCode;
        this.fromValue = fromValue;
        this.toValue = toValue;
        this.dateTime = LocalDateTime.now();
    }

    public String getFromCode() {
        return fromCode;
    }

    public void setFromCode(String fromCode) {
        this.fromCode = fromCode;
    }

    public String getToCode() {
        return toCode;
    }

    public void setToCode(String toCode) {
        this.toCode = toCode;
    }

    public double getFromValue() {
        return fromValue;
    }

    public void setFromValue(double fromValue) {
        this.fromValue = fromValue;
    }

    public double getToValue() {
        return toValue;
    }

    public void setToValue(double toValue) {
        this.toValue = toValue;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Conversión: " +fromValue + " " + fromCode + " -> " + toValue + " " + toCode + ", Fecha: " + dateTime;
    }
}
