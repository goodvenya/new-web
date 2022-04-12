package ru.newmcpe.magicstone.dao.entity.product

import org.hibernate.Hibernate
import ru.newmcpe.magicstone.dao.entity.category.SubCategoryEntity
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "products")
data class ProductEntity(
    @Id
    @Column(name = "id", length = 16, unique = true, nullable = false)
    val id: UUID = UUID.randomUUID(),
    val name: String = "",
    @Column(name = "image_url")
    val imageURL: String = "",
    @Column(name = "price_per_square_meter")
    val pricePerSquareMeter: Float = 1F,
    @Column(name = "price_per_piece")
    val pricePerPiece: Float = 1F,
    @Column(name = "have_corner_elements")
    val haveCornerElements: Boolean = false,

    @ManyToOne
    @JoinColumn(name = "sub_category")
    val subCategory: SubCategoryEntity? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as ProductEntity

        return id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name , imageURL = $imageURL , pricePerSquareMeter = $pricePerSquareMeter , pricePerPiece = $pricePerPiece , haveCornerElements = $haveCornerElements , subCategoryEntity = $subCategory )"
    }
}