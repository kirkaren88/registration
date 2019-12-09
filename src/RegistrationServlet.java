import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RegistrationServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPass");
        String userEmail = request.getParameter("userEmail");

        if (userName.equals("") && userEmail.equals("") && userPassword.equals("")) {
            int status = RegisterDao.registerUser(new User(userName, userEmail, userPassword));
            if (status > 0) {
                out.println("You are successfully registered...");
            }
        } else {
            out.println("Please enter all fields!");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.include(request, response);
        }
        out.close();
    }
}