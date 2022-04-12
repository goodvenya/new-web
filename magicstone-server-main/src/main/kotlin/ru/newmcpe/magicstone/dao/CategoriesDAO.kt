package ru.newmcpe.magicstone.dao

import org.springframework.data.repository.CrudRepository
import ru.newmcpe.magicstone.dao.entity.category.CategoryEntity
import java.util.*

interface CategoriesDAO : CrudRepository<CategoryEntity, UUID>