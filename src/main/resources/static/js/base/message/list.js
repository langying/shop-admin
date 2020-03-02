/**
 * 消息推送表js
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
		url: '../../app/message/list?_' + $.now(),
		height: $(window).height()-56,
		queryParams: function(params){
			params.name = vm.keyword;
			return params;
		},
		columns: [
			{checkbox: true},
			{field : "title", title : "标题", width : "100px"},
			{field : "content", title : "推送内容", width : "100px"},
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
			{field : "name", title : "产品名称", width : "200px"},
			{field : "linkUrl", title : "链接地址", width : "100px"},
            {
                field : "channel",
                title : "渠道",
                width : "100px",
                formatter : function(value, row, index) {
                    if (value == 'android') {
                        return '<span class="label label-danger">安卓</span>';
                    } else if (value == 'ios') {
                        return '<span class="label label-success">苹果</span>';
                    }else if(value == 'all'){
                        return '<span class="label label-success">所有</span>';
					}else{
                        return '<span class="label label-success">无</span>';
					}
                }
            },
			{field : "gmtCreate", title : "创建时间", width : "100px"},
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
				title: '新增消息推送表',
				url: 'base/message/add.html?_' + $.now(),
				width: '520px',
				height: '420px',
				yes : function(iframeId) {
					top.frames[iframeId].vm.acceptClick();
				},
			});
		},
		edit: function() {
			var ck = $('#dataGrid').bootstrapTable('getSelections');
			if(checkedRow(ck)){
				dialogOpen({
					title: '编辑消息推送表',
					url: 'base/message/edit.html?_' + $.now(),
					width: '520px',
					height: '420px',
					success: function(iframeId){
						top.frames[iframeId].vm.tMessage.id = ck[0].id;
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
					url: '../../app/message/remove?_' + $.now(),
			    	param: ids,
			    	success: function(data) {
			    		vm.load();
			    	}
				});
			}
		}
	}
})