<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Эксперимент ${experiment.id}</title>
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
    <script>
        function updateAddButtonValue(selectElement) {
            console.log("AAAAAAAAAAAAAAAAAAAAAA!!!!" + selectElement)
            document.getElementById("button-add").disabled = false;
            document.getElementById("button-add").value = selectElement.value;
        }
    </script>
</head>
<body>
<#include "parts/header.ftl">
<#assign status = experiment.statusName>
<main>
    <p></p>
    <#--  Кнопки управления процессом эксперимента  -->
    <#include "parts/experiment/buttons.ftl">
    <p></p>
    <#--  Таблица с полями эксперимента  -->
    <#include "parts/experiment/table.ftl">
</main>
</body>
</html>