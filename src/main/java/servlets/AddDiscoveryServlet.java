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
        Integer category_id = Integer.parseInt(request.getParameter("categoryId"));

        HttpSession httpSession = request.getSession();
        User user = (User) httpSession.getAttribute("userName");

        System.out.println(title);
        System.out.println(url);
        System.out.println(text);
        System.out.println(LocalDateTime.now());
        System.out.println(category_id);
        System.out.println((Integer)user.getId());


        Discovery discovery = new Discovery();

        discovery.setTitle(title);
        discovery.setUrl(url);
        discovery.setDescription(text);
        discovery.setDateTime(LocalDateTime.now());
        discovery.setCategoryId(category_id);
        discovery.setUserId(user.getId());

        DiscoveryDAO discoveryDAO = new DiscoveryDAO();
        discoveryDAO.create(discovery);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CategoryDAO categoryDAO = new CategoryDAO();
        request.setAttribute("categories", categoryDAO.findAll());

        getServletContext().getRequestDispatcher("/WEB-INF/add_discovery.jsp").forward(request, response);
    }
}
