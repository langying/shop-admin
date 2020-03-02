/**
 * 新增-渠道的推广统计js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		tAgentLog: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../app/agentLog/save?_' + $.now(),
		    	param: vm.tAgentLog,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
