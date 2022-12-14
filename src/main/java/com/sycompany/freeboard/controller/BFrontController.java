package com.sycompany.freeboard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sycompany.freeboard.command.BCommand;
import com.sycompany.freeboard.command.BDeleteCommand;
import com.sycompany.freeboard.command.BListCommand;
import com.sycompany.freeboard.command.BModifyCommand;
import com.sycompany.freeboard.command.BWriteCommand;
import com.sycompany.freeboard.command.BcontentCommand;

/**
 * Servlet implementation class BFreeController
 */
@WebServlet("*.do")
public class BFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();  //클라이언트가 요청한 uri 전부 가져오기
		String conPath = request.getContextPath();
		String comm= uri.substring(conPath.length()); //전체 uri에서 context 경로 길이만큼 빼기
		
		BCommand command = null;
		
		String view = null;
		
		if(comm.equals("/write.do")) {
			System.out.println("write.do 요청!");
			
			command = new BWriteCommand();
			command.execute(request, response);
			
			view ="/list.do";
			
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/list.do");
//			dispatcher.forward(request, response);
			
		}else if(comm.equals("/list.do")){
			System.out.println("list.do 요청!");
			
			command = new BListCommand();
			command.execute(request, response);
			
			view = "/list.jsp";
			
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
//			dispatcher.forward(request, response);
					
		} else if(comm.equals("/write_form.do")) {
			System.out.println("write_form.do 요청");
			
			view = "/write_form.jsp";
			
//			RequestDispatcher dispatcher =request.getRequestDispatcher("/write_form.jsp");
//			dispatcher.forward(request, response);
			
		} else if(comm.equals("/content_view.do")) {
			System.out.println("content_view.do 요청");
			
			view = "/content_view.jsp";
			
			command=new BcontentCommand();
			command.execute(request, response);
			
//			RequestDispatcher dispatcher =request.getRequestDispatcher("/content_view.jsp");
//			dispatcher.forward(request, response);
		} else if(comm.equals("/content_modify.do")) {
			System.out.println("content_modify.do 요청");
			
			command = new BcontentCommand();
			command.execute(request, response);
			
			view = "/content_modify.jsp";
				
//			RequestDispatcher dispatcher =request.getRequestDispatcher("/content_modify.jsp");
//			dispatcher.forward(request, response);
		
		} else if(comm.equals("/modify.do")) {
			System.out.println("modify.do 요청");
			
			
			
			command = new BModifyCommand();
			command.execute(request, response);
			
			view = "/list.do";
				
//			RequestDispatcher dispatcher =request.getRequestDispatcher("/list.do");
//			dispatcher.forward(request, response);
		
		} else if(comm.equals("/delete.do")) {
			System.out.println("delete.do 요청");
			
			command = new BDeleteCommand();
			command.execute(request, response);
			
			view = "/list.do";
				
//			RequestDispatcher dispatcher =request.getRequestDispatcher("/list.do");
//			dispatcher.forward(request, response);
		}
	
		RequestDispatcher dispatcher =request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
		
	}
	
}
