<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${title} 首页</title>
    <style>
        * {
            padding: 0;
            margin: 0;
        }

        :root {
            --header_height: 100px; /*头部高*/
            --footer_height: 40px; /*底部高*/
            --aside_width: 200px; /*左边菜单宽*/
        }

        header {
            position: absolute;
            top: 0;
            height: calc(var(--header_height) - 2px);
            background-color: mediumturquoise;
            width: 100%;
            border-bottom: red 2px solid;
        }

        .parcel {
            position: absolute;
            width: 100%;
            top: var(--header_height);
            bottom: var(--footer_height);
        }

        aside {
            position: absolute;
            left: 0;
            width: calc(var(--aside_width) - 2px);
            height: 100%;
            border-right: 2px red solid;
        }

        main {
            position: absolute;
            left: var(--aside_width);
            right: 0;
            height: 100%;
        }

        #iframeMain {
            position: absolute;
            width: 100%;
            height: 100%;
            border: 0;
        }

        footer {
            position: absolute;
            bottom: 0;
            height: var(--footer_height);
            background-color: bisque;
            width: 100%;
        }

        ul {
            margin-left: 5px;
        }

        li {
            /*list-style: none;*/
            margin: 10px;
        }

    </style>
    <script src="/public/js/jquery-1.9.0.min.js"></script>
</head>
<body>

<header>
    <a href="/logout">注销</a>
${user.userId}
${user.userName}
${user.nickName}
</header>
<div class="parcel">
    <!--菜单-->
    <aside>
        <#if catalogueTree?exists>
            ${catalogueTree}
        </#if>

    <#--<div class="sidebar">-->
    <#--<h2 class="sidebar-header"><p>功能导航</p></h2>-->
    <#--<ul class="nav" style="min-height: 263px;">-->
    <#--<li class="office">-->
    <#--<div class="nav-header"><a href="home.ftl" target="right" class="ue-clear"><span>首页</span><i-->
    <#--class="icon"></i></a></div>-->
    <#--</li>-->
    <#--<li class="land">-->
    <#--<div class="nav-header"><a href="JavaScript:;" class="ue-clear"><span>日常办公</span><i-->
    <#--class="icon hasChild"></i></a></div>-->
    <#--<ul class="subnav" style="display: none;">-->
    <#--<li><a href="work.html" target="right" class="">工作日志</a></li>-->
    <#--<li><a href="mywork.html" target="right" class="">我的工作日志</a></li>-->
    <#--<li><a href="recode.html" target="right" class="">定制任务</a></li>-->
    <#--<li><a href="myrecode.html" target="right" class="">我的任务</a></li>-->
    <#--<li><a href="schedule.html" target="right" class="">日程管理</a></li>-->
    <#--</ul>-->
    <#--</li>-->

    <#--<li class="train">-->
    <#--<div class="nav-header"><a href="JavaScript:;" class="ue-clear"><span>培训管理</span><i-->
    <#--class="icon hasChild"></i></a></div>-->
    <#--<ul class="subnav" style="display: none;">-->
    <#--<li><a href="mytrain.html" target="right" class="">我的培训</a></li>-->
    <#--<li><a href="train.html" target="right" class="">培训管理</a></li>-->

    <#--</ul>-->
    <#--</li>-->


    <#--<li class="email">-->
    <#--<div class="nav-header"><a href="mesage.html" class="ue-clear" target="right"><span>消息推送</span><i-->
    <#--class="icon"></i></a></div>-->
    <#--</li>-->
    <#--<li class="list_m">-->
    <#--<div class="nav-header"><a href="mailList.html" class="ue-clear" target="right"><span>通讯录管理</span><i-->
    <#--class="icon"></i></a></div>-->
    <#--</li>-->
    <#--<li class="news_m">-->
    <#--<div class="nav-header"><a href="notice.html" class="ue-clear" target="right"><span>通知通告</span><i-->
    <#--class="icon"></i></a></div>-->
    <#--</li>-->


    <#--<li class="dossier">-->
    <#--<div class="nav-header"><a href="JavaScript:;" class="ue-clear"><span>档案管理</span><i-->
    <#--class="icon hasChild"></i></a></div>-->
    <#--<ul class="subnav" style="display: none;">-->
    <#--<li><a href="dossier_my.html" target="right">个人档案</a></li>-->
    <#--<li><a href="dossier_puplic.html" target="right">公共档案</a></li>-->

    <#--</ul>-->
    <#--</li>-->

    <#--<li class="part current">-->
    <#--<div class="nav-header"><a href="JavaScript:;" class="ue-clear"><span>系统管理</span><i-->
    <#--class="icon hasChild"></i></a></div>-->
    <#--<ul class="subnav" style="display: block;">-->
    <#--<li><a href="person.html" target="right" class="color">用户管理</a></li>-->
    <#--<li><a href="part.html" target="right">部门管理</a></li>-->

    <#--<li><a href="role.html" target="right">角色管理</a></li>-->

    <#--</ul>-->
    <#--</li>-->
    <#--</ul>-->
    <#--</div>-->
    </aside>
    <!--主体信息-->
    <main>
        <iframe name="iframeMain" id="iframeMain" src="/main.html">
        </iframe>

    </main>

</div>
<footer>Footer</footer>

</body>
<script src="../public/js/jquery-1.9.0.min.js"></script>
</html>