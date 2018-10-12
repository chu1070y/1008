package org.salem.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Webtoon
 */
@WebServlet("/webtoon")
public class Webtoon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String[] arr;	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Webtoon() {
        
    	arr = new String[21];
        
    	for(int i=0; i< arr.length;i++) {
    		
    		String str = "/jsonEx/imgs/1_0";
    		
    		if(i<10) {
    			str += "0" + i + ".jpg";
    		}else {
    			str += i + ".jpg";
    		}
    		
    		arr[i] = str;
    	}
    
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//현재페이지와 어디로 이동할 것인지 방향, 두가지 파라미터가 필요하다.
		String pageStr = request.getParameter("page");
		String direction = request.getParameter("dir");
		
		int page = Integer.parseInt(pageStr);
		
		if(direction.equals("f")) {
			page += 1;
		}else if(direction.equals("p")) {
			page -= 1;
		}
		
		System.out.println("page" + page);
		System.out.println("direction" + direction);
		System.out.println(arr[page]);
		
		//response.setContentType("application/json");
		//response.getWriter().print("{\"dest\":\""+ arr[page]+"\"}");
		
		response.setContentType("application/javascript");
		response.getWriter().print(request.getParameter("callback") +"('"+arr[page]+"')");
		System.out.println("what i want :"+request.getParameter("callback") +"('"+arr[page]+"')");
		
	}

}
