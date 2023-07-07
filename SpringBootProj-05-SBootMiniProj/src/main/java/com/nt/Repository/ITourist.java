package com.nt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nt.entity.Tourist;

public interface ITourist extends JpaRepository<Tourist, Integer> {

//	@Query("from Tourist t WHERE t.tid>=:start AND t.tid<=:end")
//	@Modifying
//	public List<Tourist> selectAllByRange(int start, int end);
//
//	@Modifying
//	@Query("DELETE FROM Tourist t WHERE t.id >= :startId AND t.id <= :endId")
//	void deleteByIdRange(@Param("startId") int start, @Param("endId") int end);

	@Modifying
	@Query("DELETE FROM Tourist t WHERE t.id >= :startId AND t.id <= :endId")
     public Integer deleteByIdRange(@Param("startId") int start, @Param("endId") int end);

}
