<form action="/research/experiments/${experiment.id}/editEquipment" method="post">
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
                            ${equipmentInInventory.name} - ${equipmentInInventory.type}
                        </option>
                    </#list>
                </select>
            </td>
        </tr>
    </table>
</form>