package com.osckorea.login.repository;

import com.osckorea.login.domain.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MemberRepository extends CrudRepository<Member, Long> {

    Optional<Member> findByUsername(String username);
}
