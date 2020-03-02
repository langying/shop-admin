/**
 * 编辑-申请记录表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		tApplyRecord: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../app/record/info?_' + $.now(),
		    	param: vm.tApplyRecord.id,
		    	success: function(data) {
		    		vm.tApplyRecord = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../app/record/update?_' + $.now(),
		    	param: vm.tApplyRecord,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})