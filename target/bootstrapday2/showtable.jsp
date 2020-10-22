<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 2020/10/21
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width,initial-scale=1"/>
    <script src="js/jquery-1.12.4.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/bootstrap-datetimepicker.js"></script>

    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/bootstrap-table.css">
    <link rel="stylesheet" href="css/bootstrap-datetimepicker.css">
    <script src="js/bootstrap-table.js"></script>
    <script src="js/bootstrap-datetimepicker.zh-CN.js"></script>
    <script type="text/javascript">
      $(function(){
        $("#t1").bootstrapTable({
          columns:[
            {checkbox:true},
            {field:"id",title:"编号"},
            {field:"name",title:"姓名"},
            {field:"age",title:"年龄"},
            {field:"sex",title:"性别",
              formatter:function(value){
                  if(value=1){
                    value="男";
                  }else{
                    value="女";
                  }
                  return value;
              }
            },
            {field:"mobile",title:"手机"},
            {field:"brithday",title:"生日"},
            {field:"id",title:"操作",
              formatter:function(value){
                return "<button class='btn btn-danger' onclick='handleDelete("+value+")'>删除</button> <button class='btn btn-primary' onclick='openUpdateModal("+value+")'>更新</button>"
              }
            },
          ],
          url:"/bootstrapday2/selectByPerson",
          toolbar:"<button class='btn btn-danger' onclick='handleclick()' >删除</button> <button class='btn btn-primary' onclick='addclick()'>添加</button>",

          //排序规则
          sortName:"id", //是否启用排序
          sortOrder:"asc", //排序方式

          //搜索框
          search:true,  //是否显示表格搜索
          searchOnEnterKey:true,
          sidePagination:"server",

          //分页
          pagination:true,   //是否显示分页（*）
          pageSize:5,         //pageSize: rows,每页的记录行数（*）
          pageList:[2,5,10,20] //可供选择的每页的行数（*）
        })
      })

      function openUpdateModal(id){
        //发起ajax请求,获取用户的数据
        $.ajax({
          url:"/bootstrapday2/showOneUser",
          data:"id="+id,
          type:"post",
          dataType:"json",
          success:function(result){
            console.log(result);
            $("#id1").val(result.person.id);
            $("#name1").val(result.person.name);
            $("#age1").val(result.person.age);
            $("#sex1").val(result.person.sex);
            $("#brithday1").val(result.person.brithday);
            $("#mobile1").val(result.person.mobile);

            //打开更新模态框
            $("#update").modal("show");
          }
        })
      }
    </script>
  </head>
  <body>
  <table id="t1" class="table table-striped"></table><table id="table" class="table table-striped"></table>


    <!-- 添加的模态框-->
    <div class="modal"  id="formadd">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
            <h4>添加</h4>
          </div>
          <div class="form-group">
            <label for="name" class="control-label col-sm-6">用户名：</label>
            <div class="col-sm-6">
              <input type="text" name="name"  id="name" class="form-control">
            </div>
          </div>

          <div class="form-group">
            <label for="age" class="control-label col-sm-6">年龄</label>
            <div class="col-sm-6"><input type="text" name="age" id="age" class="form-control"></div>
          </div>

          <div class="form-group">
            <label  class="control-label col-sm-6">性别</label>
            <div class="col-sm-6">
              <select class="form-control" id="sex">
                <option value="1">男</option>
                <option value="0">女</option>
              </select>
            </div>
          </div>

          <div class="form-group">
            <label for="age" class="control-label col-sm-6">手机号</label>
            <div class="col-sm-6"><input type="text" name="mobile" id="mobile" class="form-control"></div>
          </div>

          <div class="form-group">
            <label class="control-label col-sm-6">生日</label>
            <div class="input-append date form_datetime col-sm-6">
              <input size="20" type="text" value="" readonly id="brithday">
              <span class="add-on"><i class="icon-remove"></i></span>
              <span class="add-on"><i class="icon-calendar"></i></span>
            </div>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal" >关闭</button>
            <button type="button" class="btn btn-primary" onclick="clickAddSave()">保存</button>
          </div>
          </div>
        </div>
      </div>
    </div>


  <!-- 修改的模态框-->
  <div class="modal"  id="update">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
          <h4>修改</h4>
        </div>
        <div class="form-group">
          <label for="name" class="control-label col-sm-6">用户名：</label>
          <div class="col-sm-6">
            <input type="hidden" name="id" id="id1">
            <input type="text" name="name"  id="name1" class="form-control">
          </div>
        </div>

        <div class="form-group">
          <label for="age" class="control-label col-sm-6">年龄</label>
          <div class="col-sm-6"><input type="text" name="age" id="age1" class="form-control"></div>
        </div>

        <div class="form-group">
          <label  class="control-label col-sm-6">性别</label>
          <div class="col-sm-6">
            <select class="form-control" id="sex1">
              <option value="1">男</option>
              <option value="0">女</option>
            </select>
          </div>
        </div>

        <div class="form-group">
          <label for="age" class="control-label col-sm-6">手机号</label>
          <div class="col-sm-6"><input type="text" name="mobile" id="mobile1" class="form-control"></div>
        </div>

        <div class="form-group">
          <label class="control-label col-sm-6">生日</label>
          <div class="input-append date form_datetime col-sm-6">
            <input size="20" type="text" value="" readonly id="brithday1">
            <span class="add-on"><i class="icon-remove"></i></span>
            <span class="add-on"><i class="icon-calendar"></i></span>
          </div>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal" >关闭</button>
            <button type="button" class="btn btn-primary" onclick="clickUpdateSave()">更新</button>
        </div>
      </div>
    </div>
  </div>
  </div>



  <script type="text/javascript">
    function handleclick(){
      //得到选中的多选框选择行数据
      var selections = $("#t1").bootstrapTable('getSelections');
      console.log(selections);
      var ids=[];
      //将选中框数据中的id的值赋给一个数组
      for(var i=0;i<selections.length;i++){
        console.log(selections[i].id);
        ids[i]=selections[i].id;
      }
      //数组改装成ids=1&ids=2....ids=n&形式的字符串
      var data = "";
      for(var i = 0;i <ids.length;i++){
        data +=("ids="+ids[i]+"&");
      }
      //利用方法去掉末尾多的&
      data = data.substring(0,data.length-1);
      console.log(data);

      //利用ajax调用action里面的删除方法
      $.ajax({
        url:"/bootstrapday2/deleteById",
        data:data,
        type:"post",
        dataType:"json",
        success:function(result){
          if(result.status=="success"){
            //刷新页面(得到table对象并且调用刷新方法
            $("#t1").bootstrapTable("refresh");
          }else{
            //弹出错误弹窗
            alert("删除失败");
          }
        }
      });
    }
    function addclick(){
      //展示添加的模态框
      $("#formadd").modal("show");
    }

    //时间插件语言设置
    $.fn.datetimepicker.dates['zh-CN'] = {
      days: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"],
      daysShort: ["周日", "周一", "周二", "周三", "周四", "周五", "周六", "周日"],
      daysMin:  ["日", "一", "二", "三", "四", "五", "六", "日"],
      months: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
      monthsShort: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
      today: "今天",
      suffix: [],
      meridiem: ["上午", "下午"]
    };
    //时间插件时间
    $(".form_datetime").datetimepicker({
      format:'yyyy-mm-dd',
      startView: "year", //初始化视图是‘年’
      minView: "day",//最精确视图为'月'
      maxView: "decade",//最高视图为'十年'
      autoclose:true,
      pickerPosition: "bottom-left",
      language:'zh-CN'
    });
    //提交
    function clickAddSave(){
      var namaVal=$("#name").val();
      var ageVal=$("#age").val();
      var sexVal=$("#sex").val();
      var brithdayVal=$("#brithday").val();
      var mobileVal=$("#mobile").val();
      console.log("性别"+sexVal);
      console.log("生日"+brithdayVal);
      var person="name="+namaVal+"&age="+ageVal+"&sex="+sexVal+"&brithday="+brithdayVal+"&mobile="+mobileVal;
      $.ajax({
        url:"/bootstrapday2/addPerson",
        data:person,
        type:"post",
        dataType:"json",
        success:function(result){
            console.log(result);
            if(result.status=="success"){
              //关闭模态框
              $("#formadd").modal("hide");
              //刷新表格
              $("#t1").bootstrapTable("refresh");
            }else{
              //弹出添加失败
                alert("添加失败");
            }
        }
      });
    }

    //删除一条
    function handleDelete(id){
      console.log("id"+id);
      //发起删除请求
      $.ajax({
        url:"/bootstrapday2/removePerson",
        data:"id="+id,
        type:"post",
        dataType:"json",
        success:function(result){
          console.log("result"+result.status);
          if (result.status == "success") {
            $("#t1").bootstrapTable("refresh");
          }else{
            alert("删除失败");
          }
        }
      })
    }
    //修改保存
    function clickUpdateSave(){
      var idVal=$("#id1").val();
      var namaVal=$("#name1").val();
      var ageVal=$("#age1").val();
      var sexVal=$("#sex1").val();
      var brithdayVal=$("#brithday1").val();
      var mobileVal=$("#mobile1").val();
      console.log("性别"+sexVal);
      console.log("生日"+brithdayVal);
      var person="id="+idVal+"&name="+namaVal+"&age="+ageVal+"&sex="+sexVal+"&brithday="+brithdayVal+"&mobile="+mobileVal;
      $.ajax({
        url:"/bootstrapday2/updatePerson",
        data:person,
        type:"post",
        dataType:"json",
        success:function(result){
          console.log(result);
          if(result.status=="success"){
            //关闭模态框
            $("#update").modal("hide");
            //刷新表格
            $("#t1").bootstrapTable("refresh");
          }else{
            //弹出添加失败
            alert("添加失败");
          }
        }
      });
    }
  </script>
  </body>
</html>
