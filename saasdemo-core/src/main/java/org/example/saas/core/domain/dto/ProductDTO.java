package org.example.saas.core.domain.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.saas.core.pojo.Product;

import java.util.List;

/**
 * <p>
 * 商品 DTO对象
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-01-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="ProductDTO", description="商品DTO对象")
public class ProductDTO extends Product {
    private List<ProductSkuDTO> skus;
    private String mainImageUrl;
}
