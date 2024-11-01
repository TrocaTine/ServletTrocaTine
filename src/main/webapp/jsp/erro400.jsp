<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
</head>
<style>
  *{
    font-family: Arial, Helvetica, sans-serif;
    color: white;
    font-size: 1.1em;
  }
  h1{
    font-size: 6em;
    margin-bottom: -10px;
  }
  body {
    background: linear-gradient(to left, #4dbfb0, #ff9f45);
    opacity: 1.1;
  }
  img{
    opacity: 1;
    width: 300px;
    position: absolute;
    top: 210px;
    left: 1005px;
  }
  #information{
    position: absolute;
    font-size: 2.3em;
    top: -90px;
    left: 150px;
  }
  a{
    position: absolute;
    top: 570px;
    left: 240px;
    background-color: black;
    padding: 30px;
    padding-left: 50px;
    padding-right: 50px;
    text-decoration: none;
    border-radius: 10px;
    justify-content: center;
  }


</style>
<body>
<div id="information">
  <h1>Erro<h1>
  <p><%=request.getAttribute("erro")%> </p>
</div>
<img src="Assets/logo.png" alt="">
<a href="../index.html">Retornar para inicial</a>
</body>
</html>