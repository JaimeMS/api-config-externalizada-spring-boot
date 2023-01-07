![GitHub repo size](https://img.shields.io/github/repo-size/JaimeDevS/api-crud-springboot?style=plastic)
![GitHub top language](https://img.shields.io/github/languages/top/JaimeDevS/api-crud-springboot?style=plastic)

# Configurações de diferentes ambientes no aquivo .properties

Trabalhando com ambientes diferentes através do arquivo .properties

![spring](https://github.com/JaimeDevS/spring-boot-docker/blob/master/spring.png) 

## Pré-requisitos

* [Spring Web](https://mvnrepository.com/artifact/org.springframework/spring-web "Spring Web]")  - framework que permite a visualização de dados geográficos armazenados em um servidor remoto.
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/1.5.16.RELEASE/reference/html/using-boot-devtools.html "Docker hub")  - ferramenta para reiniciar automaticamente a aplicação durante o desenvolvimento.
* [JDK](https://www.oracle.com/br/java/technologies/downloads/#java17) - JDK necessário para executar a aplicação.
* [Spring Tools](https://spring.io/tools) - Ferramenta para o desenvolvimento.

## Começando
- Acesse o link para fazer o download da aplicação pré estruturada, nele já é possível baixar todas as dependências do projeto.
```
https://start.spring.io/
```

## 1º Passo: Para este exemplo foi adicionada apenas duas dependências
Para subir a aplicação web
```
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
```
## 2º Passo: Na classe principal da aplicação foi adicionada a annotation @RestController
para chamar as funcões para teste

## 3º Passo: criada uma variável que vai receber o nome da aplicação do aquivo application.properties 
para exibir no navegador a título de teste
```
@Value("${application.name}")
private String applicationName;
```
## 4º Passo: Criada a função para retornar no browser o nome da aplicação 
conforme configurado em seu respectivo application.properties 
```
@GetMapping("/ola-mundo")
public String olaMundo() {
	return applicationName;
}
```
## 5º Passo: No application.properties foram adicionadas duas propriedades

Nesta propriedade informo ao spring qual arquivo .properties ele deve ser acatada as configurações
spring.profiles.active=production

Nesta propriedade informo ao spring o contexto do caminho para abrir no navegador
server.servlet.context-path=/exemplo-properties

## 6º Passo: Crio o arquivo application-development.properties

Com a propriedade : application.name=Ambiente de Desenvolvimento
apenas a título de identificação, mas posso utilizar para configurações de ambiente de desenvolvimento, 
como string de conexão ao banco de dados ou configurações de portas por exemplo

## 7º Passo: Crio o arquivo application-production.properties

com a finalidade de fazer as configurações do ambiente de produção
Similar ao que fiz com os arquivos .properties posso fazer também com classes de configuração
```
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
```
```
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
```

link para fazer o teste local: http://localhost:8080/exemplo-properties/ola-mundo
