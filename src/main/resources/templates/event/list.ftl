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
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>商品id</th>
                            <th>名称</th>
                            <th>图片</th>
                            <th>单价</th>
                            <th>库存</th>
                            <th>描述</th>
                            <th>类目</th>
                            <th>创建时间</th>
                            <th>修改时间</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>

                        <#list EventInfoPage.content as EventInfo>
                        <tr>
                            <td>${EventInfo.eventId}</td>
                            <td>${EventInfo.eventName}</td>
                            <td><img height="100" width="100" src="${EventInfo.eventIcon}" alt=""></td>
                            <td>${EventInfo.eventPrice}</td>
                            <td>${EventInfo.eventStock}</td>
                            <td>${EventInfo.eventDescription}</td>
                            <td>${EventInfo.categoryType}</td>
                            <td>${EventInfo.createTime}</td>
                            <td>${EventInfo.updateTime}</td>
                            <td><a href="/seller/Event/index?EventId=${EventInfo.eventId}">修改</a></td>
                            <td>
                                <#if EventInfo.eventStatus == 1>
                                    <a href="/seller/Event/off_sale?EventId=${EventInfo.eventId}">下架</a>
                                <#else>
                                    <a href="/seller/Event/on_sale?EventId=${EventInfo.eventId}">上架</a>
                                </#if>
                            </td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>

                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <ul class="pagination pull-right">
                        <#if currentPage lte 1>
                            <li class="disabled">
                                <a>上一页</a>
                            </li>
                        <#else >
                            <li>
                                <a href="/seller/Event/list?page=${currentPage-1}&size=${size}"> 上一页</a>
                            </li>
                        </#if>

                        <#list   1..EventInfoPage.getTotalPages() as index >
                            <#if currentPage==index>
                                <li class="disabled">
                                    <a>${index}</a>
                                </li>
                            <#else >
                                <li>
                                    <a href="/seller/Event/list?page=${index}&size=${size}">${index}</a>
                                </li>
                            </#if>

                        </#list>

                        <#if currentPage gte EventInfoPage.getTotalPages()>
                            <li class="disabled">
                                <a>下一页</a>
                            </li>
                        <#else >
                            <li>
                                <a href="/seller/Event/list?page=${currentPage+1}&size=${size}"> 下一页</a>
                            </li>
                        </#if>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

    </div>
</body>
</html>