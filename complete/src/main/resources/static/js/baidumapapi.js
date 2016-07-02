
var map;            
var centerPoint;
var locationList;
var overLay;
var overLayList;
var clickMakerIndex;
function addPoint(point,index){   
	var url="../imgs/marker_"+index+".png";
	//alert(url);
	var myIcon = new BMap.Icon(url, new BMap.Size(40, 25),
			{   
		    anchor: new BMap.Size(10, 25),
		    });
	var marker = new BMap.Marker(point, {icon: myIcon});    
	//marker.enableDragging(); 
	if (index!="root")
	marker.addEventListener("click", showFloatBox); 
	return marker;
}


var pointList="";
function setLocation(list,index)
{
	overLay=new Array();
	for (var i=0; i<list.length; i++)
		{
		//alert(list[i].x+" "+list[i].y);
          var point = new BMap.Point(list[i].x,list[i].y);
	      overLay.push(addPoint(point,index));
	      var tmPoint={};
	      tmPoint["x"]=list[i].x;
	      tmPoint["y"]=list[i].y;
	      tmPoint["index"]=index;
	      tmPoint["id"]=list[i].id;
	      tmPoint["name"]=list[i].name;
	      tmPoint["footstep"]=list[i].footstep;
	      tmPoint["i"]=i;
	      pointList.push(tmPoint);
	      //map.addOverlay(addPoint(point,index));
		}
	overLayList.push(overLay);
	for (var i=0;i<overLayList[index].length; i++)
	map.addOverlay(overLayList[index][i]);
}



function getCenterPoint()
{
	var geolocation = new BMap.Geolocation();
	geolocation.getCurrentPosition(function(r){
		if(this.getStatus() == BMAP_STATUS_SUCCESS){
	        var point=new BMap.Point(r.point.lng,r.point.lat);  
	      //  alert(r.point.lng+" "+r.point.lat);
	       // translateCallback=function(point) {
	        	map.addOverlay(addPoint(point,"root"));
	        	centerPoint=point;
	        	map.panTo(centerPoint);
	        	var myGeo = new BMap.Geocoder();      
	        	// 根据坐标得到地址描述    
	        	
	        	myGeo.getLocation(centerPoint, function(result){      
	        	                 if (result){      
	        	                     console.log(result.address);
	        	                     }
	        	}); 
	       // };
	       /* var pointArr=new Array();
	        pointArr.push(r.point);
	        var convertor = new BMap.Convertor();
	        yes=function(point) {
	        	// var ttpoint=new BMap.Point(point.points[0].lng,point.points[0].lat); 
	        	// map.panTo(ttpoint);
		        	map.addOverlay(addPoint(ttpoint,"root"));

	        }
			convertor.translate(pointArr,3,5,yes);*/
		}
			else {
				alert('failed'+this.getStatus());
			}        
			},{enableHighAccuracy: true})
}
function loadScript() {
	var script = document.createElement("script");
	script.type = "text/javascript";
	script.src = "http://api.map.baidu.com/api?v=2.0&ak=TPb1KOPQZBWz9qvujQPNPWklQGCHxNO1&callback=init";
	document.body.appendChild(script);
} 
var RatingKey = 'averageRating';
var JsonGET;
var locationArray;
function getLocations(){
		var data1 = {};
		locationArray=new Array();
		$.ajax({
		type:"GET",
 		contentType : 'application/json',
 		url:"/getLocationList",
 		dataType:"json",
 		data : JSON.stringify(data1),
 	    success : function(data) {  
 	    	for(var i=0;i<data.length;i++){ 	    	
	  			$("#panel-body").append('<label class="checkbox"><input type="checkbox" checked="checked" value="'+i+'" onclick="checkboxOnclick(this)" > '+data[i]["name"]+'</label>');
	  			locationArray.push(data[i]["name"]);
 	    	}
 	  		console.log(data);	
 	     },  
 	    error : function() {  
      		alert('Err...');  
 	    },		
 	     done : function(e) {
 
			console.log("DONE");
		}
 	}).done(function() {
 	        for (var i=0; i<locationArray.length; i++)
 	        	{	  
 	        	itemShow(locationArray[i]);
 	        	}     
 	}
 	);
}
	function itemShow(locationName){ 
		var JsonSEND = JSON.stringify( {"locationName":locationName});  
	 	$.ajax({
	 		type:"POST",
	 		contentType : 'application/json',
	 		url:"/getItemList/normal",
	 		dataType:"json",
	 		data:JsonSEND,
	 	    success : function(data) {  
	 	  		console.log(data);
	 	  		JsonGET=data;
	 		   var itemList=new Array();
	 			 for(var i=0,l=JsonGET.length;i<l;i++){  
	 			 	   var tmp={};
	 			 	   tmp["x"]=JsonGET[i]["latitude"];
	 			 	   tmp["y"]=JsonGET[i]["longitude"];	 			
	 			 	   tmp["name"]=JsonGET[i]["name"];
	 			 	   tmp["id"]=JsonGET[i]["id"];
	 			 	   tmp["footstep"]=JsonGET[i]["footstep"];
	 			 	   itemList.push(tmp); 			 	   
	 			 	 }
	 			locationList.push(itemList);
	 			var index=locationList.length-1;
	 			setLocation(locationList[index],index);
	 	     },  
	 	    error : function() {  
	      		alert('Err...');  
	 	    }
	 	});

	 };
