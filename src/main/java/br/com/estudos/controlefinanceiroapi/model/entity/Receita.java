package br.com.estudos.controlefinanceiroapi.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.estudos.controlefinanceiroapi.model.entity.generic.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Receita extends GenericEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String descricao;

	@Column(nullable = false)
	private Double valor;

	@ManyToOne
	@JoinColumn(name = "id_tipo_receita")
	private TipoReceita tipoReceita;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

}
