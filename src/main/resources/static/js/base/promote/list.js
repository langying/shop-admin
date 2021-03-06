/**
 * 首页推荐位表js
 */

$(function () {
	initialPage();
	getGrid();
});

function initialPage() {
	$(window).resize(function() {
		$('#dataGrid').bootstrapTable('resetView', {height: $(window).height()-56});
	});
}



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


function getGrid() {
	$('#dataGrid').bootstrapTableEx({
		url: '../../app/promote/list?_' + $.now(),
		height: $(window).height()-56,
		queryParams: function(params){
			params.name = vm.keyword;
			return params;
		},
		columns: [
			{checkbox: true},
			{field : "name", title : "名称", width : "100px"}, 
			{field : "describe", title : "文案", width : "100px"},
            { field: 'imgUrl', title: '封面',width : "120px",
                formatter:function(value,row,index){
                    var s = '<a class = "view"  href="javascript:void(0)"><img style="width:50px;height:50px;"  src="'+value+'" /></a>';
                    return s;
                },
                //定义点击之后放大图片的事件
                events: 'operateEvents'
            },
            {
                field : "type",
                title : "类型",
                width : "100px",
                formatter : function(value, row, index) {
                    if (value == '1') {
                        return '分类引导';
                    } else if (value == '2') {
                        return '产品栏目';
                    }else if(value =='3'){
                    	return '指定产品'
					}
                }
            },
			{field : "columnName", title : "栏目名称", width : "100px"},
            {field : "productName", title : "产品名称", width : "100px"},
			{field : "orderNum", title : "排序", width : "100px"},
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
				title: '新增首页推荐位表',
				url: 'base/promote/add.html?_' + $.now(),
				width: '620px',
				height: '450px',
				yes : function(iframeId) {
					top.frames[iframeId].vm.acceptClick();
				},
			});
		},
		edit: function() {
			var ck = $('#dataGrid').bootstrapTable('getSelections');
			if(checkedRow(ck)){
				dialogOpen({
					title: '编辑首页推荐位表',
					url: 'base/promote/edit.html?_' + $.now(),
					width: '620px',
					height: '450px',
					success: function(iframeId){
						top.frames[iframeId].vm.tPromote.id = ck[0].id;
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
					url: '../../app/promote/remove?_' + $.now(),
			    	param: ids,
			    	success: function(data) {
			    		vm.load();
			    	}
				});
			}
		}
	}
})