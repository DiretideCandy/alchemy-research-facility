<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Отчёт ${report.id}</title>
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
</head>
<body>
<#include "parts/header.ftl">
<main class="a4-main">
    <div class="a4-page">
        <div class="a4-header">
            <span>Ответственный: ${report.experimentCreatedBy}</span><br>
            <span>Согласующий: ${report.experimentApprovedBy}</span>
        </div>
        <div class="a4-title">
            Эксперимент №${report.experimentId}
        </div>
        <div class="a4-content">
            ${report.text}
        </div>
        <div class="a4-footer">
            <div class="date">
                ${report.experimentLastUpdatedBy}
            </div>
            <div class="a4-signatures">
                <span>Подпись ответственного: ________________</span>
                <br><br><br>
                <span>Подпись согласующего: ________________</span>
            </div>
        </div>
    </div>

</main>
</body>
</html>