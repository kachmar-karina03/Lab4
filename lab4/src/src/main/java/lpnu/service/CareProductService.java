package lpnu.service;



import lpnu.dto.CareProductDTO;

import java.util.List;

public interface CareProductService {
    int numberOfCareProducts(CareProductDTO careProduct);
    List<CareProductDTO> getCareProductDiscount();
    List<CareProductDTO> getAllCareProducts();
    CareProductDTO getCareProductById(long id);
    CareProductDTO saveCareProduct(CareProductDTO careProduct);
    CareProductDTO updateCareProduct(CareProductDTO careProduct);
    void deleteCareProductById(long id);
}
