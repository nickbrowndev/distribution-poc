package nb.distribution;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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

        out.println("Hello, nick!");
        out.close();
    }
}
