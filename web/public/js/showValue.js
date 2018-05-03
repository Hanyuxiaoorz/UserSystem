$(document).ready(function(){
	$(".loading").hide();
	showStuDir();

});
function showStuDir(){

	//画布大小
	var width = 400;
	var height = 400;

	var svg = d3.select("#StuDir")
	.append("svg")
	.attr("id","showStuDir")
	.attr("width",width)
	.attr("height",height);

	//饼状图所需数据
	var datasetPie = [7,8,9,4];
	//使用布局制定一个饼状图
	// var pie = d3.layout.pie();
	// //将数组datasetPie作为pie()的参数，返回值给pie
	// var piedata = pie(datasetPie);

	// var outerRadius = 150; //外半径
	// var innerRadius = 75;//内半径

	// var arc = d3.svg.arc()   //弧生成器
	// 	.innerRadius(innerRadius)
	// 	.outerRadius(outerRadius);


	// var arcs = svg.selectAll("g")
	// 	.data(piedata)
	// 	.enter()
	// 	.append("g")
	// 	.attr("transform","translate(" + (width/2) + "," + (width/2) + ")");



	// arcs.append("path")
	// 	.attr("fill",function(d,i){
	// 		return color(i);
	// 	})
	// 	.attr("d",function(d){
	// 		return arc(d);
	// 	});



	// //定义有10种颜色比例尺
	// var color = d3.scale.category10();


	// //然后在每一个弧线中心添加文本
	// arcs.append("text")
	// 	.attr("transform",function(d){
	// 		return "translate(" + arc.centroid(d) + ")"
	// 	})
	// 	.attr("text-anchor","middle")
	// 	.text(function(d){
	// 		return d.data;
	// 	})


var pie = d3.layout.pie();

		var piedata = pie(datasetPie);
		
		var outerRadius = 150;	//外半径
		var innerRadius = 75;	//内半径，为0则中间没有空白

		var arc = d3.svg.arc()	//弧生成器
					.innerRadius(innerRadius)	//设置内半径
					.outerRadius(outerRadius);	//设置外半径
		
		var color = d3.scale.category10();
		
		var arcs = svg.selectAll("g")
					  .data(piedata)
					  .enter()
					  .append("g")
					  .attr("transform","translate("+ (width/2) +","+ (width/2) +")");
					  
		arcs.append("path")
			.attr("fill",function(d,i){
				return color(i);
			})
			.transition()
			.delay(function(d,i){ return i * 200})
			.duration(200)
			.ease("linear")
			.attrTween('d',function(d){
				var i = d3.interpolate(d.startAngle,d.endAngle);
				return function(t){
					d.endAngle = i(t);
					return arc(d);
				}
			});
		
		arcs.append("text")
			.attr("transform",function(d){
				return "translate(" + arc.centroid(d) + ")";
			})
			.attr("text-anchor","middle")
			.text(function(d){
				return d.data;
			});

}