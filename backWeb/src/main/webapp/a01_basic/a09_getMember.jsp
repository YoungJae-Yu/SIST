<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "backWeb.z01_vo.Member"
    import = "backWeb.a01_dao.A05_MemberDao"
    import = "backWeb.z01_vo.Manager"
    import = "backWeb.a01_dao.A04_PreParedDao"
    import = "java.util.List"
    %>
<%
	A04_PreParedDao dao2 = new A04_PreParedDao();
	List<Manager> mlist = dao2.getManager();	
	A05_MemberDao dao = new A05_MemberDao();
	Member m = dao.login("himan","7777");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>로그인한 정보</h2>
	<h3>아이디:<%=m.getId()%> </h3>
	<h3>이름:<%=m.getName()%> </h3>
	<h3>권한:<%=m.getAuth()%> </h3>
<%--
# dao를 불러와서 처리되는 내용
1. 전체 조회
2. 특정 단일 데이터 상세 확인(등록/수정/삭제)
3. combo형태의 데이터 처리(*)
	select
	checbox
	radio

# 관리자 정보를 select에 가져와서 검색할 때
관리자:[select     ] 검색/상세/등록/수정화면
1. 관리자 combox 처리 화면 UI만들기
	관리자:[전체선택]
		홍길동(부서명) ==> 1001
		김길동(부서명) ==> 1002
		신길동(부서명) ==> 1003
2. sql 작성
	SELECT EMPNO , ename, dname
	FROM emp e, dept d
	WHERE e.DEPTNO = d.DEPTNO 
	AND empno IN(
		SELECT DISTINCT mgr FROM EMP e
	);
3. VO를 작성 관리자번호, 부서명, 관리자명
	backWeb.z01_vo.Manager
	
4. Dao 메서드 추가
	backWeb.a01_dao.A04_PreParedDao
	public List<Manager> getManager()
	데이터의 형태에 따라 단일 컬럼으로 나올 경우
	public List<String> getList()
5. jsp
	import vo/dao
	객체 생성
	화면에 forEach문 처리...
 --%>
	<h2>관리자 콤보</h2>
	관리자명:<select name="mgr" onchange="alert(this.value)">
		<option value="0">선택하세요!!</option>
		<%for(Manager mgr:mlist){%>
		<option value='<%=mgr.getEmpno()%>'>
		<%=mgr.getEname()%>(<%=mgr.getDname()%>)</option>
		<%}%>
	</select>
</body>
</html>













