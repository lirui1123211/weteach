<!DOCTYPE html>
<html lang="en">
<head>
    <title>登录</title>
    <meta content="text/html" charset="utf-8">
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/static/css/bootstrap.css" media="screen">
    <link rel="stylesheet" href="/static/external/HubSpot-messenger/build/css/messenger.css" media="screen">
    <link rel="stylesheet" href="/static/external/HubSpot-messenger/build/css/messenger-theme-air.css" media="screen">
    <link rel="stylesheet" href="/static/external/pace-master/themes/black/pace-theme-material.css" media="screen">
    <link rel="stylesheet" href="/static/external/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.css"
          media="screen">
    <link rel="stylesheet" href="/static/css/main-campus.css" media="screen">
</head>
<body>
<div id="vm">
    <div class="jumbotron jumbotron-fluid align-items-center">
        <div class="container-fluid ">
            <div class="container ">
                <h1 class="display-4">Hello, world!</h1>
                <p class="lead ">
                    You can sign in from here, register or modify your user information
                </p>
            </div>
            <hr class="my-4">
            <div class="container">
                <div class="row justify-content-end">
                    <div class="col-4 ">
                        <form @submit.prevent="login($event)">
                            <div class="form-group">
                                <label for="username">Username</label>
                                <input type="text" class="form-control" id="username"
                                       v-model="username" name="username"
                                       data-toggle="tooltip"
                                       data-placement="left" title="请输入有效的用户名"
                                       aria-describedby="usernameHelp" placeholder="Enter Username">
                                <small id="usernameHelp" class="form-text text-muted">

                                </small>
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input type="password" class="form-control" id="password"
                                       v-model="password" name="password"
                                       data-toggle="tooltip"
                                       data-placement="left" title="请输入密码"
                                       aria-describedby="passwordHelp" placeholder="Password">
                                <small id="passwordHelp" class="form-text text-muted">

                                </small>
                            </div>
                            <div class="form-group">
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" id="gridCheck" name="rememberMe">
                                    <label class="form-check-label" for="gridCheck">
                                        Remember me
                                    </label>
                                </div>
                            </div>
                            <!--<div class="form-group  ">
                                <label for="dateTime">日期</label>
                                <div class="input-group date form_datetime">
                                    <input type="text" class="form-control" id="dateTime"
                                           name="dateTime"
                                           data-toggle="tooltip"
                                           data-placement="left" title="请输入日期"
                                           aria-describedby="dateTimeHelp" placeholder="Date Time"
                                           readonly>
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                </div>
                                <small id="dateTimeHelp" class="form-text text-muted">

                                </small>
                            </div>-->

                            <div class="btn-group">
                                <button class="btn btn-primary" type="submit">
                                    Submit
                                </button>
                                <button type="button"
                                        class="btn btn-primary dropdown-toggle dropdown-toggle-split"
                                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="sr-only">Toggle Dropdown</span>
                                </button>
                                <div class="dropdown-menu">
                                    <a class="dropdown-item" href="#" @click="changeHost('base')">member</a>
                                    <a class="dropdown-item" href="#" @click="changeHost('system')">administrator</a>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="/static/js/jquery-3.3.1.js"></script>
<script src="/static/js/jquery.form.js"></script>
<script src="/static/js/popper.js"></script>
<script src="/static/js/bootstrap.min.js"></script>
<script src="/static/js/vue.js"></script>
<script src="/static/external/HubSpot-messenger/build/js/messenger.js"></script>
<script src="/static/external/pace-master/pace.js"></script>
<script src="/static/external/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.js"></script>
<script src="/static/js/main-campus.js"></script>
<script>
    let vm = new Vue({
        el: "#vm",
        data: {
            username: null,
            password: null,
            host: "base"
        },
        beforeCreate: function () {
        },
        created: function () {
        },
        updated: function () {
        },
        methods: {
            login: function (e) {
                $(e.currentTarget).ajaxSubmit({
                    url: "/" + vm.host + "/user/login",
                    type: "post",
                    success: function (data) {
                        Messenger().post({
                            id: "loginMessenger",
                            message: data.msg,//提示信息
                            type: data.result ? 'success' : 'error',//消息类型。error、info、success
                            hideAfter: 2,//多长时间消失
                            showCloseButton: true,//是否显示关闭按钮
                            hideOnNavigate: false//是否隐藏导航
                        });
                        setTimeout(function () {
                            window.location.href = data.url;
                        }, 2000);

                    }
                });
            },
            changeHost: function (host) {
                vm.host = host;
            }
        }
    });
</script>

</body>
</html>