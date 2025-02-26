package com.jwd.test.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jwd.test.model.Linija;

@Repository
public interface LinijaRepository extends JpaRepository<Linija, Long> {

	@Query("SELECT l FROM Linija l WHERE "
			+ "(:destinacija=NULL OR l.destinacija LIKE %:destinacija%) AND"
			+ "(:prevoznikId=NULL OR l.prevoznik.id=:prevoznikId) AND"
			+ "(:cenaKarteDo=NULL OR l.cenaKarte <= :cenaKarteDo)")
	Page<Linija> search(@Param("destinacija")String destinacija ,
						@Param("prevoznikId")Long prevoznikId,
						@Param("cenaKarteDo") Double cenaKarteDo,
						Pageable pageable);


	
	
}
