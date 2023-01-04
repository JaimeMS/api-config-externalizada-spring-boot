package io.github.jaimems.multiambientes.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/*
 * @Profile("production") foi usado neste contexto para executar
 * configurações em ambiente de produção
 */

@Configuration
@Profile("development")
public class MinhaConfiguracaoDesenvolvimento {
	
	/*
	 * O CommandLineRunner É EXECUTADO ASSIM QUE A APLICAÇÃO SOBE
	 * O Spring PROCURA PELAS @Configuration, @Bean E CommandLineRunner
	 */
	
	@Bean
	public CommandLineRunner executar() {
		return args -> {
			System.out.println("CONFIGURAÇÕES DE DESENVOLVIMENTO");
		};
	}
}
