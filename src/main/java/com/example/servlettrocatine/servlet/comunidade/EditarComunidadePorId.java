package com.example.servlettrocatine.servlet.comunidade;

import com.example.servlettrocatine.DAO.ComunidadeDAO;
import com.example.servlettrocatine.DAO.LogDAO;
import com.example.servlettrocatine.model.Comunidade;
import com.example.servlettrocatine.model.Log;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "editarComunidadePorID", value = "/editarComunidadePorID") // Mapeia a URL para este servlet
public class EditarComunidadePorId extends HttpServlet {

    // Método que lida com requisições POST para editar uma comunidade
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Coleta os dados do formulário da requisição
        String idComunidade = request.getParameter("id");
        String nomeComunidade = request.getParameter("nome");
        String criadorComunidade = request.getParameter("criador");
        String descricaoComunidade = request.getParameter("descricao");
        String qntComunidade = request.getParameter("qntIntegrantes"); // Quantidade de integrantes da comunidade
        String fotoComunidade = request.getParameter("fotoPerfil"); // Foto da comunidade

        // Obtém o ID do administrador da sessão
        int idAdm = (Integer) request.getSession().getAttribute("idAdm");

        // Verifica se todos os parâmetros necessários foram fornecidos
        if (idComunidade == null || nomeComunidade == null || criadorComunidade == null ||
                descricaoComunidade == null || qntComunidade == null || fotoComunidade == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Todos os campos são obrigatórios.");
            return;
        }

        try {
            // Cria o objeto Comunidade com os dados fornecidos
            Comunidade comunidade = new Comunidade(
                    Integer.parseInt(idComunidade),
                    nomeComunidade,
                    criadorComunidade,
                    descricaoComunidade,
                    Integer.parseInt(qntComunidade),
                    fotoComunidade
            );

            // Atualiza a comunidade no banco de dados
            ComunidadeDAO comunidadeDAO = new ComunidadeDAO();
            boolean certo = comunidadeDAO.editarComunidadePorId(comunidade);

            // Cria o log de edição
            Log log = new Log(
                    "Editar",
                    "Comunidade",
                    "Comunidade atualizada Novo nome: " + nomeComunidade +
                    ", Novo criador: " + criadorComunidade + ", Nova descricão: " + descricaoComunidade +
                    ", Nova quantidade de integrantes: " + qntComunidade + ", Nova foto de perfil: " + fotoComunidade +
                    " com ID: " + idComunidade, idAdm);

            // Cria o objeto LogDAO para inserir o log no banco de dados
            LogDAO logDAO = new LogDAO();

            // Insere o log no banco de dados
            boolean logCerto = logDAO.inserirLog(log);

            // Verifica se tanto a atualização da comunidade quanto o log foram bem-sucedidos
            if (certo && logCerto) {
                // Define a mensagem de sucesso na sessão e redireciona para a lista de comunidades
                request.getSession().setAttribute("successMessage", "Comunidade editada com sucesso!");
                response.sendRedirect(request.getContextPath() + "/comunidade");
            } else {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao editar comunidade.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Retorna erro em caso de problemas com o banco de dados
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro SQL exception ao editar comunidade.");
        } catch (NumberFormatException e) {
            // Retorna erro se houver um problema com a conversão de dados numéricos
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID ou valores numéricos inválidos.");
        }
    }
}
