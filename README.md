# Spring Security API

Uma API RESTful para autenticação e gerenciamento de usuários e livros, utilizando Spring Boot, Spring Security, JWT, e PostgreSQL. Este projeto implementa operações CRUD básicas e autenticação baseada em tokens JWT.

---

## 🛠️ Tecnologias e Ferramentas Utilizadas

- **Java 21**: Linguagem de programação principal.
- **Spring Boot 3.4.0**: Framework para desenvolvimento rápido de aplicações Java.
- **Spring Security**: Implementação de autenticação e controle de acesso.
- **JWT (JSON Web Tokens)**: Gerenciamento de autenticação e autorização.
- **PostgreSQL**: Banco de dados relacional.
- **Flyway**: Controle de versões do banco de dados.
- **SpringDoc OpenAPI**: Documentação interativa da API com Swagger UI.
- **Maven**: Gerenciador de dependências e build.
- **Lombok**: Redução de boilerplate no código.

---

## 🚀 Funcionalidades

- **Autenticação**:
  - Geração e validação de tokens JWT.
  - Login seguro com Spring Security.
- **Gerenciamento de Usuários**:
  - Operações CRUD.
  - Busca por nome de usuário.
- **Gerenciamento de Livros**:
  - Criação e armazenamento de livros.
- **Documentação OpenAPI/Swagger**:
  - Interface para testar os endpoints diretamente no navegador.

---

## 📂 Estrutura do Projeto

O projeto segue a estrutura padrão de um projeto Spring Boot. Destaques:

- `src/main/java` - Contém os códigos fonte do projeto.
- `src/main/resources` - Contém arquivos de configuração, como `application.properties`.


---

## 📋 Pré-requisitos

- **Java 21** instalado.
- **Maven** configurado.
- **PostgreSQL** instalado e com um banco de dados configurado.

---

## ⚙️ Configuração

1. **Clone o repositório**  
   Clone o repositório para sua máquina local executando o comando abaixo no terminal:  
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git

Certifique-se de ter o Git instalado. O repositório será clonado na pasta atual onde o comando foi executado.

2. **Configure o banco de dados, as dependências e as propriedades**
   Execute as etapas abaixo para configurar o ambiente de execução do projeto:
   # 1. Configure o banco de dados:
    - Certifique-se de que o PostgreSQL esteja instalado e em execução.
    - Crie um banco de dados chamado `seu_banco` (ou o nome que preferir).

  # 2. Atualize o arquivo `application.properties`:
   - Edite o arquivo localizado em `src/main/resources/application.properties` para incluir as configurações corretas do banco de dados. Exemplo:
    spring.datasource.url=jdbc:postgresql://localhost:5432/seu_banco
    spring.datasource.username=seu_usuario
    spring.datasource.password=sua_senha
    spring.jpa.hibernate.ddl-auto=validate // pois criamos o banco através do flyway, para registrar as migrations.

  # 3. Instale as dependências do projeto:
  - Navegue até o diretório raiz do projeto.
  - Execute o comando:
     mvn clean install


3. **Execute a aplicação**

4. **Acesse a API**
     Após a execução bem-sucedida, a API estará disponível no seguinte endereço padrão:
       http://localhost:8080
   
## 📖 Endpoints Principais

### 🔒 Autenticação
- `POST /auth/login`: Realiza a autenticação de um usuário e gera um token JWT.
- `POST /auth/register`: Registra um novo usuário no sistema. Verifica se o nome de usuário já existe e codifica a senha antes de salvar.

### 📚 Gerenciamento de Livros
- `GET /books`: Lista todos os livros disponíveis no sistema.
- `POST /books`: Cria um novo livro e retorna os dados do livro criado.



📜 Licença
Este projeto está licenciado sob a Licença MIT.

✍️ Autor
Arthur - Desenvolvedor Java em formação e apaixonado por tecnologias. Conecte-se comigo no <a href="https://www.linkedin.com/in/arthurvasc/" target="_blank">LinkedIn</a>.
