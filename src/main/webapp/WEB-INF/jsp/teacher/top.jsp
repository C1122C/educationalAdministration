<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<div class="container" id="top">
    <div class="row">
        <div class="col-md-12">
            <div class="navbar navbar-default" role="navigation">
                　<div class="navbar-header">
                　    <a href="##" class="navbar-brand">教师登录</a>
                　</div>
                <div class="navbar-form navbar-right">
                    <div class="dropdown">
                        <div style="margin-right: 20px; font-size: 14px;margin-top: 10px;">
                            <span class="glyphicon glyphicon-user"><shiro:principal/></span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
