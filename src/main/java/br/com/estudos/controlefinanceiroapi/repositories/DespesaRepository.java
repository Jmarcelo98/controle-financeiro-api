package br.com.estudos.controlefinanceiroapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estudos.controlefinanceiroapi.model.entity.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa, Integer> {

}
