package lpnu.repository;


import lpnu.entity.CareProduct;
import lpnu.exception.ServiceException;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CareProductRepository {
    private List<CareProduct> careProductList;

    private long id = 1;

    public int numberOfCareProducts(final CareProduct careProduct) {
        final CareProduct careProduct1 = careProductList.stream()
                .filter(e -> e.equals(careProduct))
               .findFirst().
                orElse(null);
        return 0;
    }
    @PostConstruct
    public void init() {
        careProductList = new ArrayList<>();
    }

    public List<CareProduct> getAllCareProduct() {
        return new ArrayList<>(careProductList);
    }

    public CareProduct getCareProductById(final long id) {
        return careProductList.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "care-product with id {" + id + "} not found"));
    }

    public CareProduct saveCareProduct(final CareProduct careProduct) {
        careProduct.setId(id);

        ++id;

        careProductList.add(careProduct);
        return careProduct;
    }

    public CareProduct updateCareProduct(final CareProduct careProduct) {

        final CareProduct savedCareProduct = getCareProductById(careProduct.getId());

        savedCareProduct.setName(careProduct.getName());
        savedCareProduct.setVolume(careProduct.getVolume());
        savedCareProduct.setPrice(careProduct.getPrice());
        savedCareProduct.setApplicationTime(careProduct.getApplicationTime());
        savedCareProduct.setSex(careProduct.getSex());

        return savedCareProduct;
    }

    public void deleteCareProductById(final Long id) {
        careProductList = careProductList.stream()
                .filter(e -> e.getId() != id)
                .collect(Collectors.toList());
    }


}
