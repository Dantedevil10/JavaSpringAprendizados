Documentação da API - Treinamento Java Spring

Autenticação

POST /auth/register

Descrição:
Registra um novo usuário.

Requisição:

{
  "email": "usuario@email.com",
  "username": "usuario123",
  "password": "senha123",
  "role": "ROLE_USER" // Opcional, padrão é ROLE_USER
}

Resposta:

{
  "jwt-token": "token_gerado"
}

Códigos de Resposta:

200 OK: Usuário registrado com sucesso.

400 Bad Request: Dados inválidos ou faltando.

POST /auth/login

Descrição:
Autentica o usuário e retorna um token JWT.

Requisição:

{
  "username": "usuario123",
  "password": "senha123"
}

Resposta:

{
  "jwt-token": "token_gerado"
}

Códigos de Resposta:

200 OK: Login bem-sucedido.

401 Unauthorized: Usuário ou senha inválidos.

Usuário

GET /user/info

Descrição:
Retorna os dados do usuário logado.

Requisição:

Header: Authorization: Bearer {token}

Resposta:

{
  "id": 1,
  "email": "usuario@email.com",
  "username": "usuario123",
  "password": "hash_senha",
  "role": "ROLE_USER"
}

Códigos de Resposta:

200 OK: Retorna informações do usuário.

401 Unauthorized: Token inválido ou ausente.

Pedidos

POST /pedido/save

Descrição:
Cria um novo pedido.

Requisição:

{
  "endereco": "Rua das Flores, 123",
  "dataPedido": "2024-03-19T14:30:00",
  "status": "PENDENTE",
  "produtos": [
    { "id": 1 },
    { "id": 2 }
  ]
}

Resposta:

{
  "id": 10,
  "endereco": "Rua das Flores, 123",
  "dataPedido": "2024-03-19T14:30:00",
  "status": "PENDENTE",
  "produtos": [
    { "id": 1, "nome": "Produto A", "preco": 10.0 },
    { "id": 2, "nome": "Produto B", "preco": 20.0 }
  ]
}

Códigos de Resposta:

200 OK: Pedido salvo com sucesso.

400 Bad Request: Dados inválidos.

GET /pedido/{id}

Descrição:
Busca um pedido pelo ID.

Resposta:

{
  "id": 10,
  "endereco": "Rua das Flores, 123",
  "dataPedido": "2024-03-19T14:30:00",
  "status": "PENDENTE",
  "produtos": [
    { "id": 1, "nome": "Produto A", "preco": 10.0 },
    { "id": 2, "nome": "Produto B", "preco": 20.0 }
  ]
}

Códigos de Resposta:

200 OK: Pedido encontrado.

404 Not Found: Pedido não encontrado.

Produtos

POST /produto/save

Descrição:
Cria um novo produto (Requer papel ADMIN).

Requisição:

{
  "nome": "Produto X",
  "preco": 99.99,
  "descricao": "Produto de teste"
}

Resposta:

{
  "id": 5,
  "nome": "Produto X",
  "preco": 99.99,
  "descricao": "Produto de teste"
}

Códigos de Resposta:

200 OK: Produto criado com sucesso.

403 Forbidden: Usuário sem permissão.

GET /produto/all

Descrição:
Retorna todos os produtos.

Resposta:

[
  { "id": 1, "nome": "Produto A", "preco": 10.0 },
  { "id": 2, "nome": "Produto B", "preco": 20.0 }
]

Códigos de Resposta:

200 OK: Lista retornada com sucesso.

GET /produto/{id}

Descrição:
Busca um produto pelo ID.

Resposta:

{
  "id": 1,
  "nome": "Produto A",
  "preco": 10.0,
  "descricao": "Produto bom"
}

Códigos de Resposta:

200 OK: Produto encontrado.

404 Not Found: Produto não encontrado.

Controle de Acesso

/auth/: Acesso público.

/user/: Requer ROLE_USER ou ROLE_ADMIN.

/pedido/: Requer ROLE_USER ou ROLE_ADMIN.

/produto/: Requer ROLE_ADMIN.

Como rodar o projeto

Clone o repositório:

git clone https://github.com/seu-usuario/seu-repositorio.git

Navegue até a pasta do projeto:

cd seu-repositorio

Rode o projeto Spring Boot:

./mvnw spring-boot:run

Agora a API estará disponível em http://localhost:8080.

Essa documentação cobre as funcionalidades principais do backend. Quer que eu adicione exemplos de erros mais específicos ou tratamentos adicionais?

