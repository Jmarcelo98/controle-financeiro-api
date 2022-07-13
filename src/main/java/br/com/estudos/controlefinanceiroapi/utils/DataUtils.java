package br.com.estudos.controlefinanceiroapi.utils;

import java.time.LocalDate;

public class DataUtils {

	public static Boolean dataMenorQueDataAtual(LocalDate data) {

		if (data.isBefore(LocalDate.now()) || data.isEqual(LocalDate.now())) {
			return true;
		}

		return false;

	}

}
