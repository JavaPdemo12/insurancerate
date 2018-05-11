

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class InsuranceDAO
 */
public class InsuranceDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     * @return 
     */
    public UserBean InsuranceDAO() {
        // TODO Auto-generated constructor stub
   
    UserBean isUser(String uid,String pwd) {
    	UserBean details=new UserBean();
    
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    	
    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hello","root","root");
    	String role="";
    	Statement stmt= (Statement) con.createStatement();
    	ResultSet rs=stmt.executeQuery("select role from underwriter");
    	while(rs.next())
    	{
    		details.setRole(rs.getString(1));
    	details.setUsername(rs.getString(2));
    }
    	rs.close();
    	con.close();
    }
    	 catch (Exception e) {
    	System.out.println(e);	
    	}
    	finally{return details;}
    		
    	}
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
		doGet(request, response);
	}

}
