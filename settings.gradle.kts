plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "msa-ex"

include("user-service")
include("discovery-service")
include("apigateway-service")
include("first-service")
include("second-service")
include("catalogs-service")
