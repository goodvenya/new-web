package ru.newmcpe.magicstone.dao.product

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import ru.newmcpe.magicstone.dao.entity.product.ProductEntity

interface ProductRepositoryCustom {
    fun findProductsByParams(
        categoryLink: String?,
        subCategoryLink: String?,
        minPrice: Int,
        maxPrice: Int,
        pageable: Pageable
    ): Page<ProductEntity>
}