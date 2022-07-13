package br.com.estudos.controlefinanceiroapi.model.dtos;

import java.time.LocalDate;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DespesaDTO {

	private Integer id;

	private String descricao;

	private Double valor;

	private LocalDate dtRecebimento;

	private Boolean isEfetuado;

	private UsuarioDTO usuario;

	private TipoDespesaDTO tipoDespesa;

}
