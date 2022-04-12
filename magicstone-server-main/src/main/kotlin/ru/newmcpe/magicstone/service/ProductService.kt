package ru.newmcpe.magicstone.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import ru.newmcpe.magicstone.dao.entity.product.ProductEntity
import ru.newmcpe.magicstone.dao.product.ProductRepository

@Service
class ProductService(
    private val productRepository: ProductRepository
) {
    fun findProductsByParams(
        categoryLink: String?,
        subCategoryLink: String?,
        minPrice: Int,
        maxPrice: Int,
        pageable: Pageable
    ): Page<ProductEntity> = productRepository.findProductsByParams(
        categoryLink,
        subCategoryLink,
        minPrice,
        maxPrice,
        pageable
    )
}