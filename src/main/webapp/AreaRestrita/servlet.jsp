<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Área Restrita | Tabela Adm</title>
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
    <style>
        main{
            margin: 50px 75px 0 75px;
        }
        .choose{
            margin-bottom: 65px;
        }
        .line{
            border: 1px solid rgba(255, 141, 34, 0.4);
            opacity: 1;
        }
        .container{
            display: flex;
            justify-content: center;
            flex-wrap: wrap;
            margin-top: 25px;
            margin-bottom: 25px;
        }
        a.buttons{
            border: 2px solid #FF8D22;;
            border-radius: 5px;
            padding: 10px 25px 10px 25px;
            align-items: center;
            background-color: white;
            font-weight: bolder;
            color: #FF8D22;
            transition: 0.1s;
            box-shadow: 1px 1px #FF8D22;
            text-decoration: none;
            margin: 25px 10px 25px 10px;
        }
        a.buttons:hover{
            box-shadow: #FF8D22;
            box-shadow: 5px 5px #FF8D22;
            transition: 0.1s;
            position: relative;
            left: -2px;
            top: -2px;
        }
        a.buttons:active{
            position: relative;
            left: 0;
            top: 0;
            box-shadow: none;
            box-shadow: 1px 1px #FF8D22;
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg bg-body-tertiary" style="padding: 0; margin: 0; width: 100%;">
      <div
        class="container-fluid"
        style="background-color: #55aca0; padding: 10px"
      >
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
              <a class="nav-link link-light ancora" href="#">Servlet</a>
            </li>
            <li class="nav-item">
              <a class="nav-link link-light ancora" aria-disabled="true"
                >Landing Page</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <main>
        <h1>Servlet</h1>
        <p class="choose">Escolha uma tabela:</p>
        <hr class="line">
        <div class="container">
            <a class="buttons" href="adm/adm.html">ADM</a>
            <a class="buttons" href="categoria/categoria.html">Categoria</a>
            <a class="buttons" href="comunidade/comunidade.html">Comunidade</a>
            <a class="buttons" href="tag/tag.html">Tag</a>
            <a class="buttons" href="usuario/usuario.html">Usuario</a>
        </div>
        <hr class="line">
    </main>

</body>
</html>