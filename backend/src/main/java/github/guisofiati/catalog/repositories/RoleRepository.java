package github.guisofiati.catalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import github.guisofiati.catalog.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
}