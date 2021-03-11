<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="assets/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<title>Tabela</title>
</head>
<body>

<div class="container">
<div class="row">
<div class="col-md-8 mb-3" style="margin: auto;">

<div class="alert-success text-center espaco">
    Listagem
</div>
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
        <tr>
           <td class="align-middle text-justify"><%out.print(request.getAttribute("cepDados")); %></td>
           <td class="align-middle text-justify"><%out.print(request.getAttribute("logradouroDados")); %></td>
            <td class="align-middle text-justify"><%out.print(request.getAttribute("complementoDados")); %></td>
            <td class="align-middle text-justify"><%out.print(request.getAttribute("localidadeDados")); %></td>
            <td class="align-middle text-justify"><%out.print(request.getAttribute("ufDados")); %></td>
            <td class="align-middle text-justify"><%out.print(request.getAttribute("ibgeDados")); %></td>
            <td class="align-middle text-justify"><%out.print(request.getAttribute("dddDados")); %></td>
            <td class="align-middle text-justify"><%out.print(request.getAttribute("siafiDados")); %></td>
         </tr>
</tbody>
</table>

</div>
</div>
</div>

</body>
</html>