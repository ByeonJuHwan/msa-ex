package dev.be.filter

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.cloud.gateway.filter.GatewayFilter
import org.springframework.stereotype.Component
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory
import reactor.core.publisher.Mono

@Component
class GlobalFilter : AbstractGatewayFilterFactory<GlobalFilter.Config>(Config::class.java) {

    data class Config(
        val baseMessage : String,
        val preLogger : Boolean,
        val postLogger : Boolean,
    )


    private val log: Logger = LoggerFactory.getLogger(GlobalFilter::class.java)

    override fun apply(config: Config): GatewayFilter {
        return GatewayFilter { exchange, chain ->
            val request = exchange.request
            val response = exchange.response

            log.info("Global filter baseMessage : {}", config.baseMessage)

            if(config.preLogger) {
                log.info("Global filter Start : request id -> {}", request.id)
            }

            chain.filter(exchange).then(Mono.fromRunnable {
                if(config.postLogger) {
                    log.info("Global filter End : response code -> {}", response.statusCode)
                }
            })
        }
    }
}