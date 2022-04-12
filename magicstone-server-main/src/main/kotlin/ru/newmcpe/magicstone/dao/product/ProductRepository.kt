package ru.newmcpe.magicstone.dao.product

import org.springframework.data.repository.CrudRepository
import ru.newmcpe.magicstone.dao.entity.product.ProductEntity
import java.util.*

interface ProductRepository : CrudRepository<ProductEntity, UUID>, ProductRepositoryCustom