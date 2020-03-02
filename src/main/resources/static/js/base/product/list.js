/**
 * 产品表js
 */

$(function () {
	initialPage();
	getGrid();
});

function initialPage() {
    vm.dateRangeSelect(0);
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
            area: ['700px', '300px'],
            skin: 'layui-layer-nobg', //没有背景色
            shadeClose: true,
            content: '<img  src="'+value+'"/>'
        });
    },
};

function getGrid() {
	$('#dataGrid').bootstrapTableEx({
		url: '../../app/product/list?_' + $.now(),
		height: $(window).height()-56,
		queryParams: function(params){
            params.name = vm.keyword;
            params.startDate = vm.startDate;
            params.endDate = vm.endDate;
			return params;
		},
		columns: [
			{checkbox: true},
            {field : "id", title : "ID", width : "60px"},
            {field : "name", title : "产品名称", width : "60px"},
            {field : "price", title : "产品单价", width : "60px"},
            {field : "merchantsName", title : "商户名称", width : "60px"},
            {field : "orderNum", title : "主推排序值", width : "60px"},
            {field : "sortNum", title : "贷款排序值", width : "60px"},
            {field : "lendNum", title : "能借到排序值", width : "60px"},
            {
                field : "recommendFlag",
                title : "是否主推",
                width : "60px",
                formatter : function(value, row, index) {
                    if (value == '1') {
                        return '<span class="label label-danger">推荐</span>';
                    } else if (value == '0') {
                        return '<span class="label label-success">不推荐</span>';
                    }
                }
            },
            {
                field : "hotFlag",
                title : "是否秒批",
                width : "60px",
                formatter : function(value, row, index) {
                    if (value == '1') {
                        return '<span class="label label-danger">是</span>';
                    } else if (value == '0') {
                        return '<span class="label label-success">否</span>';
                    }
                }
            },
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

			{field : "content", title : "产品后台", width : "400px"}
			//, {field : "gmtCreate", title : "创建时间", width : "150px"}
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
				title: '新增产品表',
				url: 'base/product/add.html?_' + $.now(),
				width: '820px',
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
					title: '编辑产品表',
					url: 'base/product/edit.html?_' + $.now(),
					width: '820px',
					height: '550px',
					success: function(iframeId){
						top.frames[iframeId].vm.tProduct.id = ck[0].id;
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
					url: '../../app/product/remove?_' + $.now(),
			    	param: ids,
			    	success: function(data) {
			    		vm.load();
			    	}
				});
			}
		},
        dateRangeSelect : function(count) {
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
        },
	}
})