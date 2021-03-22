package servlets;

import DAO.CategoryDAO;
import DAO.DiscoveryDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("")
public class HomeServlet extends HttpServlet {

    private CategoryDAO categoryDAO = new CategoryDAO();
    private DiscoveryDAO discoveryDAO = new DiscoveryDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("discoveries", discoveryDAO.findAll());
        request.setAttribute("categories", categoryDAO.findAll());

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}

