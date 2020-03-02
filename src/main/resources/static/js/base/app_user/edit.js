/**
 * 编辑-用户表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		tUser: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../app/user/info?_' + $.now(),
		    	param: vm.tUser.id,
		    	success: function(data) {
		    		vm.tUser = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../app/user/update?_' + $.now(),
		    	param: vm.tUser,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})