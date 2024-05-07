package com.Bitts.Repository;

import com.Bitts.Model.Orderitem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<Orderitem ,Long> {
}
