
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="tm-page-wrap mx-auto">
	<div class="position-relative">
		<div class="position-absolute tm-site-header">
			<div class="container-fluid position-relative">
				<div class="row">
					<div class="col-7 col-md-4"></div>
					<div class="col-5 col-md-8 ml-auto mr-0">
						<div class="tm-site-nav">
							<nav class="navbar navbar-expand-lg mr-0 ml-auto"
								id="tm-main-nav">
								<button
									class="navbar-toggler tm-bg-black py-2 px-3 mr-0 ml-auto collapsed"
									type="button" data-toggle="collapse" data-target="#navbar-nav"
									aria-controls="navbar-nav" aria-expanded="false"
									aria-label="Toggle navigation">
									<span> <i class="fas fa-bars tm-menu-closed-icon"></i> <i
										class="fas fa-times tm-menu-opened-icon"></i>
									</span>
								</button>
								<div class="collapse navbar-collapse tm-nav" id="navbar-nav">
									<fmt:setLocale value="${sessionScope.lang}" scope="request" />
									<fmt:setBundle basename="global" scope="request" />

									<a href="?lang=vi" style="padding: 0 10px"><img
										style="width: 40px; height: 25px" alt=""
										src="https://upload.wikimedia.org/wikipedia/commons/thumb/1/1b/Flag_of_North_Vietnam_%281955%E2%80%931976%29.svg/230px-Flag_of_North_Vietnam_%281955%E2%80%931976%29.svg.png" /></a>
									<%-- <fmt:message key="memu.langVi" /> --%>

									<a href="?lang=en"><img style="width: 40px; height: 25px"
										alt=""
										src="https://vuongquocanh.com/wp-content/uploads/2018/04/la-co-vuong-quoc-anh.jpg" /></a>
									<ul class="navbar-nav text-uppercase">

										<li class="nav-item active"><a
											class="nav-link tm-nav-link"
											href="${pageContext.request.contextPath }/views/video"><fmt:message
													key="memu.home" /> <span class="sr-only">(current)</span>
										</a></li>
										<li class="nav-item"><a class="nav-link tm-nav-link"
											href="#"> <fmt:message key="memu.hello" /> <span
												style="color: blue"> ${username }</span> <span
												class="sr-only">(current)</span>
										</a></li>
										<li class="nav-item"><a class="nav-link tm-nav-link"
											href="${pageContext.request.contextPath }/views/favorite">
												<fmt:message key="memu.favorite" /> <span class="sr-only">(current)</span>
										</a></li>
										<li class="nav-item"><c:if test="${isLogin == 1}">
												<a class="nav-link tm-nav-link"
													href="${pageContext.request.contextPath }/views/logout"><fmt:message
														key="memu.logout" /></a>
											</c:if> <c:if test="${isLogin == 0}">
												<a class="nav-link tm-nav-link"
													href="${pageContext.request.contextPath }/views/login"><fmt:message
														key="memu.login" /></a>
											</c:if></li>

										<li class="nav-item dropdown"><a
											class="nav-link dropdown-toggle" href="#" role="button"
											data-bs-toggle="dropdown" aria-expanded="false"
											style="color: white"> Setting </a>
											<ul class="dropdown-menu">
												<li class="nav-item"><a class="nav-link tm-nav-link"
													style="color: black; font-size: 15px"
													href="${pageContext.request.contextPath }/views/changepass"><fmt:message
															key="memu.changpass" /></a></li>
												<li class="nav-item"><a class="nav-link tm-nav-link"
													style="color: black; font-size: 15px"
													href="${pageContext.request.contextPath }/views/register"><fmt:message
															key="memu.Resgister" /></a></li>
												<li><hr class="dropdown-divider" /></li>
												<li><a class="dropdown-item" href="${pageContext.request.contextPath }/views/profile">Set Avatar</a></li>
											</ul></li>
										<li class="nav-item"><img alt="Day la anh"
											src="../upload/${avatar}"
											style="width: 50px; height: 50px; border-radius: 50%">
											
											</li>
									</ul>
								</div>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="tm-welcome-container text-center text-white">
			<div class="tm-welcome-container-inner">
				<p class="tm-welcome-text mb-1 text-white">
					<fmt:message key="memu.des1" />
				</p>
				<p class="tm-welcome-text mb-5 text-white">
					<fmt:message key="memu.des2" />
				</p>
				<a href="#content"
					class="btn tm-btn-animate tm-btn-cta tm-icon-down"> <span><fmt:message
							key="memu.btn" /></span>
				</a>
			</div>
		</div>

		<div id="tm-video-container">
			<!-- <video autoplay muted loop id="tm-video">
				<source src="video/sunset-timelapse-video.mp4" type="video/mp4">
				<source src="video/wheat-field.mp4" type="video/mp4">
			</video> -->
			<img alt=""
				src="https://thumbs.gfycat.com/LoathsomeColorlessFlee-size_restricted.gif"
				style="width: 100%">
		</div>

		<i id="tm-video-control-button" class="fas fa-pause"></i>
	</div>