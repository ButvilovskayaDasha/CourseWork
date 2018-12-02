<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
    <div>
<@l.logout>

</@l.logout>
    <span><a href="/user">User List</a> </span>
    </div>
    <div>
        <form method="post" enctype="multipart/form-data">
            <input type="text" name="name" placeholder="Enter Name"/>
            <input type="text" name="agency" placeholder="Enter Agency"/>
            <input type="text" name="contact" placeholder="Enter Contact"/>
            <input type="file" name="file">
            <button type="button" id="btnGetFiles">Files</button>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <button id="realtorSubmit" type="submit">Add</button>
        </form>
    </div>
    <div id="listFiles">
    </div>
    <div>Список пользователей</div>
    <form method="get" action="/main">
        <input type="text" name="filter" value="${filter?ifExists}">
        <button type="submit">Find</button>
    </form>
    <#list realtor as realtor>
    <div>
        <b>${realtor.name}</b>
        <span>${realtor.agency}</span>
        <i>${realtor.contact}</i>
    <div>
        <#if realtor.filename??>
            <img src="/img/${realtor.filename}"
        </#if>
    </div>
    </div>
    <#else>
    No realtors
</#list>
</@c.page>