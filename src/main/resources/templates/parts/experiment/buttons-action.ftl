<form action="/research/experiments/${experiment.id}/editAction" method="post">
    <table class="edit-table">
        <tr>
            <td>
                <button type="submit" id="change-action-button" disabled>Изменить действие</button>
            </td>
            <td>
                <select name="newActionId" onchange="updateButtonValueAndEnable(this, 'change-action-button')" >
                    <option value="" selected disabled hidden>Выбрать действие</option>
                    <#list allActions as actionInInventory>
                        <option value="${actionInInventory.id}">
                            ${actionInInventory.name}
                        </option>
                    </#list>
                </select>
            </td>
        </tr>
    </table>
</form>