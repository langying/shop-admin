/**
 * 编辑-消息推送表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
        tMessage: {
            id: 0,
            type:1,
            status:0
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
				url: '../../app/message/info?_' + $.now(),
		    	param: vm.tMessage.id,
		    	success: function(data) {
		    		vm.tMessage = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../app/message/update?_' + $.now(),
		    	param: vm.tMessage,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})