/**
 * banner表js
 */

$(function () {
	initialPage();
	getGrid();
});



//点击之后放到图片

window.operateEvents = {

    'click .view': function (e, value, row, index) {
        console.log(row);
		/* var i = row.companyImage.indexOf("webapps");
		 var url = row.companyImage.substring(i+7,row.companyImage.length); */
        layer.open({
            type: 1,
            title: false,
            closeBtn: 0,
            area: ['500px', '500px'],
            skin: 'layui-layer-nobg', //没有背景色
            shadeClose: true,
            content: '<img  src="'+value+'"/>'
        });
    },
};


function initialPage() {
	$(window).resize(function() {
		$('#dataGrid').bootstrapTable('resetView', {height: $(window).height()-56});
	});
}

function getGrid() {
	$('#dataGrid').bootstrapTableEx({
		url: '../../app/advert/list?_' + $.now(),
		height: $(window).height()-56,
		queryParams: function(params){
			params.name = vm.keyword;
			return params;
		},
		columns: [
			{checkbox: true},
			{field : "title", title : "标题", width : "200px"},
            { field: 'coverUrl', title: '封面',width : "120px",
                formatter:function(value,row,index){
                    var s = '<a class = "view"  href="javascript:void(0)"><img style="width:50px;height:50px;"  src="'+value+'" /></a>';
                    return s;
                },

//定义点击之后放大图片的事件
                events: 'operateEvents'
            },
			{field : "name", title : "产品名称", width : "200px"},
            {
                field : "type",
                title : "类型",
                width : "100px",
                formatter : function(value, row, index) {
                    if (value == '1') {
                        return '<span class="label label-danger">平台产品</span>';
                    } else if (value == '2') {
                        return '<span class="label label-success">第三方链接</span>';
                    }
                }
            },

			{field:"linkUrl",title : "链接地址", width : "100px"},
            {
                field : "status",
                title : "状态",
                width : "60px",
                formatter : function(value, row, index) {
                    if (value == '1') {
                        return '<span class="label label-danger">禁用</span>';
                    } else if (value == '0') {
                        return '<span class="label label-success">正常</span>';
                    }
                }
            },
			{field : "gmtCreate", title : "创建时间", width : "100px"}

		]
	})
}

var vm = new Vue({
	el:'#dpLTE',
	data: {
		keyword: null
	},
	methods : {
		load: function() {
			$('#dataGrid').bootstrapTable('refresh');
		},
		save: function() {
			dialogOpen({
				title: '新增banner表',
				url: 'base/advert/add.html?_' + $.now(),
				width: '520px',
				height: '350px',
				yes : function(iframeId) {
					top.frames[iframeId].vm.acceptClick();
				},
			});
		},
		edit: function() {
			var ck = $('#dataGrid').bootstrapTable('getSelections');
			if(checkedRow(ck)){
				dialogOpen({
					title: '编辑banner表',
					url: 'base/advert/edit.html?_' + $.now(),
					width: '520px',
					height: '350px',
					success: function(iframeId){
						top.frames[iframeId].vm.tAdvert.id = ck[0].id;
						top.frames[iframeId].vm.setForm();
					},
					yes: function(iframeId){
						top.frames[iframeId].vm.acceptClick();
					}
				});
			}
		},
		remove: function() {
			var ck = $('#dataGrid').bootstrapTable('getSelections'), ids = [];	
			if(checkedArray(ck)){
				$.each(ck, function(idx, item){
					ids[idx] = item.id;
				});
				$.RemoveForm({
					url: '../../app/advert/remove?_' + $.now(),
			    	param: ids,
			    	success: function(data) {
			    		vm.load();
			    	}
				});
			}
		}
	}


})