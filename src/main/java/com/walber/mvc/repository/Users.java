package com.walber.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.walber.mvc.models.UserDetails;

public interface Users extends JpaRepository<UserDetails, Long> {
	UserDetails findById(long id);
}