/**
 * 新增-申请记录表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		tProductApply: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../app/productApply/save?_' + $.now(),
		    	param: vm.tProductApply,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
