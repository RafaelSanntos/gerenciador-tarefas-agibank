🗂️ Gerenciador de Tarefas API – Organização com poder de gestão

Bem-vindo ao Gerenciador de Tarefas API, uma API REST feita para quem acredita que produtividade também precisa de estrutura, papéis bem definidos e… um toque de Java.
Aqui, cada tarefa é uma missão, cada usuário tem um papel, e a autenticação JWT é o escudo que protege tudo isso.

Porque até para organizar o caos, é bom ter um sistema bem feito.
---
🧩 Sobre o projeto

O Gerenciador de Tarefas API foi desenvolvido em Java com Spring Boot e tem como objetivo gerenciar tarefas e usuários com diferentes níveis de acesso.
Cada colaborador possui um papel definido, e o sistema garante que só quem tem permissão execute as ações certas — tudo isso com segurança e eficiência.
---
⚙️ Tecnologias e ferramentas usadas

☕ Java 17+

🚀 Spring Boot 3.x

🔐 Spring Security (JWT)

💾 Spring Data JPA

🧰 Gradle

🔐 Autenticação

Endpoint de login: /api/v1/usuarios/login

Use o token no Swagger: Bearer {token}

Perfis disponíveis: GESTOR | SUPERVISOR | COLABORADOR

Token JWT com validade de 2 horas e senhas criptografadas com BCrypt.
A matrícula dos usuários é gerada automaticamente (100–9999).
---
📌 Funcionalidades principais
👤 Usuários

🔑 Login e autenticação com JWT

➕ Cadastro de novos usuários

🔍 Busca por matrícula, cargo ou setor

🧭 Atualização de cargo, setor ou situação

💤 Reatribuição automática de tarefas ao desativar um usuário

📝 Tarefas

🆕 Criar novas tarefas

✏️ Atualizar dados e situação

🔍 Filtrar por situação ou responsável

📋 Listar todas as tarefas do sistema

🧾 Estrutura básica das entidades
👥 Usuário

matricula: identificador automático

nome: nome completo

email / senha: credenciais de acesso

cargo: enum (GESTOR, SUPERVISOR, COLABORADOR)

setor: departamento do colaborador

situacao: enum (ATIVO, FERIAS, LICENCA, AFASTADO, DESLIGADO)

✅ Tarefa

id: identificador único

titulo / descricao: informações da tarefa

prazo: data limite

prioridade: enum (BAIXA, MEDIA, ALTA, URGENTE)

status: enum (PENDENTE, EM_ANDAMENTO, CONCLUIDA, CANCELADA)

matricula: responsável pela tarefa
---
🔍 Exemplos de uso
🔑 Login
POST /api/v1/usuarios/login
{
  "email": "usuario@email.com",
  "senha": "senha123"
}

👥 Cadastrar Usuário
POST /api/v1/usuarios/cadastrar
{
  "nome": "João Silva",
  "email": "joao@email.com",
  "senha": "Senha123!",
  "cargo": "COLABORADOR",
  "setor": "TI"
}

🧾 Criar Tarefa
POST /tarefas/criar
{
  "titulo": "Desenvolver feature X",
  "descricao": "Descrição detalhada",
  "prazo": "2025-12-31T23:59:59",
  "prioridade": "ALTA",
  "matricula":
