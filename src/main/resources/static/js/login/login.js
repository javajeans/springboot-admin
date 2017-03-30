/**
 * 
* @author liangjiange
*
 */
$(function(){
	
	$("#login").click(function(){

        var uname = $("#uname").val();
		var sha512Str = CryptoJS.SHA512($("#pword").val()+"{"+uname+"}");
    	var pword = CryptoJS.MD5(sha512Str+"{"+uname+"}").toString();
    	$.post("login/validate",{uname:uname,pword:pword},function(result){
    		if(result.success){
    			window.location.href="index";
    		}else{
    			alert(result.message);
    		}
    	},"json");
	});
	
});