# Treinamento Java Spring - API Backend

## Descrição

Este projeto é uma API desenvolvida com Java Spring Boot, oferecendo funcionalidades de autenticação, gerenciamento de usuários, pedidos e produtos. Ele implementa autenticação JWT e controle de acesso por roles.

Atenção : Este projeto é somente demonstrativo.

Atenção : Antes de TODA Requisição que não seja ("/auth") dentro do sistema ,deve-se ser feito primeiro a criação de um usuário e seu respectivo Login com o Token 

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.4.3**
- **Spring Security**
- **JWT (JSON Web Token)**
- **JPA/Hibernate**
- **Lombok**

## Endpoints

### Autenticação

#### **POST /auth/register**
Registra um novo usuário.

**Requisição:**
```json
{
  "email": "usuario@email.com",
  "username": "usuario123",
  "password": "senha123",
  "role": "ROLE_USER" //Caso queira um Usuario ADM mude de "ROLE_USER" para "ROLE_ADMIN"
}
```

**Resposta:**
```json
{
  "jwt-token": "token_gerado"
}
```

#### **POST /auth/login**
Realiza o login e retorna o token JWT.

**Requisição:**
```json
{
  "username": "usuario123",
  "password": "senha123"
}
```

**Resposta:**
```json
{
  "jwt-token": "token_gerado"
}
```

### Usuário

#### **GET /user/info**
Retorna informações do usuário logado.

**Header:** `Authorization: Bearer {token}`

**Resposta:**
```json
{
  "id": 1,
  "email": "usuario@email.com",
  "username": "usuario123",
  "role": "ROLE_USER"
}
```

### Pedidos

#### **POST /pedido/save**
Cria um novo pedido.

**Requisição:**
```json
{
  "endereco": "Rua das Flores, 123",
  "dataPedido": "2024-03-19T14:30:00",
  "status": "PENDENTE",
  "produtos": [
    { "id": 1 },
    { "id": 2 }
  ]
}
```

#### **GET /pedido/{id}**
Retorna um pedido pelo ID.

### Produtos

#### **POST /produto/save**
Cria um novo produto (**Requer ROLE_ADMIN**).

**Requisição:**
```json
{
  "nome": "Produto X",
  "preco": 99.99,
  "descricao": "Produto de teste"
}
```

#### **GET /produto/all**
Retorna todos os produtos.

## Controle de Acesso

- `/auth/`: Acesso público.
- `/user/`: Requer `ROLE_USER` ou `ROLE_ADMIN`.
- `/pedido/`: Requer `ROLE_USER` ou `ROLE_ADMIN`.
- `/produto/`: Requer `ROLE_ADMIN`.

## Como Rodar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/seuusuario/seuprojeto.git
   ```

2. Entre na pasta do projeto:
   ```bash
   cd seuprojeto
   ```

3. Instale as dependências:
   ```bash
   mvn clean install
   ```

4. Configure o banco de dados (`application.properties`):
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/seubanco
   spring.datasource.username=root
   spring.datasource.password=senha
   ```

5. Execute a aplicação:
   ```bash
   mvn spring-boot:run
   ```

6. Acesse a API:
   ```
   http://localhost:8080/auth/register
   ```

Agora é só testar a API! 🚀
