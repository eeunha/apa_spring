<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header class="site-header">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 col-12 d-flex flex-wrap">
                        <p class="d-flex me-4 mb-0">
                            <i class="bi-geo-alt me-2"></i>
                            서울특별시 강남구 테헤란로 132 8층
                        </p>
                        <p class="d-flex mb-0">
                            <i class="bi-envelope me-2"></i>
                            <a href="mailto:info@company.com">
                                DoubleDragon@mail.com
                            </a>
                        </p>
                    </div>
                    <div class="col-lg-3 col-12 ms-auto d-lg-block d-none">
                        <ul class="social-icon">
                            <li class="social-icon-item">
                                <a href="#" class="social-icon-link bi-twitter"></a>
                            </li>

                            <li class="social-icon-item">
                                <a href="#" class="social-icon-link bi-facebook"></a>
                            </li>

                            <li class="social-icon-item">
                                <a href="#" class="social-icon-link bi-instagram"></a>
                            </li>

                            <li class="social-icon-item">
                                <a href="#" class="social-icon-link bi-youtube"></a>
                            </li>

                            <li class="social-icon-item">
                                <a href="#" class="social-icon-link bi-whatsapp"></a>
                            </li>
                        </ul>
                    </div>

                </div>
            </div>
        </header>

        <nav class="navbar navbar-expand-lg bg-light shadow-lg">
            <div class="container">
                <a class="navbar-brand" href="/apa/main.do">
                    <img src="/apa/resources/images/logo.png" class="logo img-fluid" alt="Kind Heart Charity">
                    <span style="font-size: 2rem;display:grid;">
                        <div style="padding-top: 10px;height:30px;" class="hansans">아파! 어디가?</div>
                        <small style="font-size: 1rem;">Reserve Your Health</small>
                    </span>
                </a>

                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item dropdown">
                            <a class="nav-link click-scroll dropdown-toggle" href="#">병원/약국 찾기</a>

                            <ul class="dropdown-menu dropdown-menu-light" aria-labelledby="navbarLightDropdownMenuLink">
                                <li><a class="dropdown-item" href="/apa/search/list.do">병원 찾기</a></li>
                                <li><a class="dropdown-item" href="/apa/search/list.do">약국 찾기</a></li>
                            </ul>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link click-scroll" href="#">의학 상담</a>
                        </li>

                        <li class="nav-item dropdown">
                            <a class="nav-link click-scroll dropdown-toggle" href="#">의학 정보</a>

                            <ul class="dropdown-menu dropdown-menu-light" aria-labelledby="navbarLightDropdownMenuLink">
                                <li><a class="dropdown-item" href="#">의학 매거진</a></li>
                                <li><a class="dropdown-item" href="#">질병백과</a></li>
                                <li><a class="dropdown-item" href="#">셀프 테스트</a></li>
                            </ul>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link click-scroll" href="#">커뮤니티</a>
                        </li>

                        <c:if test="${empty pw && empty id}">
                        <li class="nav-item ms-3">
                            <a class="nav-link custom-btn custom-border-btn btn" href="#">로그인</a>
                        </li>
                        <li class="nav-item ms-3">
                            <a class="nav-link custom-btn custom-border-btn btn" href="#">회원가입</a>
                        </li>
                        </c:if>
                        <c:if test="${not empty pw && not empty id}">
                        	<c:if test="${lv == 1}">
		                        <li class="nav-item ms-3">
		                            <a class="nav-link custom-btn custom-border-btn btn" href="#">마이페이지</a>
		                        </li>
                        	</c:if>
                        	<c:if test="${lv == 2}">
		                        <li class="nav-item ms-3">
		                            <a class="nav-link custom-btn custom-border-btn btn" href="#">마이페이지</a>
		                        </li>
		                        <li class="nav-item ms-3">
		                            <a class="nav-link custom-btn custom-border-btn btn" href="#">내 진료</a>
		                        </li>
                        	</c:if>
                        	<c:if test="${lv == 3}">
		                        <li class="nav-item ms-3">
		                            <a class="nav-link custom-btn custom-border-btn btn" href="#">마이페이지</a>
		                        </li>
                        	</c:if>
                        	<c:if test="${lv == 0}">
		                        <li class="nav-item ms-3">
		                            <a class="nav-link custom-btn custom-border-btn btn" href="#">마이페이지</a>
		                        </li>
                        	</c:if>
                        <li class="nav-item ms-3">
                            <a class="nav-link custom-btn custom-border-btn btn" href="#">로그아웃</a>
                        </li>
                        </c:if>
                    </ul>
                </div>
            </div>
        </nav>



