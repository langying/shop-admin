/**
 * 编辑-第三方统计表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		tThirdRecord: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../app/thirdRecord/info?_' + $.now(),
		    	param: vm.tThirdRecord.id,
		    	success: function(data) {
		    		vm.tThirdRecord = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../app/thirdRecord/update?_' + $.now(),
		    	param: vm.tThirdRecord,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})