<form action="/research/experiments/${experiment.id}/editEquipment" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <table class="edit-table">
        <tr>
            <td>
                <button type="submit" id="change-equipment-button" disabled>Изменить оборудование</button>
            </td>
            <td>
                <select name="newEquipmentId" onchange="updateButtonValueAndEnable(this, 'change-equipment-button')" >
                    <option value="" selected disabled hidden>Выбрать оборудование</option>
                    <#list allEquipment as equipmentInInventory>
                        <option value="${equipmentInInventory.id}">
                            ${equipmentInInventory.name} - ${equipmentInInventory.typePrettyName}
                        </option>
                    </#list>
                </select>
            </td>
        </tr>
    </table>
</form>