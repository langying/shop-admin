/**
 * 新增-第三方统计表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		tThirdRecord: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../app/thirdRecord/save?_' + $.now(),
		    	param: vm.tThirdRecord,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
