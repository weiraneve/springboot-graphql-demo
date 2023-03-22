package com.weiran.graphql.query

import com.graphql.spring.boot.test.GraphQLTestTemplate
import com.weiran.graphql.entity.Hero
import com.weiran.graphql.repository.HeroRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.mockito.BDDMockito.given
import org.skyscreamer.jsonassert.JSONAssert
import org.skyscreamer.jsonassert.JSONCompareMode
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HeroQueryTest : AbstractGraphQLTest() {

    @Autowired
    private lateinit var graphQLTestTemplate: GraphQLTestTemplate

    @MockBean
    private lateinit var heroRepository: HeroRepository

    @Test
    fun `get heroes not is pick`() {
        // given
        given(heroRepository.getHeroesNotIsPick()).willReturn(
            Hero(
                id = 1,
                line = 1,
                name = "hero",
                isPick = false
            )
        )

        // when
        val postMultipart = graphQLTestTemplate.postMultipart("query {getHeroesNotIsPick {id,line,name,isPick}}", "{}")
        val expectedResponseBody = """
            {
            "data":
              { "getHeroesNotIsPick":
                  {
                    "id": "1",
                    "line": 1,
                    "name": "hero",
                    isPick: false
                  }
              }
            }
            """

        // then
        assertThat(postMultipart).isNotNull
        JSONAssert.assertEquals(
            expectedResponseBody,
            postMultipart.rawResponse.body,
            JSONCompareMode.LENIENT
        )
    }
}
