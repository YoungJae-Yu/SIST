<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="backWeb.saram.CompanyDao"
    import="backWeb.saram_vo.Company"
    import="java.util.*"
%>
<%
	CompanyDao dao = new CompanyDao();
	List<Company> clist = dao.getCompany();
%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>사람인</title>
  <style type="text/css">
    body, h1, h2, h3, p, ul, li {
      margin: 0;
      padding: 0;
    }
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
    }
    header {
      background-color: #ffffff;
      color: #000000;
      padding: 10px;
      display: flex;
      align-items: center;
      justify-content: space-between;
      border: solid 1px;
    }
    .logo img {
      height: 40px;
      width: auto;
      padding-left: 200px;
    }
    nav ul {
      list-style: none;
      display: flex;
    }
    nav ul li {
      margin-right: 10px;
    }
    nav ul li a {
      color: #000000;
      text-decoration: none;
      padding: 5px 10px;
    }
    main {
      max-width: 100%;
      margin: 20px auto;
      padding: 20px;
      background-color: #dbe7ffd5;
      border: 1px solid #ccc;
      border-radius: 5px;
    }
    #banner {
      text-align: center;
      margin-bottom: 20px;
    }
    #banner h1 {
      font-size: 32px;
      margin-bottom: 10px;
    }
    #banner p {
      color: #666;
      margin-bottom: 20px;
    }
    .cta-button {
      display: inline-block;
      padding: 10px 20px;
      background-color: #c3e1ff;
      color: #000000;
      text-decoration: none;
      border: solid 1px;
      border-radius: 5px;
      border-color: #000000;
    }
    #job-listings h2 {
      margin-bottom: 10px;
      padding-left: 200px;
    }
    #job-listings ul {
      list-style: none;
      padding-left: 200px;
    }
    #job-listings li {
      border-bottom: 1px solid #ccc;
      padding: 10px 0;
    }
    footer {
      text-align: center;
      background-color: #333;
      color: #fff;
      padding: 10px;
    }
    .search-container {
      display: flex;
      justify-content: center;
      align-items: center;
      height: 50px;
    }
    .search-box {
      padding: 11px;
      font-size: 16px;
      border: 3px solid #9292f5;
      border-radius: 4px;
      width: 600px;
    }
    .main-menu {
      display: flex;
      margin-top: 3px;
      padding-left: 200px;
    }
    .main-menu li{
      list-style: none;
      padding: 15px;
      background-color: #f4f4f4;
      transition: transform 0.3s ease-in-out;
    }
    .main-menu li:hover {
      transform: scale(1.1);
      font-size: 20px;
    }
    .main-menu li a{
      padding: 15px;
      transition: transform 0.3s ease-in-out;
      text-decoration-line:none;
      color: #333;
    }
    .box-container {
        display: flex;
        justify-content: center;
    }
    .box {
      border: 2px solid #3d43b6;
      padding: 10px;
      width: 280px;
      height: 100px;
      text-align: center;
      margin: 0 10px;
      font-size: 30px;
    }
  </style>
</head>
<body>
  <header>
    <div class="logo">
      <img src="..\Users\user\로고2.png" alt="사람인 로고">
    </div>
    <div class="search-container">
      <input type="text" placeholder="땡큐 베리 매치, 사람인! " class="search-box">
    </div>
    <nav>
      <ul style="padding-right: 200px;">
        <li><a href="loginForm.html">로그인</a></li>
        <li><a href="joinForm.html">회원가입</a></li>
        <li><a href="#">프로필 등록</a></li>
        <li><a href="..\company\companyMainForm.html">기업서비스</a></li>
      </ul>
    </nav>
  </header>
  <ul class="main-menu">
    <li><a href="#">채용정보</a></li>
    <li><a href="#">포지션MATCH</a></li>
    <li><a href="#">신입/인턴</a></li>
    <li><a href="comNotice.html">기업/연봉</a></li>
    <li><a href="#">커리어성장</a></li>
  </ul>
  <main>
    <section id="banner">
      <h1>취업의 시작, 사람인</h1>
      <p>다양한 채용 정보와 인재를 연결합니다.</p>
      <a class="cta-button">채용공고 매치</a>
    </section>
    <section id="job-listings">
      <h2>인기 구인 정보</h2>
      <ul>
        <li>
          <h3>웹 개발자</h3>
          <p>경력 3년 이상 / 서울</p>
        </li>
        <li>
          <h3>마케팅 전문가</h3>
          <p>경력 무관 / 전국</p>
        </li>
        <li>
          <h3>디자이너</h3>
          <p>경력 1년 이상 / 부산</p>
        </li>
      </ul>
    </section>
  </main>
	<% 
	int cnt = 1;
	for(Company c:clist){%>
		<%if(cnt%4==1){%> 
			<div class="box-container"><div class="box">
			<p>기업명:<%=c.getComName()%></p>
			<p>형태:<%=c.getComType()%></p></div>
		<%}else if(cnt%4==0){%> 
			<div class="box"><p>기업명:<%=c.getComName()%></p>
			<p>형태:<%=c.getComType()%></p></div></div><br>
		<%}else{%>
		<div class="box"><p>기업명:<%=c.getComName()%></p>
		<p>형태:<%=c.getComType()%></p></div>
		<%}cnt++;%>
	<%}%>
  <footer>
    <p>Copyright (c) (주)사람인. All rights reserved.</p>
  </footer>
</body>
</html>