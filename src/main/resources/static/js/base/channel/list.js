/**
 * 渠道表js
 */

$(function () {
	initialPage();
	getGrid();
});

function initialPage() {
	$(window).resize(function() {
		$('#dataGrid').bootstrapTable('resetView', {height: $(window).height()-56});
	});

    //日期选择
    laydate.render({
        elem: '#dateRange',
        range: true,
        theme: '#3C8DBC',
        eventElem: '#dateRange',
        trigger: 'click',
        done: function(value, date, endDate){
            vm.dateRangeSelect(0);
            vm.dateRange = value;
            vm.startDate = formatDate(date.year + '-' + date.month + '-' + date.date, 'yyyy-MM-dd');
            vm.endDate = formatDate(endDate.year + '-' + endDate.month + '-' + endDate.date, 'yyyy-MM-dd');
        }
    });
}

function getGrid() {
	$('#dataGrid').bootstrapTableEx({
		url: '../../app/channel/list?_' + $.now(),
		height: $(window).height()-56,
        queryParams: function(params){
            params.name = vm.keyword;
            params.startDate = vm.startDate;
            params.endDate = vm.endDate;
            return params;
        },
		columns: [
			{checkbox: true},
			{field : "id", title : "渠道id", width : "100px"},
			{field : "name", title : "渠道名称", width : "100px"},
            {field : "company", title : "公司名称", width : "100px"},
            {
                field : "channelType",
                title : "渠道类型",
                width : "60px",
                formatter : function(value, row, index) {
                    if (value == '1') {
                        return '<span class="label label-danger">贷超</span>';
                    } else if (value == '2') {
                        return '<span class="label label-success">短信</span>';
                    } else if (value == '3'){
                        return '<span class="label label-success">贷款被拒</span>';
					}else if (value == '4'){
                        return '<span class="label label-success">信息流</span>';
                    }else if (value == '5'){
                        return '<span class="label label-success">应用市场</span>';
                    }else if (value == '6'){
                        return '<span class="label label-success">代理</span>';
                    }else if (value == '7'){
                        return '<span class="label label-success">其它</span>';
                    }

                }
            },
			{field : "account", title : "帐号名", width : "60px"},
            {field : "password", title : "密码", width : "60px"},
            {field : "contact", title : "联系人", width : "60px"},
            {field : "phone", title : "联系电话", width : "60px"},
            {field : "position", title : "职务", width : "60px"},
            {field : "payment", title : "收款账号", width : "100px"},
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
            {
                field : "cooperationType",
                title : "合作方式",
                width : "60px",
                formatter : function(value, row, index) {
                    if (value == '1') {
                        return '<span class="label label-danger">CPA</span>';
                    } else if (value == '2') {
                        return '<span class="label label-success">CPC</span>';
                    }else if (value == '3') {
                        return '<span class="label label-success">按条</span>';
                    }else if (value == '4') {
                        return '<span class="label label-success">其他</span>';
                    }
                }
            },
            //{field : "content", title : "渠道信息", width : "200px"},
            {field : "address", title : "公司地址", width : "100px"},
            {field : "userName", title : "我司对接人", width : "100px"}

		]


	})
}

var vm = new Vue({
	el:'#dpLTE',
    data: {
        keyword: null,
        startDate : null,
        endDate : null,
        dateRangeText : '时间范围',
        dateRange : null
    },
	methods : {
		load: function() {
			$('#dataGrid').bootstrapTable('refresh');
		},
		save: function() {
			dialogOpen({
				title: '新增渠道表',
				url: 'base/channel/add.html?_' + $.now(),
				width: '720px',
				height: '550px',
				yes : function(iframeId) {
					top.frames[iframeId].vm.acceptClick();
				},
			});
		},
		edit: function() {
			var ck = $('#dataGrid').bootstrapTable('getSelections');
			if(checkedRow(ck)){
				dialogOpen({
					title: '编辑渠道表',
					url: 'base/channel/edit.html?_' + $.now(),
					width: '720px',
					height: '550px',
					success: function(iframeId){
						top.frames[iframeId].vm.tChannel.id = ck[0].id;
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
					url: '../../app/channel/remove?_' + $.now(),
			    	param: ids,
			    	success: function(data) {
			    		vm.load();
			    	}
				});
			}
		},dateRangeSelect : function(count) {
            if(count==1){
                vm.dateRangeText = '最近一天';
                vm.startDate = countDay(-1);
                vm.endDate = today();
                vm.dateRange = vm.startDate + ' - ' + vm.endDate;
            }else if(count ==7){
                vm.dateRangeText = '最近一周';
                vm.startDate = countDay(-7);
                vm.endDate = today();
                vm.dateRange = vm.startDate + ' - ' + vm.endDate;
            }else if(count ==30){
                vm.dateRangeText = '最近一月';
                vm.startDate = countDay(-30);
                vm.endDate = today();
                vm.dateRange = vm.startDate + ' - ' + vm.endDate;
            }else{
                vm.dateRangeText = '时间范围';
                vm.startDate = '';
                vm.endDate = '';
                vm.dateRange = '';
            }
        }
	}
})