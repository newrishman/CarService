package com.newrishman.repository;

import com.newrishman.domain.Owners;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OwnersRepository extends JpaRepository<Owners, Long> {
    @Query(value = "SELECT * FROM AutoService.Owners where First_Name = :FirstName and Last_Name = :LastName", nativeQuery = true)
    Owners getOwnerByFirstAndLastName(
            @Param("FirstName") String firstName,
            @Param("LastName") String lastName);
}
