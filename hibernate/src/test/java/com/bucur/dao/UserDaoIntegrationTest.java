package com.bucur.dao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UserDaoIntegrationTest {

    public UserDao userDao = new UserHibernateDao();
    public UserDao userDao1 = new UserJdbcAdvancedDao();
    public UserDao userDao2 = new UserJdbcDao();
    public UserJpaDao userDao3 = new UserJpaDao();

    @BeforeEach
    void setUp() {
        userDao.deleteAll();
    }

    @Test
    void givenUser_whenCRUD_thenOk() {
        // given
        // user dao

        // 2 users
        User user1 = new User("alex", "alex@gmail.com", "secret");
        User user2 = new User("ana", "ana@gmail.com", "secret");

        // when
        // create user
        userDao.create(user1);
        userDao.create(user2);

        // find all
        List<User> users = userDao.findAll();
        Assertions.assertThat(users).isNotEmpty();
        assertThat(users.size()).isEqualTo(2);

        // find by id
        User firstUser = users.get(0);
        Long firstUserId = firstUser.getId();

        User foundFirstUser = userDao.findById(firstUserId);
        assertThat(foundFirstUser).isNotNull();

        // update id 1
        User newUserData = new User("test", "test@test.com", "new");
        userDao.update(firstUserId, newUserData);
        // search updated user 1
        User updatedFirstUser = userDao.findById(firstUserId);

        // assert that user 1 values are modified
        // assert actual = expected
        assertThat(updatedFirstUser.getName()).isEqualTo(newUserData.getName());
        assertThat(updatedFirstUser.getEmail()).isEqualTo(newUserData.getEmail());
        assertThat(updatedFirstUser.getPassword()).isEqualTo(newUserData.getPassword());

        // delete id 2
        User secondUser = users.get(1);
        userDao.delete(secondUser.getId());

        List<User> finalUserList = userDao.findAll();
        // then
        // assert that 1 user left
        Assertions.assertThat(finalUserList).hasSize(1);
    }

    // given
    // user dao
    // 2 users

    // when
    // create user
    // create user
    // find all
    // find by id
    // update id 1
    // delete id 2

    // then
    // assert that 1 user left
    // assert that user 1 values are modified

    @Test
    void givenState_whenMethodUnderTest_thenResult() {
        // given

        // when

        // then
    }
}
