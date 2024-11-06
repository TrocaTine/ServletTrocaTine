package com.example.servlettrocatine.servlet.comunidade;

import com.example.servlettrocatine.DAO.ComunidadeDAO;
import com.example.servlettrocatine.DAO.LogDAO;
import com.example.servlettrocatine.model.Comunidade;
import com.example.servlettrocatine.model.Log;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "inserirComunidade", value = "/inserirComunidade") // Mapeia a URL para este servlet
@MultipartConfig(maxFileSize = 16177215) // Configuração para permitir upload de arquivos com tamanho máximo de 16MB
public class InserirComunidade extends HttpServlet {

    // Método que lida com requisições POST para inserir uma nova comunidade
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // Cria instância do DAO para manipulação de dados de comunidade
        ComunidadeDAO comunidadeDAO = new ComunidadeDAO();

        // Coleta os parâmetros enviados pelo formulário de inserção de comunidade
        String nome = request.getParameter("nome");
        String criador = request.getParameter("criador");
        String descricao = request.getParameter("descricao");
        String foto = request.getParameter("foto");
        int qntIntegrantes = Integer.parseInt(request.getParameter("qntIntegrantes"));

        // Recupera o ID do administrador da sessão
        int idAdm = (Integer) request.getSession().getAttribute("idAdm");

        // Cria um objeto Comunidade com os dados coletados
        Comunidade comunidade = new Comunidade(nome, criador, descricao, qntIntegrantes, foto);

        // Verifica se todos os campos obrigatórios foram preenchidos
        if (nome == null || criador == null || descricao == null || foto == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Todos os campos são obrigatórios.");
            return;
        }

        // Tenta inserir a nova comunidade no banco de dados
        boolean certo = comunidadeDAO.inserirComunidade(comunidade);

        // Cria o log da operação de inserção
        Log log = new Log(
                "Inserir",
                "Comunidade",
                "Comunidade inserida: Nome: " + nome + ", Criador: " + criador + ", Descrição: " + descricao + ", Foto: " + foto + ", Quantidade de integrantes: " + qntIntegrantes,
                idAdm
        );

        // Criação do objeto logDAO
        LogDAO logDAO = new LogDAO();

        // Inserção do log no banco de dados
        boolean logCerto = logDAO.inserirLog(log);

        // Verifica se a inserção da comunidade e do log foram bem-sucedidas
        if (certo && logCerto) {
            // Se sucesso, envia uma mensagem de sucesso para a sessão e redireciona
            request.getSession().setAttribute("successMessage", "Categoria adicionada com sucesso!");
            response.sendRedirect("jsp/comunidade/inserirComunidade.jsp");
        } else {
            // Caso contrário, retorna um erro interno
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao inserir categoria.");
        }
    }
}
