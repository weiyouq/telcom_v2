$(function () {
    var $userTableForm = $(".user-table-form");
    $('#datetimepicker1').datetimepicker({
        format: 'YYYY-MM-DD'
    });
    var settings = {
        url: ctx + "uaUserCount/uaUserCount",
        pageSize: 10,
        queryParams: function (params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
                beginTime: $userTableForm.find("input[name='beginTime']").val()
            };
        },
        columns: [{
                checkbox: true
            },{
                field: 'activityCount',
                title: '注册激活ID数'
            }, {
                field: 'onePreMod',
                title: '预注册ID数（有一条预注册模型数量）'
            }, {
                field: 'twoPreMod',
                title: '预注册ID数（有两条预注册模型数量）'
            }, {
                field: 'verifyNotice',
                title: '验证关注ID数'
            }, {
                field: 'deleteCount',
                title: '注销ID数'
        }]
    };
    $MB.initTable('uaUserCountTable', settings);
});

//根据条件查找
function search() {
    $MB.refreshTable('uaUserCountTable');
}

function refresh() {
    $(".user-table-form")[0].reset();
    $MB.refreshTable('uaUserCountTable');
}
