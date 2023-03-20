package com.weiran.graphql.query

import com.weiran.graphql.repository.TeamRepository
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component

@Component
class TeamQuery(
    private val teamRepository: TeamRepository
): GraphQLQueryResolver {

    fun getTeamByEncryptCode(encryptCode: String) = teamRepository.findByEncryptCode(encryptCode)
}
