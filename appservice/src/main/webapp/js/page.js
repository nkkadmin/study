//添加分页
function pageShow(functionName,data){
	$("#page").html("");
	if(data.pageNo != 1){
		$("#page").append("<li onclick=\""+ functionName +"("+ (data.pageNo-1) +")\"> 《 </li>");
	}
	for(var i = 1;i <= data.totalPages;i++){
		if(data.pageNo == i){
			$("#page").append("<li class='active' onclick=\""+ functionName +"("+ i +")\">"+ i +"</li>");
	}else{
		$("#page").append("<li onclick=\""+ functionName +"("+ i +")\">"+ i +"</li>");
		}
		
	}
	if(data.pageNo != data.totalPages){
		$("#page").append("<li onclick=\""+ functionName +"("+ (data.pageNo+1) +")\"> 》 </li>");
	}
}
