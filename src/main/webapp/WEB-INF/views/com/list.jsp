<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>부서 리스트</h4>
	<h5>Locale A</h5>

	<h5>Locale C</h5>

	<h5>Home B</h5>
	
	<div>
		<a href="./create">부서등록</a>
	</div>
	
	<div>
		<table>
			<thead>
				<tr>
					<th>부서번호</th>
					<th>부서명</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.list}" var="d">
					<tr>
						<td>${pageScope.d.departmentId}</td>
						<td><a href="./detail?departmentId=${d.departmentId}">${d.departmentName}</a></td>
					</tr>
					<!-- 
						getter의 이름 : getter메서드에서
						get을 빼고 () 빼고
						첫글자를 소문자로 바꾼거
						ex) getName() => name
					-->
					
					
					
				</c:forEach>
			</tbody>
		</table>
	</div>
	
</body>
</html>