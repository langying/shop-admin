/**
 * 新增-banner表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		tAdvert: {
			id: 0,
			type:1,
            coverUrl:"",
            status:0
		},
        options: [

        ]
	},
    //初始化   获取下拉列表
    created:function(){
        var url='../../app/comm/select?_' + $.now();
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
		    	url: '../../app/advert/save?_' + $.now(),
		    	param: vm.tAdvert,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		},

        //selectClick: function() {



        //},


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
                            thisr.tAdvert.coverUrl=data.path;
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
