package servlets;

import DAO.UserDAO;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("loginUsername");
        String password = request.getParameter("loginPassword");

        UserDAO userDAO = new UserDAO();
        try {
            User user = userDAO.login(username, password);
            if(user != null){
                HttpSession session = request.getSession();
                session.setAttribute("userName", user);
                response.sendRedirect("http://localhost:8090");
            }else{
                response.sendRedirect("login");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }
}
