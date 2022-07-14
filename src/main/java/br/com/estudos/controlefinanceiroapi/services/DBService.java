package br.com.estudos.controlefinanceiroapi.services;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import br.com.estudos.controlefinanceiroapi.model.entity.Despesa;
import br.com.estudos.controlefinanceiroapi.model.entity.Receita;
import br.com.estudos.controlefinanceiroapi.model.entity.TipoDespesa;
import br.com.estudos.controlefinanceiroapi.model.entity.TipoReceita;
import br.com.estudos.controlefinanceiroapi.model.entity.Usuario;
import br.com.estudos.controlefinanceiroapi.repositories.DespesaRepository;
import br.com.estudos.controlefinanceiroapi.repositories.ReceitaRepository;
import br.com.estudos.controlefinanceiroapi.repositories.TipoDespesaRepository;
import br.com.estudos.controlefinanceiroapi.repositories.TipoReceitaRepository;
import br.com.estudos.controlefinanceiroapi.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DBService {

	private final UsuarioRepository usuarioRepository;

	private final TipoReceitaRepository tipoReceitaRepository;

	private final TipoDespesaRepository tipoDespesaRepository;

	private final ReceitaRepository receitaRepository;

	private final DespesaRepository despesaRepository;

	public void instanciarBandoDeDados() {

		LocalDate date1 = LocalDate.of(1998, Month.NOVEMBER, 16);

		var usuario1 = Usuario.builder().id(null).foto(null).nomeCompleto("JOÃO MARCELO DE JESUS MACEDO").cpf("05455329146")
				.dtNascimento(date1).build();

		LocalDate date2 = LocalDate.of(1999, Month.SEPTEMBER, 26);

		var usuario2 = Usuario.builder().id(null).foto(null).nomeCompleto("MARCOS GIOVANNY 22CM").cpf("01234567890")
				.dtNascimento(date2).build();

		usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2));

		var tipoReceita1 = TipoReceita.builder().id(null).descricao("SALÁRIO").usuario(usuario1).build();
		var tipoReceita2 = TipoReceita.builder().id(null).descricao("DEVEDORES").usuario(usuario1).build();
		var tipoReceita3 = TipoReceita.builder().id(null).descricao("INVESTIMENTOS").usuario(usuario1).build();

		var tipoReceita4 = TipoReceita.builder().id(null).descricao("SALÁRIO").usuario(usuario2).build();
		var tipoReceita5 = TipoReceita.builder().id(null).descricao("VENDA ALIMENTAÇÃO").usuario(usuario2).build();

		tipoReceitaRepository
				.saveAll(Arrays.asList(tipoReceita1, tipoReceita2, tipoReceita3, tipoReceita4, tipoReceita5));

		LocalDate date3 = LocalDate.of(2022, Month.JULY, 1);
		LocalDate date4 = LocalDate.of(2022, Month.JULY, 4);
		LocalDate date5 = LocalDate.of(2022, Month.APRIL, 16);

		var receita1 = Receita.builder().id(null).descricao("SALÁRIO MENSAL").dtRecebimento(date3).isEfetuado(true)
				.valor(6042.45).tipoReceita(tipoReceita1).usuario(tipoReceita1.getUsuario()).build();
		var receita2 = Receita.builder().id(null).descricao("RECEBIDO DA TAUANY").dtRecebimento(date4).isEfetuado(true)
				.valor(400.00).tipoReceita(tipoReceita2).usuario(tipoReceita2.getUsuario()).build();
		var receita3 = Receita.builder().id(null).descricao("ETHERUM VENDIDO").dtRecebimento(date5).isEfetuado(true)
				.valor(2012.00).tipoReceita(tipoReceita3).usuario(tipoReceita3.getUsuario()).build();

		LocalDate date6 = LocalDate.of(2022, Month.MARCH, 15);
		LocalDate date7 = LocalDate.of(2022, Month.MAY, 29);

		var receita4 = Receita.builder().id(null).descricao("SALÁRIO MENSAL - PRIMEIRA PARCELA").dtRecebimento(date6)
				.isEfetuado(true).valor(3175.49).tipoReceita(tipoReceita4).usuario(tipoReceita4.getUsuario()).build();

		var receita5 = Receita.builder().id(null).descricao("ALIMENTAÇÃO VENDIDO").dtRecebimento(date7).isEfetuado(true)
				.valor(891.45).tipoReceita(tipoReceita5).usuario(tipoReceita5.getUsuario()).build();

		receitaRepository.saveAll(Arrays.asList(receita1, receita2, receita3, receita4, receita5));

		var tipoDespesa1 = TipoDespesa.builder().id(null).descricao("SUZI").usuario(usuario1).build();
		var tipoDespesa2 = TipoDespesa.builder().id(null).descricao("CLARO MÓVEL").usuario(usuario1).build();
		var tipoDespesa3 = TipoDespesa.builder().id(null).descricao("INTERNET FIBRA OI").usuario(usuario1).build();

		var tipoDespesa4 = TipoDespesa.builder().id(null).descricao("LAZER").usuario(usuario2).build();
		var tipoDespesa5 = TipoDespesa.builder().id(null).descricao("TRANSPORTE").usuario(usuario2).build();

		tipoDespesaRepository
				.saveAll(Arrays.asList(tipoDespesa1, tipoDespesa2, tipoDespesa3, tipoDespesa4, tipoDespesa5));

		LocalDate date8 = LocalDate.of(2022, Month.JULY, 2);
		LocalDate date9 = LocalDate.of(2022, Month.JULY, 15);
		LocalDate date10 = LocalDate.of(2022, Month.JULY, 20);

		var despesa1 = Despesa.builder().id(null).descricao("VACINA LEISHMANIOSE").dtRecebimento(date8).isEfetuado(true)
				.valor(190.0).tipoDespesa(tipoDespesa1).usuario(tipoDespesa1.getUsuario()).build();

		var despesa2 = Despesa.builder().id(null).descricao("PLANO CLARO").dtRecebimento(date9).isEfetuado(true)
				.valor(59.00).tipoDespesa(tipoDespesa2).usuario(tipoDespesa2.getUsuario()).build();

		var despesa3 = Despesa.builder().id(null).descricao("PLANO DE INTERNET").dtRecebimento(date10).isEfetuado(true)
				.valor(120.00).tipoDespesa(tipoDespesa3).usuario(tipoDespesa3.getUsuario()).build();

		LocalDate date11 = LocalDate.of(2022, Month.JULY, 7);
		LocalDate date12 = LocalDate.of(2022, Month.MAY, 17);

		var despesa4 = Despesa.builder().id(null).descricao("CIMEMA").dtRecebimento(date11).isEfetuado(true)
				.valor(70.50).tipoDespesa(tipoDespesa4).usuario(tipoDespesa4.getUsuario()).build();
		
		var despesa5 = Despesa.builder().id(null).descricao("BANHO").dtRecebimento(date8).isEfetuado(true)
				.valor(90.0).tipoDespesa(tipoDespesa1).usuario(tipoDespesa1.getUsuario()).build();

		var despesa6 = Despesa.builder().id(null).descricao("UBER PARA ASA NORTE").dtRecebimento(date12)
				.isEfetuado(true).valor(120.39).tipoDespesa(tipoDespesa5).usuario(tipoDespesa5.getUsuario()).build();
		
		

		despesaRepository.saveAll(Arrays.asList(despesa1, despesa2, despesa3, despesa4, despesa5, despesa6));

	}
}
