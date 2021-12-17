package at.rajoub.blogservice.repository;

import at.rajoub.blogservice.entity.Blog;
import at.rajoub.blogservice.model.LocationStat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

    @Query("SELECT new at.rajoub.blogservice.model.LocationStat(b.locationId, sum(b.blogNumberOfViews)) FROM Blog b group by b.locationId")
    List<LocationStat> findAllTimeLocationStats();

    @Query("SELECT new at.rajoub.blogservice.model.LocationStat(b.locationId, sum(b.blogNumberOfViews)) FROM Blog b where year(b.blogDate) = ?1 and month(b.blogDate) = ?2 group by b.locationId")
    List<LocationStat> findCurrentMonthLocationStats(int currentYear, int currentMonth);
}
