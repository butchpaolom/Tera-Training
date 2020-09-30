<!DOCTYPE html>

<html lang="en">
<head>
<%@ include file="/WEB-INF/jsp/head.jsp"%>
</head>

<body>
	<div class="container">
		<div class="row d-flex justify-content-center">
			<div class="col-4">
				<div class="container mt-4 animate__animated animate__fadeInDown">
					<div class="card p-4 bg-dark">
						<div class="row m-0 my-3">
							<img class="img-fluid" src="static/images/terasystem.png" />
						</div>
						<div class="row mx-0 d-flex justify-content-center">
							<h6 class="text-mono text-danger">${error}</h6>
						</div>
						<form method="POST" action="home">
							<div class="row mx-0 mt-2">
								<input class="form-control text-mono" placeholder="Username"
									name="username" />
							</div>
							<div class="row mx-0 mt-2">
								<input class="form-control text-mono" placeholder="Password"
									name="password" type="password" />
							</div>
							<div class="row mx-0 mt-3 align-items-middle">
								<div class="col-6 p-0">
									<button class="btn btn-dark btn-shadow pt-2 ml-0 text-mono">
										Register</button>
								</div>
								<div class="col-6 p-0">
									<button
										class="btn btn-dark btn-shadow pt-2 text-mono float-right"
										type="submit">Login</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
