package com.itwillbs.factron.dto.item;

import lombok.Data;

@Data

public class ResponseItemDTO {
    private String itemId;
    private String name;
    private String unit;
    private String unitName;
    private Long price;
    private String typeCode;
    private String createdAt;
    private String createdBy;
}
