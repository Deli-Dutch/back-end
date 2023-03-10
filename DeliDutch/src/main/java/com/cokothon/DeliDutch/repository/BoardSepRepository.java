package com.cokothon.DeliDutch.repository;

import com.cokothon.DeliDutch.constant.Dormitory;
import com.cokothon.DeliDutch.entity.BoardSep;
import com.cokothon.DeliDutch.entity.BoardTog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardSepRepository extends JpaRepository<BoardSep, Long> {
    List<BoardSep> findByDormitory(Dormitory dormitory);


    @Query(value = "SELECT * FROM Board_Separate b inner join Restaurant rs on b.restaurant_id = rs.restaurant_id WHERE b.dormitory =:dormitory AND b.end_time > SYSDATE() AND rs.category =:category ORDER BY end_time; ", nativeQuery = true)
    List<BoardSep> findBoardSepList(@Param("dormitory") String dormitory, @Param("category") String category);
}
