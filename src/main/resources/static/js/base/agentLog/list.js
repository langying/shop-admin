/**
 * 渠道的推广统计js
 */

$(function () {
	initialPage();
	getGrid();
});

function initialPage() {
    vm.dateRangeSelect(1);
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
		url: '../../app/agentLog/list?_' + $.now(),
        height: $(window).height()-56,
        queryParams: function(params){
            params.name = vm.keyword;
            params.startDate = vm.startDate;
            params.endDate = vm.endDate;
            return params;
        },
		columns: [
			{checkbox: true},
            {field : "channelName", title : "渠道名称", width : "200px"},
            {field : "agentName", title : "公司名称", width : "200px"},
			{field : "days", title : "日期", width : "100px"},
			{field : "pv", title : "pv", width : "60px"},
			{field : "uv", title : "uv", width : "60px"},
            {field : "price", title : "单价", width : "60px"},
            {field : "settleNumber", title : "渠道结算数据", width : "100px"},
            {field : "realCost", title : "结算费用", width : "100px"},
            {field : "firstLoginNum", title : "当天app首次登录数", width : "100px"},
			{field : "registerNum", title : "用户注册数", width : "100px"},
			{field : "loginNum", title : "成功登录数", width : "100px"},
			{field : "loginRate", title : "登录率", width : "60px"},
			{field : "nowApplyNum", title : "立即申请的数量", width : "100px"}, 
			{field : "nowApplyPnum", title : "立即申请的人数", width : "100px"}, 
			{field : "nowApplyRate", title : "立即申请率", width : "100px"},
            {field : "averageNowApplyNum", title : "平均立即申请数", width : "100px"},
			{field : "applySuccessNum", title : "成功申请数", width : "100px"}, 
			{field : "averageApplySuccessNum", title : "平均我已申请数", width : "100px"}, 
			{field : "averageRegisterApplyNum", title : "注册用户平均申请订单数", width : "100px"},
            {field : "loginSevenNum", title : "7天内登录数", width : "100px"},
            {field : "averageSevenApplyNum", title : "APP首次登陆用户平均立即申请订单数", width : "100px"}
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
        dateRange : null,
		pageNumber:1,
		pageSize:1000
    },
	methods : {
		load: function() {
			$('#dataGrid').bootstrapTable('refresh');
		},
		save: function() {
			dialogOpen({
				title: '新增渠道的推广统计',
				url: 'base/agentLog/add.html?_' + $.now(),
				width: '420px',
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
					title: '编辑渠道的推广统计',
					url: 'base/agentLog/edit.html?_' + $.now(),
					width: '420px',
					height: '350px',
					success: function(iframeId){
						top.frames[iframeId].vm.tAgentLog.id = ck[0].id;
						top.frames[iframeId].vm.setForm();
					},
					yes: function(iframeId){
						top.frames[iframeId].vm.acceptClick();
					}
				});
			}
		},
		exports:function(){
			$("#pageNumber").val(vm.pageNumber);
            $("#pageSize").val(vm.pageSize);
            $("#name").val(vm.keyword);
            $("#startDate").val(vm.startDate);
            $("#endDate").val(vm.endDate);
			$("#form").submit();

		},
		remove: function() {
			var ck = $('#dataGrid').bootstrapTable('getSelections'), ids = [];	
			if(checkedArray(ck)){
				$.each(ck, function(idx, item){
					ids[idx] = item.id;
				});
				$.RemoveForm({
					url: '../../app/agentLog/remove?_' + $.now(),
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