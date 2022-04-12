package ru.newmcpe.magicstone.api

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.newmcpe.magicstone.dao.entity.product.ProductEntity
import ru.newmcpe.magicstone.service.ProductService

@RestController
@RequestMapping("products")
class ProductController(
    private val productService: ProductService
) {
    @GetMapping
    fun getProducts(
        @RequestParam(defaultValue = Int.MIN_VALUE.toString()) minPrice: Int,
        @RequestParam(defaultValue = Int.MAX_VALUE.toString()) maxPrice: Int,
        @RequestParam(required = false) categoryLink: String?,
        @RequestParam(required = false) subCategoryLink: String?,
        @PageableDefault(size = 20)
        pageable: Pageable
    ): Page<ProductEntity> = productService.findProductsByParams(
        categoryLink,
        subCategoryLink,
        minPrice,
        maxPrice,
        pageable
    )
}