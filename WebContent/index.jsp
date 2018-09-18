<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
	Bem vindo ao nosso gerenciador de empresas!<br/> <br>
	<c:if test="${not empty usuarioLogado }">
		Logado como <strong>${usuarioLogado.email }</strong>  <br>
	</c:if>
	<form action="executa?tarefa=NovaEmpresa" method="POST">
		<input type="text" name="nome">
		<button type="submit">Salvar</button>
	</form>
	<br/>
	<form action="login" method="POST">
		E-mail: <input type="text" name="email"> <br>
		Senha: <input type="password" name="senha">
		<button type="submit">Acessar</button>
	</form>
	<form action="executa" method="POST">
		<input type="hidden" name="tarefa" value="Logout">
		<input type="submit" value="Sair" />
	</form>
</body>
</html>