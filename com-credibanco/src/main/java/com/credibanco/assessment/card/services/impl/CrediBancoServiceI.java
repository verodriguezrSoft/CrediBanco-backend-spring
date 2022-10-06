package com.credibanco.assessment.card.services.impl;

import com.credibanco.assessment.card.dto.Tarjeta;
import com.credibanco.assessment.card.dto.Transaccion;
import com.credibanco.assessment.card.model.RequestCardInfo;
import com.credibanco.assessment.card.model.RequestUsuarioInfo;
import com.credibanco.assessment.card.model.ResponseTarjeta;
import com.credibanco.assessment.card.repository.TarjetaRepository;
import com.credibanco.assessment.card.repository.TransaccionRepository;
import com.credibanco.assessment.card.services.ICrediBancoServiceImpl;
import com.credibanco.assessment.card.utilities.Constants;
import com.credibanco.assessment.card.utilities.EnmascararNumeroTarjeta;
import com.credibanco.assessment.card.utilities.GenerarNumeroValidacion;
import com.credibanco.assessment.card.utilities.TiempoTranscurrido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

@Service
public class CrediBancoServiceI implements ICrediBancoServiceImpl {

    @Autowired
    private TarjetaRepository tarjetaRepository;

    @Autowired
    private TransaccionRepository transaccionRepository;

    @Override
    public HashMap<ResponseTarjeta, HttpStatus> crearTarjeta(RequestCardInfo requestCardInfo) throws Exception {
        ResponseTarjeta response = new ResponseTarjeta();
        HashMap<ResponseTarjeta, HttpStatus> result = new HashMap<>();
        Tarjeta tarjeta = new Tarjeta();
        try {
            Tarjeta exiteTarjeta = tarjetaRepository.findByPAN(requestCardInfo.getPan());
            if (exiteTarjeta != null){
                response.setCodigo(Constants.ERROR03_CODE);
                response.setMessage(Constants.ERROR03_MESSAGE);
                result.put(response, HttpStatus.OK);
                return result;
            }

            Integer numeroValidacion = GenerarNumeroValidacion.generarNumeroValacion();

            tarjeta.setPAN(requestCardInfo.getPan());
            tarjeta.setCedula(requestCardInfo.getCedula());
            tarjeta.setTitular(requestCardInfo.getTitular());
            tarjeta.setDebitoCredito(requestCardInfo.getDebitoCredito());
            tarjeta.setTelefono(requestCardInfo.getTelefono());
            tarjeta.setNumeroValidacion(numeroValidacion);
            tarjetaRepository.save(tarjeta);

            response.setCodigo(Constants.ERROR00_CODE);
            response.setMessage(Constants.ERROR00_MESSAGE);
            response.setNumeroValidacion(numeroValidacion);
            response.setPanEnmascarado(EnmascararNumeroTarjeta.enmascarar(requestCardInfo.getPan()));

            result.put(response, HttpStatus.OK);
            return result;
        }catch (Exception e){
            e.printStackTrace();
            response.setCodigo(Constants.ERROR01_CODE);
            response.setMessage(Constants.ERROR01_MESSAGE);
            result.put(response, HttpStatus.BAD_REQUEST);
            return result;
        }
    }

    @Override
    public HashMap<ResponseTarjeta, HttpStatus> enrolarTarjeta(RequestCardInfo requestCardInfo) throws Exception {
        ResponseTarjeta response = new ResponseTarjeta();
        HashMap<ResponseTarjeta, HttpStatus> result = new HashMap<>();
        try {
            Tarjeta tarjetaTemp = tarjetaRepository.findByPANANDNumeroValidacion(requestCardInfo.getPan(), requestCardInfo.getNumeroValidacion());
            if (Objects.equals(tarjetaTemp, null)){
                response.setCodigo(Constants.ERROR01_CODE);
                response.setMessage(Constants.ERROR01_MESSAGE_TARJETA_NO_EXISTE);
                result.put(response, HttpStatus.OK);
                return result;
            }
            if (Objects.equals(tarjetaTemp, null) && tarjetaTemp.getNumeroValidacion() != null
                    && tarjetaTemp.getNumeroValidacion() != requestCardInfo.getNumeroValidacion()){
                response.setCodigo(Constants.ERROR02_CODE);
                response.setMessage(Constants.ERROR02_MESSAGE_NUMERO_VALIDACION_INVALIDO);
                result.put(response, HttpStatus.OK);
                return result;
            }

            tarjetaTemp.setEstado("E"); // E: significa enrolado
            tarjetaRepository.save(tarjetaTemp);

            response.setCodigo(Constants.ERROR00_CODE);
            response.setMessage(Constants.ERROR00_MESSAGE);
            response.setPanEnmascarado(EnmascararNumeroTarjeta.enmascarar(requestCardInfo.getPan()));

            result.put(response, HttpStatus.OK);
            return result;
        }catch (Exception e){
            e.printStackTrace();
            response.setCodigo(Constants.ERROR01_CODE);
            response.setMessage(Constants.ERROR01_MESSAGE);
            result.put(response, HttpStatus.BAD_REQUEST);
            return result;
        }
    }

