/**
 * 新增-商户表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		tMerchants: {
			id: 0,
            settlementType:1,
            payType:1,
            userName:"小明",
            status:0
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
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../app/merchants/save?_' + $.now(),
		    	param: vm.tMerchants,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
