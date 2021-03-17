package com.newsampath.driving.school.repository;

import com.newsampath.driving.school.model.Appoinments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppoinmentsRepository extends JpaRepository<Appoinments,Long> {
}
