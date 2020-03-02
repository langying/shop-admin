/**
 * 新增-用户表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		tUser: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../app/user/save?_' + $.now(),
		    	param: vm.tUser,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
