package com.weiran.graphql.mutation

import com.weiran.graphql.repository.TeamRepository
import graphql.kickstart.tools.GraphQLMutationResolver
import org.springframework.stereotype.Component

@Component
class TeamMutation(
    private val teamRepository: TeamRepository
) : GraphQLMutationResolver {

    fun clearOneTeam(id: Int) = teamRepository.clearOneTeam(id)

    fun clearAllTeam() = teamRepository.clearAllTeam()
}
