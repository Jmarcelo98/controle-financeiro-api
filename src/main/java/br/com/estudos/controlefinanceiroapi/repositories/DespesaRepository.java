package br.com.estudos.controlefinanceiroapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estudos.controlefinanceiroapi.model.entity.Despesa;
import br.com.estudos.controlefinanceiroapi.model.entity.Usuario;

public interface DespesaRepository extends JpaRepository<Despesa, Integer> {

	List<Despesa> findAllByUsuario(Usuario usuario);

}
