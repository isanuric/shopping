package com.prismaplaza.shopping.repository;

import com.prismaplaza.shopping.dto.UserProductDTO;
import com.prismaplaza.shopping.entity.Product;
import com.prismaplaza.shopping.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.stream.Collectors;


public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM users LIMIT 10", nativeQuery = true)
    List<User> findAllUsersz();

    List<Product> findUserById(Long userId);

    @Query(nativeQuery = true,
            value = "SELECT u.email as user_email, p.name as product_name " +
                    "FROM users u " +
                    "INNER JOIN products p ON u.id = p.user_id;")
    List<Object[]> findAllUserWithProduct();

    default List<UserProductDTO> findAllUserWithProductDTO() {
        List<Object[]> resultList = findAllUserWithProduct();


        List<UserProductDTO> users = resultList.stream()
                .map(row -> new UserProductDTO((String) row[0], (String) row[1]))
                .collect(Collectors.toList());

        System.out.println(users.size());
       for (UserProductDTO user: users) {
           System.out.println("go");
           System.out.println(user.getName());
       }
        return users;
    }
}
