
package services;

import entities.Seller;
import entities.dao.SellerDao;
import exceptions.DbException;
import entities.dao.DaoFactory;

import java.util.List;

public class SellerServices {
    private SellerDao sellerDao = DaoFactory.createSellerDao();

    public List<Seller> findAll(){
        List<Seller> listSeller = sellerDao.findAll();
        return listSeller;
    }
    public void saveOrUpdate(Seller seller){
        if (seller.getName() == "" || seller.getName() == null){
            throw new DbException("Error, in saveOrUpdate, not able to save to database");
        }else if(seller.getId() == null){
            sellerDao.insert(seller);
        }else{
            sellerDao.update(seller);
        }
    }
    public void delete(Seller seller){
        sellerDao.deleteById(seller.getId());
    }
}
