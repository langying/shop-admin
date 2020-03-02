/**
 * 编辑-商户表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		tMerchants: {
			id: 0
		},
        settlements:[
            {text:"预付",value:1},
            {text:"月结",value:2}
        ],
        pays:[

            {text:"对公",value:1},
            {text:"对私",value:2}
        ]
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../app/merchants/info?_' + $.now(),
		    	param: vm.tMerchants.id,
		    	success: function(data) {
		    		vm.tMerchants = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../app/merchants/update?_' + $.now(),
		    	param: vm.tMerchants,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})