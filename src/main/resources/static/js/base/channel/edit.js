/**
 * 编辑-渠道表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		tChannel: {
			id: 0
		},
        settlements:[
            {text:"预付",value:1},
            {text:"月结",value:2}
        ],
        pays:[

            {text:"对公",value:1},
            {text:"对私",value:2}
        ],
        channels:[
            {text:"贷超",value:1},
            {text:"短信",value:2},
            {text:"贷款被拒",value:3},
            {text:"信息流",value:4},
            {text:"应用市场",value:5},
            {text:"代理",value:6},
            {text:"其它",value:7}
        ],
        cooperations:[
            {text:"CPA",value:1},
            {text:"CPC",value:2},
            {text:"按条",value:3},
            {text:"其他",value:4}
        ]
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../app/channel/info?_' + $.now(),
		    	param: vm.tChannel.id,
		    	success: function(data) {
		    		vm.tChannel = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../app/channel/update?_' + $.now(),
		    	param: vm.tChannel,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})