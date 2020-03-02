/**
 * 新增-第三方链接js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {

        tThird: {
            id: 0,
            type:1
        },
        options: [

        ]
	},
    //初始化   获取下拉列表
    created:function(){
        var url='../../app/comm/select?_' + $.now();
        var thisr=this;
        this.options=[];
        $.get(url,function(data){
            thisr.options=thisr.options.concat(data);
        })
    },
	methods : {

		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../app/third/save?_' + $.now(),
		    	param: vm.tThird,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
