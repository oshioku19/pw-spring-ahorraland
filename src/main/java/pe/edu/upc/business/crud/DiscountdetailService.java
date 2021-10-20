package pe.edu.upc.business.crud;

import java.util.List;

import pe.edu.upc.model.entity.Discountdetail;
import pe.edu.upc.model.entity.DiscountdetailId;
import pe.edu.upc.model.entity.Product;
import pe.edu.upc.model.entity.Seller;
import pe.edu.upc.model.entity.Status;

public interface DiscountdetailService extends CrudService<Discountdetail, DiscountdetailId> {
	List<Discountdetail> findByDiscount(Status discount)throws Exception;
	List<Discountdetail> findByProduct(Product product)throws Exception;
	List<Discountdetail> findBySeller(Seller seller)throws Exception;
}
