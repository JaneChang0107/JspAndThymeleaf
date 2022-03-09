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
	<div style="width: 400px">
		<canvas id="myChart"></canvas>
	</div>
	<div style="width: 400px">
		<canvas id="multiLineChart"></canvas>
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
				var grade = [];

				for ( var i in data) {
					player.push("Player " + data[i].userName);
					score.push(data[i].score);
					grade.push(data[i].grade);
				}

				var chartdata = {
					labels : player,
					datasets : [ 
						{
							label : 'Player Score',
							backgroundColor : 'rgba(200, 200, 200, 0.75)',
							borderColor : 'rgba(200, 200, 200, 0.75)',
							hoverBackgroundColor : 'rgba(200, 200, 200, 1)',
							hoverBorderColor : 'rgba(200, 200, 200, 1)',
							data : score
						}
					]
				};

				var ctx = $("#mychart-bar");

				var barGraph = new Chart(ctx, {
					type : 'bar',
					data : chartdata
				});
				
				const linedata = {
						labels : player,
						datasets : [ {
							label : 'My First dataset',
							backgroundColor : 'rgb(255, 99, 132)',
							borderColor : 'rgb(255, 99, 132)',
							data :score,
						},
						{
							label : 'Player grade',
							backgroundColor : 'rgba(200, 200, 200, 0.75)',
							borderColor : 'rgba(200, 150, 200, 0.75)',
							hoverBackgroundColor : 'rgba(200, 200, 200, 1)',
							hoverBorderColor : 'rgba(200, 200, 200, 1)',
							data : grade
						}]
					};

					const config = {
						type : 'line',
						data : linedata,
						options : {
						}
					};
					
					const myChart = new Chart(
						    document.getElementById('myChart'),
						    config
						  );
					
					 const DATA_COUNT = 7;
					 const NUMBER_CFG = {count: DATA_COUNT, min: -100, max: 100};

					 //const labels = Utils.months({count: 7});
					 const mulitdata = {
					 	labels: player,
						   datasets: [
					     {
					       label: 'Score',
					       data: score,
					       borderColor: 'blue',
					       backgroundColor: 'white',
					       yAxisID: 'y',
					     },
					     {
					       label: 'Grade',
					       data: grade,
					       borderColor: 'purple',
					       backgroundColor: 'white',
					       yAxisID: 'y1',
					     }
					   ]
					 };

				 const multiconfig = {
					 		  type: 'line',
					 		  data: mulitdata,
					 		  options: {
					 		    responsive: true,
					 		    interaction: {
					 		      mode: 'index',
					 		      intersect: false,
					 		    },
					 		    stacked: false,
					 		    plugins: {
					 		      title: {
					 		        display: true,
					 		        text: 'Chart.js Line Chart - Multi Axis'
					 		      }
				 		    },
					 		    scales: {
					 		      y: {
					 		        type: 'linear',
					 		        display: true,
					 		        position: 'left',
					 		      },
					 		      y1: {
					 		        type: 'linear',
					 		        display: true,
					 		        position: 'right',

					 		        // grid line settings
					 		        grid: {
					 		          drawOnChartArea: false, // only want the grid lines for one axis to show up
					 		        },
					 		      },
					 		    }
					 		  },					 		};
					 	const multiLineChart = new Chart(
					 	    document.getElementById('multiLineChart'),
				 	    multiconfig
					 	  );
			}
	});
});	
</script>
<script>
// const DATA_COUNT = 7;
// const NUMBER_CFG = {count: DATA_COUNT, min: -100, max: 100};

// //const labels = Utils.months({count: 7});
// const data = {
//   labels: player,
//   datasets: [
//     {
//       label: 'Dataset 1',
//       data: Utils.numbers(NUMBER_CFG),
//       borderColor: Utils.CHART_COLORS.red,
//       backgroundColor: Utils.transparentize(Utils.CHART_COLORS.red, 0.5),
//       yAxisID: 'y',
//     },
//     {
//       label: 'Dataset 2',
//       data: Utils.numbers(NUMBER_CFG),
//       borderColor: Utils.CHART_COLORS.blue,
//       backgroundColor: Utils.transparentize(Utils.CHART_COLORS.blue, 0.5),
//       yAxisID: 'y1',
//     }
//   ]
// };

// const config = {
// 		  type: 'line',
// 		  data: data,
// 		  options: {
// 		    responsive: true,
// 		    interaction: {
// 		      mode: 'index',
// 		      intersect: false,
// 		    },
// 		    stacked: false,
// 		    plugins: {
// 		      title: {
// 		        display: true,
// 		        text: 'Chart.js Line Chart - Multi Axis'
// 		      }
// 		    },
// 		    scales: {
// 		      y: {
// 		        type: 'linear',
// 		        display: true,
// 		        position: 'left',
// 		      },
// 		      y1: {
// 		        type: 'linear',
// 		        display: true,
// 		        position: 'right',

// 		        // grid line settings
// 		        grid: {
// 		          drawOnChartArea: false, // only want the grid lines for one axis to show up
// 		        },
// 		      },
// 		    }
// 		  },
// 		};
// 	const multiLineChart = new Chart(
// 	    document.getElementById('multiLineChart'),
// 	    config
// 	  );
</script>


</html>