import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import UI.MyUserInterface;
import UI.UserInterface;
import model.Field;
import services.MyDAOimpl;



/**
 * Servlet implementation class Hello
 */
@WebServlet("/data")
public class Hello extends HttpServlet {
	MyDAOimpl dao=new MyDAOimpl();
	
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Hello() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Field field;
		switch (request.getParameter("mode")) {
		case "insert":
			field=new Field();
			field.setId(new BigInteger(request.getParameter("id")));
			field.setKind(new Integer(request.getParameter("kind")));
			field.setIdentifier(request.getParameter("identifier"));
			field.setFullName(request.getParameter("name"));
			field.setStartDate(UserInterface.getDate(request.getParameter("start_date")));
			dao.create(field);
			break;
		case "update":
			field=new Field();
			field.setId(new BigInteger(request.getParameter("id")));
			field.setKind(new Integer(request.getParameter("kind")));
			field.setIdentifier(request.getParameter("identifier"));
			field.setFullName(request.getParameter("name"));
			field.setStartDate(UserInterface.getDate(request.getParameter("start_date")));
			dao.update(field);
			break;
		case "delete":
			int id=new Integer(request.getParameter("id"));
			dao.delete(id);
			break;
		default:
			printData(response);
			break;
		}
		
		

	}
	
	private void printData(HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		List<Field> data=dao.read();
		out.print("<html><body>");
		for(int i=0;i<data.size();i++){
			out.print("<h3>"+data.get(i)+"</h3>");
		}
		out.print("</body></html>");
	}
	
	private void insert(Field field) {
		
	}


}
