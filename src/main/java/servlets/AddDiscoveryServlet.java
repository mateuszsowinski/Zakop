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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/app/add/discovery")
public class AddDiscoveryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title = request.getParameter("title");
        String url = request.getParameter("url");
        String text = request.getParameter("text");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));

        HttpSession httpSession = request.getSession();
        User user = (User) httpSession.getAttribute("userName");

        Discovery discovery = new Discovery();
        discovery.setTitle(title);
        discovery.setUrl(url);
        discovery.setDescription(text);
        discovery.setCategoryId(categoryId);
        discovery.setDateTime(LocalDateTime.now());
        discovery.setUserId(user.getId()); // do poprawki, trzeba wczytać id zalogowanego użytkownika
//        discovery.setUserId(18);
        DiscoveryDAO discoveryDAO = new DiscoveryDAO();
        discoveryDAO.create(discovery);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CategoryDAO categoryDAO = new CategoryDAO();
        request.setAttribute("categories", categoryDAO.findAll());

        getServletContext().getRequestDispatcher("/WEB-INF/add_discovery.jsp").forward(request, response);
    }
}
