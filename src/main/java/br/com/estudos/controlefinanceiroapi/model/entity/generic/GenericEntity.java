package br.com.estudos.controlefinanceiroapi.model.entity.generic;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class GenericEntity {

	@Column(nullable = false)
	private LocalDate dtRecebimento;

	@Column(nullable = false)
	protected Boolean isEfetuado;

}
