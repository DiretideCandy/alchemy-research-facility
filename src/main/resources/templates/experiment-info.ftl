<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Эксперимент ${experiment.id}</title>
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
    <script>
        function updateButtonValueAndEnable(selectElement, buttonId) {
            document.getElementById(buttonId).disabled = false;
            document.getElementById(buttonId).value = selectElement.value;
        }
    </script>
</head>
<body>
<#assign status = experiment.statusName>
<#assign eqName = experiment.equipmentName>
<#assign repText = experiment.reportText>
<#include "parts/header.ftl">
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