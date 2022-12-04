package co.edu.iudigital.helpmeuid.repository;

import co.edu.iudigital.helpmeuid.model.Caso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICasoRepository extends JpaRepository<Caso, Long> {

    @Modifying
    @Query("UPDATE Caso c SET c.visible = :visible WHERE c.id = :id")
    int setVisible(@Param("visible") Boolean visible, @Param("id") Long id);
}
