package com.weiran.graphql.query

import com.weiran.graphql.common.PostParam
import com.weiran.graphql.service.PickService
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component

@Component
class PickQuery(
    private val pickService: PickService
) : GraphQLQueryResolver {

    fun pickHeroes(param: PostParam) = pickService.pick(param)
}
