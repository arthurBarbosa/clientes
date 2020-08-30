package br.com.abcode.clientes.util;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Responsável por converter uma String para um BigDecimal
 *
 * @author arthurbarbosa
 */
@Component
public class BidDecimalConverter {

    /**
     * Converte uma string para BigDecimal
     *
     * @param value
     * @return
     */
    public BigDecimal converter(String value) {
        if (value == null) {
            return null;
        }
        value = value.replace(".", "").replace(",", ".");
        return new BigDecimal(value);
    }
}
