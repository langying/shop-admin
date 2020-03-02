/**
 * 编辑-用户浏览商品记录js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		tProductBrowse: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../app/browse/info?_' + $.now(),
		    	param: vm.tProductBrowse.id,
		    	success: function(data) {
		    		vm.tProductBrowse = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../app/browse/update?_' + $.now(),
		    	param: vm.tProductBrowse,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})