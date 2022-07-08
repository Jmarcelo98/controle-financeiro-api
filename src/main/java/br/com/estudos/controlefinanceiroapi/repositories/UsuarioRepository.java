package br.com.estudos.controlefinanceiroapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estudos.controlefinanceiroapi.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
