<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="${pageContext.request.contextPath}/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/gallery.css" rel="stylesheet" type="text/css">
</head>


<body>
	<div id="wrap">

		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>

		<div id="container" class="clearfix">
			<div id="aside">
				<h2>갤러리</h2>
				<ul>
					<li><a href="">일반갤러리</a></li>
					<li><a href="">파일첨부연습</a></li>
				</ul>
			</div>
			<!-- //aside -->
			
			<div id="content">
				<div id="content-head">
					<h3>일반갤러리</h3>
					<div id="location">
						<ul>
							<li>홈</li>
							<li>갤러리</li>
							<li class="last">일반갤러리</li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				<!-- //content-head -->
				
				<div id="gallery">
					<div id="list">
						
							<button id="btnImgUpload">이미지올리기</button>
							<div class="clear"></div>

						<ul id="viewArea">
							
							<!-- 이미지반복영역 -->
								<li>
									<div class="view" >
										<img class="imgItem" src="${pageContext.request.contextPath}/assets/image/Gangho-dong.jpg">
										<div class="imgWriter">작성자: <strong>유재석</strong></div>
									</div>
								</li>

								<li>
									<div class="view" >
										<img class="imgItem" src="${pageContext.request.contextPath}/assets/image/Jeongjae-Lee.jpg">
										<div class="imgWriter">작성자: <strong>유재석</strong></div>
									</div>
								</li>

								<li>
									<div class="view" >
										<img class="imgItem" src="${pageContext.request.contextPath}/assets/image/JeonSoMin.jpg">
										<div class="imgWriter">작성자: <strong>유재석</strong></div>
									</div>
								</li>

								<li>
									<div class="view" >
										<img class="imgItem" src="${pageContext.request.contextPath}/assets/image/JiseokJin.jpg">
										<div class="imgWriter">작성자: <strong>유재석</strong></div>
									</div>
								</li>

								<li>
									<div class="view" >
										<img class="imgItem" src="${pageContext.request.contextPath}/assets/image/JungWooSung.jpg">
										<div class="imgWriter">작성자: <strong>유재석</strong></div>
									</div>
								</li>
							<!-- 이미지반복영역 -->
							
						</ul>
					</div>
					<!-- //list -->
				</div>
				<!-- //	gallery -->

			</div>
			<!-- //content  -->

		</div>
		<!-- //container  -->

		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
	</div>
	<!-- //wrap -->

</body>

</html>

