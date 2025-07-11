package com.itwillbs.factron.repository.lot;

import com.itwillbs.factron.entity.Lot;
import com.itwillbs.factron.entity.LotHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LotHistoryRepository extends JpaRepository<LotHistory, Long> {

    Optional<List<LotHistory>> findByWorkOrderIdOrderByCreatedAtDesc(String workOrderId);

    List<LotHistory> findByWorkOrderId(String workOrderId);

    Optional<LotHistory> findFirstByWorkOrderIdOrderByCreatedAtDesc(String workOrderId);

    Optional<LotHistory> findTopByWorkOrderIdOrderByCreatedAtDesc(String workOrderId);
}
