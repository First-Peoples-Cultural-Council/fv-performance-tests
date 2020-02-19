
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class GalleryTest extends Simulation {

	val httpProtocol = http
		.baseUrl("https://www.firstvoices.com")
		.inferHtmlResources(BlackList(""".*.css""", """.*.js""", """.*.ico"""), WhiteList())
		.acceptHeader("image/webp,*/*")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-CA,en-US;q=0.7,en;q=0.3")
		.userAgentHeader("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:70.0) Gecko/20100101 Firefox/70.0")

	val headers_0 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_1 = Map(
		"Accept" -> "application/json",
		"Content-Type" -> "application/json",
		"Nuxeo-Transaction-Timeout" -> "60000",
		"Origin" -> "https://www.firstvoices.com",
		"properties" -> "*")

	val headers_4 = Map(
		"Accept" -> "application/json",
		"Nuxeo-Transaction-Timeout" -> "60000",
		"properties" -> "*")

	val headers_7 = Map(
		"Accept" -> "application/json",
		"Nuxeo-Transaction-Timeout" -> "60000",
		"enrichers.document" -> "ancestry,dialect,permissions,acls",
		"properties" -> "*")

	val headers_10 = Map(
		"Accept" -> "application/json",
		"Nuxeo-Transaction-Timeout" -> "60000",
		"enrichers.document" -> "ancestry,gallery,permissions",
		"properties" -> "*")



	val scn = scenario("GalleryTest")
		.exec(http("request_0")
			.get("/explore/FV/sections/Data/Coast%20Salish/%C3%89y7%C3%A17juuthem/Homalco/gallery/573e8479-778e-480e-a505-2a014ed0c9eb")
			.headers(headers_0))
		.pause(2)
		.exec(http("request_1")
			.post("/nuxeo/api/v1/automation/User.Get")
			.headers(headers_1)
			.body(RawFileBody("gallerytest/0001_request.json"))
			.resources(http("request_2")
			.get("/apple-touch-icon.png"),
            http("request_3")
			.get("/favicon-16x16.png"),
            http("request_4")
			.get("/nuxeo/api/v1/user/Guest")
			.headers(headers_4),
            http("request_5")
			.get("/explore/FV/sections/Data/Coast%20Salish/%C3%89y7%C3%A17juuthem/Homalco/gallery/assets/images/logo.png"),
            http("request_6")
			.get("/explore/FV/sections/Data/Coast%20Salish/%C3%89y7%C3%A17juuthem/Homalco/gallery/assets/images/logo-fpcc-white.png"),
            http("request_7")
			.get("/nuxeo/api/v1/path/FV/sections/Data/Coast%20Salish/%C3%89y7%C3%A17juuthem/Homalco")
			.headers(headers_7),
            http("request_8")
			.post("/nuxeo/api/v1/automation/Document.EnrichedQuery")
			.headers(headers_1)
			.body(RawFileBody("gallerytest/0008_request.json")),
            http("request_9")
			.get("/explore/FV/sections/Data/Coast%20Salish/%C3%89y7%C3%A17juuthem/Homalco/gallery/assets/images/cover.png"),
            http("request_10")
			.get("/nuxeo/api/v1/id/573e8479-778e-480e-a505-2a014ed0c9eb")
			.headers(headers_10),
            http("request_11")
			.get("/explore/FV/sections/Data/Coast%20Salish/%C3%89y7%C3%A17juuthem/Homalco/gallery/assets/styles/assets/images/footer-background.png"),
            http("request_12")
			.get("/nuxeo/nxfile/default/4c12ecd9-cd85-4599-a56b-06274067ffb2/picture:views/2/content/Medium_50259476_10156862291482317_7122474640689070080_o.jpg"),
            http("request_13")
			.get("/nuxeo/nxfile/default/0304c2f5-21ce-41c9-997c-3dec9d5d14cc/picture:views/2/content/Medium_65923337_225925321700777_7675792318200283136_o.jpg"),
            http("request_14")
			.get("/nuxeo/nxfile/default/1144a05d-c07f-4976-bb04-1d9fe5329eaa/picture:views/2/content/Medium_61673845_10217254158659121_4110579565389152256_o.jpg"),
            http("request_15")
			.get("/nuxeo/nxfile/default/4980653a-d334-4058-94e8-5933267c57be/picture:views/2/content/Medium_62237494_10217277673766984_6860764016847880192_n.jpg"),
            http("request_16")
			.get("/nuxeo/nxfile/default/f9b85cee-fd10-4822-9263-3c8b06629ec3/picture:views/2/content/Medium_61844712_10217285212515448_2806423225678954496_n.jpg"),
            http("request_17")
			.get("/nuxeo/nxfile/default/76eeac83-4797-4768-af6b-12d789a139ba/picture:views/2/content/Medium_62081501_10217277356079042_2715279097625313280_n.jpg"),
            http("request_18")
			.get("/nuxeo/nxfile/default/06d75f46-08c0-4062-88fb-10bd62c365c3/picture:views/2/content/Medium_61916304_10217277360079142_7524198243442360320_n.jpg"),
            http("request_19")
			.get("/nuxeo/nxfile/default/25643011-fc1e-4781-9758-c2f35e5cab19/picture:views/2/content/Medium_61657009_10217277363359224_2531975309385793536_n.jpg"),
            http("request_20")
			.get("/nuxeo/nxfile/default/cf733efb-d59c-4825-bfee-1eba50a395ca/picture:views/2/content/Medium_61783100_10217277678447101_184233004414009344_n.jpg"),
            http("request_21")
			.get("/nuxeo/nxfile/default/e1b04245-e2a0-46ec-8ee8-363f399192d9/picture:views/2/content/Medium_62007437_10217277585644781_146513171396427776_n.jpg"),
            http("request_22")
			.get("/nuxeo/nxfile/default/29cc5da3-25a6-4a9d-a59c-d08fbaed2173/picture:views/2/content/Medium_61905135_10217277364159244_5369134996072169472_n.jpg")))

	//setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
	setUp(scn.inject(rampUsers(30) during (10 seconds))).protocols(httpProtocol)
}