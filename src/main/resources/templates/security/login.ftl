<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
</head>
<#include "../parts/header.ftl">
<body>
<form method="POST" action="/login" class="form-signin">
    <h2 class="form-heading">Log in</h2>

    <div class="form-group <#if error??> 'has-error' <#else> ''</#if>">
        <#if message??><span>${message}</span></#if>
        <input name="username" type="text" class="form-control" placeholder="Username"
               autofocus="true"/>
        <input name="password" type="password" class="form-control" placeholder="Password" prefix="{noop}"/>
        <#if error??><span>${error}</span></#if>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <button class="login" type="submit">Log In</button>
    </div>
</form>
</body>
</html>