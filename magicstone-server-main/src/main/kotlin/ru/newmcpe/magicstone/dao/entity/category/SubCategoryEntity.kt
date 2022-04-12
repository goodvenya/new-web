package ru.newmcpe.magicstone.dao.entity.category

import org.hibernate.Hibernate
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "subcategories")
data class SubCategoryEntity(
    @Id
    @Column(name = "id", length = 16, unique = true, nullable = false)
    val id: UUID = UUID.randomUUID(),
    val name: String = "",
    val link: String = "",

    @ManyToOne
    @JoinColumn(name = "category")
    val category: CategoryEntity? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as SubCategoryEntity

        return id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name , link = $link , category = $category )"
    }
}