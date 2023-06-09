package com.weiran.graphql.repository

import com.weiran.graphql.entity.Team
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
interface TeamRepository : JpaRepository<Team, Int> {

    fun findByEncryptCode(encryptCode: String): Team?

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Transactional
    @Query("UPDATE Team SET pickContent='',isPicked=0,updateTime=current_time WHERE id=?1 ")
    fun clearOneTeam(id: Int): Int

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Transactional
    @Query("UPDATE Team SET pickContent='',isPicked=0,updateTime=current_time WHERE isPicked=true ")
    fun clearAllTeam(): Int

}
