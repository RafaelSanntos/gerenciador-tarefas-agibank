📋 Gerenciador de Tarefas API
API REST para gerenciamento de tarefas e usuários com autenticação JWT.

🚀 Tecnologias
Java 17+ | Spring Boot 3.x | Spring Security (JWT) | Spring Data JPA | Gradle

⚙️ Executar

./gradlew bootRun


API: http://localhost:8080

Swagger: http://localhost:8080/swagger-ui.html

🔐 Autenticação
Login em /api/v1/usuarios/login
Use o token no Swagger: Bearer {token}
Roles: GESTOR | SUPERVISOR | COLABORADOR

📚 Endpoints Principais

👤 Usuários (/api/v1/usuarios)

Método	Endpoint	Descrição	Acesso
POST	/login	Login (retorna JWT)	Público
POST	/cadastrar	Cadastrar usuário	GESTOR
GET	/{matricula}	Buscar por matrícula	Autenticado
GET	/listarsetor?setor=	Listar por setor	Autenticado
GET	/listarcargo?cargo=	Listar por cargo	Autenticado
PUT	/{matricula}/cargo	Atualizar cargo	GESTOR
PUT	/{matricula}/setor	Atualizar setor	GESTOR
PUT	/{matricula}/situacao	Atualizar situação	GESTOR

📝 Tarefas (/tarefas)

Método	Endpoint	Descrição
POST	/criar	Criar tarefa
PUT	/atualizar	Atualizar dados
PUT	/atualizarSituacao/{id}	Atualizar situação
GET	/listarTodas	Listar todas
GET	/buscarPorSituacao?situacao=	Filtrar por situação
GET	/buscarPorMatricula?matricula=	Filtrar por responsável

🧩 Exemplos de Uso

Login:

POST /api/v1/usuarios/login
{
  "email": "usuario@email.com",
  "senha": "senha123"
}


Cadastrar Usuário:

POST /api/v1/usuarios/cadastrar
{
  "nome": "João Silva",
  "email": "joao@email.com",
  "senha": "Senha123!",
  "cargo": "COLABORADOR",
  "setor": "TI"
}


Criar Tarefa:

POST /tarefas/criar
{
  "titulo": "Desenvolver feature X",
  "descricao": "Descrição detalhada",
  "prazo": "2025-12-31T23:59:59",
  "prioridade": "ALTA",
  "matricula": 5847
}


📊 Enums Disponíveis
Cargo: GESTOR, SUPERVISOR, COLABORADOR
Situação: ATIVO, FERIAS, LICENCA, AFASTADO, DESLIGADO
Prioridade: BAIXA, MEDIA, ALTA, URGENTE
Status Tarefa: PENDENTE, EM_ANDAMENTO, CONCLUIDA, CANCELADA

🔒 Segurança
Senha: criptografada (BCrypt)
Matrícula: gerada automaticamente (100–9999)
Token JWT: validade de 2 horas
Reatribuição: tarefas transferidas quando usuário fica inativo

📄 Códigos HTTP
200 / 201 - Sucesso
400 - Dados inválidos
401 - Não autenticado
403 - Sem permissão
404 - Não encontrado
