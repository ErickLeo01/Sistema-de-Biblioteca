# 📚 Sistema de Biblioteca

Sistema de gerenciamento de biblioteca desenvolvido com Java e Spring Boot, permitindo o cadastro, consulta, atualização e exclusão de livros por meio de uma API REST.

O projeto também possui uma interface web desenvolvida em Angular, responsável por consumir a API do back-end.

## 🚀 Tecnologias utilizadas

### Back-end
- Java
- Spring Boot
- Spring Data JPA
- API REST
- PostgreSQL
- Maven

### Front-end
- Angular
- TypeScript
- HTML
- CSS

### Ferramentas
- Git
- GitHub
- IntelliJ IDEA
- DBeaver

## 📌 Funcionalidades

- ✅ Cadastrar livros
- ✅ Listar livros
- ✅ Consultar livros
- ✅ Atualizar livros
- ✅ Excluir livros
- ✅ Persistência dos dados no PostgreSQL
- ✅ Comunicação entre Angular e API REST

## 🏗️ Estrutura do projeto

O projeto está dividido em duas partes:

```text
sistema-biblioteca/
├── back/
│   └── sistema-biblioteca/
│       └── src/
│
└── front/
    └── sistema-biblioteca/
        └── src/

### Back-end 
Responsável pela criação da API REST, regras da aplicação e comunicação com o banco de dados PostgreSQL.
### Front-end
Interface desenvolvida em Angular para interação com o usuário e consumo dos endpoints disponibilizados pelo back-end.
### Banco de dados
O projeto utiliza PostgreSQL.
Crie um banco de dados chamado:
sistema-biblioteca
Depois, configure as informações de conexão no arquivo:
application.properties
Exemplo:
spring.application.name=sistema-biblioteca
spring.datasource.url=jdbc:postgresql://localhost:5432/sistema-biblioteca
spring.datasource.username=SEU_USERNAME_AQUI
spring.datasource.password=SUA_SENHA_AQUI
spring.jpa.hibernate.ddl-auto=update
⚠️ Não coloque sua senha real do PostgreSQL no GitHub.

⚙️ Como executar o projeto
1. Clone o repositório
git clone https://github.com/ErickLeo01/Sistema-de-Biblioteca.git
2. Acesse a pasta do projeto
cd Sistema-de-Biblioteca
3. Configure o banco de dados
Crie o banco PostgreSQL:
sistema-biblioteca
Configure seu usuário e senha no arquivo application.properties.
4. Execute o back-end
No Windows:
mvnw.cmd spring-boot:run
Ou, caso o Maven esteja instalado:
mvn spring-boot:run
5. Execute o front-end
Acesse a pasta do Angular:
cd front/sistema-biblioteca
Instale as dependências:
npm install
Execute o projeto:
ng serve
Depois, acesse no navegador:
http://localhost:4200
🔗 Comunicação
A aplicação funciona da seguinte forma:
Angular
   ↓
API REST
   ↓
Spring Boot
   ↓
JPA / Hibernate
   ↓
PostgreSQL
O Angular envia requisições para a API REST, o Spring Boot processa as operações e o PostgreSQL armazena os dados.

👨‍💻 Autor
Erick Leonardo
- GitHub: https://github.com/ErickLeo01
- LinkedIn: https://www.linkedin.com/in/erick-leonardo87/
