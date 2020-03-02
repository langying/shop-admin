/**
 * 编辑-第三方链接js
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
		setForm: function() {
			$.SetForm({
				url: '../../app/third/info?_' + $.now(),
		    	param: vm.tThird.id,
		    	success: function(data) {
		    		vm.tThird = data;
		    	}
			});
		},

		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../app/third/update?_' + $.now(),
		    	param: vm.tThird,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})