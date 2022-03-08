<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>jsphome.jsp</title>
</head>
<body>
	<h2>welcome! : ${welcome}</h2>
	<p>Today: ${today}</p>
	<%-- <c:forEach var="obj" items="${students}">
　　<p class="label"><c:out value="${obj.userName}"/></p><br>
</c:forEach> --%>
	<p>${students}</p>
	<div style="width: 400px">
		<canvas id="mychart-bar"></canvas>
	</div>
</body>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.2.0/chart.min.js"
	integrity="sha512-VMsZqo0ar06BMtg0tPsdgRADvl0kDHpTbugCBBrL55KmucH6hP9zWdLIWY//OTfMnzz6xWQRxQqsUFefwHuHyg=="
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/chartjs-adapter-date-fns@next/dist/chartjs-adapter-date-fns.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$.ajax({
			url : "/thjsp/getPlayer",
			method : "GET",
			success : function(data) {
				console.log(data);
				var player = [];
				var score = [];

				for ( var i in data) {
					player.push("Player " + data[i].userName);
					score.push(data[i].score);
				}

				var chartdata = {
					labels : player,
					datasets : [ {
						label : 'Player Score',
						backgroundColor : 'rgba(200, 200, 200, 0.75)',
						borderColor : 'rgba(200, 200, 200, 0.75)',
						hoverBackgroundColor : 'rgba(200, 200, 200, 1)',
						hoverBorderColor : 'rgba(200, 200, 200, 1)',
						data : score
					} ]
				};

				var ctx = $("#mychart-bar");

				var barGraph = new Chart(ctx, {
					type : 'bar',
					data : chartdata
				});
			}
		});
	});
</script>


</html>