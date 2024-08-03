<!DOCTYPE html>
<html>
<head>
    <title>Оборудование</title>
</head>
<body>
<header>
    <nav>
        <a href="/">Home</a> |
        <a href="/experiments">Эксперименты</a> |
        <a href="/materials">Материалы</a> |
        <a href="/equipment">Оборудование</a> |
    </nav>
</header>
<main>
    <h1>Список экспериментов</h1>
    <table>
        <#list equipment as eq>
            <tr>
                <td>${eq.name}</td>
                <td>${eq.type}</td>
                <td>${eq.amount}</td>
            </tr>
        </#list>
    </table>
</main>
</body>
</html>