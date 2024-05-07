package com.Bitts.ServiceImpl;

import com.Bitts.Exception.ProductException;
import com.Bitts.Model.Category;
import com.Bitts.Model.Product;
import com.Bitts.Repository.CategoryRepository;
import com.Bitts.Repository.ProductRepository;
import com.Bitts.Request.CreateProductRequest;
import com.Bitts.Service.ProductService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private UserServiceaImpl userService;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private  CategoryRepository categoryRepository;




    @Override
    public Product createProduct(CreateProductRequest request) {
        System.out.println("yha hu");
        Category topLevel = categoryRepository.findByName(request.getTopLevelCategory());
        if(topLevel==null){
            Category topLevelCategory=new Category();
            topLevelCategory.setName(request.getTopLevelCategory());
            topLevelCategory.setLevel(1);

            topLevel=categoryRepository.save(topLevelCategory);
        }
        System.out.println("yha hu");
        Category secondLevel = categoryRepository.findByNameAndParent(request.getSecondLevelCategory(),topLevel.getName());
        if(secondLevel==null){
            Category secondLevelCategory=new Category();
            secondLevelCategory.setName(request.getSecondLevelCategory());
            secondLevelCategory.setLevel(2);
            secondLevelCategory.setParentCategory(topLevel);
            secondLevel=categoryRepository.save(secondLevelCategory);
        }
        System.out.println("yha hu");
        Category thirdLevel = categoryRepository.findByNameAndParent(request.getThirdLevelCategory(),secondLevel.getName());
        if(thirdLevel==null){
            Category thirdLevelCategory=new Category();
            thirdLevelCategory.setName(request.getThirdLevelCategory());
            thirdLevelCategory.setLevel(3);
            thirdLevelCategory.setParentCategory(secondLevel);
            thirdLevel=categoryRepository.save(thirdLevelCategory);
        }
        System.out.println("yha hu");

        Product product=new Product();
        product.setTitle(request.getTitle());
        product.setDescription(request.getDescription());
        product.setColor(request.getColor());
        product.setBrand(request.getBrand());
        product.setPrice(request.getPrice());
        product.setDiscountPrice(request.getDiscountedPrice());
        product.setDiscountPresent(request.getDiscountPresent());
        product.setQuantity(request.getQuantity());
        product.setImageUrl(request.getImageUrl());
        product.setSizes(request.getSize());
        product.setCategory(thirdLevel);
        product.setCreatedAt(LocalDateTime.now());
        System.out.println("yha hu");


        return  productRepository.save(product);

    }

    @Override
    public String deleteProduct(Long productId) throws ProductException {
        Product product=findProductById(productId);
        product.getSizes().clear();

        productRepository.delete(product);

        return "Product deleted successfully";
    }

    @Override
    public Product findProductById(Long productId) throws ProductException {
        Optional<Product> product=productRepository.findById(productId);
        if (product.isPresent()) {
            return product.get();
        }
        throw new ProductException("Product not found ID :"+productId);
    }

    @Override
    public Product updateProduct(Long productId, Product product) throws ProductException {
        Product pro=findProductById(productId);

        if (product.getQuantity()!=0) {
            pro.setQuantity(product.getQuantity());
        }
        return productRepository.save(pro);
    }

    @Override
    public List<Product> findProductByCategory(String category) throws ProductException {
        return null;
    }

    @Override
    public Page<Product> getAllProduct(String category, List<String> colors, List<String> sizes, Integer minPrice, Integer maxPrice, Integer minDiscount, String sort, String stock, Integer pageNumber, Integer pageSize) throws ProductException {

        Pageable pageable = PageRequest.of(pageNumber,pageSize);

        List<Product> products=productRepository.filterProducts(category,minPrice,maxPrice,minDiscount,sort);
        if(!colors.isEmpty()){
            products= products.stream().filter(p->colors.stream().anyMatch(c->c.equalsIgnoreCase(p.getColor()))).collect(Collectors.toList());
        }
        if(stock!=null){
            if(stock.equals("in_stock")){
                products= products.stream().filter(p->p.getQuantity()>0).collect(Collectors.toList());
            } else if (stock.equals("out_stock")) {
                products=products.stream().filter(p->p.getQuantity()<1).collect(Collectors.toList());
            }

        }

        int startIndex=(int)pageable.getOffset();
        int endIndex=Math.min(startIndex+pageable.getPageSize(),products.size());

        List<Product> pageContent =products.subList(startIndex, endIndex);

        Page<Product> filteredProducts = new PageImpl<>(pageContent,pageable,products.size());





        return filteredProducts;
    }
}
