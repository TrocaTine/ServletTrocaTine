<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Login</title>
    <style>
      body {
          height: 100vw;
          position: relative;
          overflow: hidden;
      }
      .sqr{
          padding: 75px 0px 75px 0px;
          margin: -200px 30% 0px 30%;
          box-shadow: 8px 8px 20px #000;
          border-radius: 15px;
      }
      #imgBotao{
          position: relative;
          bottom: -10px;
          left: -65px;
      }
      #imgUrso{
        position: relative;
        bottom: -410px;
        left: -375px;
      }
      #imgCamisa{
        position: relative;
        right: -875px;
        bottom: -300px;
        transform: rotate(-15deg);

      }
      .mainImages{
        width: 250px;
        opacity: 0.25;

      }
      .imgM {
          position: absolute;
          bottom: 0;
          width: 100vw;
      }
      .footer {
          position: absolute;
          bottom: 0;
      }
      .ancora:hover {
          color: #ffa201 !important;  
      }
      .nuvens{
        width: 100%;
        position: relative;
        bottom: -5px;
    }
    .header{
        width: 100%;
        height: 100px;
        position: fixed; top: 0;
        font-size: 150%;
        background: #55aca192;
        display: flex;
        z-index: 999;
    }
    .header #img-banner{
        width: 165px;
        height: 75px;
    }
    .header nav{
        width: 100%;
        display: flex;
        flex-direction: row;
        align-items: center;
        justify-content: space-between;
        padding: 20px 50px;
    }
    .header nav ul li{
      display: inline-flex;
      justify-content: center;
      align-items: center;
      list-style: none;
      margin: 10px 40px 0 20px;

  }
  .header nav ul li a{
      text-decoration: none;
      color: white;
      transition: 0.5s;
      font-weight: bold;
  }
  .header nav ul li a:hover{
      color: #ffa201;
  }
      @media (max-width: 500px) {
        main h1{
          max-width: 96%;
        }
        .forms {
          width: 260px;
          max-width: 90%;
        }
        .btn-forms {
          width: 150px;
        }
        .logo {
          width: 100px;
        }
      }
      @media (min-width: 700px) {
        .myFlexEnd{
        position: absolute;
        right: 0px;
      }
    
        .logo {
          width: 130px;
        }
        .forms {
          width: 340px;
        }
        .btn-forms {
          width: 200px;
        }
        li {
          font-size: 20px;
        }
        .myFlexEnd {
          position: absolute;
          right: 0;
          margin-right: 20px;
      }
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
            <div class="collapse navbar-collapse myFlexEnd" id="navbarSupportedContent">
              <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                  <a class="nav-link link-light ancora" aria-current="page" href="#"
                    >Dashboard</a>
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
    </header>
    <main>
        <img src="Assets/botoes.png" class="mainImages" id="imgBotao">
        <img src="Assets/urso.png" class="mainImages" id="imgUrso">
        <img src="Assets/camisa.png" class="mainImages" id="imgCamisa">
        <div class="sqr">
            <h1 class="h1" style="text-align: center; margin-left: 5px;">
              Login da área restrita
            </h1>
            <div class="d-flex justify-content-center">
              <form class="forms" style="margin-top: 30px">
                <div class="mb-3">
                  <label for="exampleInputEmail1" class="form-label"
                    >Nome do usuário</label>
                  <input
                    type="email"
                    class="form-control"
                    id="exampleInputEmail1"
                    aria-describedby="emailHelp"
                  />
                </div>
                <div class="mb-3">
                  <label for="exampleInputPassword1" class="form-label"
                  >Senha</label>
                  <input
                    type="password"
                    class="form-control"
                    id="exampleInputPassword1"
                  />
                </div>
                <div style="display: flex; justify-content: center">
                  <button
                    type="submit"
                    class="btn btn-forms"
                    style="
                      margin: 20px;
                      padding:5px ;
                      padding-bottom: 10px;
                      background-color: #55aca0;
                      color: white;
                      align-content: center;
                    "
                  >Login</button>
                </div>
              </form>
            </div>
        </div>
    </main>
    <footer>
    </footer>
  </body>
</html>