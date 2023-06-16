<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="backWeb.saram.SaramInDao"
    import="backWeb.saram_vo.SaramSelect"
    import="backWeb.saram_vo.JobPosting"
    import="backWeb.saram_vo.Match"
    import="java.util.*"
    %>
<%
SaramInDao s = new SaramInDao();
List<SaramSelect> sslist = s.getSaramSelect();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>지역별</title>
<style>
   table {
     border-collapse: collapse;
     width: 100%;
   }
   
   th, td {
     border: 1px solid black;
     padding: 10px;
   }
   
   th {
     background-color: #EDF4FA;
     font-weight: bold;
   }
   
   td {
     text-align: center;
   }
    body {
        font-family: Arial, sans-serif;
    }

    h3 {
        text-align: center;
    }

    .container {
        max-width: 70%;
        margin: 0 auto;
        margin-bottom : 30px;
        padding: 20px;
        background-color: #EFF5FF;
        border: 1px solid;
        border-radius: 4px;
        
    }

    .container2 {
        max-width: 70%;
        margin: 0 auto;
        padding: 20px;
        background-color: #EFF5FF;
        border: 1px solid;
        border-radius: 4px;
        margin-bottom: 50px;
    }
    .container3 {
        max-width: 70%;
        margin: 0 auto;
        padding: 20px;
        background-color: #EFF5FF;
        border: 1px solid;
        border-radius: 4px;
        margin-bottom: 30px;
    }
    .container4 {
        max-width: 70%;
        margin: 0 auto;
        padding: 20px;
        background-color: #EFF5FF;
        border: 1px solid;
        border-radius: 4px;
        margin-bottom: 50px;
    }

    .input-field {
        width: 70%;
        padding: 8px;
        border: 1px solid #cccccc;
        border-radius: 10px;
        box-sizing: border-box;
        margin-bottom: 10px;
    }
    .input-com {
        width: 30%;
        padding: 8px;
        border: 1px solid #cccccc;
        border-radius: 10px;
        box-sizing: border-box;
        margin-bottom: 10px;
    }

    .button {
        width: 40%;
        padding: 8px 16px;
        border: none;
        border-radius: 10px;
        background-color: #4c6aaf;
        color: white;
        cursor: pointer;
        margin-bottom: 10px;
        margin-left: 350px;
        text-align: center;
    }

    .button:hover {
        background-color: #458ea0;
    }
    h6{
        font-family: 맑은고딕;
    }
    
    .logo img {
      height: 40px;
      width: auto;
      padding-left: 200px;
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
      border: 3px solid #a0ff74;
      border-radius: 4px;
      width: 600px;
    }
    .main-menu {
      display: flex;
      margin-top: 3px;
      padding-left: 200px;
    }
    .main-menu li {
      list-style: none;
      padding: 15px;
      background-color: #f4f4f4;
      transition: transform 0.3s ease-in-out;
      cursor: pointer;
    }
    .main-menu li:hover {
      transform: scale(1.1);
      font-size: 20px;
    }
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
</style>
<script>
    function findcom() {
    var comList = document.getElementById("com-list"); //comList의 값을 com-list에 저장
    var selectedOption = comList.options[comList.selectedIndex].text; // 선택된 옵션 가져오기
    var comTextbox = document.getElementById("com"); // 작성될 text 상자 선언
    comTextbox.value = selectedOption; // 선택된 내용 작성
  }
  function findcom2() {
    var comList2 = document.getElementById("com-list2"); 
    var selectedOption = comList2.options[comList2.selectedIndex].text; 
    var comTextbox2 = document.getElementById("com2"); 
    comTextbox2.value = selectedOption; 
  }
  function findcom3() {
       var comList3 = document.getElementById("com-list3"); 
       var selectedOption = comList3.options[comList3.selectedIndex].text; 
       var comTextbox3 = document.getElementById("com3"); 
       comTextbox3.value = selectedOption; 
     }
  function findcom4() {
       var comList4 = document.getElementById("com-list4"); 
       var selectedOption = comList4.options[comList4.selectedIndex].text; 
       var comTextbox4 = document.getElementById("com4"); 
       comTextbox4.value = selectedOption; 
     }
  
