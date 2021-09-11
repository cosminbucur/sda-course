package com.sda.spring.data.jpa.derivedquerry;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.List;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {

    // find by

    List<Profile> findByName(String name);

    List<Profile> findByNameIs(String name);

    List<Profile> findByNameEquals(String name);

    List<Profile> findByNameIsNull();

    List<Profile> findByNameNot(String name);

    List<Profile> findByNameIsNot(String name);

    List<Profile> findByNameStartingWith(String name);

    List<Profile> findByNameEndingWith(String name);

    List<Profile> findByNameContaining(String name);

    List<Profile> findByNameLike(String name);

    // find by numbers

    List<Profile> findByAgeLessThan(Integer age);

    List<Profile> findByAgeLessThanEqual(Integer age);

    List<Profile> findByAgeGreaterThan(Integer age);

    List<Profile> findByAgeGreaterThanEqual(Integer age);

    List<Profile> findByAgeBetween(Integer startAge, Integer endAge);

    // find by dates

    List<Profile> findByBirthDateAfter(ZonedDateTime birthDate);

    List<Profile> findByBirthDateBefore(ZonedDateTime birthDate);

    List<Profile> findByActiveTrue();

    List<Profile> findByActiveFalse();

    List<Profile> findByAgeIn(Collection<Integer> ages);

    // find by or

    List<Profile> findByNameOrBirthDate(String name, ZonedDateTime birthDate);

    List<Profile> findByNameOrBirthDateAndActive(String name, ZonedDateTime birthDate, Boolean active);

    // find by order

    List<Profile> findByNameOrderByName(String name);

    List<Profile> findByNameOrderByNameDesc(String name);

    // delete

    @Transactional
    Long deleteByName(String name);

    @Transactional
    List<Profile> deleteByActive(boolean active);

}
