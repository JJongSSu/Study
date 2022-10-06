<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Random" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String[] menu = {"원 디그리 노스","정면","필레터","개성만두 궁","게방식당","광화문 국밥","교다이야","교양식사","구복만두","금돼지식당","꽃,밥에피다","꿉당","남포면옥","대성집","마포옥","만두집","만족오향족발","멘텐","명동교자","미미면가","미진","베이스 이즈 나이스","봉산옥","봉피양","부촌육회","삼청동 수제비","소이연남마오","스바루","안씨 막걸리","야키토리 묵","양양 메밀 막국수","에그 앤 플라워","역전회관","오레노 라멘","옥동식","용금옥","우래옥","우육면관","유림면","임병주 산동 칼국수","자하 손만두","정육면체","정인면옥","진미 평양냉면","진진","툭툭 누들타이","팀호완","팩피","피양콩 할마니","필동면옥","하동관","할매집","합정옥","현우동","화해당","황금콩밭","황생가 칼국수"};
	Random ran = new Random();
	int index = ran.nextInt(menu.length);	//0~1사이 length 출력
%>
오늘의 추천 메뉴 : <%=menu[index] %>
<br>
<a href="launchmenu.html">돌아가기</a>
</body>
</html>