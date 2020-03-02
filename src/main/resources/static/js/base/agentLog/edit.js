/**
 * 编辑-渠道的推广统计js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		tAgentLog: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../app/agentLog/info?_' + $.now(),
		    	param: vm.tAgentLog.id,
		    	success: function(data) {
		    		vm.tAgentLog = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../app/agentLog/update?_' + $.now(),
		    	param: vm.tAgentLog,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})