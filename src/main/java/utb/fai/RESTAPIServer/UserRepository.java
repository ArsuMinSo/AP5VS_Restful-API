package utb.fai.RESTAPIServer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<MyUser, Long> {

    @Query("SELECT u FROM MyUser u WHERE "
            + "(:name IS NULL OR LOWER(u.name) LIKE LOWER(CONCAT('%', :name, '%'))) AND "
            + "(:email IS NULL OR LOWER(u.email) LIKE LOWER(CONCAT('%', :email, '%'))) AND "
            + "(:phoneNumber IS NULL OR u.phoneNumber LIKE CONCAT('%', :phoneNumber, '%'))")
    List<MyUser> search(
            @Param("name") String name,
            @Param("email") String email,
            @Param("phoneNumber") String phoneNumber);
}
