<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Home</title>
  <style>
    body{
      overflow-y: hidden;
      position: relative;
      max-width: 100%;
      max-height: 100%;
    }
    main{
      padding: 50px;
      font-size: larger;
      display: flex;
      flex-direction: column;
    }
    main h3{
      margin-bottom: 15px;
      width: 95%;
    }
    p{
      margin-bottom: 45px;
    }
    .description{
      display: flex;
    }
    .description img{
      width: 24px;
      height: 24px;
      margin-right: 10px;
    }
    .ancora:hover {
      color: #ffa201 !important;
    }
    .ilustration-container {
      display: flex;
      align-items: center;
      justify-content: space-between;
      gap: 20px;
      margin-top: 20px;
    }
    .ilustration {
      display: flex;
      gap: 20px;
    }
    .rectangle{
      width: 300px;
      height: 200px;
      border: #ffa201 solid 3px;
      border-radius: 10px;
      margin-bottom: 10px;
    }
    .button-container {
      display: flex;
      flex-direction: column;
      justify-content: center;
      gap: 10px;
    }
    .button-container a {
      width: 180px;
      text-align: center;
    }
    @media (max-width: 500px) {
      *{
        max-width: 100.4%;
      }

      p{
        font-size: 0.75em;
        overflow-x: hidden;
      }
      main{
        margin: 6%;
        overflow-x: hidden;
        width: 90%;
        padding: 0px;
      }

      body{
        overflow-y: scroll;
      }
      .logo {
        overflow-x: hidden;
        width: 100px;
      }
      .rectangle{
        overflow-x: hidden;
        width: 90%;
        margin-left: 3px;
        height: 200px;
        border: #ffa201 solid 3px;
        border-radius: 10px;
        margin-bottom: 10px;
      }
    }
    @media (min-width: 700px) {
      .myFlexEnd{
        position: absolute;
        right: 20px;
      }
      .logo {
        width: 130px;
        margin-left: 20px;
      }
      li {
        font-size: 20px;
      }
    }
    .sair{
      background-color: #d9534f; /* Cor de fundo vermelha */
      color: white; /* Cor do texto */
      padding: 10px 20px; /* Espaçamento interno */
      border: none; /* Remove borda */
      border-radius: 5px; /* Bordas arredondadas */
      cursor: pointer; /* Cursor de mão ao passar o mouse */
      font-size: 50px; /* Tamanho da fonte */
      transition: background-color 0.3s ease; /* Efeito de transição */
    }
    .sair:hover{
      background-color: #c9302c; /* Cor de fundo ao passar o mouse */
    }
  </style>
  <link
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
          crossorigin="anonymous"
  />
  <script
          src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
          integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
          crossorigin="anonymous"
  ></script>
</head>
<body>
<header>

  <nav class="navbar navbar-expand-lg bg-body-tertiary" style="padding:0;">
    <div
            class="container-fluid"
            style="background-color: #55aca0; padding: 10px">
      <img src="../Assets/Logo-nuvem.png" class="navbar-brand logo" alt="" />
      <button
              class="navbar-toggler"
              type="button"
              data-bs-toggle="collapse"
              data-bs-target="#navbarSupportedContent"
              aria-controls="navbarSupportedContent"
              aria-expanded="false"
              aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
      <div
              class="collapse navbar-collapse myFlexEnd"
              id="navbarSupportedContent"
      >
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <a class="nav-link link-light ancora" aria-current="page" href="#"
            >Dashboard</a
            >
          </li>
          <li class="nav-item">
            <a class="nav-link link-light ancora" href="#">com.example.com.example.servlettrocatine.servlet.controller</a>
          </li>
          <li class="nav-item">
            <a class="nav-link link-light ancora" aria-disabled="true"
            >Landing Page</a
            >
          </li>
        </ul>
      </div>
    </div>
  </nav>
</header>

<main>
  <div class="button-container">
    <a href="../index.html" style="display: flex; justify-content: flex-start" class="sair" > Sair </a>

  </div>
  <h1>Bem vindo à área restrita</h1>
  <p>Um espaço exclusivo onde você pode acessar e gerenciar informações essenciais através de nossa dashboard interativa. Aqui, utilizamos a tecnologia de Servlets para garantir que todos os dados sejam processados de forma eficiente e segura.</p>

  <h3>Ilustrações da área restrita</h3>

  <div class="ilustration-container">
    <div class="ilustration">
      <div class="wrapper">
        <div class="rectangle"></div>
        <div class="description">
          <img src="../AreaRestrita/_Assets/navigation.png"><p>Dashboard</p>
        </div>
      </div>
      <div class="wrapper">
        <div class="rectangle"></div>
        <div class="description">
          <img src="../AreaRestrita/_Assets/navigation.png"><p>com.example.com.example.servlettrocatine.servlet.controller</p>
        </div>
      </div>
    </div>

    <!-- Adicionando os botões ao lado das imagens -->
    <div class="button-container">
      <a href="AreaRestrita/dashboard.jsp" class="btn btn-success">Ir para o Dashboard</a>
      <a href="../jsp/pagCrud.jsp" class="btn btn-primary">Ir para o CRUD</a>
    </div>
  </div>

</main>

</body>
</html>
