package com.weiran.graphql.subscription

import com.weiran.graphql.entity.Hero
import com.weiran.graphql.repository.HeroRepository
import graphql.kickstart.tools.GraphQLSubscriptionResolver
import org.reactivestreams.Publisher
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.scheduler.Schedulers
import java.time.Duration
import java.util.*

@Component
class HeroSubscription(
    private val heroRepository: HeroRepository
) : GraphQLSubscriptionResolver {

    fun getHeroUpdate(id: Int): Publisher<Optional<Hero>> {
        return Flux.interval(Duration.ofSeconds(1L))
            .publishOn(Schedulers.boundedElastic())
            .map<Optional<Hero>> { heroRepository.findById(id) }
    }
}
