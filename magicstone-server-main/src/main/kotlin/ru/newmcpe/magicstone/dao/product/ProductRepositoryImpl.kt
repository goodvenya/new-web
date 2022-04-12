package ru.newmcpe.magicstone.dao.product

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository
import ru.newmcpe.magicstone.dao.entity.category.CategoryEntity
import ru.newmcpe.magicstone.dao.entity.category.SubCategoryEntity
import ru.newmcpe.magicstone.dao.entity.product.ProductEntity
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Root

@Repository
class ProductRepositoryImpl : ProductRepositoryCustom {
    @PersistenceContext
    lateinit var entityManager: EntityManager

    override fun findProductsByParams(
        categoryLink: String?,
        subCategoryLink: String?,
        minPrice: Int,
        maxPrice: Int,
        pageable: Pageable
    ): Page<ProductEntity> {
        val criteriaBuilder = entityManager.criteriaBuilder
        val criteriaQuery: CriteriaQuery<ProductEntity> = criteriaBuilder.createQuery(ProductEntity::class.java)
        val product: Root<ProductEntity> = criteriaQuery.from(ProductEntity::class.java)

        val predicates = buildList {
            add(criteriaBuilder.ge(product["pricePerSquareMeter"], minPrice))
            add(criteriaBuilder.le(product["pricePerSquareMeter"], maxPrice))

            if (subCategoryLink != null)
                add(
                    criteriaBuilder.equal(
                        product
                            .get<SubCategoryEntity>("subCategory")
                            .get<String>("link"),
                        subCategoryLink
                    )
                )
            if (categoryLink != null)
                add(
                    criteriaBuilder.equal(
                        product
                            .get<SubCategoryEntity>("subCategory")
                            .get<CategoryEntity>("category")
                            .get<String>("link"),
                        categoryLink
                    )
                )
        }

        criteriaQuery.where(*predicates.toTypedArray())


        val query = entityManager.createQuery(criteriaQuery)
        val count = query.resultList.size

        return PageImpl(
            entityManager
                .createQuery(criteriaQuery)
                .setMaxResults(pageable.pageSize)
                .setFirstResult(pageable.pageNumber * chunkSize)
                .resultList,
            pageable,
            count.toLong()
        )
    }


    companion object {
        const val chunkSize = 20
    }
}