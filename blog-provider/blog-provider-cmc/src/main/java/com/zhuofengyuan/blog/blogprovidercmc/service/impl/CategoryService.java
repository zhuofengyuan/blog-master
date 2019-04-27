package com.zhuofengyuan.blog.blogprovidercmc.service.impl;

import com.zhuofengyuan.blog.blogcommon.keygen.KeyGenerator;
import com.zhuofengyuan.blog.blogprovidercmc.mapper.CategoryMapper;
import com.zhuofengyuan.blog.blogprovidercmc.model.Category;
import com.zhuofengyuan.blog.blogprovidercmc.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
@CacheConfig(cacheNames = "categoryCache")
public class CategoryService implements ICategoryService {

    @Autowired
    CategoryMapper categoryDao;
    @Autowired
    KeyGenerator<String> keyGen;

    @Override
    @Transactional(readOnly = true)
    public List<Category> findAll() {
        return categoryDao.selectAll();
    }

    @Override
    public List<Category> findTree() {
        return categoryDao.selectTree();
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(key = "'category_'+ #p0")
    public Category findById(String id) {
        Assert.notNull(id, "id不能为空");
        return this.categoryDao.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @CachePut(key = "'category_'+ #p0.id")
    public Category addCategory(Category object) {
        Assert.notNull(object, "category参数有误");
        object.setId(keyGen.generateKey());
        this.categoryDao.insert(object);
        return this.categoryDao.selectByPrimaryKey(object.getId());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    @CachePut(key = "'category_'+ #p0.id")
    public Category updateCategory(Category object) {
        Assert.notNull(object, "category参数有误");

        String id = object.getId();
        Assert.notNull(id, "id不能为空");
        this.categoryDao.updateByPrimaryKeySelective(object);
        return this.categoryDao.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    @CacheEvict(key = "'category_' + #p0") // 删除缓存名称为userCache,key等于指定的id对应的缓存
    public void deleteById(String id) {
        Assert.notNull(id, "id不能为空");
        this.categoryDao.deleteByPrimaryKey(id);
    }
}
