<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>Cadastro</title></head>
<body>
  <h2>Cadastrar Produto</h2>
  <form action="produtos" method="post">
    Nome: <input type="text" name="nome" required><br>
    Preço: <input type="number" name="preco" step="0.01" required><br>
    <button type="submit">Salvar</button>
  </form>
  <hr>
  <a href="produtos">Ver produtos</a>
</body>
</html>
