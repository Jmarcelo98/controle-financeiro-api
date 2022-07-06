package br.com.estudos.controlefinanceiroapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estudos.controlefinanceiroapi.model.entity.Receita;


public interface ReceitaRepository extends JpaRepository<Receita, Integer> {

}
