<%@ taglib prefix="t" uri="/WEB-INF/tlds/customTags.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/jsp/head.jsp"%>
</head>
<body>
<c:out value="123"/>
	<div class="container">
		<div class="row">
			<div class="col-9"></div>
			<div class="col-3">
				<div class="card mt-4">
					<img class="card-img-top img-fluid" src="static/images/user.png"
						alt="Card image cap">
					<div class="card-body">
						<div class="row align-items-middle">
							<div class="col-9">
								<h6 class="card-title text-mono">Hello</h6>
								<h4 class="card-title text-mono">
									<t:User />
								</h4>
							</div>
							<div class="col-3">
								<form action="logout" method="POST">
									<button
										class="btn btn-sm btn-dark btn-shadow float-right text-mono"
										type="submit">Logout</button>
								</form>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>