/**
 * 新增-点击推广链接记录表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		tAgentRecord: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../app/agentRecord/save?_' + $.now(),
		    	param: vm.tAgentRecord,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
