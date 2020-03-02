/**
 * 编辑-渠道月统计js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		tChannelLog: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../app/channelLog/info?_' + $.now(),
		    	param: vm.tChannelLog.id,
		    	success: function(data) {
		    		vm.tChannelLog = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../app/channelLog/update?_' + $.now(),
		    	param: vm.tChannelLog,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})