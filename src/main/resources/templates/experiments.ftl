<!DOCTYPE html>
<html>
<head>
    <title>Эксперименты</title>
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
        <#list experiments as experiment>
            <tr>
                <td><a href="/experiments/${experiment.id}">#${experiment.id}</a></td>
                <td>${experiment.createdAt}</td>
                <td>${experiment.createdBy}</td>
                <td>${experiment.statusName}</td>
                <td>${experiment.statusDescription}</td>
            </tr>
        </#list>
    </table>
</main>
</body>
</html>