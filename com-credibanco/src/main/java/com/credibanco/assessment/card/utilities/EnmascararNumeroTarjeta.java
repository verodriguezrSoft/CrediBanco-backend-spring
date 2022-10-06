package com.credibanco.assessment.card.utilities;

public class EnmascararNumeroTarjeta {
    public static String enmascarar(String pan){
        StringBuilder enmascarado = new StringBuilder();
        for (int i = 0; i < pan.length(); i++){
            if (i >= 6 && i <= 9){
                enmascarado.append("*");
            }else {
                enmascarado.append(pan.charAt(i));
            }
        }
        return enmascarado.toString();
    }
}
