package local.nask.sw.repository;

import local.nask.sw.entity.World;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorldRepository extends JpaRepository<World, Long> {
}
