package br.com.estudos.controlefinanceiroapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estudos.controlefinanceiroapi.model.entity.Receita;
import br.com.estudos.controlefinanceiroapi.model.entity.Usuario;


public interface ReceitaRepository extends JpaRepository<Receita, Integer> {
	
	List<Receita> findAllByUsuario(Usuario usuario);

}