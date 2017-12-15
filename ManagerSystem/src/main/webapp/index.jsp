<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
      <title>Title</title>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet">

    <!-- Mainly scripts -->
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

    <!-- Custom and plugin javascript -->
    <script src="${pageContext.request.contextPath}/static/js/inspinia.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/plugins/pace/pace.min.js"></script>

    <script>
        function getPage(url,name) {
            if(url!=""){
                $.ajax({cache: false});
                $("#title h2").text(name);
                $("#title strong").text(name);
                $("#content").load(url,function(result){
                    //alert(result);
                    //将被加载页的JavaScript加载到本页执行
                    $result = $(result);
                    $result.find("script").appendTo('#content');
                });
            }
        }
    </script>
</head>
<body class="">
<div id="wrapper">
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav metismenu" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element"> <span>
                        <c:if test=""></c:if>
                            <img alt="image" class="img-circle" src="${pageContext.request.contextPath}/static/img/profile_small.jpg" />
                             </span>
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold">${user.username}</strong>
                             </span> <span class="text-muted text-xs block">Art Director <b class="caret"></b></span> </span> </a>
                        <ul class="dropdown-menu animated fadeInRight m-t-xs">
                            <li><a href="profile.html" id="">个人信息</a></li>
                            <li><a href="contacts.html">Contacts</a></li>
                            <li><a href="mailbox.html">邮箱</a></li>
                            <li class="divider"></li>
                            <li><a href="login.html">安全退出</a></li>
                        </ul>
                    </div>
                    <div class="logo-element">
                        IN+
                    </div>
                </li>
                <c:forEach items="${mlist}" var="tree">
                <li>
                    <a onclick="getPage('${tree.url}','${tree.menu_name}')"><i class="${tree.icon}"></i> <span class="nav-label">${tree.menu_name}</span>
                        <c:if test="${!empty tree.children}">
                        <span class="fa arrow"></span>
                        </c:if>
                     </a>
                    <c:if test="${!empty tree.children}">
                    <ul class="nav nav-second-level collapse">
                        <c:forEach items="${tree.children}" var="menu">
                        <li><a onclick="getPage('${menu.url}','${menu.menu_name}')">
                        <i class="${menu.icon}"></i>
                        <span class="nav-label">${menu.menu_name}</span>
                        </a></li>
                        </c:forEach>
                    </ul>
                    </c:if>
                </li>
                </c:forEach>
            </ul>
        </div>
    </nav>
    <div id="page-wrapper" class="gray-bg">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top  " role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
                    <form role="search" class="navbar-form-custom" action="search_results.html">
                        <div class="form-group">
                            <input type="text" placeholder="Search for something..." class="form-control" name="top-search" id="top-search">
                        </div>
                    </form>
                </div>
                <ul class="nav navbar-top-links navbar-right">
                    <li>
                        <span class="m-r-sm text-muted welcome-message">Welcome to INSPINIA+ Admin Theme.</span>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                            <i class="fa fa-envelope"></i>  <span class="label label-warning">16</span>
                        </a>
                        <ul class="dropdown-menu dropdown-messages">
                            <li>
                                <div class="dropdown-messages-box">
                                    <a href="profile.html" class="pull-left">
                                        <img alt="image" class="img-circle" src="/static/img/a7.jpg">
                                    </a>
                                    <div class="media-body">
                                        <small class="pull-right">46h ago</small>
                                        <strong>Mike Loreipsum</strong> started following <strong>Monica Smith</strong>. <br>
                                        <small class="text-muted">3 days ago at 7:58 pm - 10.06.2014</small>
                                    </div>

                                </div>

                            </li>

                            <li class="divider"></li>

                        </ul>

                    </li>

                    <li class="dropdown">

                        <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">

                            <i class="fa fa-bell"></i>  <span class="label label-primary">8</span>

                        </a>

                        <ul class="dropdown-menu dropdown-alerts">

                            <li>

                                <a href="mailbox.html">

                                    <div>

                                        <i class="fa fa-envelope fa-fw"></i> You have 16 messages

                                        <span class="pull-right text-muted small">4 minutes ago</span>

                                    </div>

                                </a>

                            </li>

                            <li class="divider"></li>

                        </ul>

                    </li>

                    <li>

                        <a href="login.html">

                            <i class="fa fa-sign-out"></i> 退出

                        </a>

                    </li>

                </ul>



            </nav>

        </div>

        <div class="row wrapper border-bottom white-bg page-heading" id="title">

            <div class="col-sm-4">

                <h2></h2>

                <ol class="breadcrumb">

                    <li>

                        <a href="index.html" id="index">首页</a>

                    </li>

                    <li class="active">

                        <span>Breadcrumb</span>

                    </li>

                    <li class="active">

                        <strong>Breadcrumb</strong>

                    </li>

                </ol>

            </div>

        </div>

        <div class="wrapper wrapper-content" id="content"></div>

        <div class="footer">

            <div class="pull-right">

                10GB of <strong>250GB</strong> Free.

            </div>

            <div>

                <strong>Copyright</strong> Example Company &copy; 2014-2017

            </div>

        </div>

    </div>

</div>

</body>
</html>
