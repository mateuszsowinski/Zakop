package servlets;

import DAO.CategoryDAO;
import DAO.DiscoveryDAO;
import domain.Category;
import domain.Discovery;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.registry.infomodel.User;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/category")
public class CategoryServlet extends HttpServlet {
    private CategoryDAO categoryDAO = new CategoryDAO();
    private DiscoveryDAO discoveryDAO = new DiscoveryDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int categoryId = Integer.parseInt(request.getParameter("id"));

        List<Discovery> discovery = discoveryDAO.findId(categoryId);
        Category categories = categoryDAO.findID(categoryId);

        request.setAttribute("category", categories);
        request.setAttribute("discovery", discovery);

        getServletContext().getRequestDispatcher("/WEB-INF/category.jsp").forward(request, response);
    }
}
