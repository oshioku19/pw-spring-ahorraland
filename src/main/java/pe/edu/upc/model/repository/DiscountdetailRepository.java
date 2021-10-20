package pe.edu.upc.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.entity.Discountdetail;
import pe.edu.upc.model.entity.DiscountdetailId;
import pe.edu.upc.model.entity.Product;
import pe.edu.upc.model.entity.Seller;
import pe.edu.upc.model.entity.Status;

@Repository
public interface DiscountdetailRepository extends JpaRepository<Discountdetail, DiscountdetailId> {
	List<Discountdetail> findByDiscount(Status discount);
	List<Discountdetail> findByProduct(Product product);
	List<Discountdetail> findBySeller(Seller seller);
}
