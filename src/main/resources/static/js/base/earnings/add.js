/**
 * 新增-收益分析表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		tEarnings: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../app/earnings/save?_' + $.now(),
		    	param: vm.tEarnings,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
