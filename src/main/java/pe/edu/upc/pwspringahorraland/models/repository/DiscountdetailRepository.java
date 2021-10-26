package pe.edu.upc.pwspringahorraland.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.pwspringahorraland.models.entity.Discountdetail;
import pe.edu.upc.pwspringahorraland.models.entity.DiscountdetailId;
import pe.edu.upc.pwspringahorraland.models.entity.Product;
import pe.edu.upc.pwspringahorraland.models.entity.Seller;
import pe.edu.upc.pwspringahorraland.models.entity.Status;

@Repository
public interface DiscountdetailRepository extends JpaRepository<Discountdetail, DiscountdetailId> {
	List<Discountdetail> findByDiscount(Status discount);
	List<Discountdetail> findByProduct(Product product);
	List<Discountdetail> findBySeller(Seller seller);
}
