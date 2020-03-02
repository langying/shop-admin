/**
 * 编辑-首页推荐位表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		tPromote: {
			id: 0,
            type:1
		},
        types:[
            {text:"分类引导",value:1},
            {text:"产品栏目",value:2},
            {text:"指定产品",value:3}
        ],
        options: [

        ],
        products: [

        ]
	},
    //初始化   获取下拉列表
    created:function(){
        var url='../../app/comm/selectColumn?_' + $.now();
        var thisr=this;
        this.options=[];
        $.get(url,function(data){
            thisr.options=thisr.options.concat(data);
        });

        var url2='../../app/comm/select?_' + $.now();
        var thisr2=this;
        this.products=[];
        $.get(url2,function(data){
            thisr2.products=thisr2.products.concat(data);
        });
    },
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../app/promote/info?_' + $.now(),
		    	param: vm.tPromote.id,
		    	success: function(data) {
		    		vm.tPromote = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../app/promote/update?_' + $.now(),
		    	param: vm.tPromote,
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
                            thisr.tPromote.imgUrl=data.path;
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