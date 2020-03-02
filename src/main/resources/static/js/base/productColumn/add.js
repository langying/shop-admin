/**
 * 新增-产品栏目关联表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		tProductColumn: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../app/productColumn/save?_' + $.now(),
		    	param: vm.tProductColumn,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
