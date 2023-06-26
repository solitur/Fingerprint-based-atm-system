package com.atm.repository;
import com.atm.entity.History;
import com.atm.entity.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
public interface HistoryRepository extends JpaRepository<History, Integer> {
@Query("FROM History where userId=?1 order by createdTime desc")
List<History> findAllHistoryByUserId(Long userId);
}