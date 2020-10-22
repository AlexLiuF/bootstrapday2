function myAJax(url,data,type,success){
// 1. 创建xhr对象
    var xhr;
    try{
        xhr= new XMLHttpRequest();
    }catch(e){
        try{
            xhr = new ActiveXObject("Msxml2.XMLHTTP");
        }catch(e){
            try{
                xhr = new ActiveXObject("Microsoft.XMLHTTP");
            }catch(e){
                alert("您的浏览器不支持AJAX，请更换！");
                return false;
            }
        }
    }
// 2. 发起请求
// 2.1 设置请求方式和请求地址
// 2.2 发送数据
    if(type.toUpperCase() == "GET"){
        xhr.open("get",url+"?"+data);
        xhr.send();
    }else{
        xhr.open("post",url);
        //post方式必须设置Content-Type请求头，必须在open和send方法之前设置
        xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
        xhr.send(data);
    }

// 3. 监听响应
    xhr.onreadystatechange= function(){
        if(xhr.readyState == 4){
            if(xhr.status == 200){
                //xhr.responseText;//获取响应的字符串
                //通过dom操作，将结果显示到页面
                //不同情况下，对于 结果字符串 的处理的代码是不同的
                success(xhr.responseText);

            }else{
                console.log(xhr.responseText);//获取到异常信息
            }
        }
    };
}