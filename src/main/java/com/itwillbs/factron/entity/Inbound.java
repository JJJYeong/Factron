package com.itwillbs.factron.entity;

import com.itwillbs.factron.entity.Item;
import com.itwillbs.factron.entity.Material;
import com.itwillbs.factron.entity.Purchase;
import com.itwillbs.factron.entity.Storage;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "inbound")
public class Inbound {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inbound_seq")
    @SequenceGenerator(name = "inbound_seq", sequenceName = "inbound_seq", allocationSize = 1)
    private Long id; // 입고 ID

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private Item item; // 제품 ID

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "material_id", referencedColumnName = "id")
    private Material material; // 자재 ID

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storage_id", referencedColumnName = "id", nullable = false)
    private Storage storage; // 창고 ID

    @Column(name = "quantity", nullable = false)
    private Long quantity; // 입고 수량

    @Column(name = "in_date")
    private LocalDate inDate; // 입고 날짜

    @Column(name = "category_code", length = 6, nullable = false)
    private String categoryCode; // 입고 품목 구분 코드 (예: 완제품, 반제품, 자재)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase_id", referencedColumnName = "id")
    private Purchase purchase; // 발주 ID (발주 입고 시)

    @Column(name = "status_code", length = 6, nullable = false)
    private String statusCode; // 상태 코드 (예: 완료, 대기 -> 자재만 입고 대기 가능)

    //입고 완료
    public void updateStatus() {
        this.statusCode = "STS003"; // 입고 완료 상태 코드
        this.inDate = LocalDate.now(); // 현재 날짜를 입고일로 설정
    }

}
