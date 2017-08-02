/**
 * Copyright (c) 2017 Oracle and/or its affiliates. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software except in
 * compliance with the terms of the License at:
 * http://java.net/projects/javaeetutorial/pages/BerkeleyLicense
 */
package javaeetutorial.hello2;


import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This is a simple example of an HTTP Servlet.  It responds to the GET
 * method of the HTTP protocol.
 */
@WebServlet("/response")
public class ResponseServlet extends HttpServlet {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy - HH:mm:ss");

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {

            // get parameters
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String domain = request.getParameter("domain");
            String month = request.getParameter("month");
            String day = request.getParameter("day");
            String year = request.getParameter("year");

            // response header
            LocalDateTime now = LocalDateTime.now();
            out.println("<h2>Thanks for completing our Customer Survey form on " + dtf.format(now) + "</h2><p></p>"
            + "<h3>The data you entered was:</h3><p></p>");

            // print inputs
            if (firstName != null && firstName.length() > 0) {
                out.println("<b>First Name: </b>" + firstName + "<p></p>");
            }
            if (lastName != null && lastName.length() > 0) {
                out.println("<b>Last Name: </b>" + lastName + "<p></p>");
            }
            if (email != null && email.length() > 0 && domain != null) {
                out.println("<b>Email Address: </b>" + email + domain + "<p></p>");
            }
            if (month != null && month.length() == 2 && day != null && day.length() == 2 && year != null && year.length() == 4) {
                out.println("<b>Birth Date: </b>" + month + "/" + day + "/" + year + "<p></p>");
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "The Response servlet says hello.";

    }
}
