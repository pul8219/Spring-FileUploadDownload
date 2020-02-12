<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>file upload</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
</head>

<body>
<form action="fileupload.do" method="post" enctype="multipart/form-data" id="form-upload">
<input type="file" name="filename" id="filename">
<input type="submit" value="upload">
</form>
<%-- <h2>Uploaded File List</h2>
<table style="border: 1px solid lightgray">
	<colgroup>
		<col width="70%" />
		<col width="30%" />
	</colgroup>
	<thead>
	<tr>
		<th scope="col">파일명</th>
		<th scope="col">파일 크기</th>
	</tr>
	</thead>
	<tbody>
		<c:choose>
		<c:when test="${fn:length(list) > 0 }">
			<c:forEach items="${list}" var="item">
				<tr>
					<td>${item.FILE_NAME}</td>
					<td>${item.FILE_SIZE}</td>
				</tr>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<tr>
				<td colspan="2">조회된 결과가 없습니다.</td>
			</tr>
		</c:otherwise>
		</c:choose>
	</tbody>
</table> --%>






</body>

<script type="text/javascript">
	
</script>

</html>