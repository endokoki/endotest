package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.ast.StringLiteral;

/**
 * Servlet implementation class Endo1
 */
@WebServlet("/Endo1")
public class Endo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Endo1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		URL obj = new URL("http://www.yahoo.co.jp");
	    URLConnection conn = obj.openConnection();

	   //get all headers
	    Map<String, List<String>> map = conn.getHeaderFields();
	    for (Map.Entry<String, List<String>> entry : map.entrySet()) {
	        response.getWriter().println( entry.getKey() + " : " + entry.getValue() + "<br>");
	    }

	   //get header by 'key'
	    String server = conn.getHeaderField("Server");

		
		response.getWriter().println("<hr>");
		
		Enumeration headernames = request.getHeaderNames();
		 while (headernames.hasMoreElements()){
		      String name = (String)headernames.nextElement();
		      Enumeration headervals = request.getHeaders(name);
		      while (headervals.hasMoreElements()){
		        String val = (String)headervals.nextElement();
		        response.getWriter().println(name + " : " + val + "<br>\n");
		      }
		 }
		
	}


}
