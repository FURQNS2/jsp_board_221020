package com.sycompany.freeboard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sycompany.freeboard.dto.BoardDto;

public class BoardDao {

	static String driverName="com.mysql.jdbc.Driver";   // 어디꺼를 쓰는지 작성
	static String url ="jdbc:mysql://localhost:3306/serverdb";      // 기본 주소 작성
	static String user = "root";    // 관리자 계정
	static String pass = "12345";    // MySql 비밀번호
	
	public void write (String bname, String btitle, String bcontente) {
	
		Connection conn = null;
		PreparedStatement pstmt = null;
	
		String sql="INSERT INTO freeboard(bname, btitle, bcontent, bhit);"
				+ "VALUES ('"+bname+"', '"+btitle+"', '"+bcontente+"', 0)";
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, user, pass);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.executeUpdate(); // sql 실행	
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
			if(pstmt != null ) {
				pstmt.close();
			} 
			if(conn != null) {
				conn.close();
			}
			
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<BoardDto> list() {

			String sql = "SELECT * FROM freeboard ORDER BY bid DESC";

			ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();

			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;//select 문이 반환하는 데이터를 담는 객체 선언
			
			try {
				Class.forName(driverName); // jdbc 드라이버 로딩
				conn = DriverManager.getConnection(url, user, pass);//DB 연동 커넥션 생성
				pstmt = conn.prepareStatement(sql);//sql 객체 생성
				
				rs = pstmt.executeQuery();//sql 실행
				
				while(rs.next()) {
					int bid = rs.getInt("bid");
					String bname = rs.getString("bname");
					String btitle = rs.getString("btitle");
					String bcontent = rs.getString("bcontent");
					String bdate = rs.getString("bdate");
					int bhit = rs.getInt("bhit");
					
					BoardDto dto = new BoardDto(bid, bname, btitle, bcontent, bdate, bhit);

					dtos.add(dto);				
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if(rs != null) {
						rs.close();
					}				
					if(pstmt != null) {
						pstmt.close();
					}
					if(conn !=null) {
						conn.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			return dtos;		
		}

	
	public BoardDto content_view(String boardNum) { //특정번호 글내용가져오기

		String sql="SELECT * FROM freeboard WHERE bid =?;";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		BoardDto dto = null;
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, user, pass);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardNum);
			
			rs=pstmt.executeQuery(); // sql 실행	
	
			if (rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitel");
				String bcontent = rs.getString("bcontent");
				String bdate = rs.getString("bdate");
				int bhit = rs.getInt("bhit");
				
				dto = new BoardDto(bid, bname, btitle, bcontent, bdate, bhit); 
				
			}
	
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
				if(rs != null ) {
					rs.close();
					} 
				if(pstmt != null ) {
					pstmt.close();
				} 
				if(conn != null) {
					conn.close();
				}
				
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return dto; 
		 }
	
	public void modify(String bname, String btitle, String bcontent, String bid) {//특정 번호글의 내용 수정하기
	
	}
}