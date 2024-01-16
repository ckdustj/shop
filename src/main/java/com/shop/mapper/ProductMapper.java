package com.shop.mapper;

import com.shop.dto.product.Category;
import com.shop.dto.product.ProductDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {
    // no에 해당하는 상품 하나의 정보 모두 가져오기
    ProductDTO get_product_by_no(int no);

    List<ProductDTO> get_products(
            @Param("searchWord") String searchWord,
            @Param("order") String order
    );
}
