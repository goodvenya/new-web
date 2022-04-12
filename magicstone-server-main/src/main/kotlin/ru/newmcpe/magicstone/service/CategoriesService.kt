package ru.newmcpe.magicstone.service

import org.springframework.stereotype.Service
import ru.newmcpe.magicstone.dao.CategoriesDAO
import ru.newmcpe.magicstone.dao.SubCategoriesDAO
import ru.newmcpe.magicstone.dao.entity.category.CategoryEntity
import ru.newmcpe.magicstone.dao.entity.category.SubCategoryEntity

@Service
class CategoriesService(
    private val categoryRepo: CategoriesDAO,
    private val subCategoryRepo: SubCategoriesDAO
) {
    fun getCategories(): Collection<CategoryEntity> = categoryRepo.findAll().toList()

    fun getSubCategories(categoryLink: String): Collection<SubCategoryEntity> =
        subCategoryRepo.findByCategoryLink(categoryLink)
}