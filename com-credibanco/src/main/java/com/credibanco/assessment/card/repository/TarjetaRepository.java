package com.credibanco.assessment.card.repository;

import com.credibanco.assessment.card.dto.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TarjetaRepository extends JpaRepository<Tarjeta, Long> {
    @Query(value = "SELECT * FROM tarjeta_entity WHERE PAN = :PAN AND  numero_validacion = :numeroValidacion", nativeQuery = true)
    Tarjeta findByPANANDNumeroValidacion(@Param("PAN") String PAN,@Param("numeroValidacion") Integer numeroValidacion);

    @Query(value = "SELECT * FROM tarjeta_entity WHERE PAN = :PAN",  nativeQuery = true)
    Tarjeta findByPAN(@Param(("PAN")) String PAN);

    @Modifying
    @Query(value = "DELETE FROM tarjeta_entity WHERE PAN = :PAN AND NUMERO_VALIDACION = :numeroValidacion",  nativeQuery = true)
    Integer deleteByPANANDNumeroValidacion(@Param("PAN") String PAN,@Param("numeroValidacion") Integer numeroValidacion);
}
