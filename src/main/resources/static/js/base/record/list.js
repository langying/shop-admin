/**
 * 申请记录表js
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
		url: '../../app/record/list?_' + $.now(),
		height: $(window).height()-56,
        queryParams: function(params){
            params.name = vm.keyword;
            params.startDate = vm.startDate;
            params.endDate = vm.endDate;
            return params;
        },
		columns: [
			{checkbox: true},
            {field : "id", title : "ID", width : "100px"},
            {field : "account", title : "用户", width : "100px"},
            {field : "productName", title : "产品名称", width : "100px"},
			{field : "gmtCreate", title : "申请时间", width : "100px"}
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
				title: '新增申请记录表',
				url: 'base/record/add.html?_' + $.now(),
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
					title: '编辑申请记录表',
					url: 'base/record/edit.html?_' + $.now(),
					width: '420px',
					height: '350px',
					success: function(iframeId){
						top.frames[iframeId].vm.tApplyRecord.id = ck[0].id;
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
					url: '../../app/record/remove?_' + $.now(),
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