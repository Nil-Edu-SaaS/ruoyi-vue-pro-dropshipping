package cn.iocoder.yudao.module.top.product.vo;


import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 商品 Excel 导入 VO
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = false) // 设置 chain = false，避免用户导入有问题
public class ProductImportExcelVO {

    @ExcelProperty("商品名称")
    private String productName;

    @ExcelProperty("商品描述")
    private String productDepict;

    @ExcelProperty("商品图片")
    private List<String> imgList;

    @ExcelProperty("商品来源")
    private String productSrc;

    @ExcelProperty("商品成本价")
    private BigDecimal costPrice;

    @ExcelProperty("商品零售价")
    private BigDecimal retailPrice;

}
