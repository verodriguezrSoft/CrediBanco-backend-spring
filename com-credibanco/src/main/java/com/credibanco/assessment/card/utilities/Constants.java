package com.credibanco.assessment.card.utilities;

public interface Constants {

    String ERROR00_CODE = "00";
    String ERROR01_CODE = "01";
    String ERROR02_CODE = "02";
    String ERROR03_CODE = "03";

    String ERROR00_MESSAGE = "Éxito";
    String ERROR00_MESSAGE_ELIMINADO_EXITOSO = "Se ha eliminado la tarjeta";
    String ERROR00_MESSAGE_COMPRA_ANULADA = "Compra anulada";

    String ERROR01_MESSAGE = "Fallido";
    String ERROR01_MESSAGE_COMPRA_EXITOSA = "Compra exitosa";
    String ERROR01_MESSAGE_ELIMINADO_FALLIDO = ", No se ha eliminado la tarjeta";
    String ERROR01_MESSAGE_TARJETA_NO_EXISTE = "Tarjeta no existe";
    String ERROR01_MESSAGE_NUMERO_DE_REFERENCIA_INVALIDO = "Numero de referencia inválido";

    String ERROR02_MESSAGE_NUMERO_VALIDACION_INVALIDO = "Número de validación invalido";
    String ERROR02_MESSAGE_TARJETA_NO_ENROLADA= "Tarjeta no enrolada";
    String ERROR02_MESSAGE_NO_SE_PUEDE_ANULAR_TRANSACCION = "No se puede anular transaccion, tiempo mayor a cinco minutos";


    String ERROR03_MESSAGE = "Tarjeta con ese número ya existe";
    String ERROR03_MESSAGE_TRANSACCION_NO_EXISTE = "Transaccion no exite";

    String MESSAGE_APROBADO = "A";
    String MESSAGE_RECHAZADA = "R";
    String MESSAGE_ANULADA = "N";

}
