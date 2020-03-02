/**
 * 新增-渠道表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		tChannel: {
			id: 0,
            channelType:1,
            payType:1,
            settlementType:1,
            cooperationType:1,
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
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../app/channel/save?_' + $.now(),
		    	param: vm.tChannel,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
