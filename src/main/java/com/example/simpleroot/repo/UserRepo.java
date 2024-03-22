package com.example.simpleroot.repo;

import com.example.simpleroot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User,Integer> {

    @Query(value = "SELECT * from User where id=?1",nativeQuery = true)
    User getUserdetaildByuseId(String id);

    @Query(value = "SELECT * from User where id=?1 and address=?2",nativeQuery = true)
    User getDetailsByIdAndAddres(String userid, String address);
}
