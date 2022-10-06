package com.credibanco.assessment.card.utilities;

import java.util.Random;

public class GenerarNumeroValidacion {
    public static Integer generarNumeroValacion(){
        Random random = new Random();
        return random.nextInt(100) + 1;
    }
}
