/**
 * 渠道的代理(推广)表js
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
		url: '../../app/channelAgent/list?_' + $.now(),
		height: $(window).height()-56,
        queryParams: function(params){
            params.name = vm.keyword;
            params.startDate = vm.startDate;
            params.endDate = vm.endDate;
            return params;
        },
		columns: [
			{checkbox: true},
			{field : "channelName", title : "渠道名称", width : "100px"},
			{field : "name", title : "位置组名称", width : "200px"},
            {field : "price", title : "单价", width : "60px"},
            {field : "account", title : "帐号名", width : "60px"},
            {field : "password", title : "密码", width : "60px"},
            {field : "discount", title : "扣量系数", width : "60px"},
            {field : "initNumber", title : "扣量初始值", width : "60px"},
            {
                field : "payType",
                title : "结账方式",
                width : "60px",
                formatter : function(value, row, index) {
                    if (value == '1') {
                        return '<span class="label label-danger">对公</span>';
                    } else if (value == '2') {
                        return '<span class="label label-success">对私</span>';
                    }
                }
            },
			{field : "mirrorUrl", title : "推广链接", width : "200px"},
			{field : "content", title : "详细信息", width : "100px"},
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
				title: '新增渠道的代理(推广)表',
				url: 'base/channelAgent/add.html?_' + $.now(),
				width: '520px',
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
					title: '编辑渠道的代理(推广)表',
					url: 'base/channelAgent/edit.html?_' + $.now(),
					width: '520px',
					height: '450px',
					success: function(iframeId){
						top.frames[iframeId].vm.tChannelAgent.id = ck[0].id;
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
					url: '../../app/channelAgent/remove?_' + $.now(),
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