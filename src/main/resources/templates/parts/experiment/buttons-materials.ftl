<form action="/research/experiments/${experiment.id}/editMaterials" method="post">
    <table class="materials-table">
        <tbody>
        <#list experiment.materials as material>
            <tr>
                <td>
                    <button type="submit" name="remove" value="${material_index}">Удалить материал</button>
                </td>
                <td>
                    ${material.name} - ${material.type}
                </td>
            </tr>
        </#list>
        <tr>
            <td>
                <button type="submit" id="button-add" name="add" disabled>Добавить</button>
            </td>
            <td>
                <select name="newMaterialId" onchange="updateAddButtonValue(this)" >
                    <option value="" selected disabled hidden>Выбрать материал для добавления</option>
                    <#list allMaterials as materialInInventory>
                        <option value="${materialInInventory.id}">
                            ${materialInInventory.name} - ${materialInInventory.type}
                        </option>
                    </#list>
                </select>
            </td>
        </tr>
        </tbody>
    </table>
</form>