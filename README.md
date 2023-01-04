# api-config-externalizada-spring-boot
Trabalhando com ambientes diferentes através do arquivo .properties


1º Para este exemplo foi adicionada apenas duas dependências
Para subir a aplicação web
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
</dependency>

Para atualizar de forma automática
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-devtools</artifactId>
	<scope>runtime</scope>
	<optional>true</optional>
</dependency>

2º Na classe principal da aplicação foi adicionada a annotation @RestController
para chamar as funcões para teste

3º criada uma variável que vai receber o nome da aplicação do aquivo application.properties 
para exibir no navegador a título de teste
@Value("${application.name}")
private String applicationName;

4º Criada a função para retornar no browser o nome da aplicação conforme configurado em seu 
respectivo application.properties 
@GetMapping("/ola-mundo")
public String olaMundo() {
	return applicationName;
}

5º No application.properties foram adicionadas duas propriedades

Nesta propriedade informo ao spring qual arquivo .properties ele deve ser acatada as configurações
spring.profiles.active=production

Nesta propriedade informo ao spring o contexto do caminho para abrir no navegador
server.servlet.context-path=/exemplo-properties

6º Crio o arquivo application-development.properties
com a propriedade : application.name=Ambiente de Desenvolvimento
apenas a título de identificação, mas posso utilizar para configurações de ambiente de desenvolvimento, 
como string de conexão ao banco de dados ou configurações de portas por exemplo

7º Crio o arquivo application-production.properties
com a finalidade de fazer as configurações do ambiente de produção

Similar ao que fiz com os arquivos .properties posso fazer também com classes de configuração

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


/*
 * @Profile("production") foi usado neste contexto para executar
 * configurações em ambiente de produção
 */

@Configuration
@Profile("production")
public class MinhaConfiguracaoProducao {

	/*
	 * O CommandLineRunner É EXECUTADO ASSIM QUE A APLICAÇÃO SOBE
	 * O Spring PROCURA PELAS @Configuration, @Bean E CommandLineRunner
	 */
	
	@Bean
	public CommandLineRunner executar() {
		return args -> {
			System.out.println("CONFIGURAÇÕES DE PRODUÇÃO");
		};
	}
}

link para fazer o teste local: http://localhost:8080/exemplo-properties/ola-mundo
