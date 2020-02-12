
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class WordPhraseSearchTest extends Simulation {

	val httpProtocol = http
		.baseUrl("https://www.firstvoices.com")
		.inferHtmlResources(BlackList(""".*.css""", """.*.js""", """.*.ico"""), WhiteList())
		.acceptHeader("application/json")
		.acceptLanguageHeader("en-CA,en-US;q=0.7,en;q=0.3")
		.userAgentHeader("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:70.0) Gecko/20100101 Firefox/70.0")

	val headers_0 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_1 = Map(
		"Accept-Encoding" -> "gzip, deflate, br",
		"Content-Type" -> "application/json",
		"Nuxeo-Transaction-Timeout" -> "60000",
		"Origin" -> "https://www.firstvoices.com",
		"properties" -> "*")

	val headers_2 = Map(
		"Accept" -> "image/webp,*/*",
		"Accept-Encoding" -> "gzip, deflate, br")

	val headers_4 = Map(
		"Accept-Encoding" -> "gzip, deflate, br",
		"Nuxeo-Transaction-Timeout" -> "60000",
		"properties" -> "*")

	val headers_7 = Map(
		"Accept-Encoding" -> "gzip, deflate, br",
		"Nuxeo-Transaction-Timeout" -> "60000",
		"enrichers.document" -> "ancestry,permissions,acls",
		"properties" -> "*")

	val headers_8 = Map(
		"Accept-Encoding" -> "gzip, deflate, br",
		"Nuxeo-Transaction-Timeout" -> "60000",
		"enrichers.document" -> "ancestry,portal",
		"properties" -> "*")

	val headers_11 = Map(
		"Accept-Encoding" -> "gzip, deflate, br",
		"Nuxeo-Transaction-Timeout" -> "60000",
		"enrichers.document" -> "ancestry,dialect,permissions,acls",
		"properties" -> "*")

	val headers_15 = Map(
		"Accept-Encoding" -> "gzip, deflate, br",
		"Content-Type" -> "application/json",
		"Nuxeo-Transaction-Timeout" -> "60000",
		"Origin" -> "https://www.firstvoices.com",
		"enrichers.document" -> "word",
		"properties" -> "*")

	val headers_16 = Map(
		"Accept-Encoding" -> "gzip, deflate, br",
		"Nuxeo-Transaction-Timeout" -> "60000",
		"enrichers.document" -> "ancestry, parentDoc, breadcrumb, children",
		"properties" -> "*")

	val headers_19 = Map(
		"Accept-Encoding" -> "gzip, deflate, br",
		"Content-Type" -> "application/json",
		"Nuxeo-Transaction-Timeout" -> "60000",
		"Origin" -> "https://www.firstvoices.com",
		"enrichers.document" -> "character",
		"properties" -> "*")

	val headers_34 = Map(
		"Accept-Encoding" -> "gzip, deflate, br",
		"Content-Type" -> "application/json",
		"Nuxeo-Transaction-Timeout" -> "60000",
		"Origin" -> "https://www.firstvoices.com",
		"enrichers.document" -> "phrase",
		"properties" -> "*")

	val headers_38 = Map(
		"Accept" -> "audio/webm,audio/ogg,audio/wav,audio/*;q=0.9,application/ogg;q=0.7,video/*;q=0.6,*/*;q=0.5",
		"Range" -> "bytes=0-")



	val scn = scenario("WordPhraseSearchTest")
		.exec(http("request_0")
			.get("/explore/FV/sections/Data/Athabascan/Dene/Dene/learn/words/10/1")
			.headers(headers_0))
		.pause(1)
		//.pause(2)
		.exec(http("request_1")
			.post("/nuxeo/api/v1/automation/User.Get")
			.headers(headers_1)
			.body(RawFileBody("wordphrasesearchtest/0001_request.json"))
			.resources(http("request_2")
			.get("/apple-touch-icon.png")
			.headers(headers_2),
            http("request_3")
			.get("/favicon-16x16.png")
			.headers(headers_2),
            http("request_4")
			.get("/nuxeo/api/v1/user/Guest")
			.headers(headers_4),
            http("request_5")
			.get("/explore/FV/sections/Data/Athabascan/Dene/Dene/learn/words/10/assets/images/logo.png")
			.headers(headers_2),
            http("request_6")
			.get("/explore/FV/sections/Data/Athabascan/Dene/Dene/learn/words/10/assets/images/logo-fpcc-white.png")
			.headers(headers_2),
            http("request_7")
			.get("/nuxeo/api/v1/path/FV/sections/Data/Athabascan/Dene/Dene/Dictionary")
			.headers(headers_7),
            http("request_8")
			.get("/nuxeo/api/v1/path/FV/sections/Data/Athabascan/Dene/Dene/Portal")
			.headers(headers_8),
            http("request_9")
			.get("/explore/FV/sections/Data/Athabascan/Dene/Dene/learn/words/10/assets/images/cover.png")
			.headers(headers_2),
            http("request_10")
			.post("/nuxeo/api/v1/automation/Document.EnrichedQuery")
			.headers(headers_1)
			.body(RawFileBody("wordphrasesearchtest/0010_request.json")),
            http("request_11")
			.get("/nuxeo/api/v1/path/FV/sections/Data/Athabascan/Dene/Dene")
			.headers(headers_11),
            http("request_12")
			.get("/nuxeo/api/v1/path/FV/sections/Data/Athabascan/Dene/Dene")
			.headers(headers_11),
            http("request_13")
			.get("/nuxeo/nxfile/default/5bc8904c-a396-4228-85d8-c43169e379cd/picture:views/0/content/Thumbnail_CLFN_logo.jpg")
			.headers(headers_2),
            http("request_14")
			.get("/explore/FV/sections/Data/Athabascan/Dene/Dene/learn/words/10/assets/styles/assets/images/footer-background.png")
			.headers(headers_2),
            http("request_15")
			.post("/nuxeo/api/v1/automation/Document.EnrichedQuery")
			.headers(headers_15)
			.body(RawFileBody("wordphrasesearchtest/0015_request.json")),
            http("request_16")
			.get("/nuxeo/api/v1/path/FV/sections/SharedData/Shared%20Categories/@children")
			.headers(headers_16),
            http("request_17")
			.get("/nuxeo/nxfile/default/862c0c18-188d-4a5e-aacf-38c9aa62a7c1/picture:views/0/content/Thumbnail_c_2_6.jpg")
			.headers(headers_2),
            http("request_18")
			.get("/nuxeo/api/v1/directory/parts_of_speech")
			.headers(headers_4),
            http("request_19")
			.post("/nuxeo/api/v1/automation/Document.EnrichedQuery")
			.headers(headers_19)
			.body(RawFileBody("wordphrasesearchtest/0019_request.json")),
            http("request_20")
			.post("/nuxeo/api/v1/automation/Document.EnrichedQuery")
			.headers(headers_19)
			.body(RawFileBody("wordphrasesearchtest/0020_request.json"))))
		.pause(2)
		//.pause(10)
		.exec(http("request_21")
			.post("/nuxeo/api/v1/automation/Document.EnrichedQuery")
			.headers(headers_15)
			.body(RawFileBody("wordphrasesearchtest/0021_request.json")))
		.pause(3)
		//.pause(15)
		.exec(http("request_22")
			.get("/explore/FV/sections/Data/Athabascan/Dene/Dene/learn/phrases/10/1")
			.headers(headers_0))
		.pause(1)
		//.pause(2)
		.exec(http("request_23")
			.post("/nuxeo/api/v1/automation/User.Get")
			.headers(headers_1)
			.body(RawFileBody("wordphrasesearchtest/0023_request.json"))
			.resources(http("request_24")
			.get("/nuxeo/api/v1/user/Guest")
			.headers(headers_4),
            http("request_25")
			.get("/explore/FV/sections/Data/Athabascan/Dene/Dene/learn/phrases/10/assets/images/logo.png")
			.headers(headers_2),
            http("request_26")
			.get("/explore/FV/sections/Data/Athabascan/Dene/Dene/learn/phrases/10/assets/images/logo-fpcc-white.png")
			.headers(headers_2),
            http("request_27")
			.get("/nuxeo/api/v1/path/FV/sections/Data/Athabascan/Dene/Dene")
			.headers(headers_11),
            http("request_28")
			.get("/nuxeo/api/v1/path/FV/sections/Data/Athabascan/Dene/Dene/Dictionary")
			.headers(headers_7),
            http("request_29")
			.post("/nuxeo/api/v1/automation/Document.EnrichedQuery")
			.headers(headers_1)
			.body(RawFileBody("wordphrasesearchtest/0029_request.json")),
            http("request_30")
			.get("/nuxeo/api/v1/path/FV/sections/Data/Athabascan/Dene/Dene/Portal")
			.headers(headers_8),
            http("request_31")
			.get("/explore/FV/sections/Data/Athabascan/Dene/Dene/learn/phrases/10/assets/images/cover.png")
			.headers(headers_2),
            http("request_32")
			.get("/nuxeo/nxfile/default/5bc8904c-a396-4228-85d8-c43169e379cd/picture:views/0/content/Thumbnail_CLFN_logo.jpg")
			.headers(headers_2),
            http("request_33")
			.get("/nuxeo/api/v1/path/FV/sections/Data/Athabascan/Dene/Dene")
			.headers(headers_11),
            http("request_34")
			.post("/nuxeo/api/v1/automation/Document.EnrichedQuery")
			.headers(headers_34)
			.body(RawFileBody("wordphrasesearchtest/0034_request.json")),
            http("request_35")
			.get("/nuxeo/api/v1/path/FV/sections/Data/Athabascan/Dene/Dene/Phrase%20Books/@children")
			.headers(headers_16),
            http("request_36")
			.get("/explore/FV/sections/Data/Athabascan/Dene/Dene/learn/phrases/10/assets/styles/assets/images/footer-background.png")
			.headers(headers_2),
            http("request_37")
			.get("/nuxeo/api/v1/directory/parts_of_speech")
			.headers(headers_4),
            http("request_38")
			.get("/nuxeo/nxfile/default/87e16f9f-0084-4ae3-a62f-48695a9513ab/file:content/77_s_papers.mp3")
			.headers(headers_38),
            http("request_39")
			.get("/nuxeo/nxfile/default/87e16f9f-0084-4ae3-a62f-48695a9513ab/file:content/77_s_papers.mp3")
			.headers(headers_38),
            http("request_40")
			.get("/nuxeo/nxfile/default/57f388d3-4333-45c1-8f1e-f7c787be0387/file:content/96_s_table.mp3")
			.headers(headers_38),
            http("request_41")
			.get("/nuxeo/api/v1/directory/parts_of_speech")
			.headers(headers_4),
            http("request_42")
			.get("/nuxeo/nxfile/default/57f388d3-4333-45c1-8f1e-f7c787be0387/file:content/96_s_table.mp3")
			.headers(headers_38),
            http("request_43")
			.get("/nuxeo/nxfile/default/87e16f9f-0084-4ae3-a62f-48695a9513ab/file:content/77_s_papers.mp3")
			.headers(headers_38),
            http("request_44")
			.get("/nuxeo/nxfile/default/57f388d3-4333-45c1-8f1e-f7c787be0387/file:content/96_s_table.mp3")
			.headers(headers_38),
            http("request_45")
			.post("/nuxeo/api/v1/automation/Document.EnrichedQuery")
			.headers(headers_19)
			.body(RawFileBody("wordphrasesearchtest/0045_request.json")),
            http("request_46")
			.post("/nuxeo/api/v1/automation/Document.EnrichedQuery")
			.headers(headers_19)
			.body(RawFileBody("wordphrasesearchtest/0046_request.json"))))
		.pause(1)
		//.pause(4)
		.exec(http("request_47")
			.post("/nuxeo/api/v1/automation/Document.EnrichedQuery")
			.headers(headers_34)
			.body(RawFileBody("wordphrasesearchtest/0047_request.json"))
			.resources(http("request_48")
			.get("/nuxeo/nxfile/default/8801a032-7be9-4962-bd9a-4fd7e9b05345/file:content/say_it_in_dene.mp3")
			.headers(headers_38),
            http("request_49")
			.get("/nuxeo/nxfile/default/97199dc3-4ff6-47ef-a745-44e9d5995300/file:content/how_do_you_say_it_in_dene.mp3")
			.headers(headers_38),
            http("request_50")
			.get("/nuxeo/nxfile/default/97199dc3-4ff6-47ef-a745-44e9d5995300/file:content/how_do_you_say_it_in_dene.mp3")
			.headers(headers_38),
            http("request_51")
			.get("/nuxeo/nxfile/default/8801a032-7be9-4962-bd9a-4fd7e9b05345/file:content/say_it_in_dene.mp3")
			.headers(headers_38)))

	//setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
	setUp(scn.inject(rampUsers(30) during (10 seconds))).protocols(httpProtocol)
}