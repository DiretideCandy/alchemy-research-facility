<header>
    <#assign anon="anonymousUser">
    <#assign user=currentUser!anon>
    <nav>
        <a href="/research">Главная</a> |
        <a href="/research/experiments">Эксперименты</a> |
        <a href="/research/materials">Материалы</a> |
        <a href="/research/equipment">Оборудование</a>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <#if user!=anon>[
            &nbsp;${user}&nbsp;|
            <a href="/logout">Выйти</a>
        ]</#if>

    </nav>
</header>