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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This is a simple example of an HTTP Servlet. It responds to the GET method of
 * the HTTP protocol.
 */
@WebServlet("/greeting")
public class GreetingServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html");
        response.setBufferSize(8192);
        try (PrintWriter out = response.getWriter()) {
            out.println("<html lang=\"en\">"
                    + "<head><title>Customer Survey</title></head>");
            
            // then write the data of the response
            out.println("<body bgcolor=\"#ffffff\">"
                    + "<img src=\"resources/images/duke.waving.gif\" "
                    + "alt=\"Duke waving his hand\">"

                    + "<form method=\"get\">"
                    + "<h2>Please take a brief moment to complete our Customer Survey!</h2>"
                    + "<b>First Name: </b>"
                    + "<input title=\"My first name is: \"type=\"text\"name=\"firstName\"size=\"25\"required=\"true\"/>"
                    + "<p></p>"
                    + "<b>Last Name: </b>"
                    + "<input title=\"My last name is: \"type=\"text\"name=\"lastName\"size=\"25\"required=\"true\"/>"
                    + "<p></p>"
                    + "<b>Email address: </b>"
                    + "<input title=\"My email address is: \"type=\"text\"name=\"email\"size=\"25\"required=\"true\"/>"
                    + "<select name=\"domain\">\n"
                    + "<option value=\"@outlook.com\">@outlook.com</option>\n"
                    + "<option value=\"@gmail.com\">@gmail.com</option>\n"
                    + "<option value=\"@yahoo.com\">@yahoo.com</option>\n"
                    + "<option value=\"@inbox.com\">@inbox.com</option>\n"
                    + "<option value=\"@icloud.com\">@icloud.com</option>\n"
                    + "<option value=\"@mail.com\">@mail.com</option>\n"
                    + "<option value=\"@aol.com\">@aol.com</option>\n"
                    + "<option value=\"\">other</option>\n"
                    + "</select>"
                    + "<p></p>"
                    + "<b>Birth Date: </b>"
                    + "<input title=\"My birth month is: \"type=\"text\"name=\"month\"size=\"1\"maxlength=\"2\"required=\"true\"/>"
                    + " / "
                    + "<input title=\"My birth day is: \"type=\"text\"name=\"day\"size=\"1\"maxlength=\"2\"required=\"true\"/>"
                    + " / "
                    + "<input title=\"My birth year is: \"type=\"text\"name=\"year\"size=\"2\"maxlength=\"4\"required=\"true\"/>"
                    + "<p></p>"
                    + "<input type=\"submit\" value=\"Submit\"/>"
                    + "<input type=\"reset\" value=\"Reset\"/>"
                    + "</form>");

            // gets parameters from form
            String firstName = request.getParameter("firstName");

            if (firstName != null && firstName.length() > 0) {
                RequestDispatcher dispatcher =
                        getServletContext().getRequestDispatcher("/response");
                
                if (dispatcher != null) {
                    dispatcher.include(request, response);
                }
            }
            out.println("</body></html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "The Hello servlet says hello.";

    }
}
