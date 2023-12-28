package org.choongang.repositories;

import org.choongang.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface AddressRepository extends JpaRepository<Address, Long> {


}
