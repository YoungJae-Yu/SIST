<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <title>Insert title here</title>
</head>
<%--
# 실습과제
[1단계:개념] 1. ajax처리시 서버단 처리와 프런트 처리의 내용을 순차별 기술하고, 핵심 코드를 정리하세요
# 처리 순서
1. 사용할 파일
	1)  a.jsp (프론트처리)
	2) z.jsp (백앤드처리)
2. (백앤드처리) z.jsp?id=himan
	1) 요청값 처리
		String id = request.getParameter("id");
	2) Dao, Vo, gson import
		com.google.gson.Gson
	3) Member m = dao.cjeckMember(id)
	4) if(m!=null){
			<%=gson.toJson(m)%>
		}else
			{"id":""}
3. (프론트처리)
	1) 화면 구현
		id : [   ] [등록여부확인] ==> 클릭시 이벤트 핸들러
	2) 이벤트핸들러 함수
		function asynAjx(page){
			xhr.open("get",page,true)
			xhr.onreadyststechange=function(){
				if(xhr.status==200&&xhr.readyState==4){
					return xhr.responseText;
				}
			}
		}
		function checkMember(){
			var idVal = document.querySelector("#id")
			var memObj = JSON.parse(asynAjx(page))
			if(memObj.id != ""){
				alert(memObj.id+"는 등록된 아이디입니다.")
			}else{
				alert(idVal+"는 등록 가능합니다.")
			}
		}

[1단계:코드] 2. 부서정보를 ajax로 (부서명,부서위치)키워드 검색하여 리스트 처리하세요.
-- Dao -- 
 	public List<Dept> getDeptList(String dname, String loc) {
	    List<Dept> elist = new ArrayList<Dept>();
	    String sql = "SELECT *\r\n"
	    		+ "FROM DEPT d \r\n"
	    		+ "WHERE dname LIKE ?\r\n"
	    		+ "AND LOC LIKE ?";
	    
	    try {
	        con = DB.con();
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, dname);
	        pstmt.setString(2, loc);
	        rs = pstmt.executeQuery();
	        
	
	        while (rs.next()) {
	            elist.add(new Dept(
	                    rs.getInt("deptno"),
	                    rs.getString("dname"),
	                    rs.getString("loc")
	            ));
	        }
	        
-- 230628_data.jsp (백앤드)--
	        <%
String dname = request.getParameter("dname");
if(dname==null)dname="";
String loc = request.getParameter("loc");
if(loc==null)loc="";
A04_PreParedDao dao = new A04_PreParedDao();
List<Dept> getDeptList = dao.getDeptList(dname, loc);
Gson gson  = new Gson();
%>
<%=gson.toJson(getDeptList)%>
 -- 230628.jsp (프론트) --
 --%>
 <script type="text/javascript">
	function schDept() {
		var dnameVal = document.querySelector("#dname").value
		var locVal = document.querySelector("#loc").value
		var qurStr = "dname=" + dnameVal + "&loc=" + locVal
		var xhr = new XMLHttpRequest()
		xhr.open("post", "230628_data.jsp", true)
		xhr.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded")
		xhr.send(qurStr)
		xhr.onreadystatechange = function() {
			console.log(xhr.responseText)
			if (xhr.readyState == 4 && xhr.status == 200) {
				var detpList = JSON.parse(xhr.responseText)
				var deptShow = document.querySelector("#deptShow")
				var show = "";
				detpList.forEach(function(dept) {
					show += "<tr class='text-center'>"
					show += "<td>" + dept.deptno + "</td>"
					show += "<td>" + dept.dname + "</td>"
					show += "<td>" + dept.loc + "</td>"
					show += "</tr>"
				})
				deptShow.innerHTML = show
			}
		}
	}
</script>
<body>
    <div class="container mt-3">
    	<h2>부서정보 검색</h2>
    	<form action="" method="post">
         	<div class="mb-3 mt-3">
            <label for="dname">부서명:</label>
            <input type="text" class="form-control" onkeyup="schDept()"
      	     id="dname" placeholder="부서명 입력" name="dname">
         	</div>
         	<div class="mb-3 mt-3">
            <label for="loc">근무지역:</label>
            <input type="text" class="form-control" onkeyup="schDept()"
      	     id="loc" placeholder="근무지역 입력" name="loc">
         	</div>
         	<button onclick="schDept()" type="button" class="btn btn-primary">조회</button>
     	</form>
		<table class="table table-striped table-hover">
			<thead class="table-success">
		      	<tr class="text-center">
				    <th>부서번호</th>
				    <th>부서이름</th>
				    <th>근무지역</th>
		      	</tr>
		    </thead>
		    <tbody id="deptShow">
		 	</tbody>
		</table>      	
    </div>
</body>
</html>