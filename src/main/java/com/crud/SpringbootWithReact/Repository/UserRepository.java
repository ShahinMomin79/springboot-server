package com.crud.SpringbootWithReact.Repository;

import com.crud.SpringbootWithReact.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
