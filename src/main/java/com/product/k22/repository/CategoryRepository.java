package com.product.k22.repository;

import com.product.k22.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Map;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query(value = "select p.* , c.category_name from product p\n" +
            ",category c\n" +
            "where c.category_id=p.category_id and p.id= :id and p.status_id= :sid",nativeQuery = true)
//                                                    p.id = ?1 and p.status_id = ?2
//    Map<String , Object> getProductDetail(int id,int sid);
    Map<String , Object> getProductDetail(@Param("id") int id, @Param("sid") int sid);
}
