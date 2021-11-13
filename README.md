Versões:
Versão Postgres - 14
Versão JAVA - 8

---------------------
Para rodar o projeto:
Caso dê erro na lib(driver) do postgres -> Botão direito no projeto aberto no eclipse -> Properties -> Libraries -> Classpath -> Add External JARs...
Adicionar JAR que está no projeto.


CREATE TABLE LIVRARIA(
	codigo_livraria SERIAL PRIMARY KEY,
	nome VARCHAR(100) NOT NULL,
	endereco VARCHAR(100) NOT NULL,
	cnpj VARCHAR(14) UNIQUE NOT NULL 
);

