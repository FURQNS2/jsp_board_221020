package com.sycompany.freeboard.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sycompany.freeboard.dao.BoardDao;
import com.sycompany.freeboard.dto.BoardDto;


public class BListCommand implements BCommand{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		BoardDao dao = new BoardDao();
		
		ArrayList<BoardDto> dtos = dao.list();
		//dto들의 컬렉션인 dtos가 반환됨
		
		request.setAttribute("list", dtos);
		
		
	}

}
