<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

  <!-- Optional theme -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

  <!-- Latest compiled and minified JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>teste</title>
</head>
<body>
<nav class="navbar navbar-inverse">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="index.jsp">Alunos</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="adicionaraluno.jsp">Adicionar aluno</a></li>
            <li><a href="obtertodosalunos">Listartodos aluno</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
  <div class="container">
  
    <form id="form" method="post" action="adicionaraluno">
      <div class="container-fluid">
        <div class="row">
          <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="form-group">
              <label for="matricula">Matricula </label>
              <input id="matricula" name="matricula"  class="form-control" type="number" min="1" maxlength="255" value="">
            </div>
          </div>
          <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="form-group">
              <label for="nome">Nome </label>
              <input id="nome" name="nome"  class="form-control" type="text" maxlength="40" value="">
            </div>
          </div> 
        </div>
        <div class="clearfix"></div>
        <div class="row">
          <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="form-group">
              <label for="email">Email </label>
              <input id="email" name="email"  class="form-control" type="email" maxlength="30" value="">
            </div>
          </div>
          <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="form-group">
              <label for="rg">RG </label>
              <input id="rg" name="rg"  class="form-control" type="text" maxlength="255" value="">
            </div>
          </div>
        </div>
        <div class="clearfix"></div>
        <div class="row">
          <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="form-group">
              <label for="logadouro">Logadouro</label>
              <input id="logadouro" name="logadouro"  class="form-control" type="text" maxlength="30" value="">
            </div>
          </div>
          <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="form-group">
              <label for="numero">Numero </label>
              <input id="numero" name="numero"  class="form-control" type="number" min="1" maxlength="255" value="">
            </div>
          </div>
        </div>
        <div class="clearfix"></div>
        <div class="row">
          <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="form-group">
              <label for="bairro">Bairro </label>
              <input id="bairro" name="bairro"  class="form-control" type="text" maxlength="25" value="">
            </div>
          </div>
          <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="form-group">
              <label for="cidade">Cidade </label>
              <input id="cidade" name="cidade"  class="form-control" type="text" maxlength="40" value="">
            </div>
          </div>
        </div>
        <div class="clearfix"></div>
        <div class="form-group">
          <label for="uf">UF </label>
          <input id="uf" name="uf"  class="form-control" type="text" maxlength="2" value="">
        </div>
        <input type="submit" name="submit" class="btn btn-default" value="Salvar">
      </div>
    </form>
  </div>
</body>
</html>