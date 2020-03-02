/**
 * 编辑-产品统计js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		tProductLog: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../app/productLog/info?_' + $.now(),
		    	param: vm.tProductLog.id,
		    	success: function(data) {
		    		vm.tProductLog = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../app/productLog/update?_' + $.now(),
		    	param: vm.tProductLog,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})