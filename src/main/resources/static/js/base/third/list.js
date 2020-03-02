/**
 * 第三方链接js
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

function getGrid() {
	$('#dataGrid').bootstrapTableEx({
		url: '../../app/third/list?_' + $.now(),
		height: $(window).height()-56,
		queryParams: function(params){
			params.name = vm.keyword;
			return params;
		},
		columns: [
			{checkbox: true},
            {field : "id", title : "ID", width : "100px"},
            {field : "name", title : "推广名称", width : "100px"},
            {
                field : "type",
                title : "类型",
                width : "100px",
                formatter : function(value, row, index) {
                    if (value == '1') {
                        return '<span class="label label-danger">平台产品</span>';
                    } else if (value == '2') {
                        return '<span class="label label-success">推广链接</span>';
                    }
                }
            },
            {field : "code", title : "跳转码", width : "100px"},
            {field : "mirrorUrl", title : "伪链接地址", width : "100px"},
            {
                field : "status",
                title : "状态",
                width : "60px",
                formatter : function(value, row, index) {
                    if (value == '1') {
                        return '<span class="label label-danger">下线</span>';
                    } else if (value == '0') {
                        return '<span class="label label-success">上线</span>';
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
				title: '新增第三方链接',
				url: 'base/third/add.html?_' + $.now(),
				width: '620px',
				height: '500px',
				yes : function(iframeId) {
					top.frames[iframeId].vm.acceptClick();
				},
			});
		},
		edit: function() {
			var ck = $('#dataGrid').bootstrapTable('getSelections');
			if(checkedRow(ck)){
				dialogOpen({
					title: '编辑第三方链接',
					url: 'base/third/edit.html?_' + $.now(),
					width: '620px',
					height: '500px',
					success: function(iframeId){
						top.frames[iframeId].vm.tThird.id = ck[0].id;
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
					url: '../../app/third/remove?_' + $.now(),
			    	param: ids,
			    	success: function(data) {
			    		vm.load();
			    	}
				});
			}
		}
	}
})