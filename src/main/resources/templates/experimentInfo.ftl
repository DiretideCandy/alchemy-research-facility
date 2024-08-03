<!DOCTYPE html>
<html>
<head>
    <title>Эксперимент ${experiment.id}</title>
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
    <h1>Detail Page</h1>
    <table>
        <tr>
            <th>Field</th><th>Value</th>
        </tr>
        <tr>
            <td>id</td><td>${experiment.id}</td>
        </tr>
        <tr>
            <td>createdAt</td><td>${experiment.createdAt}</td>
        </tr>
        <tr>
            <td>createdBy</td><td>${experiment.createdBy}</td>
        </tr>
        <tr>
            <td>lastUpdatedAt</td><td>${experiment.lastUpdatedAt}</td>
        </tr>
        <tr>
            <td>statusDescription</td><td>${experiment.statusDescription}</td>
        </tr>
        <tr>
            <td>statusName</td><td>${experiment.statusName}</td>
        </tr>
    </table>
    </main>
</body>
</html>