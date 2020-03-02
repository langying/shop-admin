/**
 * 商户表js
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
		url: '../../app/merchants/list?_' + $.now(),
		height: $(window).height()-56,
		queryParams: function(params){
			params.name = vm.keyword;
			return params;
		},
		columns: [
			{checkbox: true},
			{field : "name", title : "客户名称", width : "100px"},
            {field : "company", title : "公司名称", width : "200px"},
            {field : "contact", title : "联系方式", width : "100px"},
            {field : "phone", title : "联系电话", width : "100px"},
            {
                field : "payType",
                title : "打款方式",
                width : "60px",
                formatter : function(value, row, index) {
                    if (value == '1') {
                        return '<span class="label label-danger">对公</span>';
                    } else if (value == '2') {
                        return '<span class="label label-success">对私</span>';
                    }
                }
            },
            {
                field : "settlementType",
                title : "结算方式",
                width : "60px",
                formatter : function(value, row, index) {
                    if (value == '1') {
                        return '<span class="label label-danger">预付</span>';
                    } else if (value == '2') {
                        return '<span class="label label-success">月结</span>';
                    }
                }
            },
			{field : "content", title : "客户相关信息", width : "200px"},
            {field : "userName", title : "我司对接人员", width : "100px"},
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
            }

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
				title: '新增商户表',
				url: 'base/merchants/add.html?_' + $.now(),
				width: '720px',
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
					title: '编辑商户表',
					url: 'base/merchants/edit.html?_' + $.now(),
					width: '720px',
					height: '450px',
					success: function(iframeId){
						top.frames[iframeId].vm.tMerchants.id = ck[0].id;
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
					url: '../../app/merchants/remove?_' + $.now(),
			    	param: ids,
			    	success: function(data) {
			    		vm.load();
			    	}
				});
			}
		}
	}
})