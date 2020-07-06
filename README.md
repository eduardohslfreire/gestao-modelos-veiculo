# Gestão de Modelos de Veículo
Desafio 1 - Gestão de Modelos de Veiculo

## Sobre o Projeto

> O projeto trata-se de uma aplicação bem simples que realiza o cadastro de Modelos de Veículo. Para a criação deste projeto foram utilizados as seguintes tecnologias:
- Spring Boot, uma estrutura leve que simplifica a configuração de aplicações baseadas em Spring, que já possui um servidor de aplicações embarcado, nesse caso, o tomcat;
- Spring MVC, um framework para criação de aplicações web e serviços RESTful;
- Spring Data JPA, framework para facilitar a criação de repositórios. O mesmo possui algumas APIs já implementadas, as quais facilitam o processo de persistência de dados;
- Thymeleaf, uma Engine de templates de páginas html;
- H2, um tipo de Banco de Dados em memória, que não precisa de instalação, apenas adicionar sua depedência no Projeto;
- Spring Tool Suite (STS), uma IDE baseada no Eclipse que vem com o Spring Initializr, uma ferramenta muito útil para criar projetos com Spring;
- Bootstrap, um framework que auxilia no desenvolvimento de interfaces WEB;
- DevTool, ferramenta para hotDeploy automático durante o desenvolvimento, entre outras utilidades;

> Todas essas dependências encontram-se no `pom.xml` desta aplicação:

---

## Configuração

> Clonar aplicar para máquina local:

```shell
$ git clone https://github.com/eduardohslfreire/gestao-modelos-veiculo.git
```
> Acessar o diretório da aplicação:

```shell
$ cd gestao-modelos-veiculo/
```

> Realizar o Build da Aplicação através do seguinte comando:

```shell
$ ./mvnw package
```

> O comando anterior irá gerar um arquivo com extensão JAR na pasta `target`. Com o <a href="https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html">JDK8</a> ou superior instalado na sua máquina, inicie a aplicação com o seguinte comando:

```shell
$ java -jar target/gestao-modelos-veiculo-0.0.1-SNAPSHOT.jar
```

> Após a subida da aplicação, utilizando um nagevador WEB, acesse a seguinte URL: `http://localhost:8080/veiculo/modelos` 

> Pronto! Aplicação configurada!
