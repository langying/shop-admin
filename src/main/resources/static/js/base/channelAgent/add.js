/**
 * 新增-渠道的代理(推广)表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		tChannelAgent: {
			id: 0,
            discount:1.0,
            initNumber:20,
            channelId:1,
            price:14,
            linkId:1,
            payType:1,
            status:0
		},
        pays:[
            {text:"对公",value:1},
            {text:"对私",value:2}
        ],
        options: [

        ],
		links:[
            {text:"推广页面1",value:1},
            {text:"推广页面2",value:2},
            {text:"推广页面3",value:3},
            {text:"推广页面4",value:4},
            {text:"推广页面5",value:5},
            {text:"推广页面6",value:6},
            {text:"推广页面7",value:7}
		]

	},
    //初始化   获取下拉列表
    created:function(){
        var url='../../app/comm/selectChannel?_' + $.now();
        var thisr=this;
        this.options=[];
        $.get(url,function(data){
            thisr.options=thisr.options.concat(data);
        })
    },
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../app/channelAgent/save?_' + $.now(),
		    	param: vm.tChannelAgent,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
