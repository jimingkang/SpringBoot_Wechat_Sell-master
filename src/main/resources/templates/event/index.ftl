<html>
<#include "../common/header.ftl">

<body>
<div id="wrapper" class="toggled">
<#include "../common/nav.ftl">


<#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" method="post" action="/seller/Event/save">
                        <div class="form-group">
                            <label>名称</label>
                            <input name="EventName" type="text" class="form-control" value="${(EventInfo.eventName)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>价格</label>
                            <input name="EventPrice" type="text" class="form-control" value="${(EventInfo.eventPrice)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>库存</label>
                            <input name="EventStock" type="number" class="form-control" value="${(EventInfo.eventStock)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>描述</label>
                            <input name="EventDescription" type="text" class="form-control" value="${(EventInfo.eventDescription)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>图片</label>
                            <img height="100" width="100" src="${(EventInfo.eventIcon)!''}" alt="">
                            <input name="EventIcon" type="text" class="form-control" value="${(EventInfo.eventIcon)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>类目</label>
                            <select name="categoryType" class="form-control">
                            <#list EventCategoryList as category>
                                <option value="${category.categoryType}"
                                    <#if (EventInfo.categoryType)?? && EventInfo.categoryType == category.categoryType>
                                        selected
                                    </#if>
                                >${category.categoryName}
                                </option>
                            </#list>
                            </select>
                        </div>
                        <input hidden type="text" name="EventId" value="${(EventInfo.eventId)!''}">
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>