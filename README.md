Versões:
Versão Postgres - 14
Versão JAVA - 8

---------------------
Para rodar o projeto:
Caso dê erro na lib(driver) do postgres -> Botão direito no projeto aberto no eclipse -> Properties -> Libraries -> Classpath -> Add External JARs...
Adicionar JAR que está no projeto.


CREATE TABLE LIVRARIA( codigo_livraria SERIAL PRIMARY KEY, 
	nome VARCHAR(100) NOT NULL, 
	endereco VARCHAR(100) NOT NULL, 
	estoque NUMERIC , 
	cnpj VARCHAR(14) UNIQUE NOT NULL );

CREATE TABLE LIVRO(codigo_livro SERIAL PRIMARY KEY,
	nome VARCHAR(100) NOT NULL, 
	autor VARCHAR(50) NOT NULL, 
	editora VARCHAR(25) NOT NULL, 
	preco NUMERIC NOT NULL, 
	isbn VARCHAR UNIQUE NOT NULL, 
	codigo_livraria INTEGER NOT NULL,
	FOREIGN KEY (codigo_livraria) REFERENCES livraria(codigo_livraria));

CREATE TABLE VENDA (codigo_venda SERIAL PRIMARY KEY, 
	data_venda DATE NOT NULL,
	codigo_livro INTEGER NOT NULL,
	FOREIGN KEY(codigo_livro) REFERENCES LIVRO(codigo_livro));
