<!DOCTYPE html>
<html>
<head>
    <title>Материалы</title>
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
    <h1>Список материалов</h1>
    <table>
        <#list materials as material>
            <tr>
                <td>${material.name}</td>
                <td>${material.type}</td>
                <td>${material.amount}</td>
            </tr>
        </#list>
    </table>
</main>
</body>
</html>