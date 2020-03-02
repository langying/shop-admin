/**
 * 编辑-收益分析表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		tEarnings: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../app/earnings/info?_' + $.now(),
		    	param: vm.tEarnings.id,
		    	success: function(data) {
		    		vm.tEarnings = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../app/earnings/update?_' + $.now(),
		    	param: vm.tEarnings,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})