package com.itwillbs.factron.dto.client;

import com.itwillbs.factron.entity.Client;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

/**
 * POST 요청 DTO
 * */
@Data
public class RequestPostClientDTO {

    @NotBlank(message = "거래처명은 필수 입력값입니다.")
    private String name;

    @NotBlank(message = "사업자등록번호는 필수 입력값입니다.")
    private String business_number;

    @NotBlank(message = "주소는 필수 입력값입니다.")
    private String address;

    @NotBlank(message = "연락처는 필수 입력값입니다.")
    private String contact;

    @NotBlank(message = "대표자는 필수 입력값입니다.")
    private String ceo;

    @NotBlank(message = "담당자는 필수 입력값입니다.")
    private String contact_manager;

    private String remark;

    /**
     * DTO -> Entity 변환
     * @param DTO 요청 DTO
     * @return detailSysCode 엔티티
     * */
    public static Client toEntity(RequestPostClientDTO DTO) {

        return Client.builder()
                .name(DTO.name)
                .businessNumber(DTO.business_number)
                .address(DTO.address)
                .contact(DTO.contact)
                .ceo(DTO.ceo)
                .contactManager(DTO.contact_manager)
                .remark(DTO.remark)
                .build();
    }
}
