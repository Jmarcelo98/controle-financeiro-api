package br.com.estudos.controlefinanceiroapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estudos.controlefinanceiroapi.model.entity.TipoDespesa;
import br.com.estudos.controlefinanceiroapi.model.entity.Usuario;

public interface TipoDespesaRepository extends JpaRepository<TipoDespesa, Integer> {

	Boolean existsByDescricaoIgnoreCaseAndUsuario(String descricao, Usuario usuario);

	List<TipoDespesa> findAllByUsuario(Usuario usuario);

}
