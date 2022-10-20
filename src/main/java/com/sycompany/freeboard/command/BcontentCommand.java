package com.sycompany.freeboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sycompany.freeboard.dao.BoardDao;
import com.sycompany.freeboard.dto.BoardDto;

public class BcontentCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String bid = request.getParameter("bid");
		
		BoardDao dao = new BoardDao(); 
		BoardDto dto = dao.content_view(bid);
		
		request.setAttribute("content", dto);
	}

}
