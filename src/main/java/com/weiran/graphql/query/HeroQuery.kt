package com.weiran.graphql.query

import com.weiran.graphql.entity.Hero
import com.weiran.graphql.repository.HeroRepository
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component

@Component
class HeroQuery(
    private val heroRepository: HeroRepository
) : GraphQLQueryResolver {

    fun getHeroesNotIsPick(): Hero = heroRepository.getHeroesNotIsPick()
}
