<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
   href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
   rel="stylesheet">
<script
   src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<title>관리자 페이지</title>
</head>
<script>
   function prd13() {
      if (eventCode == 13) {
         prd()
      }
   }
   function prd() {
      var titleVal = document.querySelector("#title").value
      var refnoVal = document.querySelector("#refno").value
      var qrStr = "title=" + titleVal+"&refno="+refnoVal
      var xhr = new XMLHttpRequest()
      xhr.open("post", "prdList.jsp", true)
      xhr.setRequestHeader("Content-Type",
            "application/x-www-form-urlencoded")
      xhr.send(qrStr)
      xhr.onreadystatechange = function() {
         if (xhr.status == 200 && xhr.readyState == 4) {
            var pList = JSON.parse(xhr.responseText)
            var pObj = document.querySelector("#prdShow")
            var show = ""
            pList.forEach(function(p) {
               show += "<tr class='text-center'>"
               show += "<th>" + p.prdno + "</th>"
               show += "<th>" + p.title + "</th>"
               show += "<th>" + (p.val==undefined?'':p.val) + "</th>"
               show += "<th>" + p.refno + "</th>"
               show += "<th>" + p.ordno + "</th>"
               show += "</tr>"
            })
            pObj.innerHTML = show
         }

      }

   }

</script>
<body>
<div class="container mt-3">
      <h2>제품 등록/수정/삭제</h2>
      <div class="mb-3 mt-3">
         <label for="title">제품명:</label> <input type="text"
            onkeyup="prd13()" class="form-control" id="title"
            placeholder="제목 입력" name="title">
         <label for="">상위코드:</label> <input type="text"
            value="0" onkeyup="prd13()" class="form-control" id="refno"
            placeholder="상위코드 입력" name="refno">
      </div>
      <button id="insertModal" 
         type="button" class="btn btn-success" data-bs-toggle="modal"
         data-bs-target="#alcoholModal">술 등록</button>
      <button id="insertModal"
         type="button" class="btn btn-success" data-bs-toggle="modal"
         data-bs-target="#snackModal">안주 등록</button>
      <button type="button" onclick="prd()" class="btn btn-primary">조회</button>
      <table class="table table-striped table-hover">
         <thead class="table-success">
            <tr class="text-center">
               <th>제품번호</th>
               <th>제품명</th>
               <th>값</th>
               <th>상위번호</th>
               <th>정렬순서</th>
            </tr>
         </thead>
         <tbody id="prdShow">
         </tbody>
      </table>
   </div>
   <div class="modal" id="alcoholModal">
      <div class="modal-dialog">
         <div class="modal-content">
            <div class="modal-header">
               <h4 class="modal-title">술 등록</h4>
               <button type="button" id="modalClsBtnA" class="btn-close" data-bs-dismiss="modal"></button>
            </div>
            <form id="regFrm">
            <div class="modal-body">
               <div class="mb-3 mt-3">
                  <label for="titleA">제목:</label> <input type="text"
                     class="form-control" id="titleA"
                     placeholder="타이틀 입력" name="titleA">
               </div>
               <div class="mb-3 mt-3">
                  <label for="valA">값:</label> <input type="text"
                     class="form-control" id="valA"
                     placeholder="값 입력" name="valA">
               </div>
               <div class="mb-3 mt-3">
                  <label for="refnoA">상위번호:</label> <input type="text"
                     class="form-control" id="refnoA"
                     placeholder="상위번호 입력" name="refnoA">
               </div>
               <div class="mb-3 mt-3">
                  <label for="ordnoA">정렬순서:</label> <input type="number"
                     class="form-control" id="ordnoA"
                     placeholder="정렬순서 입력" name="ordnoA">
               </div>
               <div class="mb-3 mt-3">
                  <label for="UDA">물건코드:</label> <input type="number"
                     class="form-control" id="UDA"
                     placeholder="코드 입력(수정/삭제)" name="UDA">
               </div>
            </div>
            </form>   
            <div class="modal-footer">
               <button onclick="saveAlcohol()" type="button" class="btn btn-success">
                  등록</button>
               <button onclick="updateA()" type="button" class="btn btn-primary">
                  수정</button>
               <button onclick="deleteA()" type="button" class="btn btn-warning">
                  삭제</button>
               <button type="button" class="btn btn-danger"
                  data-bs-dismiss="modal">취소</button>
            </div>
         </div>
      </div>
   </div>
   <div class="modal" id="snackModal">
      <div class="modal-dialog">
         <div class="modal-content">
            <div class="modal-header">
               <h4 class="modal-title">안주 등록</h4>
               <button type="button" id="modalClsBtnS" class="btn-close" data-bs-dismiss="modal"></button>
            </div>
            <form id="regFrm">
            <div class="modal-body">
               <div class="mb-3 mt-3">
                  <label for="titleSN">제목:</label> <input type="text"
                     class="form-control" id="titleSN"
                     placeholder="타이틀 입력" name="titleSN">
               </div>
               <div class="mb-3 mt-3">
                  <label for="valSN">값:</label> <input type="text"
                     class="form-control" id="valSN"
                     placeholder="값 입력" name="valSN">
               </div>
               <div class="mb-3 mt-3">
                  <label for="refno">상위번호:</label> <input type="text"
                     class="form-control" id="refnoSN"
                     placeholder="상위번호 입력" name="refnoSN">
               </div>
               <div class="mb-3 mt-3">
                  <label for="ordnoSN">정렬순서:</label> <input type="number"
                     class="form-control" id="ordnoSN"
                     placeholder="정렬순서 입력" name="ordnoSN">
               </div>
               <div class="mb-3 mt-3">
                  <label for="UDSN">물건코드:</label> <input type="number"
                     class="form-control" id="UDSN"
                     placeholder="코드 입력(수정/삭제)" name="UDSN">
               </div>
            </div>
            </form>   
            <div class="modal-footer">
               <button onclick="saveSnack()" type="button" class="btn btn-success">
                  등록</button>
               <button onclick="updateSN()" type="button" class="btn btn-primary">
                  수정</button>
               <button onclick="deleteSN()" type="button" class="btn btn-warning">
                  삭제</button>
               <button type="button" class="btn btn-danger"
                  data-bs-dismiss="modal">취소</button>
            </div>
            
         </div>
      </div>
   </div>
   <script>
      function saveAlcohol(){
         var title = document.querySelector("#alcoholModal .modal-body #titleA").value
         var val = document.querySelector("#alcoholModal .modal-body #valA").value
         var refno = document.querySelector("#alcoholModal .modal-body #refnoA").value
         var ordno = document.querySelector("#alcoholModal .modal-body #ordnoA").value
         // ?title=매실원주&refno=6&ordno=1&val=매실원주
         var qStr = "title="+title+"&refno="+refno+"&ordno="+ordno+"&val="+val
         var xhr = new XMLHttpRequest();
         xhr.open("post","/frontWeb/AlcoholServlet",true)
         xhr.setRequestHeader("Content-Type",
               "application/x-www-form-urlencoded")
         xhr.send(qStr)
         xhr.onreadystatechange=function(){
            if(xhr.readyState==4&&xhr.status==200) {
               var resultA = xhr.responseText
               if(resultA=="Y"){
                  alert("등록 성공")
                  prd()
                  document.querySelector("#alcoholModal #regFrm").reset()
                  if(!confirm("계속 등록하시겠습니까?")){
                     // 창닫기 처리
                     document.querySelector("#modalClsBtnA").click()
                  }
               }else {
                  alert("등록 실패")
               }
            }
         }
         
      }
      prd()
      
      function updateA(){
          var title = document.querySelector("#alcoholModal .modal-body #titleA").value
          var val = document.querySelector("#alcoholModal .modal-body #valA").value
          var refno = document.querySelector("#alcoholModal .modal-body #refnoA").value
          var ordno = document.querySelector("#alcoholModal .modal-body #ordnoA").value
          var prdno = document.querySelector("#alcoholModal .modal-body #UDA").value
          var qStr = "prdno="+prdno+"&title="+title+"&refno="+refno+"&ordno="+
          		ordno+"&val="+val
          var xhr = new XMLHttpRequest();
          xhr.open("post","/frontWeb/AlcoholServletUdt",true)
          xhr.setRequestHeader("Content-Type",
                "application/x-www-form-urlencoded")
          xhr.send(qStr)
          console.log(qStr)
          xhr.onreadystatechange=function(){
             if(xhr.readyState==4&&xhr.status==200) {
                var resultA = xhr.responseText
                if(resultA=="Y"){
                   alert("수정 성공")
                   prd()
                   document.querySelector("#alcoholModal #regFrm").reset()
                   if(!confirm("계속 수정하시겠습니까?")){
                      // 창닫기 처리
                      document.querySelector("#modalClsBtnA").click()
                   }
                }else {
                   alert("수정 실패")
                }
             }
          }
      }
      function updateSN(){
          var title = document.querySelector("#snackModal .modal-body #titleSN").value
          var val = document.querySelector("#snackModal .modal-body #valSN").value
          var refno = document.querySelector("#snackModal .modal-body #refnoSN").value
          var ordno = document.querySelector("#snackModal .modal-body #ordnoSN").value
          var prdno = document.querySelector("#snackModal .modal-body #UDSN").value
          // ?title=매실원주&refno=6&ordno=1&val=매실원주
          var qStr = "prdno="+prdno+"&title="+title+"&refno="+refno+"&ordno="+ordno+"&val="+val
          var xhr = new XMLHttpRequest();
          xhr.open("post","/frontWeb/SnackServletUdt",true)
          xhr.setRequestHeader("Content-Type",
                "application/x-www-form-urlencoded")
          xhr.send(qStr)
          console.log(qStr)
          xhr.onreadystatechange=function(){
             if(xhr.readyState==4&&xhr.status==200) {
                var resultA = xhr.responseText
                if(resultA=="Y"){
                   alert("수정 성공")
                   prd()
                   document.querySelector("#snackModal #regFrm").reset()
                   if(!confirm("계속 수정하시겠습니까?")){
                      // 창닫기 처리
                      document.querySelector("#modalClsBtnS").click()
                   }
                }else {
                   alert("수정 실패")
                }
             }
          }
      }
      function deleteA(){
          var prdno = document.querySelector("#alcoholModal .modal-body #UDA").value
          // ?title=매실원주&refno=6&ordno=1&val=매실원주
          var qStr = "prdno="+prdno
          var xhr = new XMLHttpRequest();
          xhr.open("post","/frontWeb/AlcoholServletDel",true)
          xhr.setRequestHeader("Content-Type",
                "application/x-www-form-urlencoded")
          xhr.send(qStr)
          xhr.onreadystatechange=function(){
             if(xhr.readyState==4&&xhr.status==200) {
                var resultA = xhr.responseText
                if(resultA=="Y"){
                   alert("삭제 성공")
                   prd()
                   document.querySelector("#alcoholModal #regFrm").reset()
                   if(!confirm("계속 삭제하시겠습니까?")){
                      // 창닫기 처리
                      document.querySelector("#modalClsBtnA").click()
                   }
                }else {
                   alert("삭제 실패")
                }
             }
          }
      }
      function deleteSN(){
          var prdno = document.querySelector("#snackModal .modal-body #UDSN").value
          // ?title=매실원주&refno=6&ordno=1&val=매실원주
          var qStr = "prdno="+prdno
          var xhr = new XMLHttpRequest();
          xhr.open("post","/frontWeb/SnackServletDel",true)
          xhr.setRequestHeader("Content-Type",
                "application/x-www-form-urlencoded")
          xhr.send(qStr)
          xhr.onreadystatechange=function(){
             if(xhr.readyState==4&&xhr.status==200) {
                var resultA = xhr.responseText
                if(resultA=="Y"){
                   alert("삭제 성공")
                   prd()
                   document.querySelector("#snackModal #regFrm").reset()
                   if(!confirm("계속 삭제하시겠습니까?")){
                      // 창닫기 처리
                      document.querySelector("#modalClsBtnS").click()
                   }
                }else {
                   alert("삭제 실패")
                }
             }
          }
      }
      function saveSnack(){
         var title = document.querySelector("#snackModal .modal-body #titleSN").value
         var val = document.querySelector("#snackModal .modal-body #valSN").value
         var refno = document.querySelector("#snackModal .modal-body #refnoSN").value
         var ordno = document.querySelector("#snackModal .modal-body #ordnoSN").value
         // ?title=매실원주&refno=6&ordno=1&val=매실원주
         var qStr = "title="+title+"&refno="+refno+"&ordno="+ordno+"&val="+val
         
         var xhr = new XMLHttpRequest();
         xhr.open("post","/frontWeb/SnackServlet",true)
         xhr.setRequestHeader("Content-Type",
               "application/x-www-form-urlencoded")
         xhr.send(qStr)
         xhr.onreadystatechange=function(){
            if(xhr.readyState==4&&xhr.status==200) {
               var resultSN = xhr.responseText
               if(resultSN=="Y"){
                  alert("등록 성공")
                  prd()
                  document.querySelector("#snackModal #regFrm").reset()
                  if(!confirm("계속 등록하시겠습니까?")){
                     // 창닫기 처리
                     document.querySelector("#modalClsBtnS").click()
                  }
               }else {
                  alert("등록 실패")
               }
            }
         }
      }
      prd()
   </script>
</body>
</html>