package com.odk.errornotesapi.Repository;


import com.odk.errornotesapi.modele.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RepositoryRole extends JpaRepository<Role,Long> {
    Role findByRoleName(String RoleName);
}
