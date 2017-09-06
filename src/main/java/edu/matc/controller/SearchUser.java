package edu.matc.controller;

import edu.matc.entity.User;
import edu.matc.persistence.UserData;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet(
        urlPatterns = {"/searchUser"}
)

public class SearchUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setContentType("text/html");

        String searchTerm = request.getParameter("searchTerm");
        String searchType = request.getParameter("searchType");
        UserData userData = new UserData();

        request.setAttribute("users", userData.getUserEntered(searchTerm, searchType));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/results.jsp");
        dispatcher.forward(request, response);
    }
}


