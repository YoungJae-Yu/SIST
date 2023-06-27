<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="project.janjan.VO.Alcohol"
    import="project.janjan.DAO.AlcoholDao"
    import="java.util.*"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="" />
<meta name="author" content="" />
<link rel="stylesheet" href="./css/store.css">
<link rel="stylesheet" href="./css/reset.css">
<link rel="stylesheet" href="./css/global.css">
<title>잔잔</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
<title>잔잔 스토어</title>
</head>
<%
AlcoholDao dao = new AlcoholDao();
double ranRate = (double)(Math.random()*0.6);

String priceFilterS = request.getParameter("filter-price");

List<Alcohol> alList = new ArrayList<Alcohol>();

if(priceFilterS=="1"){
	alList = dao.getPriceFilter(0, 10000);
}
if(priceFilterS=="2"){
	alList = dao.getPriceFilter(10000, 30000);
}
if(priceFilterS=="3"){
	alList = dao.getPriceFilter(30000, 50000);
}
if(priceFilterS=="4"){
	alList = dao.getPriceFilter(50000, 100000);
}
if(priceFilterS=="5"){
	alList = dao.getPriceFilterOver(100000);
}


%>
<body>
	<div class="wrap">
        <header>
            <div class="inner">
                <div class="gnb">
                    <div class="gnbL">
                        <ul>
                            <li><a href="index.html"><img src="./img/logo.png" class="logo"></a></li>
                            <li><a href="sub.html">구독</a></li>
                            <li><a href="store.html">스토어</a></li>
                        </ul>
                    </div>
                    <div class="gnbR">
                        <ul>
                            <li><a href="login.html">로그인/회원가입</a></li>
                            <li><a href="bag.html"><img src="./img/bag.png" class="bag"></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </header>
        <header>
        <div class="inner">
            <div class="gnb">
                <div class="gnbL">
                    <ul>
                        <li><a href="">술</a></li>
                        <li><a href="">안주</a></li>
                    </ul>
                </div>
            </div>
        </div>    
        </header>
        <header> 
        <div class="inner"> 
            <div class="gnb">
                <div class="gnbL">
                    <ul>
                        <li><a href="">전체상품</a></li>
                        <li><a href="">신상품</a></li>
                        <li><a href="">베스트</a></li>
                    </ul>
                </div>
            </div>
        </div>
        </header>  
        <img class="img-fluid" src="./img/alcoholImg.jpg">
        <div class="position-absolute translate-middle start-50 bottom-50">
            <div class="text-center text-white">
                <h1 class="display-5 fw-bolder">전체 상품</h1>
                <p class="lead fw-normal text-white-50 mb-0">ALCOHOL</p>
            </div>
        </div>
        <div class="inner">
            <section class="py-2">
                    <div class="container px-4 px-lg-5 mt-5">
                    <form method="post">
                        <select name="filter-price" class="select mb-5 me-3" onchange="document.querySelector('form').submit()">
                            <option>==가격 선택==</option>
                            <option value="1">1만원 이하</option>
                            <option value="2">1~3만원</option>
                            <option value="3">3~5만원</option>
                            <option value="4">5~10만원</option>
                            <option value="5">10만원 초과</option>
                        </select>
                        <select name="filter-type" class="select mb-5 me-3" onchange="document.querySelector('form').submit()">
                            <option>==주종 선택==</option>
                            <option value="A-1">탁주</option>
                            <option value="A-2">청주</option>
                            <option value="A-3">증류주</option>
                            <option value="A-4">약주</option>
                            <option value="A-5">과실주</option>
                            <option value="A-6">와인</option>
                        </select>
                        <select name="filter-degree" class="select mb-5 me-3" name="degree" onchange="document.quertSelector('form').submit()">
                            <option>==도수 선택==</option>
                            <option value="10">10도 이하</option>
                            <option value="20">20도 이하</option>
                            <option value="30">30도 이하</option>
                            <option value="30">30도 초과</option>
                        </select>
                    </form>                            
                        <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                        <%
                        if(priceFilterS == null) {
                        	for (Alcohol a : dao.getAllList()) {                        		
                        		if(a.getSaleYN().equals("N")) {
                        %>  
                            <div class="col mb-5">                           	
                                <div class="card h-100">
                                    <!-- Product image-->
                                    <img class="card-img-top" src="<%=a.getAlcoholImg()%>"
                                        alt="..." />
                                    <!-- Product details-->
                                    <div class="card-body p-4">
                                        <div class="text-center">
                                            <!-- Product name-->
                                            <h5 class="fw-bolder"><%=a.getAlcoholName()%></h5>
                                            <!-- Product price-->
                                            <%=a.getPrice() %>원
                                            <p class="text-black-50 p-1"><%=a.getAlcoholDet() %></p>
                                        </div>
                                    </div>
                                    <!-- Product actions-->
                                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                        <div class="text-center">
                                            <button class="btn btn-outline-dark mt-auto" type="submit">
                                                구매하기</button>
                                        </div>
                                    </div>
                                </div>                               
                            </div>
                            <%}else if(a.getSaleYN().equals("Y")) {%>
                            <div class="col mb-5">
                                <div class="card h-100">
                                    <!-- Sale badge-->
                                    <div class="badge bg-dark text-white position-absolute"
                                        style="top: 0.5rem; right: 0.5rem">Sale</div>
                                    <!-- Product image-->
                                    <img class="card-img-top" src="<%=a.getAlcoholImg() %>"
                                        alt="..." />
                                    <!-- Product details-->
                                    <div class="card-body p-4">
                                        <div class="text-center">
                                            <!-- Product name-->
                                            <h5 class="fw-bolder"><%=a.getAlcoholName() %></h5>
                                            <!-- Product price-->
                                            <span class="text-muted text-decoration-line-through"><%=a.getPrice() %>원</span>
                                            <%=(int)(a.getPrice()-(a.getPrice()*ranRate)) %>원
                                            <p class="text-black-50 p-1"><%=a.getAlcoholDet() %></p>
                                        </div>
                                    </div>
                                    <!-- Product actions-->
                                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                        <div class="text-center">
                                            <button class="btn btn-outline-dark mt-auto" type="submit">
                                                구매하기</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                             
                        <%
                          		}
                        	}
                        }else{
                        	for (Alcohol a : alList) {                        		
                        		if(a.getSaleYN().equals("N")) {
                        %>  
                            <div class="col mb-5">                           	
                                <div class="card h-100">
                                    <!-- Product image-->
                                    <img class="card-img-top" src="<%=a.getAlcoholImg()%>"
                                        alt="..." />
                                    <!-- Product details-->
                                    <div class="card-body p-4">
                                        <div class="text-center">
                                            <!-- Product name-->
                                            <h5 class="fw-bolder"><%=a.getAlcoholName()%></h5>
                                            <!-- Product price-->
                                            <%=a.getPrice() %>원
                                            <p class="text-black-50 p-1"><%=a.getAlcoholDet() %></p>
                                        </div>
                                    </div>
                                    <!-- Product actions-->
                                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                        <div class="text-center">
                                            <button class="btn btn-outline-dark mt-auto" type="submit">
                                                구매하기</button>
                                        </div>
                                    </div>
                                </div>                               
                            </div>
                            <%}else if(a.getSaleYN().equals("Y")) {%>
                            <div class="col mb-5">
                                <div class="card h-100">
                                    <!-- Sale badge-->
                                    <div class="badge bg-dark text-white position-absolute"
                                        style="top: 0.5rem; right: 0.5rem">Sale</div>
                                    <!-- Product image-->
                                    <img class="card-img-top" src="<%=a.getAlcoholImg() %>"
                                        alt="..." />
                                    <!-- Product details-->
                                    <div class="card-body p-4">
                                        <div class="text-center">
                                            <!-- Product name-->
                                            <h5 class="fw-bolder"><%=a.getAlcoholName() %></h5>
                                            <!-- Product price-->
                                            <span class="text-muted text-decoration-line-through"><%=a.getPrice() %>원</span>
                                            <%=(int)(a.getPrice()-(a.getPrice()*ranRate)) %>원
                                            <p class="text-black-50 p-1"><%=a.getAlcoholDet() %></p>
                                        </div>
                                    </div>
                                    <!-- Product actions-->
                                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                        <div class="text-center">
                                            <button class="btn btn-outline-dark mt-auto" type="submit">
                                                구매하기</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <%		}
                        		}
                        	}%>	                       
                    	</div>
                </section>
        </div>
    </div>
</body>
</html>