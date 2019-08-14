<html>

<#include "../common/header.ftl">

<body>
<div id="wrapper" class="toggled">
    <!-- 边框sidebar -->
    <#include "../common/nav.ftl">

    <!-- 主体内容content -->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" method="post" action="/sell/seller/product/save">
                        <div class="form-group">
                            <label>名称</label>
                            <input type="text" class="form-control" name="productName" value="${(productInfo.productName)!''}" />
                        </div>
                        <div class="form-group">
                            <label>价格</label>
                            <input type="text" class="form-control" name="productPrice" value="${(productInfo.productPrice)!''}" />
                        </div>
                        <div class="form-group">
                            <label>库存</label>
                            <input type="number" class="form-control" name="productStock" value="${(productInfo.productStock)!''}" />
                        </div>
                        <div class="form-group">
                            <label>描述</label>
                            <input type="text" class="form-control" name="productDescription" value="${(productInfo.productDescription)!''}" />
                        </div>
                        <div class="form-group">
                            <label>图片</label>
                            <img height="100" width="100" src="${(productInfo.productIcon)!''}">
                            <input type="text" class="form-control" name="productIcon" value="${(productInfo.productIcon)!''}" />
                        </div>
                        <div class="form-group">
                            <label>类目</label>
                            <select name="categoryType" class="form-control">
                                <#list productCategoryList as productCategory>
                                        <option value="${productCategory.categoryType}"
                                            <#if (productInfo.categoryType)?? && productInfo.categoryType == productCategory.categoryType>
                                                selected
                                            </#if>
                                        >
                                            ${productCategory.categoryName}
                                        </option>
                                </#list>
                            </select>
                        </div>
                        <input type="text" name="productId" value="${(productInfo.productId)!''}" hidden>
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>