/**
 * 新增-用户浏览商品记录js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		tProductBrowse: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../app/browse/save?_' + $.now(),
		    	param: vm.tProductBrowse,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
