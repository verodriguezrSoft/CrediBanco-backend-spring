package com.credibanco.assessment.card.services;

import com.credibanco.assessment.card.model.RequestCardInfo;
import com.credibanco.assessment.card.model.RequestUsuarioInfo;
import com.credibanco.assessment.card.model.ResponseTarjeta;
import org.springframework.http.HttpStatus;

import java.util.HashMap;

public interface ICrediBancoServiceImpl {
    HashMap<ResponseTarjeta, HttpStatus> crearTarjeta(RequestCardInfo requestCardInfo) throws Exception;
    HashMap<ResponseTarjeta, HttpStatus> enrolarTarjeta(RequestCardInfo requestCardInfo) throws Exception;
    HashMap<ResponseTarjeta, HttpStatus> consultarTarjeta(RequestCardInfo requestCardInfo) throws Exception;
    HashMap<ResponseTarjeta, HttpStatus> eliminarTarjeta(RequestCardInfo requestCardInfo) throws Exception;
    HashMap<ResponseTarjeta, HttpStatus> crearTransacción(RequestUsuarioInfo requestUsuarioInfo) throws Exception;
    HashMap<ResponseTarjeta, HttpStatus> anularTransacción(RequestUsuarioInfo requestUsuarioInfo) throws Exception;
}
