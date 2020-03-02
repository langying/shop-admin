/**
 * 编辑-产品栏目关联表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		tProductColumn: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../app/productColumn/info?_' + $.now(),
		    	param: vm.tProductColumn.id,
		    	success: function(data) {
		    		vm.tProductColumn = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../app/productColumn/update?_' + $.now(),
		    	param: vm.tProductColumn,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})