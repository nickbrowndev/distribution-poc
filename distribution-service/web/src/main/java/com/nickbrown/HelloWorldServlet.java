package com.nickbrown;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;

/**
 * Created by nick on 01/03/15.
 */
public class HelloWorldServlet extends HttpServlet {

    @Override
    public void doGet (HttpServletRequest req,
                       HttpServletResponse res)
            throws ServletException, IOException
    {
        PrintWriter out = res.getWriter();

        out.println("Hello, world!");
        out.close();
    }
}
