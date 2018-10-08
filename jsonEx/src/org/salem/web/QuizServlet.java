package org.salem.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class QuizServlet
 */
@WebServlet("/quiz")
public class QuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuizServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html;charset=UTF-8");
		response.setContentType("application/json");
		
		Quiz quiz = new Quiz("���� ����!! �� �̸��� �����ϱ��?",new String[] {"1.����","2.����","3.����"},"1");
		
		Gson gson = new Gson();
		String json = gson.toJson(quiz);
		
		response.getWriter().print(json);
		
	}

}
