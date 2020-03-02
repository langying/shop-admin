/**
 * 编辑-申请记录表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		tProductApply: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../app/productApply/info?_' + $.now(),
		    	param: vm.tProductApply.id,
		    	success: function(data) {
		    		vm.tProductApply = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../app/productApply/update?_' + $.now(),
		    	param: vm.tProductApply,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})