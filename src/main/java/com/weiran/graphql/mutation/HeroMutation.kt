package com.weiran.graphql.mutation

import com.weiran.graphql.repository.HeroRepository
import graphql.kickstart.tools.GraphQLMutationResolver
import org.springframework.stereotype.Component

@Component
class HeroMutation(
    private val heroRepository: HeroRepository
) : GraphQLMutationResolver {

    fun clearAllHero() = heroRepository.clearAllHero()
}
