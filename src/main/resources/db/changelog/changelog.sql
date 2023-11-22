-- liquibase formatted sql
create table livros
(
    id int primary key auto_increment,
    titulo varchar,
    categoria varchar,
    anopublicacao int,
    autor varchar,
    codigoisbn LONG
);

create table bibliotecas
(
    id int primary key auto_increment,
    nome varchar
);

insert into bibliotecas (nome) values ('Biblioteca UNISC');
INSERT INTO livros (titulo, categoria, anopublicacao, autor, codigoisbn) VALUES('Livro Tal', 'Aventura', 2018, 'Wagner', 8485799);

CREATE TABLE livro_biblioteca (
    id INT AUTO_INCREMENT PRIMARY KEY not null,
    livro_FK INT,
    biblioteca_FK INT,
    FOREIGN KEY (livro_fk) REFERENCES livros(id),
    FOREIGN KEY (biblioteca_FK) REFERENCES bibliotecas(id)
);

INSERT INTO livro_biblioteca (livro_FK, biblioteca_FK) VALUES(1,1);