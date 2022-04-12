package ru.newmcpe.magicstone.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.newmcpe.magicstone.dao.entity.category.CategoryEntity
import ru.newmcpe.magicstone.dao.entity.category.SubCategoryEntity
import ru.newmcpe.magicstone.service.CategoriesService

@RestController
@RequestMapping("categories")
class CategoriesController(
    private val categoriesService: CategoriesService
) {
    @GetMapping
    fun getCategories(): Collection<CategoryEntity> = categoriesService.getCategories()

    @GetMapping("/subcategories/{category}")
    fun getSubCategories(
        @PathVariable(value = "category") categoryLink: String
    ): Collection<SubCategoryEntity> = categoriesService.getSubCategories(categoryLink)
}