/**
 * 新增-产品表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		tProduct: {
			id: 0,
            loanAmountMin:1000,
            loanAmountMax:50000,
            borrowMin:7,
            borrowMax:30,
            rateScope:0.02,
            applyData:"1、年龄：20周岁-45周岁\r\n2、地区：除新疆内蒙古青海港澳台等地\r\n3、手机号实名半年以上 \r\n4、芝麻分580以上",
            introduce:"1、年龄20周岁以上\r\n2、有身份证\r\n3、芝麻分580以上",
            borrowUnit:1,
            rateUnit:"日",
            hotFlag:0,
            orderNum:999,
            sortNum:999,
            lendNum:999,
            status:0,
            recommendFlag:0,
            cooperationType:1,
            applyTotal:60000,
            columns:["1"]
		},
        scores:[
			{text:"1星",value:1},
            {text:"2星",value:2},
            {text:"3星",value:3},
            {text:"4星",value:4},
            {text:"5星",value:5}
		],
        rateUnits:[
            {text:"日",value:"日"},
            {text:"月",value:"月"},
            {text:"年",value:"年"}
        ],
        borrowUnits:[
            {text:"天",value:1},
            {text:"月",value:2},
            {text:"年",value:3}
        ],
        cooperations:[
            {text:"CPA",value:1},
            {text:"CPC",value:2}

        ],
		types:[
            {text:"今日贷款",value:1},
            {text:"热门推荐",value:2},
            {text:"优质推荐",value:3}
        ],
        options: [

        ],
        merchants:[]
	},
    //初始化   获取下拉列表
    created:function(){
        var url='../../app/comm/selectColumn?_' + $.now();
        var thisr=this;
        this.options=[];
        $.get(url,function(data){
            thisr.options=thisr.options.concat(data);
        });

        var url2='../../app/comm/selectMerchants?_' + $.now();
        var thisr2=this;
        this.merchants=[];
        $.get(url2,function(data){
            thisr2.merchants=thisr2.merchants.concat(data);
        });
    },

	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
            vm.tProduct.columns=vm.tProduct.columns.join(",");

		    $.SaveForm({
		    	url: '../../app/product/save?_' + $.now(),
		    	param: vm.tProduct,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		},
		selectCover: function() {
            $('#cover').trigger('click');
        },
        uploadCover: function() {
            if(checkFileExt($('#cover').val(), ['jpg', 'png'])) {

                var thisr=this;
                $.ajaxFileUpload({
                    url: '../../app/comm/upload',
                    type: 'post',
                    fileElementId: ['cover'],
                    dataType: 'json',
                    success: function (data, status) {
                        if(data.code=='0'){
                            thisr.tProduct.logoUrl=data.path;
                            $("#img_src").attr('src',data.path);
                            dialogMsg(data.msg, 'success');
                        }else{
                            dialogMsg(data.msg, 'error');
                        }
                    },
                    error: function (data, status, e) {
                        dialogMsg(e, 'error')
                    }
                });

            } else {
                dialogMsg('仅支持jpg，png类型！');
            }
            $('#cover').on('change', vm.uploadCover);
        }
	}
})
checkFileExt = function(fileName, fileExts) {
    var check = false;
    var index = fileName.lastIndexOf(".");
    var ext = fileName.substr(index+1);
    for(var i=0; i<fileExts.length; i++) {
        if (ext == fileExts[i]) {
            check = true;
            break;
        }
    }
    return check;
}
