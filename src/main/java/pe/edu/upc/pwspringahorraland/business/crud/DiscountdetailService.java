package pe.edu.upc.pwspringahorraland.business.crud;

import java.util.List;

import pe.edu.upc.pwspringahorraland.models.entity.Discountdetail;
import pe.edu.upc.pwspringahorraland.models.entity.DiscountdetailId;
import pe.edu.upc.pwspringahorraland.models.entity.Product;
import pe.edu.upc.pwspringahorraland.models.entity.Seller;
import pe.edu.upc.pwspringahorraland.models.entity.Status;

public interface DiscountdetailService extends CrudService<Discountdetail, DiscountdetailId> {
	List<Discountdetail> findByDiscount(Status discount)throws Exception;
	List<Discountdetail> findByProduct(Product product)throws Exception;
	List<Discountdetail> findBySeller(Seller seller)throws Exception;
}
