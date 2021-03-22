package servlets;

import DAO.CategoryDAO;
import DAO.DiscoveryDAO;
import DAO.UserDAO;
import domain.Category;
import domain.Discovery;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/adddiscovery")
@ServletSecurity(httpMethodConstraints = {
        @HttpMethodConstraint(value = "GET", rolesAllowed = "USER"),
        @HttpMethodConstraint(value = "POST", rolesAllowed = "USER")
})
public class AddDiscoveryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String loggedInUsername = request.getUserPrincipal().getName();
        String title = request.getParameter("title");
        String url = request.getParameter("url");
        String text = request.getParameter("text");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));

        UserDAO userDAO = new UserDAO();
        userDAO.findIdByName(loggedInUsername);

        Discovery discovery = new Discovery();
        discovery.setTitle(title);
        discovery.setUrl(url);
        discovery.setDescription(text);
        discovery.setCategoryId(categoryId);
        discovery.setDateTime(LocalDateTime.now());
        // discovery.setUserId(); // do poprawki, trzeba wczytać id zalogowanego użytkownika

        DiscoveryDAO discoveryDAO = new DiscoveryDAO();
        discoveryDAO.addDiscovery(discovery);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CategoryDAO categoryDAO = new CategoryDAO();
        request.setAttribute("categories", categoryDAO.findAll());

        getServletContext().getRequestDispatcher("/add_discovery.jsp").forward(request, response);
    }
}
