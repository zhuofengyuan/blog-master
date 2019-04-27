package com.zhuofengyuan.blog.blogprovidercmc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhuofengyuan.blog.blogcommon.keygen.KeyGenerator;
import com.zhuofengyuan.blog.blogprovidercmc.mapper.ProductMapper;
import com.zhuofengyuan.blog.blogprovidercmc.model.Product;
import com.zhuofengyuan.blog.blogprovidercmc.service.IProductService;
import com.zhuofengyuan.blog.blogprovidercmc.vo.ShopProductVo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
@CacheConfig(cacheNames = "productCache")
public class ProductService implements IProductService {

    @Autowired
    ProductMapper productDao;
    @Autowired
    KeyGenerator<String> keyGen;

    @Override
    @Transactional(readOnly = true)
    public PageInfo<Product> findPage(int num, int size) {
        PageHelper.startPage(num, size);
        return new PageInfo<> (productDao.selectAll());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @CachePut(key = "'product_'+ #p0.id")
    public Product addProduct(Product object) {
        Assert.notNull(object, "product参数有误");
//        object.setId(keyGen.generateKey());
        this.productDao.insert(object);
        return this.productDao.selectByPrimaryKey(object.getId());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    @CachePut(key = "'product_'+ #p0.id")
    public Product updateProduct(Product object) {
        Assert.notNull(object, "product参数有误");

        Long id = object.getId();
        Assert.notNull(id, "id不能为空");
        this.productDao.updateByPrimaryKeySelective(object);
        return this.productDao.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    @CacheEvict(key = "'product_' + #p0") // 删除缓存名称为userCache,key等于指定的id对应的缓存
    public void deleteById(Long id) {
        Assert.notNull(id, "id不能为空");
        this.productDao.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ShopProductVo> findAll() {
        return this.productDao.selectShop();
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(key = "'product_'+ #p0")
    public Product findById(Long id) {
        Assert.notNull(id, "id不能为空");
        return this.productDao.selectByPrimaryKey(id);
    }
}
