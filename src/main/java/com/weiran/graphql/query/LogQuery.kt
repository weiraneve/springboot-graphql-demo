package com.weiran.graphql.query

import com.weiran.graphql.repository.LogRepository
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component

@Component
class LogQuery(
    private val logRepository: LogRepository
): GraphQLQueryResolver {

    fun getLogByTeamId(teamId: Int) = logRepository.findByTeamId(teamId)

}
