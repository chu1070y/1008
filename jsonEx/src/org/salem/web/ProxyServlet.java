package org.salem.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProxyServlet
 */
@WebServlet("/proxy")
public class ProxyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProxyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application/json");
		
//		response.getWriter().print("{\"age\":16}");
		
		URL url = new URL("http://10.10.10.90:8080/jsonEx/proxy");
		
		InputStream in = url.openStream();	
		
		byte[] buffer = new byte[1024*8];
		
		OutputStream os = response.getOutputStream();
		
		while(true) {
			int count = in.read(buffer);
			
			if (count == -1) {
				break;
			}
			
			os.write(buffer, 0, count);
			
		}
	}

}
