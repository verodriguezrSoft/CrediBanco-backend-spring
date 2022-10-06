package com.credibanco.assessment.card.controller;

import com.credibanco.assessment.card.api.client.TarjetaStatusApi;
import com.credibanco.assessment.card.model.RequestCardInfo;
import com.credibanco.assessment.card.model.RequestUsuarioInfo;
import com.credibanco.assessment.card.model.ResponseTarjeta;
import com.credibanco.assessment.card.services.ICrediBancoServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class TarjetaController implements TarjetaStatusApi {

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private ICrediBancoServiceImpl iCrediBancoService;

    @Autowired
    public TarjetaController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public ResponseEntity<ResponseTarjeta> crearTarjeta(RequestCardInfo requestCardInfo) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                HashMap<ResponseTarjeta, HttpStatus> respuesta = iCrediBancoService.crearTarjeta(requestCardInfo);
                if (respuesta != null) {
                    for (Map.Entry<ResponseTarjeta, HttpStatus> entry : respuesta.entrySet()) {
                        return new ResponseEntity<ResponseTarjeta>(entry.getKey(), entry.getValue());
                    }
                }
            } catch (IOException e) {
                return new ResponseEntity<ResponseTarjeta>(HttpStatus.INTERNAL_SERVER_ERROR);
            } catch (Exception ex) {
                return new ResponseEntity<ResponseTarjeta>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<ResponseTarjeta>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<ResponseTarjeta> enrolarTarjeta(RequestCardInfo requestCardInfo) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                HashMap<ResponseTarjeta, HttpStatus> respuesta = iCrediBancoService.enrolarTarjeta(requestCardInfo);
                if (respuesta != null) {
                    for (Map.Entry<ResponseTarjeta, HttpStatus> entry : respuesta.entrySet()) {
                        return new ResponseEntity<ResponseTarjeta>(entry.getKey(), entry.getValue());
                    }
                }
            } catch (IOException e) {
                return new ResponseEntity<ResponseTarjeta>(HttpStatus.INTERNAL_SERVER_ERROR);
            } catch (Exception ex) {
                return new ResponseEntity<ResponseTarjeta>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<ResponseTarjeta>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<ResponseTarjeta> consultarTarjeta(RequestCardInfo requestCardInfo) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                HashMap<ResponseTarjeta, HttpStatus> respuesta = iCrediBancoService.consultarTarjeta(requestCardInfo);
                if (respuesta != null) {
                    for (Map.Entry<ResponseTarjeta, HttpStatus> entry : respuesta.entrySet()) {
                        return new ResponseEntity<ResponseTarjeta>(entry.getKey(), entry.getValue());
                    }
                }
            } catch (IOException e) {
                return new ResponseEntity<ResponseTarjeta>(HttpStatus.INTERNAL_SERVER_ERROR);
            } catch (Exception ex) {
                return new ResponseEntity<ResponseTarjeta>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<ResponseTarjeta>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<ResponseTarjeta> eliminarTarjeta(RequestCardInfo requestCardInfo) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                HashMap<ResponseTarjeta, HttpStatus> respuesta = iCrediBancoService.eliminarTarjeta(requestCardInfo);
                if (respuesta != null) {
                    for (Map.Entry<ResponseTarjeta, HttpStatus> entry : respuesta.entrySet()) {
                        return new ResponseEntity<ResponseTarjeta>(entry.getKey(), entry.getValue());
                    }
                }
            } catch (IOException e) {
                return new ResponseEntity<ResponseTarjeta>(HttpStatus.INTERNAL_SERVER_ERROR);
            } catch (Exception ex) {
                return new ResponseEntity<ResponseTarjeta>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<ResponseTarjeta>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<ResponseTarjeta> crearTransacción(RequestUsuarioInfo requestUsuarioInfo) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                HashMap<ResponseTarjeta, HttpStatus> respuesta = iCrediBancoService.crearTransacción(requestUsuarioInfo);
                if (respuesta != null) {
                    for (Map.Entry<ResponseTarjeta, HttpStatus> entry : respuesta.entrySet()) {
                        return new ResponseEntity<ResponseTarjeta>(entry.getKey(), entry.getValue());
                    }
                }
            } catch (IOException e) {
                return new ResponseEntity<ResponseTarjeta>(HttpStatus.INTERNAL_SERVER_ERROR);
            } catch (Exception ex) {
                return new ResponseEntity<ResponseTarjeta>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<ResponseTarjeta>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<ResponseTarjeta> anularTransacción(RequestUsuarioInfo requestUsuarioInfo) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                HashMap<ResponseTarjeta, HttpStatus> respuesta = iCrediBancoService.anularTransacción(requestUsuarioInfo);
                if (respuesta != null) {
                    for (Map.Entry<ResponseTarjeta, HttpStatus> entry : respuesta.entrySet()) {
                        return new ResponseEntity<ResponseTarjeta>(entry.getKey(), entry.getValue());
                    }
                }
            } catch (IOException e) {
                return new ResponseEntity<ResponseTarjeta>(HttpStatus.INTERNAL_SERVER_ERROR);
            } catch (Exception ex) {
                return new ResponseEntity<ResponseTarjeta>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<ResponseTarjeta>(HttpStatus.NOT_IMPLEMENTED);
    }
}
