<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro</title>
    <link rel="stylesheet" href="cadastro.css">
</head>
<body>
    <div class="body">
        <div class="header">
            <nav>
                <img id="img-banner" src="../Assets/Logo-nuvem.png">
                <ul>
                    <li><a href="../index.html">Página Inicial</a></li>
                    <li><a href="../index.html">Sobre Nós</a></li>
                    <li><a href="../index.html">ODS 11</a></li>
                    <li><a href="">Cadastrar</a></li>
                    <li><a href="../index.html">Equipe</a></li>
                </ul>
            </nav>
            </div>
        <div class="container">
            <div class="left-side">
                <h2>Junte-se a nós</h2>
                <h1>Cadastre-se</h1>
                <img src="../Assets/fotologin2.png" alt="">
            </div>
            <div class="right-side">
                <form>
                    <label for="name">Nome completo</label>
                    <input type="text" id="name" name="name">
    
                    <label for="email">E-mail</label>
                    <input type="email" id="email" name="email">
    
                    <label for="password">Senha</label>
                    <input type="password" id="password" name="password">
                    <a href="../jsp/login.jsp">Login área restrita</a>
    
                    <button type="submit">Cadastrar</button>
                </form>
            </div>
        </div>
    </div>

</body>
</html>
