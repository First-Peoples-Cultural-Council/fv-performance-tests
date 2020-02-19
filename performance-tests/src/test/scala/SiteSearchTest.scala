
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class SiteSearchTest extends Simulation {

	val httpProtocol = http
		.baseUrl("https://preprod.firstvoices.com")
		.inferHtmlResources(BlackList(""".*.css""", """.*.js""", """.*.ico"""), WhiteList())
		.acceptHeader("application/json")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-CA,en-US;q=0.7,en;q=0.3")
		.userAgentHeader("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:70.0) Gecko/20100101 Firefox/70.0")

	val headers_0 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
		"Accept-Encoding" -> "gzip, deflate",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_1 = Map("Accept" -> "image/webp,*/*")

	val headers_3 = Map(
		"Content-Type" -> "application/json",
		"Nuxeo-Transaction-Timeout" -> "60000",
		"Origin" -> "https://preprod.firstvoices.com",
		"properties" -> "*")

	val headers_4 = Map(
		"Nuxeo-Transaction-Timeout" -> "60000",
		"properties" -> "*")

	val headers_7 = Map(
		"Content-Type" -> "application/json",
		"Nuxeo-Transaction-Timeout" -> "60000",
		"Origin" -> "https://preprod.firstvoices.com",
		"enrichers.document" -> "ancestry,permissions",
		"properties" -> "*")

	val headers_12 = Map(
		"Content-Type" -> "application/json",
		"Nuxeo-Transaction-Timeout" -> "60000",
		"Origin" -> "https://preprod.firstvoices.com",
		"enrichers.document" -> "ancestry, word, phrase",
		"properties" -> "*")

    val uri1 = "preprod.firstvoices.com"

	val scn = scenario("SiteSearchTest")
		.exec(http("request_0")
			.get("http://" + uri1 + "/")
			.headers(headers_0))
		.pause(1)
		.exec(http("request_1")
			.get("/apple-touch-icon.png")
			.headers(headers_1)
			.resources(http("request_2")
			.get("/favicon-16x16.png")
			.headers(headers_1),
            http("request_3")
			.post("/nuxeo/api/v1/automation/User.Get")
			.headers(headers_3)
			.body(RawFileBody("sitesearchtest/0003_request.json")),
            http("request_4")
			.get("/nuxeo/api/v1/user/Guest")
			.headers(headers_4),
            http("request_5")
			.get("/assets/images/logo.png")
			.headers(headers_1),
            http("request_6")
			.get("/assets/images/logo-fpcc-white.png")
			.headers(headers_1),
            http("request_7")
			.post("/nuxeo/api/v1/automation/Document.EnrichedQuery")
			.headers(headers_7)
			.body(RawFileBody("sitesearchtest/0007_request.json")),
            http("request_8")
			.post("/nuxeo/api/v1/automation/Document.EnrichedQuery")
			.headers(headers_3)
			.body(RawFileBody("sitesearchtest/0008_request.json")),
            http("request_9")
			.post("/nuxeo/api/v1/automation/FVGetUserStartPage")
			.headers(headers_3)
			.body(RawFileBody("sitesearchtest/0009_request.json")),
            http("request_10")
			.get("/assets/styles/assets/images/footer-background.png")
			.headers(headers_1),
            http("request_11")
			.get("/assets/images/fv-intro-background.jpg")
			.headers(headers_1)))
		.pause(2)
		.exec(http("request_12")
			.post("/nuxeo/api/v1/automation/Document.EnrichedQuery")
			.headers(headers_12)
			.body(RawFileBody("sitesearchtest/0012_request.json"))
			.resources(http("request_13")
			.post("/nuxeo/api/v1/automation/Document.EnrichedQuery")
			.headers(headers_12)
			.body(RawFileBody("sitesearchtest/0013_request.json"))))

	//setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
	setUp(scn.inject(rampUsers(30) during (10 seconds))).protocols(httpProtocol)
}