<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      //ajax 호출
      let centerArr = [['Sido', 'Count Center of Sido']];
      fetch('centerChart.do')
        .then(result => result.json())
        .then(result => {
          result.forEach(center => {
            centerArr.push([center.SIDO, center.CNT]);
          })
          google.charts.setOnLoadCallback(drawChart);
          console.log(centerArr);
        })
        .catch(err => console.log(err))

      function drawChart() {
        
        var data = google.visualization.arrayToDataTable(centerArr);

        var options = {
          title: '시도별 센터갯수'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
    </script>
  </head>
  <body>
    <div id="piechart" style="width: 900px; height: 500px;"></div>
  </body>
</html>