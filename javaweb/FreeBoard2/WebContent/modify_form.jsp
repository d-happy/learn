<%@page import="free.board.BoardVo"%>
<%@page import="free.board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int b_no = Integer.parseInt(request.getParameter("b_no"));
	BoardDao dao = BoardDao.getInstance();
	BoardVo vo = dao.selectArticle(b_no);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>글 수정</title>
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<form role="form" action="modify_run.jsp" method="post">
				<input type="hidden" name="b_no" value="<%=b_no%>"/>
				<div class="form-group">
					<label for="b_title">글제목</label>
					<input type="text" class="form-control" id="b_title" name="b_title"
					value="<%=vo.getB_title() %>"/>
				</div>
				<div class="form-group">
					<label for="b_writer">작성자</label>
					<input type="text" class="form-control" id="b_writer" name="b_writer"
					value="<%=vo.getB_writer() %>" />
				</div>
				<div class="form-group">
					<label for="b_pass">비밀번호</label>
					<input type="password" class="form-control" id="b_pass" name="b_pass"/>
				</div>
				<div class="form-group">
					<label for="b_content">내용</label>
					<textarea class="form-control" id="b_content" 
					name="b_content"><%=vo.getB_content() %></textarea>
				</div>
				<button type="submit" class="btn btn-sm btn-primary">수정완료</button>
			</form>
		</div>
	</div>
</div>
</body>
</html>