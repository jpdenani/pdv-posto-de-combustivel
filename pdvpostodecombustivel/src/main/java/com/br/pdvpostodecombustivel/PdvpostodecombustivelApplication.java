package com.br.pdvpostodecombustivel;

import com.br.pdvpostodecombustivel.api.domain.entity.Pessoa;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PdvpostodecombustivelApplication {

	public static void main(String[] args) {
        //SpringApplication.run(PdvpostodecombustivelApplication.class, args);
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNomeCompleto("João");
        pessoa1.setCpfCnpj("111111111111");
        pessoa1.setNumeroCtps(1111L);
        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNomeCompleto("Maria");
        pessoa2.setCpfCnpj("22222222222");
        pessoa2.setNumeroCtps(2222L);
        Pessoa pessoa3 = new Pessoa();
        pessoa3.setNomeCompleto("José");
        pessoa3.setCpfCnpj("33333333333");
        pessoa3.setNumeroCtps(3333L);

        System.out.println("Nome completo: " + pessoa1.getNomeCompleto());
        System.out.println("CPF/CNPJ: " + pessoa1.getCpfCnpj());
        System.out.println("Número CTPs: " + pessoa1.getNumeroCtps());
        System.out.println("----------------------------------------------");
        System.out.println("Nome completo: " + pessoa2.getNomeCompleto());
        System.out.println("CPF/CNPJ: " + pessoa2.getCpfCnpj());
        System.out.println("Número CTPs: " + pessoa2.getNumeroCtps());
        System.out.println("-----------------------------------------------");
        System.out.println("Nome completo: " + pessoa3.getNomeCompleto());
        System.out.println("CPF/CNPJ: " + pessoa3.getCpfCnpj());
        System.out.println("Número CTPs: " + pessoa3.getNumeroCtps());
	}


}
