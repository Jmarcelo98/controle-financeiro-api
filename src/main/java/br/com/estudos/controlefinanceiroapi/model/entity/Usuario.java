package br.com.estudos.controlefinanceiroapi.model.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomeCompleto;
	private String cpf;
	private LocalDate dtNascimento;

	@JsonIgnore
	@OneToMany(mappedBy = "usuario")
	private List<TipoReceita> tipoReceitas;

	@JsonIgnore
	@OneToMany(mappedBy = "usuario")
	private List<TipoDespesa> tipoDespesas;

	@JsonIgnore
	@OneToMany(mappedBy = "usuario")
	private List<Receita> receitas;

	@JsonIgnore
	@OneToMany(mappedBy = "usuario")
	private List<Despesa> despesas;

}
