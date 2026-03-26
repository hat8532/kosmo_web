<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>부서 등록 페이지</h2>
	<form action="create" method="post">
		<div>
			<label for="ch">부서명</label> <input type="text" id="ch">
		</div>
		
		<div>
			<label for="ch2">관리자코드</label> <input type="text" id="ch2">
		</div>
		
		<div>
			<label>지역코드</label> <input type="text">
		</div>
		
		<button type="submit">button</button>
		<input type="submit" value="create"> <input type="button"
			value="등록"> <input type="reset" value="reset">
	</form>

</body>
</html>