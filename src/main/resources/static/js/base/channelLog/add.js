/**
 * 新增-渠道月统计js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		tChannelLog: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../app/channelLog/save?_' + $.now(),
		    	param: vm.tChannelLog,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
