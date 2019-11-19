$(function () {
    var $userTableForm = $(".user-table-form");
    var settings = {
        url: ctx + "uaUserSearch/uaUserSearch",
        pageSize: 10,
        queryParams: function (params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
                userNo: $userTableForm.find("input[name='userNo']").val().trim()
            };
        },
        columns: [{
                checkbox: true
            }, {
                field: 'id',
                visible: false
            }, {
                field: 'userId',
                title: '用户编号'
            }, {
                field: 'activityEnrolDate',
                title: '注册激活时间',
                formatter : function(value, row, index){
                   return $MB.formatDatebox(value);
                }
            }, {
                field: 'noticeEnrolDate',
                title: '验证关注时间',
                formatter : function(value, row, index){
                   return $MB.formatDatebox(value);
                }
            }, {
                field: 'pre1EnrolDate',
                title: '预注册（有一条模型）时间',
                formatter : function(value, row, index){
                   return $MB.formatDatebox(value);
                }
            }, {
                field: 'pre2EnrolDate',
                title: '预注册（有两条模型）时间',
                formatter : function(value, row, index){
                   return $MB.formatDatebox(value);
                }
            }, {
                field: 'deleteEnrolDate',
                title: '注销时间',
                formatter : function(value, row, index){
                   return $MB.formatDatebox(value);
                }
        }]
    };
    $MB.initTable('uaUserSearchTable', settings);
});

//根据条件查找
function search() {
    var userNo = $(".user-table-form").find("input[name='userNo']").val().trim();
    if(userNo == null || userNo == ""){
        $MB.n_warning("请输入用户ID！");
    }else{
        $MB.refreshTable('uaUserSearchTable');
    }

}

function refresh() {
    $(".user-table-form")[0].reset();
    $MB.refreshTable('uaUserSearchTable');
}

function deleteUsers() {
    var selected = $("#uaUserSearchTable").bootstrapTable('getSelections');
    var selected_length = selected.length;
    if (!selected_length) {
        $MB.n_warning('请勾选需要从黑白名单中删除的用户！');
        return;
    }
    var ids = "";               //获取要删除用户的主键
    var userNos = ""; //获取要删除的用户名
    for (var i = 0; i < selected_length; i++) {
        ids += selected[i].id;
        userNos += selected[i].userId;
        if (i !== (selected_length - 1)){
            ids += ",";
            userNos += ",";
        }
    }

    $MB.confirm({
        text: "确定删除选中用户"+ userNos +"？",
        confirmButtonText: "确定删除"
    }, function () {
        $.post(ctx + 'uaUser/userListsDelete', {"ids": ids}, function (r) {
            if (r.code === 0) {
                $MB.n_success(r.msg);
                refresh();
            } else {
                $MB.n_danger(r.msg);
            }
        });
    });
}

//导出到Excel
function exportUserExcel() {
    $.post(ctx + "user/excel", $(".user-table-form").serialize(), function (r) {
        if (r.code === 0) {
            window.location.href = "common/download?fileName=" + r.msg + "&delete=" + true;
        } else {
            $MB.n_warning(r.msg);
        }
    });
}

//导出到Csv
function exportUserCsv() {
    $.post(ctx + "user/csv", $(".user-table-form").serialize(), function (r) {
        if (r.code === 0) {
            window.location.href = "common/download?fileName=" + r.msg + "&delete=" + true;
        } else {
            $MB.n_warning(r.msg);
        }
    });
}