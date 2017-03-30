/**
 * 
* @author liangjiange
*
 */
$(function(){

    var total = $("#table-content").attr("page-num");
    loadingPage(total);

    var getFilters = function(){
      var obj = new Object();
      //obj.mac = $("#filter-mac").val();
      obj.ajaxSearch = true;
      obj.pageSize = 10;
      return obj;
    };

    function loadingPage(total) {
        laypage({
           cont : $("#page"),
            pages : total,
            skip : true,
            skin : "molv",
            groups : 5,
            jump : function (obj,first) {
                if(!first){
                    var currentPage = obj.curr;
                    console.log(currentPage);
                    //var mac = $("#filter-mac").val();
                    var filters = getFilters();
                    filters.currentPage = currentPage;
                    $.post("manage/user",filters,function(data){
                        $("#user-content").html(data);
                    });
                }
            }
        });
    }
	
});