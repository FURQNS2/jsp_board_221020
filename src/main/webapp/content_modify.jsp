<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 글보기</title>
</head>
<body>
	<h2>자유게시판 글 내용수정</h2>
	<hr>
	<table width="600" border="1" cellpadding="0" cellspacing="0">
	<form action="modify.do">
		<input type="hidden" name="bid" value="${content.bid }">  //히튼이라서 값은 보이지 않음
		
		<tr>
			<td align="center" bgcolor="#D4F4FA">제목</td>
			<td><input type="text" value="${content.btitle }" size="80" name="btitle"></td>
		</tr>
		<tr>
			<td align="center" bgcolor="#D4F4FA">글쓴이</td>
			<td><input type="text" value="${content.bname }" size="80" name="bname"></td>
		</tr>
		<tr>
			<td align="center" bgcolor="#D4F4FA">등록일</td>
			<td>${content.bdate }</td>
		</tr>
		<tr>
			<td align="center" bgcolor="#D4F4FA">조회수</td>
			<td>${content.bhit }</td>
		</tr>
		<tr height="200">
			<td valign="top" bgcolor="#D4F4FA">내용</td>
			<td valign="top">
				<textarea rows="12" cols="60" name="bcontent">${content.bcontent }</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="수정완료" onclick="javascript:window.loction='content_modify.do'">
				<input type="button" value="글목록" onclick="javascript:window.loction='list.do'">
			</td>
		</tr>
	</form>
	</table>
	
	
</body>
</html>