/**
 * 产品统计js
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
		url: '../../app/productLog/listMerchants?_' + $.now(),
        height: $(window).height()-56,
        queryParams: function(params){
            params.name = vm.keyword;
            params.startDate = vm.startDate;
            params.endDate = vm.endDate;
            return params;
        },
		columns: [
			{checkbox: true},
            {field : "days", title : "日期", width : "100px"},
			{field : "merchantsName", title : "客户名称", width : "60px"},
            {field : "productName", title : "产品名称", width : "100px"},
            {
                field : "cooperationType",
                title : "合作模式",
                width : "60px",
                formatter : function(value, row, index) {
                    if (value == '1') {
                        return '<span class="label label-danger">CPA</span>';
                    } else if (value == '2') {
                        return '<span class="label label-success">CPC</span>';
                    }
                }
            },
            {field : "price", title : "产品单价", width : "60px"},
			{field : "income", title : "产品费用", width : "60px"},
            {field : "upPayment", title : "客户预付款", width : "60px"},
            {field : "resPayment", title : "客户预付款剩余", width : "60px"}

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
				title: '新增产品统计',
				url: 'base/productLog/add.html?_' + $.now(),
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
					title: '编辑产品统计',
					url: 'base/productLog/edit_merchants.html?_' + $.now(),
					width: '520px',
					height: '450px',
					success: function(iframeId){
						top.frames[iframeId].vm.tProductLog.id = ck[0].id;
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
					url: '../../app/productLog/remove?_' + $.now(),
			    	param: ids,
			    	success: function(data) {
			    		vm.load();
			    	}
				});
			}
		}
		,dateRangeSelect : function(count) {
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