</script>
</head>
<body>
  <header>
    <div class="logo">
      <img src="C:\Users\user\Desktop\로고2.png" alt="사람인 로고">
    </div>
    <div class="search-container">
      <input type="text" placeholder="땡큐 베리 매치, 사람인! " class="search-box">
    </div>
    <nav>
      <ul style="padding-right: 200px;">
        <li><a>로그인</a></li>
        <li><a>회원가입</a></li>
        <li><a>프로필 등록</a></li>
        <li><a>기업서비스</a></li>
      </ul>
    </nav>
  </header>
  <ul class="main-menu">
    <li>채용정보</li>
    <li>포지션MATCH</li>
    <li>신입/인턴</li>
    <li>기업/연봉</li>
    <li>커리어성장</li>
    <li>커뮤니티</li>
  </ul>
     <%
   String placeOfWork = request.getParameter("placeOfWork");
   if(placeOfWork==null) placeOfWork="";
   String fieldName = request.getParameter("fieldName");
   if(fieldName==null) fieldName="";
   %>
<form>
    <h3>지역별 공고</h3>
    <div class="container">
        <h6>직업별</h6>
        <div>    
            <select id="com-list"class="input-com" style="text-align: left;" onchange="findcom()">
              <%for(SaramSelect ss:sslist){%>
              <option value="<%=fieldName%>"><%=ss.getIjob()%></option>
              <%}%>
            </select>    
            <input onclick="dice01()" name ="fieldName" type="text" id="com" class="input-com">
          </div>
          <h6>지역별</h6>
        <div>    
            <select id="com-list2" class="input-com" style="text-align: left;" onchange="findcom2()">
              <%for(SaramSelect ss:sslist){%>
              <option value="<%=placeOfWork%>"><%=ss.getIloc()%></option>
              <%}%>
            </select>   
            <input type="text" id="com2" name ="placeOfWork" class="input-com">
          </div>
          <input type="submit" class="button"value="검색"/>
          </div>
          <div align="center">
          <div class="container2">
          <h2>기업 공고</h2>
          <hr>
   <div>
          <table border>
   <tr><th>회사명</th><th>연락처</th><th>지역</th><th>모집분야</th>
       <th>담당업무</th><th>학력</th><th>연봉</th><th>채용일자</th><th>접수방법</th><tr>
   <%
   SaramInDao dao = new SaramInDao();
   Map<String,String> sch = new HashMap<String,String>();
   sch.put("fieldName",fieldName);
   sch.put("placeOfWork",placeOfWork);
   for(JobPosting p: dao.getPostList(sch)){ 
   %>
   <tr>
        <td><%=p.getComName()%></td>
        <td><%=p.getPhoneNum()%></td>
        <td><%=p.getPlaceOfWork()%></td>
        <td><%=p.getFieldName()%></td>
        <td><%=p.getTaskInCharge()%></td>
        <td><%=p.getEducation()%></td>
        <td><%=p.getSalary()%></td>
        <td><%=p.getRecruitmentDate()%></td>
        <td><%=p.getReceptionMethod()%></td>
   </tr>
   <%}%>
   </table>
   </div>
   </div>
   </div>
    </form>
    
<form>
<%

%>
    <h3>MATCH</h3>
    <div class="container3">
    <%--
        <h6>직업별</h6>
        <div>    
            <select id="com-list3"class="input-com" style="text-align: left;" onchange="findcom3()">
              <%for(SaramSelect ss:sslist){%>
              <option value="<%=fieldName%>"><%=ss.getIjob()%></option>
              <%}%>
            </select>    
            <input name ="compaName" type="text" id="com3" class="input-com">
          </div>
          --%>
          <h6>지역별</h6>
        <div>    
            <select id="com-list4" class="input-com" style="text-align: left;" onchange="findcom4()">
              <%for(SaramSelect ss:sslist){%>
              <option value="<%=placeOfWork%>"><%=ss.getIloc()%></option>
              <%}%>
            </select>   
            <input type="text" id="com4" name ="placeOfWork" class="input-com">
          </div>
          <input type="submit" class="button"value="검색"/>
          </div>
          <div align="center">
          <div class="container4">
          <h2>MATCH List</h2>
          <hr>
   <div>
          <table border>
   <tr><th>회사명</th><th>연락처</th><th>모집분야</th>
       <th>담당업무</th><th>학력</th><th>연봉</th><th>채용일자</th><tr>
   <%
   Map<String,String> sch1 = new HashMap<String,String>();
   sch1.put("placeOfWork",placeOfWork);
   for(Match m:dao.getMatch(sch1)){
   %>
   <tr>
        <td><%=m.getPlaceOfWork()%></td>
        <td><%=m.getComName()%></td>
        <td><%=m.getMemCareer()%></td>
        <td><%=m.getHopeWorktype()%></td>
        <td><%=m.getFieldName()%></td>
        <td><%=m.getSalary()%></td>
        <td><%=m.getReceptionMethod()%></td>
   </tr>
   <%}%>
   </table>
   </div>
   </div>
   </div>
    </form>    
</body>
</html>