package org.example.saas.core.domain.dto;


import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.saas.core.pojo.ProductSku;
import org.example.saas.core.pojo.SkuAttribute;

import java.util.List;

/**
 * <p>
 * 商品规格 DTO对象
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-01-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="ProductSkuDTO", description="商品规格DTO对象")
public class ProductSkuDTO extends ProductSku {
    /**
     * SKU特性
     */
    private List<SkuAttribute> attributes;


}
