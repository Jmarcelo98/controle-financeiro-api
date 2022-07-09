package br.com.estudos.controlefinanceiroapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estudos.controlefinanceiroapi.model.entity.TipoReceita;
import br.com.estudos.controlefinanceiroapi.model.entity.Usuario;

public interface TipoReceitaRepository extends JpaRepository<TipoReceita, Integer> {
	
	Boolean existsByDescricaoAndUsuario(String descricao, Usuario usuario);
 
}
