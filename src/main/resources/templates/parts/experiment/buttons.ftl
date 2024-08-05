<#if status == "CREATED" || status == "FILLED_IN">
    <#include "buttons-materials.ftl">
    <#include "buttons-equipment.ftl">
    <#if eqName != unknownString><#include "buttons-action.ftl"></#if>
    <#if status == "FILLED_IN">
        <#if roleMANAGER == "yes">
            <form action="/research/experiments/${experiment.id}/approve" method="get">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button type="submit">Согласовать</button>
            </form>
        <#else>
            <form>
                <button type="submit" disabled>Ожидайте согласования старшим сотрудником</button>
            </form>
        </#if>
    </#if>
<#elseif status == "APPROVED">
    <form action="/research/experiments/${experiment.id}/start" method="get">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit">Начать проведение эксперимента</button>
    </form>
<#elseif status == "RUNNING">
    <form action="/research/experiments/${experiment.id}/finish" method="get">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit">Завершить проведение эксперимента</button>
    </form>
<#elseif status == "FINISHED">
    <form action="/research/experiments/${experiment.id}/create-report" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit">Предоставить отчёт</button>
    </form>
<#elseif status == "REPORTED">
</#if>

<#if status != "CANCELLED">
    <form action="/research/experiments/${experiment.id}/cancel" method="get">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit" <#if status == "CANCELLED">disabled</#if>>Отменить эксперимент</button>
    </form>
</#if>