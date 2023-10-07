# *Gerência de livros e bibliotecas.*
### API Rest desenvolvida utilizando Java Spring Boot e H2 Database.

## *Payloads para teste:*
```bash
Livro:
GET - localhost:8080/livros
POST - localhost:8080/livros
{
    "titulo":"O Pequeno Príncipe",
    "categoria": "Infantil",
    "anopublicacao": 1943,
    "autor": "Antoine de Saint-Exupéry",
    "codigoisbn": 9780152023980
}
PUT - localhost:8080/livros/Id desejado
DELETE - localhost:8080/livros/Id desejado
```
```bash
Biblioteca:
GET - localhost:8080/bibliotecas
POST - localhost:8080/bibliotecas
{
    "nome": "Biblioteca Dom Alberto"
}
PUT - localhost:8080/bibliotecas/Id desejado
DELETE - localhost:8080/bibliotecas/Id desejado
```
```bash
Gerência da biblioteca:
Adicionar livro a biblioteca - POST - localhost:8080/bibliotecas/adicionarLivroNaBiblioteca
{
    "bibliotecaId":2,
    "livroId": 1
}
Remover livro da biblioteca - DELETE - localhost:8080/bibliotecas/Id desejado/livros/Id desejado
Listar livros da biblioteca - GET - localhost:8080/bibliotecas/listarLivrosDaBiblioteca/Id desejado
Encontrar em qual biblioteca tem um livro por titulo - GET - localhost:8080/bibliotecas/buscarLivroPorTitulo?titulo=titulo desejado
```
