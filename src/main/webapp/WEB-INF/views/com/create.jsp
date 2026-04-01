<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>노트 등록 페이지</h3>

	<form action="./create" method="post">
		<div>
			<label>노트내용</label>
			<input type="text" placeholder="노트 입력" name="numNumber">
		</div>
		<div>
			<label>관리자코드</label> <input type="text" name="managerId"
				placeholder="숫자만입력">
		</div>

		<div>
			<label>지역코드</label> <input type="text" name="locationId">
		</div>
		<button type="submit">button</button>
		<input type="submit" value="create"> <input type="button"
			value="등록"> <input type="reset" value="reset">

	</form>
</body>
</html>