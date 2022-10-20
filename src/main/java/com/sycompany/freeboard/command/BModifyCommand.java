package com.sycompany.freeboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sycompany.freeboard.dao.BoardDao;

public class BModifyCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String bname=request.getParameter("bname");
		String btitle=request.getParameter("btitle");
		String bcontent=request.getParameter("bcontent");
		String bid=request.getParameter("bid");
		
		
		BoardDao dao = new BoardDao(); 
		dao.modify(bname, btitle, bcontent, bid);
		
	}

}
