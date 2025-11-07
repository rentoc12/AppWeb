package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.ProdutoDao;
import model.Produto;
import java.io.IOException;
import java.util.List;

@WebServlet("/produtos")
public class ProdutoServlet extends HttpServlet {

    private final ProdutoDao dao = new ProdutoDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String nome = req.getParameter("nome");
        double preco = Double.parseDouble(req.getParameter("preco"));
        dao.salvar(new Produto(nome, preco));
        resp.sendRedirect("produtos");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Produto> lista = dao.listar();
        req.setAttribute("lista", lista);
        RequestDispatcher rd = req.getRequestDispatcher("listar.jsp");
        rd.forward(req, resp);
    }
}
