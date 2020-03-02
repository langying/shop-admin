/**
 * 新增-申请记录表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		tApplyRecord: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../app/record/save?_' + $.now(),
		    	param: vm.tApplyRecord,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
