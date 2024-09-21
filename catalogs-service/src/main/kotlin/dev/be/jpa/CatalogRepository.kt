package dev.be.jpa

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CatalogRepository : JpaRepository<CatalogEntity, Long> {
    fun findByProductId(productId : String) : CatalogEntity?
}