    @Override
    public HashMap<ResponseTarjeta, HttpStatus> consultarTarjeta(RequestCardInfo requestCardInfo) throws Exception {
        ResponseTarjeta response = new ResponseTarjeta();
        HashMap<ResponseTarjeta, HttpStatus> result = new HashMap<>();
        try {
            Tarjeta exiteTarjeta = tarjetaRepository.findByPAN(requestCardInfo.getPan());
            if (exiteTarjeta == null){
                response.setCodigo(Constants.ERROR01_CODE);
                response.setMessage(Constants.ERROR01_MESSAGE_TARJETA_NO_EXISTE);
                result.put(response, HttpStatus.OK);
                return result;
            }

            response.setPanEnmascarado(EnmascararNumeroTarjeta.enmascarar(exiteTarjeta.getPAN()));
            response.setCedula(exiteTarjeta.getCedula());
            response.setTitular(exiteTarjeta.getTitular());
            response.setTelefono(exiteTarjeta.getTelefono());
            response.setEstado(exiteTarjeta.getEstado());

            result.put(response, HttpStatus.OK);
            return result;
        }catch (Exception e){
            e.printStackTrace();
            response.setCodigo(Constants.ERROR01_CODE);
            response.setMessage(Constants.ERROR01_MESSAGE);
            result.put(response, HttpStatus.BAD_REQUEST);
            return result;
        }
    }

    @Override
    public HashMap<ResponseTarjeta, HttpStatus> eliminarTarjeta(RequestCardInfo requestCardInfo) throws Exception {
        ResponseTarjeta response = new ResponseTarjeta();
        HashMap<ResponseTarjeta, HttpStatus> result = new HashMap<>();
        try {
            Tarjeta exiteTarjeta = tarjetaRepository.findByPAN(requestCardInfo.getPan());
            if (exiteTarjeta == null){
                response.setCodigo(Constants.ERROR01_CODE);
                response.setMessage(Constants.ERROR01_MESSAGE_TARJETA_NO_EXISTE);
                result.put(response, HttpStatus.OK);
                return result;
            }

            tarjetaRepository.deleteByPANANDNumeroValidacion(requestCardInfo.getPan(), requestCardInfo.getNumeroValidacion());

            response.setCodigo(Constants.ERROR00_CODE);
            response.setMessage(Constants.ERROR00_MESSAGE_ELIMINADO_EXITOSO);
            result.put(response, HttpStatus.OK);
            return result;
        }catch (Exception e){
            e.printStackTrace();
            response.setCodigo(Constants.ERROR01_CODE);
            response.setMessage(Constants.ERROR01_MESSAGE_ELIMINADO_FALLIDO);
            result.put(response, HttpStatus.BAD_REQUEST);
            return result;
        }
    }

