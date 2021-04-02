package com.se2.bankingsystem.domains.CustomerAccount;

import com.se2.bankingsystem.domains.CustomerAccount.entity.CustomerAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional(readOnly = true)
public interface CustomerAccountRepository extends JpaRepository<CustomerAccount, Long> {

//    Page<CustomerAccount> findByDepartmentId(Long departmentId, Pageable pageable);
//
//    @Query("SELECT s FROM CustomerAccount s " +
//        "JOIN s.enrollments e " +
//        "WHERE e.courseRelease.id = ?1")
//    Page<CustomerAccount> findByCourseReleaseId(Long courseReleaseId, Pageable pageable);
//
//    @Query("SELECT s FROM CustomerAccount s " +
//        "JOIN s.enrollments e " +
//        "JOIN e.courseRelease cr " +
//        "WHERE cr.course.id = ?1")
//    Page<CustomerAccount> findByCourseId(Long courseId, Pageable pageable);
//
//    @Query("SELECT s FROM CustomerAccount s " +
//            "JOIN User u ON s.id = u.id " +
//            "WHERE u.firstName LIKE %?1% " +
//            "OR u.phoneNumber LIKE %?1% " +
//            "OR u.email LIKE %?1% " +
//            "OR u.lastName LIKE %?1%")
//    Page<CustomerAccount> findByKeyword(String keyword, Pageable pageable);
}