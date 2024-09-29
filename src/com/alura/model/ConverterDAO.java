package com.alura.model;

import java.util.ArrayList;

public class ConverterDAO {
    private ArrayList<ConverterDTO> converters;

    public ConverterDAO() {
        converters = new ArrayList<>();
    }

    public ArrayList<ConverterDTO> getConverters() {
        return converters;
    }
    public void setConverters(ArrayList<ConverterDTO> converters) {
        this.converters = converters;
    }

    public void addConverter(ConverterDTO converter) {
        converters.add(converter);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (ConverterDTO converter : converters) {
            sb.append(converter.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
