package com.credibanco.assessment.card.api.client;

import com.credibanco.assessment.card.model.RequestCardInfo;
import com.credibanco.assessment.card.model.RequestUsuarioInfo;
import com.credibanco.assessment.card.model.ResponseTarjeta;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RequestMapping("/tarjeta")
public interface TarjetaStatusApi {

    @PostMapping("/crearTarjeta")
    ResponseEntity<ResponseTarjeta> crearTarjeta(@RequestBody RequestCardInfo requestCardInfo);

    @PutMapping("/enrolarTarjeta")
    ResponseEntity<ResponseTarjeta> enrolarTarjeta(@RequestBody RequestCardInfo requestCardInfo);

    @GetMapping("/consultarTarjeta")
    ResponseEntity<ResponseTarjeta> consultarTarjeta(@RequestBody RequestCardInfo requestCardInfo);

    @DeleteMapping("/eliminarTarjeta")
    ResponseEntity<ResponseTarjeta> eliminarTarjeta(@RequestBody RequestCardInfo requestCardInfo);

    @PostMapping("/crearTransacción")
    ResponseEntity<ResponseTarjeta> crearTransacción(@RequestBody RequestUsuarioInfo requestUsuarioInfo);

    @PutMapping("/anularTransacción")
    ResponseEntity<ResponseTarjeta> anularTransacción(@RequestBody RequestUsuarioInfo requestUsuarioInfo);
}
