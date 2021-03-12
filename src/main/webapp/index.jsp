<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="assets/css/bootstrap.css" rel="stylesheet" type="text/css" />
<title>Buscar API</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-8 mb-3" style="margin: auto;">
				<div class="alert-success text-center espaco">Digite um CEP</div>
				<form name="Ceps" method="post" action="controller">
					<div class="row">
						<div class="col-md-12 mb-5">
							<label>CEP</label> <input type="text" class="form-control"name="cep">
						</div>
					</div>
					<div class="row">
						<div class="col-md-12 mb-5">
							<input type="submit" name="CEP"class="form-control btn btn-primary" value="buscar">
						</div>
					</div>
				</form>
				
				<table class="table table-bordered table-striped text-center">
					<thead>
						<tr>
							<th class="text-justify">cep</th>
							<th class="text-justify">logradouro</th>
							<th class="text-justify">complemento</th>
							<th class="text-justify">localidade</th>
							<th class="text-justify">uf</th>
							<th class="text-justify">ibge</th>
							<th class="text-justify">ddd</th>
							<th class="text-justify">siafi</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="cepDados" items="${cepDados}">
							<form name="lista_dados" method="post" action="controller">
							<tr>
								<td class="align-middle text-justify">${cepDados.cep}</td>
								<td class="align-middle text-justify">${cepDados.logradouro}</td>
								<td class="align-middle text-justify">${cepDados.complemento}</td>
								<td class="align-middle text-justify">${cepDados.localidade}</td>
								<td class="align-middle text-justify">${cepDados.uf}</td>
								<td class="align-middle text-justify">${cepDados.ibge}</td>
								<td class="align-middle text-justify">${cepDados.ddd}</td>
								<td class="align-middle text-justify">${cepDados.siafi}</td>
							</tr>
							</form>
						</c:forEach>
					</tbody>
				</table>					
			</div>
		</div>
	</div>
</body>
</html>