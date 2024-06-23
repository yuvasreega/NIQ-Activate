package com.example.niq_activate.serviceimpl;


import com.example.niq_activate.dto.ShopperProductListDTO;
import com.example.niq_activate.model.Product;
import com.example.niq_activate.model.Shopper;
import com.example.niq_activate.model.ShopperProductList;
import com.example.niq_activate.repository.ProductRepository;
import com.example.niq_activate.repository.ShopperProductListRepository;
import com.example.niq_activate.repository.ShopperRepository;
import com.example.niq_activate.service.ShopperProductListService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ShopperProductListServiceImpl implements ShopperProductListService {


    private ModelMapper modelMapper;

    private ShopperProductListRepository shopperProductListRepository;


    private ProductRepository productRepository;


    private ShopperRepository shopperRepository;

    public ShopperProductListServiceImpl() {
    }

    @Autowired
    public ShopperProductListServiceImpl(ModelMapper modelMapper, ShopperProductListRepository shopperProductListRepository, ProductRepository productRepository, ShopperRepository shopperRepository) {
        this.modelMapper = modelMapper;
        this.shopperProductListRepository = shopperProductListRepository;
        this.productRepository = productRepository;
        this.shopperRepository = shopperRepository;
    }

    @Override
    public Page<ShopperProductListDTO> getProductsByShopperId(String shopperId, String category, String brand, Integer limit) {
        Pageable pageable = PageRequest.of(0, Math.min(limit, 100)); // Ensure the limit does not exceed 100
        Page<ShopperProductList> entities =  shopperProductListRepository.findProductsByShopperIdWithFilters(shopperId, category, brand, pageable);
        return entities.map(entity -> modelMapper.map(entity, ShopperProductListDTO.class));

    }


    @Transactional
    public void saveShopperProductList(ShopperProductList shopperProductList) {
        // Retrieve or create Product entity
        Product product = getProduct(shopperProductList.getProduct().getProductId());

        // Retrieve or create Shopper entity
        Shopper shopper = getShopper(shopperProductList.getShopper().getShopperId());

        // Set the retrieved entities
        shopperProductList.setProduct(product);
        shopperProductList.setShopper(shopper);

        // Save the ShopperProductList entity
        shopperProductListRepository.save(shopperProductList);
    }

    // Helper method to retrieve or create Product
    private Product getProduct(String productId) {
        return productRepository.findById(productId)
                .orElseGet(() -> {
                    Product newProduct = new Product();
                    newProduct.setProductId(productId);
                    return productRepository.save(newProduct);
                });
    }

    // Helper method to retrieve or create Shopper
    private Shopper getShopper(String shopperId) {
        return shopperRepository.findById(shopperId)
                .orElseGet(() -> {
                    Shopper newShopper = new Shopper();
                    newShopper.setShopperId(shopperId);
                    return shopperRepository.save(newShopper);
                });
    }
}

