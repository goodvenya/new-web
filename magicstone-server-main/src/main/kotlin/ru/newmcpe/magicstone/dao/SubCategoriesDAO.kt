package ru.newmcpe.magicstone.dao

import org.springframework.data.repository.CrudRepository
import ru.newmcpe.magicstone.dao.entity.category.SubCategoryEntity
import java.util.*

interface SubCategoriesDAO : CrudRepository<SubCategoryEntity, UUID> {
    fun findByCategoryLink(name: String): List<SubCategoryEntity>
}
