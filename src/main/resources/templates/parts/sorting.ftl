<#if sortBy=="id">
    <#if sortDir=="desc">
        <#assign sortByIdUrl = "">
    <#else>
        <#assign sortByIdUrl = "id,desc">
    </#if>
<#else>
    <#assign sortByIdUrl = "id,asc">
</#if>
<#if sortBy=="createdAt">
    <#if sortDir=="desc">
        <#assign sortByCreatedAtUrl = "createdAt,asc">
    <#else>
        <#assign sortByCreatedAtUrl = "">
    </#if>
<#else>
    <#assign sortByCreatedAtUrl = "createdAt,desc">
</#if>
<#if sortBy=="lastUpdatedAt">
    <#if sortDir=="desc">
        <#assign sortByLastUpdatedAtUrl = "lastUpdatedAt,asc">
    <#else>
        <#assign sortByLastUpdatedAtUrl = "">
    </#if>
<#else>
    <#assign sortByLastUpdatedAtUrl = "lastUpdatedAt,desc">
</#if>
<#if sortBy=="createdBy">
    <#if sortDir=="desc">
        <#assign sortByCreatedByUrl = "">
    <#else>
        <#assign sortByCreatedByUrl = "createdBy,desc">
    </#if>
<#else>
    <#assign sortByCreatedByUrl = "createdBy,asc">
</#if>
<#if sortBy=="progress">
    <#if sortDir=="desc">
        <#assign sortByProgressUrl = "progress,asc">
    <#else>
        <#assign sortByProgressUrl = "">
    </#if>
<#else>
    <#assign sortByProgressUrl = "progress,desc">
</#if>