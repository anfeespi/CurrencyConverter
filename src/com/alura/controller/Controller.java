package com.alura.controller;

import com.alura.model.Converter;
import com.alura.model.ConverterDAO;
import com.alura.model.ConverterDTO;
import com.alura.util.RequestMaker;
import com.alura.view.Console;

public class Controller {
    private final Console console;
    private final ConverterDAO converterDAO;

    private int from;
    private boolean rep = true, printed = false;
    private Converter converter;

    public Controller(){
        console = new Console();
        converterDAO = new ConverterDAO();

        run();
    }

    public void run(){
        while(rep){
            preconvert();
            convert();
        }
    }

    public void preconvert(){
        String menuIn = """
                \t -- Conversor de monedas: anfeespi --\

                -Bienvenido al conversor de monedas, ingrese un la opción de origen\

                1. Dólar (USD)\
                           \s
                2. Euro (EUR)\

                3. Peso argentino (ARS)\

                4. Boliviano (BOB)\

                5. Real brasileño (BRL)\

                6. Peso chileno (CLP)\

                7. Peso colombiano (COP)\
                
                8. Ver historial* \

                #. Salir""";
        console.printMessage(menuIn);
        from = console.readInt();
        if(from == 0){
            rep = false;
            return;
        }

        if(from == 8){
            console.printMessage(converterDAO.toString());
            printed = true;
            return;
        }

        String code = codeMapper(from);

        converter = RequestMaker.requestAConverter(code);
    }

    public void convert(){
        if(!rep)
            return;

        if(printed){
            printed = false;
            return;
        }

        String menuOut = """
                \t -- Conversor de monedas: anfeespi --\

                -Elija la moneda destino para la conversión\

                1. Dólar (USD)\
                           \s
                2. Euro (EUR)\

                3. Peso argentino (ARS)\

                4. Boliviano (BOB)\

                5. Real brasileño (BRL)\

                6. Peso chileno (CLP)\

                7. Peso colombiano (COP)\

                #. Salir""";
        console.printMessage(menuOut);
        int to = console.readInt();
        if(to == 0){
            rep = false;
            return;
        }

        console.printMessage("Ingrese el valor a convertir: ");
        double convertValue = console.readDouble();

        double ans = switch (to) {
            case 1 -> converter.getUSD() * convertValue;
            case 2 -> converter.getEUR() * convertValue;
            case 3 -> converter.getARS() * convertValue;
            case 4 -> converter.getBOB() * convertValue;
            case 5 -> converter.getBRL() * convertValue;
            case 6 -> converter.getCLP() * convertValue;
            case 7 -> converter.getCOP() * convertValue;
            default -> 0.0;
        };

        String fromString = codeMapper(from);

        String toString = codeMapper(to);

        console.printMessage("\t ------------------------------- \n - El resultado de la conversión es de "+ convertValue +" "+fromString+" a "+ans+" "+toString+"\n\t ------------------------------- \n");

        converterDAO.addConverter(new ConverterDTO(fromString, toString, convertValue, ans));
    }

    private String codeMapper(int i) {
        return switch (i) {
            case 1 -> "USD";
            case 2 -> "EUR";
            case 3 -> "ARS";
            case 4 -> "BOB";
            case 5 -> "BRL";
            case 6 -> "CLP";
            case 7 -> "COP";
            default -> "";
        };
    }

}
