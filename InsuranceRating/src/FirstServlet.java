

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public FirstServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String uid=request.getParameter("uid");
		String pwd=request.getParameter("pwd");
		String role=new InsuranceDAO().isUser(uid,pwd);
		if(role=="") {
			System.out.println("SOrry invalid username or password");
			RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
			rd.include(request,response);
		}
		else {
			if(role.equals("user")) {
				response.sendRedirect("Mainmenu_user.jsp");
			}
			else if(role.equals("admin")) {
				response.sendRedirect("Mainmenu_admin.jsp");
			}
			}
		}
	doGet(request, response);
	}

}
