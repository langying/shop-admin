/**
 * 编辑-意见反馈表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		tFeedback: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../app/feedback/info?_' + $.now(),
		    	param: vm.tFeedback.id,
		    	success: function(data) {
		    		vm.tFeedback = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../app/feedback/update?_' + $.now(),
		    	param: vm.tFeedback,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})