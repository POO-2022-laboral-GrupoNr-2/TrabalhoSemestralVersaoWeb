<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	
	
	
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="assets/css/formulario.css">
<title>RufragoHotel-Reserva</title>
</head>

<body>


	<section>

		<nav class="barra-navegacao">
			<h2>
				<span>&lt;/</span>Rufrago<span>hotel</span>&gt;
			</h2>
			<ul class="cabecalho-link">
				<li><a href="#inicio">INÍCIO</a></li>
				<li><a href="formulario.html">RESERVAS</a></li>
				<li><a href="#sobre">SOBRE</a></li>
				<li><a href="#Nossos-servicos">SERVIÇOS</a></li>
				<li><a href="#contacto">CONTACTOS</a></li>
			</ul>

		</nav>


	</section>







	<div class="container">
		<div class="form-image">
			<img src="assets/img//undraw_shopping_re_3wst.svg" alt="">
		</div>
		<div class="form">
			<form name="form1" action="reserva">
				<div class="form-header">
					<div class="title">
						<h1>Reservas</h1>
					</div>
					<div class="login-button">
						<button onclick="submeterFormulario">
							<a href="#">Entrar</a>
						</button>
					</div>
				</div>

				<div class="input-group">
					<div class="input-box">
						<label for="checkin">Checkin</label> <input id="checkin"
							type="date" name="dataCheckin" required>
					</div>

					<div class="input-box">
						<label for="checkout">Checkout</label> <input id="checkout"
							type="date" name="dataCheckout" required>
					</div>


				</div>

				<div class="gender-inputs">
					<div class="gender-title">
						<h6>Acomodação</h6>
					</div>

					<div class="gender-group">
						<div class="gender-input">
							<input id="female" type="radio" name="Tipo"> <label
								for="female">Casal</label>
						</div>

						<div class="gender-input">
							<input id="male" type="radio" name="Tipo"> <label
								for="male">Familia</label>
						</div>

						<div class="gender-input">
							<input id="others" type="radio" name="Tipo"> <label
								for="others">Solteiro</label>
						</div>

					</div>
				</div>
				<div class="select input-box">
					<select name="format" id="format">
						<option selected disabled>Descrição</option>
						<option value="1">Suite, Ac e wifi</option>
						<option value="2">Simples e Ac</option>
						<option value="3">Ac e wifi</option>
						<option value="4">Suite, Ac e wifi</option>
						<option value="4"></option>
					</select>
				</div>
				<div class="continue-button">
					<button onclick="submeterFormulario1()">
						<a href="#">Continuar</a>
					</button>
				</div>
			</form>
		</div>
	</div>
	<scriptsrc"assets/js/validador.js"> </script>
</body>

</html>