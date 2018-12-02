package login;
import java.io.IOException;
import java.sql.*;  
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
                String firstname=request.getParameter("firstname");
                String lastname=request.getParameter("lastname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
                            try{  
Class.forName("com.mysql.jdbc.Driver");  
  
Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/database","root","");  
  // for Connection with mysql
PreparedStatement stmt=con.prepareStatement("insert into student  values(?,?,?,?)");  
stmt.setString(1,firstname);  
  stmt.setString(2,lastname);
stmt.setString(3,username);
stmt.setString(4,password);
stmt.executeUpdate();  
System.out.println(" records inserted");  

con.close();  
RequestDispatcher req = request.getRequestDispatcher("swiggy.html");
			req.include(request, response);
}catch(Exception e){ System.out.println(e);}  
                        
		}
	}
 