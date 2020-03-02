/**
 * 新增-产品统计js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		tProductLog: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../app/productLog/save?_' + $.now(),
		    	param: vm.tProductLog,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