    @Override
    public HashMap<ResponseTarjeta, HttpStatus> crearTransacción(RequestUsuarioInfo requestUsuarioInfo) throws Exception {
        ResponseTarjeta response = new ResponseTarjeta();
        HashMap<ResponseTarjeta, HttpStatus> result = new HashMap<>();
        try {
            Tarjeta exiteTarjeta = tarjetaRepository.findByPAN(requestUsuarioInfo.getPan());
            if (exiteTarjeta == null){
                response.setCodigo(Constants.ERROR01_CODE);
                response.setMessage(Constants.ERROR01_MESSAGE_TARJETA_NO_EXISTE);
                response.setEstado(Constants.MESSAGE_RECHAZADA);
                response.setNumeroReferencia(requestUsuarioInfo.getNumeroReferecia());
                result.put(response, HttpStatus.OK);
                return result;
            }

            if (!exiteTarjeta.getEstado().equals("E")){
                response.setCodigo(Constants.ERROR02_CODE);
                response.setMessage(Constants.ERROR02_MESSAGE_TARJETA_NO_ENROLADA);
                response.setEstado(Constants.MESSAGE_RECHAZADA);
                response.setNumeroReferencia(requestUsuarioInfo.getNumeroReferecia());
                result.put(response, HttpStatus.OK);
                return result;
            }

            Transaccion transaccion = new Transaccion();
            transaccion.setPAN(requestUsuarioInfo.getPan());
            transaccion.setDireccionCompra(requestUsuarioInfo.getDireccionCompra());
            transaccion.setTotalCompra(requestUsuarioInfo.getTotalCompra());
            transaccion.setNumeroReferecia(requestUsuarioInfo.getNumeroReferecia());
            transaccion.setFecha(new Date());
            transaccion.setEstado(Constants.MESSAGE_APROBADO);

            transaccionRepository.save(transaccion);

            response.setCodigo(Constants.ERROR00_CODE);
            response.setMessage(Constants.ERROR01_MESSAGE_COMPRA_EXITOSA);
            response.setEstado(Constants.MESSAGE_APROBADO);
            response.setNumeroReferencia(requestUsuarioInfo.getNumeroReferecia());
            result.put(response, HttpStatus.OK);
            return result;
        }catch (Exception e){
            e.printStackTrace();
            response.setCodigo(Constants.ERROR01_CODE);
            response.setMessage(Constants.ERROR01_MESSAGE);
            result.put(response, HttpStatus.BAD_REQUEST);
            return result;
        }
    }

    @Override
    public HashMap<ResponseTarjeta, HttpStatus> anularTransacción(RequestUsuarioInfo requestUsuarioInfo) throws Exception {
        ResponseTarjeta response = new ResponseTarjeta();
        HashMap<ResponseTarjeta, HttpStatus> result = new HashMap<>();
        try {
            Transaccion transaccion
                    = transaccionRepository.findByPanAndNumeroReferenciaAndTotalCompra(requestUsuarioInfo.getPan(), requestUsuarioInfo.getNumeroReferecia(), requestUsuarioInfo.getTotalCompra());
            if (Objects.equals(transaccion, null)){
                response.setCodigo(Constants.ERROR03_CODE);
                response.setMessage(Constants.ERROR03_MESSAGE_TRANSACCION_NO_EXISTE);
                response.setEstado(Constants.MESSAGE_APROBADO);
                response.setNumeroReferencia(requestUsuarioInfo.getNumeroReferecia());
                result.put(response, HttpStatus.OK);
                return result;
            }

            if (!Objects.equals(transaccion.getNumeroReferecia(), requestUsuarioInfo.getNumeroReferecia())){
                response.setCodigo(Constants.ERROR01_CODE);
                response.setMessage(Constants.ERROR01_MESSAGE_NUMERO_DE_REFERENCIA_INVALIDO);
                response.setEstado(Constants.MESSAGE_APROBADO);
                response.setNumeroReferencia(requestUsuarioInfo.getNumeroReferecia());
                result.put(response, HttpStatus.OK);
                return result;
            }

            if (TiempoTranscurrido.minutoTranscurridos(transaccion.getFecha()) > 5L) {
                response.setCodigo(Constants.ERROR02_CODE);
                response.setMessage(Constants.ERROR02_MESSAGE_NO_SE_PUEDE_ANULAR_TRANSACCION);
                result.put(response, HttpStatus.OK);
                return result;
            }

            transaccion.setEstado(Constants.MESSAGE_ANULADA);

            transaccionRepository.save(transaccion);

            response.setCodigo(Constants.ERROR00_CODE);
            response.setMessage(Constants.ERROR00_MESSAGE_COMPRA_ANULADA);
            response.setNumeroReferencia(requestUsuarioInfo.getNumeroReferecia());
            result.put(response, HttpStatus.OK);
            return result;
        }catch (Exception e){
            e.printStackTrace();
            response.setCodigo(Constants.ERROR02_CODE);
            response.setMessage(Constants.ERROR02_MESSAGE_NO_SE_PUEDE_ANULAR_TRANSACCION);
            result.put(response, HttpStatus.BAD_REQUEST);
            return result;
        }
    }


}
