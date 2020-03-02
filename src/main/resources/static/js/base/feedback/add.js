/**
 * 新增-意见反馈表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		tFeedback: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../app/feedback/save?_' + $.now(),
		    	param: vm.tFeedback,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
