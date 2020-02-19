
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class ViewAllTest extends Simulation {

	val httpProtocol = http
		.baseUrl("https://preprod.firstvoices.com")
		.inferHtmlResources(BlackList(""".*.css""", """.*.js""", """.*.ico"""), WhiteList())
		.acceptHeader("application/json")
		.acceptLanguageHeader("en-CA,en-US;q=0.7,en;q=0.3")
		.userAgentHeader("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:70.0) Gecko/20100101 Firefox/70.0")

	val headers_0 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_1 = Map(
		"Accept" -> "image/webp,*/*",
		"Accept-Encoding" -> "gzip, deflate, br")

	val headers_3 = Map(
		"Accept-Encoding" -> "gzip, deflate, br",
		"Content-Type" -> "application/json",
		"Nuxeo-Transaction-Timeout" -> "60000",
		"Origin" -> "https://preprod.firstvoices.com",
		"properties" -> "*")

	val headers_4 = Map(
		"Accept-Encoding" -> "gzip, deflate, br",
		"Nuxeo-Transaction-Timeout" -> "60000",
		"properties" -> "*")

	val headers_7 = Map(
		"Accept-Encoding" -> "gzip, deflate, br",
		"Nuxeo-Transaction-Timeout" -> "60000",
		"enrichers.document" -> "ancestry,word,permissions",
		"properties" -> "*")

	val headers_11 = Map(
		"Accept-Encoding" -> "gzip, deflate, br",
		"Nuxeo-Transaction-Timeout" -> "60000",
		"enrichers.document" -> "ancestry,dialect,permissions,acls",
		"properties" -> "*")

	val headers_13 = Map(
		"Accept" -> "audio/webm,audio/ogg,audio/wav,audio/*;q=0.9,application/ogg;q=0.7,video/*;q=0.6,*/*;q=0.5",
		"Range" -> "bytes=0-")

	val headers_19 = Map(
		"Accept-Encoding" -> "gzip, deflate, br",
		"Nuxeo-Transaction-Timeout" -> "60000",
		"enrichers.document" -> "ancestry,phrase,permissions",
		"properties" -> "*")

	val headers_31 = Map(
		"Accept-Encoding" -> "gzip, deflate, br",
		"Nuxeo-Transaction-Timeout" -> "60000",
		"enrichers.document" -> "ancestry,permissions,book",
		"properties" -> "*")

	val headers_33 = Map(
		"Accept-Encoding" -> "gzip, deflate, br",
		"Content-Type" -> "application/json",
		"Nuxeo-Transaction-Timeout" -> "60000",
		"Origin" -> "https://preprod.firstvoices.com",
		"enrichers.document" -> "ancestry,book,permissions",
		"properties" -> "*")



	val scn = scenario("ViewAllTest")
		.exec(http("request_0")
			.get("/explore/FV/sections/Data/Athabascan/Dene/Dene/learn/words/99b94e91-ea34-4750-abfa-b7aa5de7749f")
			.headers(headers_0))
		//.pause(3)
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
			.body(RawFileBody("viewalltest/0003_request.json")),
            http("request_4")
			.get("/nuxeo/api/v1/user/Guest")
			.headers(headers_4),
            http("request_5")
			.get("/explore/FV/sections/Data/Athabascan/Dene/Dene/learn/words/assets/images/logo.png")
			.headers(headers_1),
            http("request_6")
			.get("/explore/FV/sections/Data/Athabascan/Dene/Dene/learn/words/assets/images/logo-fpcc-white.png")
			.headers(headers_1),
            http("request_7")
			.get("/nuxeo/api/v1/id/99b94e91-ea34-4750-abfa-b7aa5de7749f")
			.headers(headers_7),
            http("request_8")
			.post("/nuxeo/api/v1/automation/Document.EnrichedQuery")
			.headers(headers_3)
			.body(RawFileBody("viewalltest/0008_request.json")),
            http("request_9")
			.get("/explore/FV/sections/Data/Athabascan/Dene/Dene/learn/words/assets/images/cover.png")
			.headers(headers_1),
            http("request_10")
			.get("/explore/FV/sections/Data/Athabascan/Dene/Dene/learn/words/assets/styles/assets/images/footer-background.png")
			.headers(headers_1),
            http("request_11")
			.get("/nuxeo/api/v1/path/FV/sections/Data/Athabascan/Dene/Dene")
			.headers(headers_11),
            http("request_12")
			.get("/nuxeo/nxfile/default/862c0c18-188d-4a5e-aacf-38c9aa62a7c1/picture:views/2/content/Medium_c_2_6.jpg")
			.headers(headers_1),
            http("request_13")
			.get("/nuxeo/nxfile/default/e6ea0e2e-d82b-4533-8f94-4556093dea51/file:content/apron.mp3")
			.headers(headers_13)))
		//.pause(5)
		.pause(2)
		.exec(http("request_14")
			.get("/explore/FV/sections/Data/Athabascan/Dene/Dene/learn/phrases/d0ae4ed4-be9c-48bb-8f55-948ee6c5de25")
			.headers(headers_0))
		//.pause(3)
		.pause(1)
		.exec(http("request_15")
			.post("/nuxeo/api/v1/automation/User.Get")
			.headers(headers_3)
			.body(RawFileBody("viewalltest/0015_request.json"))
			.resources(http("request_16")
			.get("/nuxeo/api/v1/user/Guest")
			.headers(headers_4),
            http("request_17")
			.get("/explore/FV/sections/Data/Athabascan/Dene/Dene/learn/phrases/assets/images/logo.png")
			.headers(headers_1),
            http("request_18")
			.get("/explore/FV/sections/Data/Athabascan/Dene/Dene/learn/phrases/assets/images/logo-fpcc-white.png")
			.headers(headers_1),
            http("request_19")
			.get("/nuxeo/api/v1/id/d0ae4ed4-be9c-48bb-8f55-948ee6c5de25")
			.headers(headers_19),
            http("request_20")
			.post("/nuxeo/api/v1/automation/Document.EnrichedQuery")
			.headers(headers_3)
			.body(RawFileBody("viewalltest/0020_request.json")),
            http("request_21")
			.get("/explore/FV/sections/Data/Athabascan/Dene/Dene/learn/phrases/assets/images/cover.png")
			.headers(headers_1),
            http("request_22")
			.get("/explore/FV/sections/Data/Athabascan/Dene/Dene/learn/phrases/assets/styles/assets/images/footer-background.png")
			.headers(headers_1),
            http("request_23")
			.get("/nuxeo/api/v1/path/FV/sections/Data/Athabascan/Dene/Dene")
			.headers(headers_11),
            http("request_24")
			.get("/nuxeo/nxfile/default/87e16f9f-0084-4ae3-a62f-48695a9513ab/file:content/77_s_papers.mp3")
			.headers(headers_13)))
		//.pause(6)
		.pause(2)
		.exec(http("request_25")
			.get("/explore/FV/sections/Data/Athabascan/Dene/Dene/learn/songs/de756e6b-0491-4637-a804-352865bb4e17")
			.headers(headers_0))
		//.pause(8)
		.pause(3)
		.exec(http("request_26")
			.post("/nuxeo/api/v1/automation/User.Get")
			.headers(headers_3)
			.body(RawFileBody("viewalltest/0026_request.json"))
			.resources(http("request_27")
			.get("/nuxeo/api/v1/user/Guest")
			.headers(headers_4),
            http("request_28")
			.get("/explore/FV/sections/Data/Athabascan/Dene/Dene/learn/songs/assets/images/logo.png")
			.headers(headers_1),
            http("request_29")
			.get("/explore/FV/sections/Data/Athabascan/Dene/Dene/learn/songs/assets/images/logo-fpcc-white.png")
			.headers(headers_1),
            http("request_30")
			.post("/nuxeo/api/v1/automation/Document.EnrichedQuery")
			.headers(headers_3)
			.body(RawFileBody("viewalltest/0030_request.json")),
            http("request_31")
			.get("/nuxeo/api/v1/id/de756e6b-0491-4637-a804-352865bb4e17")
			.headers(headers_31),
            http("request_32")
			.get("/nuxeo/api/v1/path/FV/sections/Data/Athabascan/Dene/Dene")
			.headers(headers_11),
            http("request_33")
			.post("/nuxeo/api/v1/automation/Document.EnrichedQuery")
			.headers(headers_33)
			.body(RawFileBody("viewalltest/0033_request.json")),
            http("request_34")
			.get("/explore/FV/sections/Data/Athabascan/Dene/Dene/learn/songs/assets/images/cover.png")
			.headers(headers_1),
            http("request_35")
			.get("/explore/FV/sections/Data/Athabascan/Dene/Dene/learn/songs/assets/styles/assets/images/footer-background.png")
			.headers(headers_1),
            http("request_36")
			.get("/nuxeo/nxfile/default/39588444-187a-460a-bac4-4cdac930c1f2/file:content/lalacanada01.mp3")
			.headers(headers_13)))
		//.pause(5)
		.pause(2)
		.exec(http("request_37")
			.get("/explore/FV/sections/Data/Athabascan/Dene/Dene/learn/stories/83f0ddbe-ad58-4db7-bd04-46ed000c3fa0")
			.headers(headers_0))
		//.pause(3)
		.pause(1)
		.exec(http("request_38")
			.post("/nuxeo/api/v1/automation/User.Get")
			.headers(headers_3)
			.body(RawFileBody("viewalltest/0038_request.json"))
			.resources(http("request_39")
			.get("/nuxeo/api/v1/user/Guest")
			.headers(headers_4),
            http("request_40")
			.get("/explore/FV/sections/Data/Athabascan/Dene/Dene/learn/stories/assets/images/logo.png")
			.headers(headers_1),
            http("request_41")
			.get("/explore/FV/sections/Data/Athabascan/Dene/Dene/learn/stories/assets/images/logo-fpcc-white.png")
			.headers(headers_1),
            http("request_42")
			.get("/nuxeo/api/v1/path/FV/sections/Data/Athabascan/Dene/Dene")
			.headers(headers_11),
            http("request_43")
			.get("/nuxeo/api/v1/id/83f0ddbe-ad58-4db7-bd04-46ed000c3fa0")
			.headers(headers_31),
            http("request_44")
			.post("/nuxeo/api/v1/automation/Document.EnrichedQuery")
			.headers(headers_3)
			.body(RawFileBody("viewalltest/0044_request.json")),
            http("request_45")
			.post("/nuxeo/api/v1/automation/Document.EnrichedQuery")
			.headers(headers_33)
			.body(RawFileBody("viewalltest/0045_request.json")),
            http("request_46")
			.get("/explore/FV/sections/Data/Athabascan/Dene/Dene/learn/stories/assets/images/cover.png")
			.headers(headers_1),
            http("request_47")
			.get("/explore/FV/sections/Data/Athabascan/Dene/Dene/learn/stories/assets/styles/assets/images/footer-background.png")
			.headers(headers_1),
            http("request_48")
			.get("/nuxeo/nxfile/default/b7d557be-c843-4b2c-8a67-192e37a8f77b/file:content/Title.mp3")
			.headers(headers_13)))

	setUp(scn.inject(rampUsers(30) during (10 seconds))).protocols(httpProtocol)
}