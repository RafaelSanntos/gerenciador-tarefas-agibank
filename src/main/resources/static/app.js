const form = document.getElementById('formTarefa');
const lista = document.getElementById('listaTarefas');
const btnListar = document.getElementById('listarTarefas');

form.addEventListener('submit', async (e) => {
  e.preventDefault();

  const tarefa = {
    titulo: document.getElementById('titulo').value,
    descricao: document.getElementById('descricao').value,
    matricula: document.getElementById('matricula').value,
    conclusao: document.getElementById('conclusao').value,
    situacao: "PENDENTE"
  };

  const response = await fetch('http://localhost:8080/tarefas/criar', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(tarefa)
  });

  if (response.ok) {
    alert('Tarefa criada com sucesso!');
    form.reset();
  } else {
    alert('Erro ao criar tarefa.');
  }
});
