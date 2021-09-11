package com.sda.spring.data.jpa.customquery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

    // create

    // there is no insert in JPA, must use native query
    // return void or int/Integer
    // native queries are not validated at startup
    // https://www.baeldung.com/spring-data-jpa-modifying-annotation
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO player (id, name, active) VALUES (:id, :name, :active)", nativeQuery = true)
    int save(
            @Param("id") Long id,
            @Param("name") String name,
            @Param("active") Boolean active);

    // find by

    // return Entity or List<Entity>
    List<Player> findByName(String name);

    List<Player> findByNameIs(String name);

    List<Player> findByNameEquals(String name);

    List<Player> findByNameIsNull();

    List<Player> findByNameNot(String name);

    List<Player> findByNameIsNot(String name);

    List<Player> findByNameStartingWith(String name);

    List<Player> findByNameEndingWith(String name);

    List<Player> findByNameContaining(String name);

    @Query("SELECT p FROM Player p WHERE p.name LIKE %:name%")
    List<Player> findByNameLike(@Param("name") String name);

    // find by numbers

    List<Player> findByAgeLessThan(Integer age);

    List<Player> findByAgeLessThanEqual(Integer age);

    List<Player> findByAgeGreaterThan(Integer age);

    List<Player> findByAgeGreaterThanEqual(Integer age);

    List<Player> findByAgeBetween(Integer startAge, Integer endAge);

    // find by dates

    List<Player> findByBirthDateAfter(ZonedDateTime birthDate);

    List<Player> findByBirthDateBefore(ZonedDateTime birthDate);

    List<Player> findByActiveTrue();

    List<Player> findByActiveFalse();

    List<Player> findByAgeIn(Collection<Integer> ages);

    // find by or

    List<Player> findByNameOrBirthDate(String name, ZonedDateTime birthDate);

    List<Player> findByNameOrBirthDateAndActive(String name, ZonedDateTime birthDate, Boolean active);

    // find by order

    List<Player> findByNameOrderByName(String name);

    List<Player> findByNameOrderByNameDesc(String name);

    // update

    // there is no update in JPA, must use native query
    @Transactional
    @Modifying
    @Query(value = "UPDATE player p SET p.name = :name WHERE p.active = :active", nativeQuery = true)
    int updateName(@Param("name") String name, @Param("active") boolean active);

    // delete

    @Transactional
    @Modifying
    @Query("DELETE FROM Player p WHERE p.name = :name")
    int deleteByName(@Param("name") String name);

    // does not support return List<Player>
    @Transactional
    @Modifying
    @Query("DELETE FROM Player p WHERE p.active = :active")
    int deleteByActive(@Param("active") boolean active);

}
