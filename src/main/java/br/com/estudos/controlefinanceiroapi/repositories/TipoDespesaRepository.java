package br.com.estudos.controlefinanceiroapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estudos.controlefinanceiroapi.model.entity.TipoDespesa;
import br.com.estudos.controlefinanceiroapi.model.entity.Usuario;

public interface TipoDespesaRepository extends JpaRepository<TipoDespesa, Integer> {
	
	Boolean existsByDescricaoAndUsuario(String descricao, Usuario usuario);

}
