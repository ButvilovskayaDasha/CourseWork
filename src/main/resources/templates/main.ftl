<#import "parts/common.ftl" as c>

<@c.page>
    <div class="form-row">
    <div class="form-group col-md-6">
    <form method="get" action="/main" class="form-inline">
    <input type="text" class="form-control" name="filter" value="${filter?ifExists}" placeholder="Search by Name">
    <button type="submit" class="btn btn-primary ml-2">Search</button>
    </form>
    </div>
    </div>
    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Add new user
    </a>
    <div class="collapse" id="collapseExample">
    <div class="form-group mt-3">
    <form method="post" enctype="multipart/form-data">
    <div class="form-group">
        <input type="text" name="name" class="form-control" placeholder="Enter Name"/>
    </div>
    <div class="form-group">
        <input type="text" name="agency" class="form-control" placeholder="Enter Agency"/>
    </div>
    <div class="form-group">
        <input type="text" name="contact" class="form-control" placeholder="Enter Contact"/>
    </div>
    <div class="form-group">
        <div class="custom-file">
            <input type="file" name="file" id="customFile">
            <label class="custom-file-label" for="customFile">Choose file</label>
        </div>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <div class="form-group">
        <button type="submit" class="btn btn-primary">Add</button>
    </div>
    </form>
    </div>
    </div>
    <div id="listFiles">
    </div>
    <div class="card-columns">
    <#list realtor as realtor>
    <div class="card my-3">
    ${realtor.name}
        <span>${realtor.agency}</span>
        <i>${realtor.contact}</i>
    </div>
        <div>
        <#if realtor.filename??>
            <img class="card-img-top" src="/img/${realtor.filename}"
        </#if>
        </div>
        </div>
    <#else>
        No realtors
    </#list>
    </div>
</@c.page>