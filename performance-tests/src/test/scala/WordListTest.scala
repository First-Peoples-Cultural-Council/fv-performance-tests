
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class WordListTest extends Simulation {

	val httpProtocol = http
		.baseUrl("https://preprod.firstvoices.com")
		.inferHtmlResources(BlackList(""".*.css""", """.*.js""", """.*.ico"""), WhiteList())
		.acceptHeader("application/json")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-CA,en-US;q=0.7,en;q=0.3")
		.userAgentHeader("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:70.0) Gecko/20100101 Firefox/70.0")

	val headers_0 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
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

	val headers_8 = Map(
		"Nuxeo-Transaction-Timeout" -> "60000",
		"enrichers.document" -> "ancestry,permissions,acls",
		"properties" -> "*")

	val headers_9 = Map(
		"Nuxeo-Transaction-Timeout" -> "60000",
		"enrichers.document" -> "ancestry,dialect,permissions,acls",
		"properties" -> "*")

	val headers_10 = Map(
		"Nuxeo-Transaction-Timeout" -> "60000",
		"enrichers.document" -> "ancestry,portal",
		"properties" -> "*")

	val headers_15 = Map(
		"Content-Type" -> "application/json",
		"Nuxeo-Transaction-Timeout" -> "60000",
		"Origin" -> "https://preprod.firstvoices.com",
		"enrichers.document" -> "word",
		"properties" -> "*")

	val headers_16 = Map(
		"Nuxeo-Transaction-Timeout" -> "60000",
		"enrichers.document" -> "ancestry, parentDoc, breadcrumb, children",
		"properties" -> "*")

	val headers_18 = Map(
		"Content-Type" -> "application/json",
		"Nuxeo-Transaction-Timeout" -> "60000",
		"Origin" -> "https://preprod.firstvoices.com",
		"enrichers.document" -> "character",
		"properties" -> "*")



	val scn = scenario("WordListTest")
		.exec(http("request_0")
			.get("/explore/FV/sections/Data/Athabascan/Dene/Dene/learn/words")
			.headers(headers_0))
		.pause(2)
		.exec(http("request_1")
			.get("/apple-touch-icon.png")
			.headers(headers_1)
			.resources(http("request_2")
			.get("/favicon-16x16.png")
			.headers(headers_1),
            http("request_3")
			.post("/nuxeo/api/v1/automation/User.Get")
			.headers(headers_3)
			.body(RawFileBody("wordlisttest/0003_request.json")),
            http("request_4")
			.get("/nuxeo/api/v1/user/Guest")
			.headers(headers_4),
            http("request_5")
			.get("/explore/FV/sections/Data/Athabascan/Dene/Dene/learn/assets/images/logo.png")
			.headers(headers_1),
            http("request_6")
			.get("/explore/FV/sections/Data/Athabascan/Dene/Dene/learn/assets/images/cover.png")
			.headers(headers_1),
            http("request_7")
			.get("/explore/FV/sections/Data/Athabascan/Dene/Dene/learn/assets/images/logo-fpcc-white.png")
			.headers(headers_1),
            http("request_8")
			.get("/nuxeo/api/v1/path/FV/sections/Data/Athabascan/Dene/Dene/Dictionary")
			.headers(headers_8),
            http("request_9")
			.get("/nuxeo/api/v1/path/FV/sections/Data/Athabascan/Dene/Dene")
			.headers(headers_9),
            http("request_10")
			.get("/nuxeo/api/v1/path/FV/sections/Data/Athabascan/Dene/Dene/Portal")
			.headers(headers_10),
            http("request_11")
			.post("/nuxeo/api/v1/automation/Document.EnrichedQuery")
			.headers(headers_3)
			.body(RawFileBody("wordlisttest/0011_request.json")),
            http("request_12")
			.get("/explore/FV/sections/Data/Athabascan/Dene/Dene/learn/assets/styles/assets/images/footer-background.png")
			.headers(headers_1),
            http("request_13")
			.get("/nuxeo/nxfile/default/5bc8904c-a396-4228-85d8-c43169e379cd/picture:views/0/content/Thumbnail_CLFN_logo.jpg")
			.headers(headers_1),
            http("request_14")
			.get("/nuxeo/api/v1/path/FV/sections/Data/Athabascan/Dene/Dene")
			.headers(headers_9),
            http("request_15")
			.post("/nuxeo/api/v1/automation/Document.EnrichedQuery")
			.headers(headers_15)
			.body(RawFileBody("wordlisttest/0015_request.json")),
            http("request_16")
			.get("/nuxeo/api/v1/path/FV/sections/SharedData/Shared%20Categories/@children")
			.headers(headers_16),
            http("request_17")
			.get("/nuxeo/nxfile/default/862c0c18-188d-4a5e-aacf-38c9aa62a7c1/picture:views/0/content/Thumbnail_c_2_6.jpg")
			.headers(headers_1),
            http("request_18")
			.post("/nuxeo/api/v1/automation/Document.EnrichedQuery")
			.headers(headers_18)
			.body(RawFileBody("wordlisttest/0018_request.json")),
            http("request_19")
			.get("/nuxeo/api/v1/directory/parts_of_speech")
			.headers(headers_4),
            http("request_20")
			.get("/nuxeo/api/v1/directory/parts_of_speech")
			.headers(headers_4),
            http("request_21")
			.post("/nuxeo/api/v1/automation/Document.EnrichedQuery")
			.headers(headers_18)
			.body(RawFileBody("wordlisttest/0021_request.json"))))

	//setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
	setUp(scn.inject(rampUsers(20) during (10 seconds))).protocols(httpProtocol)
}