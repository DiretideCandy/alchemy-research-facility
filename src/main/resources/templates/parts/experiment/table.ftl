<table>
    <tr>
        <td>Номер</td>
        <td>${experiment.id}</td>
    </tr>
    <tr>
        <td>Дата создания</td>
        <td>${experiment.createdAt}</td>
    </tr>
    <tr>
        <td>Дата изменения</td>
        <td>${experiment.lastUpdatedAt}</td>
    </tr>
    <tr>
        <td>Ответственный</td>
        <td>${experiment.createdBy}</td>
    </tr>
    <tr>
        <td>Статус</td>
        <td>${experiment.statusDescription}</td>
    </tr>
    <#if progress != 0>
        <tr>
            <td>Прогресс</td>
            <td><#include "progress-bar.ftl"></td>
        </tr>
    </#if>
    <#if approvedBy != unknownString>
        <tr>
            <td>Согласовано</td>
            <td>${approvedBy}</td>
        </tr>
    </#if>
    <tr>
        <td>Используемые материалы</td>
        <td>
            <#if experiment.materials?size == 0>
                Не выбраны
            <#else>
                <table>
                    <thead>
                    <tr>
                        <th>Название</th>
                        <th>Тип или источник</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list experiment.materials as material>
                        <tr>
                            <td>${material.name}</td>
                            <td>${material.typePrettyName}</td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </#if>
        </td>
    </tr>
    <tr>
        <td>Оборудование</td>
        <td>
            <#if eqName != unknownString>
                ${eqName}
            <#else>
                Не выбрано
            </#if>
        </td>
    </tr>
    <#if eqName != unknownString>
        <tr>
            <td>Вид оборудования</td>
            <td>${experiment.equipmentTypePrettyName}</td>
        </tr>
    </#if>
    <tr>
        <td>Основное действие</td>
        <td>
            <#if experiment.actionName != unknownString>
                ${experiment.actionName}
            <#else>
                Не выбрано
            </#if>
        </td>
    </tr>
</table>