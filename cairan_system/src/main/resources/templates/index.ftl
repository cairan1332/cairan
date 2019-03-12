<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${title} 登录</title>
    <link rel="stylesheet" type="text/css" href="/login/css/normalize.css"/>
    <link rel="stylesheet" type="text/css" href="/login/css/demo.css"/>
    <!--必要样式-->
    <link rel="stylesheet" type="text/css" href="/login/css/component.css"/>
    <style>
        * {
            padding: 0;
            margin: 0;
        }
    </style>
</head>
<body>
<div class="container demo-1">
    <div class="content">
        <div id="large-header" class="large-header">
            <canvas id="demo-canvas"></canvas>
            <div class="logo_box">
                <h3>欢迎登录</h3>
                <form action="/login" name="login" method="post">
                    <div class="input_outer">
                        <span class="u_user"></span>
                        <input name="userName" class="text" style="color: #FFFFFF !important" type="text"
                               placeholder="请输入账户">
                    </div>
                    <div class="input_outer">
                        <span class="us_uer"></span>
                        <input name="password" class="text"
                               style="color: #FFFFFF !important; position:absolute; z-index:100;" value=""
                               type="password" placeholder="请输入密码">
                    </div>
                    <#if message?exists>
                    <div style="color: red">${message}</div>
                    </#if >
                    <div class="mb2"><a class="act-but submit" href="javascript:login()" style="color: #FFFFFF">登录</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <script>
        function login() {
            if ($("input[name='userName']").val().trim() !== "" && $("input[name='password']").val().trim() !== "") {
                $("form[name='login']").submit();
            }
        }
    </script>
</div>
<script src="/public/js/jquery-1.9.0.min.js"></script>
<script src="/login/js/TweenLite.min.js"></script>
<script src="/login/js/EasePack.min.js"></script>
<script src="/login/js/rAF.js"></script>
<script src="/login/js/demo-1.js"></script>

</body>
</html>