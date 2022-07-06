package br.com.estudos.controlefinanceiroapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estudos.controlefinanceiroapi.model.entity.TipoReceita;

public interface TipoReceitaRepository extends JpaRepository<TipoReceita, Integer> {
 
}
