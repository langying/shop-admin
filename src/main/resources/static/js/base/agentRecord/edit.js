/**
 * 编辑-点击推广链接记录表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		tAgentRecord: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../app/agentRecord/info?_' + $.now(),
		    	param: vm.tAgentRecord.id,
		    	success: function(data) {
		    		vm.tAgentRecord = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../app/agentRecord/update?_' + $.now(),
		    	param: vm.tAgentRecord,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})