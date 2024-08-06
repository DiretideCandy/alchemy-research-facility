<form action="/research/experiments/${experiment.id}/editMaterials" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <table class="edit-table">
        <tbody>
        <#list experiment.materials as material>
            <tr>
                <td>
                    <button type="submit" name="remove" value="${material_index}">Удалить материал</button>
                </td>
                <td>
                    ${material.name} - ${material.typePrettyName}
                </td>
            </tr>
        </#list>
        <#if experiment.materials?size lt 3>
        <tr>
            <td>
                <button type="submit" id="add-material-button" name="add" disabled>Добавить</button>
            </td>
            <td>
                <select name="newMaterialId" onchange="updateButtonValueAndEnable(this, 'add-material-button')"  >
                    <option value="" selected disabled hidden>Выбрать материал для добавления</option>
                    <#list allMaterials as materialInInventory>
                        <option value="${materialInInventory.id}">
                            ${materialInInventory.name} - ${materialInInventory.typePrettyName}
                        </option>
                    </#list>
                </select>
            </td>
        </tr>
        </#if>
        </tbody>
    </table>
</form>