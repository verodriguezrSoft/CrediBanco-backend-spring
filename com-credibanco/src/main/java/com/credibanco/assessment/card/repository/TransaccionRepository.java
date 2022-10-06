package com.credibanco.assessment.card.repository;

import com.credibanco.assessment.card.dto.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {
    @Query(value = "SELECT * FROM transaccion WHERE PAN = :PAN AND numero_referencia = :numeroReferencia AND total_compra = :totalCompra", nativeQuery = true)
    Transaccion findByPanAndNumeroReferenciaAndTotalCompra(@Param("PAN") String pan, @Param("numeroReferencia") String numeroReferencia, @Param("totalCompra") BigDecimal totalCompra);
}
