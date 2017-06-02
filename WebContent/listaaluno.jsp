<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="Model.AlunoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alunos cadastrados</title>

</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.jsp">Alunos</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="adicionaraluno.jsp">Adicionar aluno</a></li>
				<li class="active"><a href="obtertodosalunos">Listartodos
						aluno</a></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
	</nav>

	<div class="container">
		<%=request.getAttribute("mensagem")%>
		<div class="row">
			<div class="col-md-12 mx-auto">
				<form method="post" action="<%=request.getAttribute("formAction")%>" class="form-inline">
					<div class="form-group">
						<label class="sr-only" for="matricula">Matricula</label> <input
							type="number" class="form-control" value="<%=request.getAttribute("matricula")%>"id="matricula"
							name="matricula" placeholder="Matricula">
					</div>
					<div class="form-group">
						<label class="sr-only" for="nome">Nome</label> <input type="text"
							class="form-control" id="nome" name="nome" value="<%=request.getAttribute("nome")%>"placeholder="Nome">
					</div>
					<div class="form-group">
						<label class="sr-only" for="nome">E-Mail</label> <input
							type="text" class="form-control" name="email" value="<%=request.getAttribute("email")%>" id="email"
							placeholder="E-Mail">
					</div>
					<div class="form-group">
						<label for="rows">Num. Por Pagina</label> <select id="rows"
							name="rows" class="form-control">
							<option <%if ((int) request.getAttribute("rowsAtual") == 4) {%>
								selected="selected" <%}%>>4</option>
							<option <%if ((int) request.getAttribute("rowsAtual") == 10) {%>
								selected="selected" <%}%>>10</option>
							<option <%if ((int) request.getAttribute("rowsAtual") == 20) {%>
								selected="selected" <%}%>>20</option>
						</select>
					</div>
					<button type="submit" class="btn btn-default">Filtrar</button>
				</form>
			</div>
			<div class="col-md-12 table-responsive">
				<table class="table table-striped table-bordered table-list">
					<thead>
						<tr>
							<th><em class="fa fa-cog"></em></th>
							<th>Matricula</th>
							<th>Nome</th>
							<th>Email</th>

						</tr>
					</thead>
					<tfoot>
						<tr>
							<th><em class="fa fa-cog"></em></th>
							<th>Matricula</th>
							<th>Nome</th>
							<th>Email</th>

						</tr>
					</tfoot>
					<tbody>

						<%
							List<AlunoBean> lista = new ArrayList<AlunoBean>();
							lista = (List<AlunoBean>) request.getAttribute("alunos");
							for (AlunoBean aluno : lista) {
						%>
						<tr>
							<td><a
								href="detalhesaluno?matricula=<%=aluno.getMatricula()%>"
								class="btn btn-default"><p data-placement="top"
										data-toggle="tooltip" title="Editar"
										data-original-title="Editar">
										<span class="glyphicon glyphicon-pencil"></span>
									</p></a> <a href="removeraluno?matricula=<%=aluno.getMatricula()%>"
								class="btn btn-danger"><p data-placement="top"
										data-toggle="tooltip" title="Deletar"
										data-original-title="Deletar">
										<span class="glyphicon glyphicon-trash"></span>
									</p></a></td>
							<td><%=aluno.getMatricula()%></td>
							<td><%=aluno.getNome()%></td>
							<td><%=aluno.getEmail()%></td>

						</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</div>
			<%
				int numPag = (int) request.getAttribute("numPag");
				int paginaAtual = (int) request.getAttribute("paginaAtual");
			%>
			<div class="col-md-12 pull-right">
				<ul class="pagination pagination-lg">
					<%
						for (int pag = 1; pag <= numPag; pag++) {
					%>
					<li <%if (pag == paginaAtual) {%> class="active" <%}%>><a
						href="?pag=<%=pag%>"><%=pag%></a></li>
					<%
						}
					%>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>