var tmp;
function init() {
	    pointList=new Array();
	    locationList=new Array();
		map = new BMap.Map("map");
		centerPoint = new BMap.Point(121.6755020000,31.1462310000);//随便设置的一个点，防止本地GPS没加载出来时地图不显示
		map.centerAndZoom(centerPoint, 12);                 // 初始化地图，设置中心点坐标和地图级别
		map.enableScrollWheelZoom();
		getCenterPoint();
		overLayList=new Array();
		getLocations();
		
	
		$("#result").click(function(){
			findTheWay(start,end);
		});
}
function findTheWay(start,end)
{

	 console.log(pointList.length);
      for (var i=0; i<pointList.length; i++)
 		console.log(pointList[i]);
	map.clearOverlays(); 
	var i="";
	search(start,end,BMAP_DRIVING_POLICY_LEAST_TIME); 
	function search(start,end,route){ 
		var driving = new BMap.DrivingRoute(map, {renderOptions:{map: map, autoViewport: true},policy: route});
		driving.search(start,end);
	}
	var mainDis;
	var myGeo = new BMap.Geocoder();
	// 将地址解析结果显示在地图上,并调整地图视野
	var point1;
	var point2;
	myGeo.getPoint(start, function(point){
		if (point) {
			point1=point;
			myGeo.getPoint(end, function(point){
				if (point) {
					point2=point;
					mainDis=map.getDistance(point1, point2); 
					console.log(mainDis);
					  for (var i=0; i<pointList.length; i++)
			        	  if (nearTheWay(i,point1,point2,mainDis))  map.addOverlay(overLayList[pointList[i]["index"]][pointList[i]["i"]]);
				}else{
					alert("您选择地址没有解析到结果!");
				}
			}, "上海市");
		}else{
			alert("您选择地址没有解析到结果!");
		}
	}, "上海市");
}
function nearTheWay(i,point1,point2,mainDis)
{
	 var halfy=(point1.lat+point2.lat)/2;
	 var halfx=(point1.lng+point2.lng)/2;
	 var midPoint=new BMap.Point(halfx,halfy);
	 var myGeo = new BMap.Geocoder();
	 var thePoint=new BMap.Point(pointList[i]["x"] ,pointList[i]["y"]);
	 console.log(pointList[i]["x"]+" "+pointList[i]["y"]);
	 var dis=map.getDistance(midPoint, thePoint);
	 console.log(i+" "+dis);
	 if (dis<mainDis) return true;
	 else return false;
}
function showOverLay(index)
{
  for (var i=0; i<overLayList[index].length; i++)
	  map.addOverlay(overLayList[index][i]);
}

function removeOverLay(index)
{
  for (var i=0; i<overLayList[index].length; i++)
	  map.removeOverlay(overLayList[index][i]);
}
function checkboxOnclick(checkbox){

	 if ( checkbox.checked == true){
         //alert(checkbox.value);
         showOverLay(checkbox.value);

	 }else{
		// alert(checkbox.value+"cancel");
		 removeOverLay(checkbox.value);
	 //Action for not checked

	 }
	 };

window.onload = loadScript;  

function showFloatBox(e) {
	var p = e.target.getPosition();
	//console.log(p.lat + ',' + p.lng);
	for (var i=0; i<pointList.length; i++)
	{
	//alert(pointList[i]["x"]+" "+pointList[i]["y"]);
	var tmp=(p.lat-pointList[i]["y"])*(p.lng-pointList[i]["x"]);
      if (tmp*tmp<0.000000000001) clickMakerIndex=i; 	 
     }
   //alert(pointList[clickMakerIndex]["name"]);
  var floatBox=$("#floatBox");
  if($("#canbeDelete1").length>0){$("#canbeDelete1").remove()};
  if($("#canbeDelete2").length>0){$("#canbeDelete2").remove()};
  console.log(pointList[clickMakerIndex]["name"]);
  floatBox.append('<div class="panel-heading" id="canbeDelete1"><h3 class="panel-title">'+pointList[clickMakerIndex]["name"]+'</h3></div><div class="panel-body" id="canbeDelete2"><ul class="nav nav-list list-unstyled" style="width: 300px;"><li>被访问：<span>'+pointList[clickMakerIndex]["footstep"]+'</span></li><li class="nav-header">照片</li><li><img id="itemimg1" class="img-rounded img-responsive"></li><li class="text-center"><a href="#/iteminfo" onclick="goIntoItemInfo()">详细页面</a></li></ul></div>');
  showMapImage1(pointList[clickMakerIndex]["id"]);
}
  
  function goIntoItemInfo()
  {
   nowItem=pointList[clickMakerIndex]["id"];
  
   nowLat=pointList[clickMakerIndex]["y"];
   nowLng=pointList[clickMakerIndex]["x"];
   $("#canbeDelete1").remove();
   $("#canbeDelete2").remove();
  }
  function showMapImage1(itemid_m){
		$("#itemimg1").attr("src","/getItemImage/"+itemid_m);
		//alert($("#itemimg1").src);
	}
  function showTOThereMap(){
	 // alert(nowItem);
	 var tlat=0;
	  var tlng=0;
	  for (var i=0; i<pointList.length; i++)
		  if (nowItem==pointList[i]["id"])
		  { tlat=pointList[i]["y"];
		    tlng=pointList[i]["x"];
		  }//31      121
	  var point1=new BMap.Point(tlng,tlat);  
	  var driving = new BMap.DrivingRoute(map, {renderOptions:{map: map, autoViewport: true}});
	  driving.search(centerPoint, point1);
  }