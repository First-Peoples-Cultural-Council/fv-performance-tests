
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class AlphabetTest extends Simulation {

	val httpProtocol = http
		.baseUrl("https://www.firstvoices.com")
		.inferHtmlResources(BlackList(""".*.css""", """.*.js""", """.*.ico"""), WhiteList())
		.acceptHeader("audio/webm,audio/ogg,audio/wav,audio/*;q=0.9,application/ogg;q=0.7,video/*;q=0.6,*/*;q=0.5")
		.acceptLanguageHeader("en-CA,en-US;q=0.7,en;q=0.3")
		.userAgentHeader("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:70.0) Gecko/20100101 Firefox/70.0")

	val headers_0 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_1 = Map(
		"Accept" -> "application/json",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Content-Type" -> "application/json",
		"Nuxeo-Transaction-Timeout" -> "60000",
		"Origin" -> "https://www.firstvoices.com",
		"properties" -> "*")

	val headers_2 = Map(
		"Accept" -> "image/webp,*/*",
		"Accept-Encoding" -> "gzip, deflate, br")

	val headers_4 = Map(
		"Accept" -> "application/json",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Nuxeo-Transaction-Timeout" -> "60000",
		"properties" -> "*")

	val headers_8 = Map(
		"Accept" -> "application/json",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Nuxeo-Transaction-Timeout" -> "60000",
		"enrichers.document" -> "ancestry,dialect,permissions,acls",
		"properties" -> "*")

	val headers_9 = Map(
		"Accept" -> "application/json",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Nuxeo-Transaction-Timeout" -> "60000",
		"enrichers.document" -> "ancestry,permissions,acls",
		"properties" -> "*")

	val headers_10 = Map(
		"Accept" -> "application/json",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Nuxeo-Transaction-Timeout" -> "60000",
		"enrichers.document" -> "ancestry,portal",
		"properties" -> "*")

	val headers_14 = Map(
		"Accept" -> "application/json",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Nuxeo-Transaction-Timeout" -> "60000",
		"enrichers.document" -> "ancestry, breadcrumb",
		"properties" -> "*")

	val headers_19 = Map(
		"Accept" -> "application/json",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Content-Type" -> "application/json",
		"Nuxeo-Transaction-Timeout" -> "60000",
		"Origin" -> "https://www.firstvoices.com",
		"enrichers.document" -> "character",
		"properties" -> "*")

	val headers_20 = Map("Range" -> "bytes=0-")



	val scn = scenario("AlphabetTest")
		.exec(http("request_0")
			.get("/explore/FV/sections/Data/Athabascan/Dene/Dene/learn/alphabet")
			.headers(headers_0))
		.pause(1)
		.exec(http("request_1")
			.post("/nuxeo/api/v1/automation/User.Get")
			.headers(headers_1)
			//.body(StringBody("""{"params":{},"context":{}}"""))//.asJson
			//{"params":{},"context":{}}
			.body(RawFileBody("alphabettest/0001_request.json"))
			.resources(http("request_2")
			.get("/favicon-16x16.png")
			.headers(headers_2),
            http("request_3")
			.get("/apple-touch-icon.png")
			.headers(headers_2),
            http("request_4")
			.get("/nuxeo/api/v1/user/Guest")
			.headers(headers_4),
            http("request_5")
			.get("/explore/FV/sections/Data/Athabascan/Dene/Dene/learn/assets/images/logo.png")
			.headers(headers_2),
            http("request_6")
			.get("/explore/FV/sections/Data/Athabascan/Dene/Dene/learn/assets/images/cover.png")
			.headers(headers_2),
            http("request_7")
			.get("/explore/FV/sections/Data/Athabascan/Dene/Dene/learn/assets/images/logo-fpcc-white.png")
			.headers(headers_2),
            http("request_8")
			.get("/nuxeo/api/v1/path/FV/sections/Data/Athabascan/Dene/Dene")
			.headers(headers_8),
            http("request_9")
			.get("/nuxeo/api/v1/path/FV/sections/Data/Athabascan/Dene/Dene/Dictionary")
			.headers(headers_9),
            http("request_10")
			.get("/nuxeo/api/v1/path/FV/sections/Data/Athabascan/Dene/Dene/Portal")
			.headers(headers_10),
            http("request_11")
			.post("/nuxeo/api/v1/automation/Document.EnrichedQuery")
			.headers(headers_1)
			.body(RawFileBody("alphabettest/0011_request.json")),
            http("request_12")
			.get("/explore/FV/sections/Data/Athabascan/Dene/Dene/learn/assets/styles/assets/images/footer-background.png")
			.headers(headers_2),
            http("request_13")
			.get("/nuxeo/nxfile/default/5bc8904c-a396-4228-85d8-c43169e379cd/picture:views/0/content/Thumbnail_CLFN_logo.jpg")
			.headers(headers_2),
            http("request_14")
			.get("/nuxeo/api/v1/id/691bce72-5d5d-4210-a407-7bf738564f64")
			.headers(headers_14),
            http("request_15")
			.get("/nuxeo/api/v1/id/a3d71781-067d-4945-a2b0-b70c48b1c6a8")
			.headers(headers_14),
            http("request_16")
			.get("/nuxeo/api/v1/id/6616d3ff-e97a-4aed-b87d-5241221d7e15")
			.headers(headers_14),
            http("request_17")
			.get("/nuxeo/api/v1/id/35dbec19-0c70-41f4-9705-50381403f0ee")
			.headers(headers_14),
            http("request_18")
			.get("/nuxeo/nxfile/default/f527994c-33f7-4b21-b721-bdb8e3d919aa/file:content/portal-1a.jpg")
			.headers(headers_2),
            http("request_19")
			.post("/nuxeo/api/v1/automation/Document.EnrichedQuery")
			.headers(headers_19)
			.body(RawFileBody("alphabettest/0019_request.json")),
            http("request_20")
			.get("/nuxeo/nxfile/default/4fd1bce8-1218-4815-be02-f7a8c5625e83/file:content/173Sounds20060606124520781a.mp3")
			.headers(headers_20),
            http("request_21")
			.get("/nuxeo/nxfile/default/89d1a767-c6bd-4174-ab9a-68dd3904b4bf/file:content/173Sounds20060606124452671glottal_stop.mp3")
			.headers(headers_20),
            http("request_22")
			.get("/nuxeo/nxfile/default/d7d0bdea-5843-405e-ac20-aee056ba33df/file:content/173Sounds20060606125010750b.mp3")
			.headers(headers_20),
            http("request_23")
			.get("/nuxeo/nxfile/default/62626b8e-788f-4aeb-ba53-336205f0675f/file:content/173Sounds20060606124640500high_a.mp3")
			.headers(headers_20),
            http("request_24")
			.get("/nuxeo/nxfile/default/d4dc42b5-dc15-4759-a798-f4200c60c8e6/file:content/173Sounds20060606124838234highnasal_a.mp3")
			.headers(headers_20),
            http("request_25")
			.get("/nuxeo/nxfile/default/7f546832-939b-45db-b469-37c411cf2e84/file:content/173Sounds20060606124745843nasal_a.mp3")
			.headers(headers_20),
            http("request_26")
			.get("/nuxeo/nxfile/default/01898879-bd8e-4eab-8908-06f88256cf40/file:content/173Sounds20060606124930031ch.mp3")
			.headers(headers_20),
            http("request_27")
			.get("/nuxeo/nxfile/default/219ac581-a766-4ec4-9f0c-ed27f92270e2/file:content/173Sounds20060606125102156ch.mp3")
			.headers(headers_20),
            http("request_28")
			.get("/nuxeo/nxfile/default/070eb654-1af2-459c-a00d-e767bea57637/file:content/173Sounds20060606125148265d.mp3")
			.headers(headers_20),
            http("request_29")
			.get("/nuxeo/nxfile/default/dbeb838b-613d-4265-a0a7-08f36c69080d/file:content/173Sounds20060606125239375ddh.mp3")
			.headers(headers_20),
            http("request_30")
			.get("/nuxeo/nxfile/default/2b6ee40c-13e5-4786-a1a3-644f7a7cf33d/file:content/173Sounds20060606125321062dh.mp3")
			.headers(headers_20),
            http("request_31")
			.get("/nuxeo/nxfile/default/3703cfd5-416a-4252-a354-781bc8cc5327/file:content/173Sounds20060606125524390dl.mp3")
			.headers(headers_20),
            http("request_32")
			.get("/nuxeo/nxfile/default/08e0d1cf-6639-4a55-842a-e6c0b39f4467/file:content/173Sounds20060606125411359dz.mp3")
			.headers(headers_20),
            http("request_33")
			.get("/nuxeo/nxfile/default/7718c436-9e09-4bae-b24e-44c5d3ad2123/file:content/173Sounds20060606125609640e.mp3")
			.headers(headers_20),
            http("request_34")
			.get("/nuxeo/nxfile/default/8e4d94b4-c60d-48d6-aec6-afe32ca65084/file:content/173Sounds20060606130223953high_e.mp3")
			.headers(headers_20),
            http("request_35")
			.get("/nuxeo/nxfile/default/d227439d-f687-4cca-b7be-d52452eeffdd/file:content/173Sounds20060606130521593nasal_e.mp3")
			.headers(headers_20),
            http("request_36")
			.get("/nuxeo/nxfile/default/45df3c09-2480-4fc0-81ee-c23249bb2a14/file:content/173Sounds20060606130700421g.mp3")
			.headers(headers_20),
            http("request_37")
			.get("/nuxeo/nxfile/default/4b440309-b13d-4779-9a9e-3e5755e60453/file:content/173Sounds20060606130841328h.mp3")
			.headers(headers_20),
            http("request_38")
			.get("/nuxeo/nxfile/default/0cbc68aa-02af-461a-afd2-725320c8dc2e/file:content/173Sounds20060606130747750gh.mp3")
			.headers(headers_20),
            http("request_39")
			.get("/nuxeo/nxfile/default/9b3194de-62fd-4dd7-bb81-fcdfb8f1cd92/file:content/173Sounds20060606130932312i.mp3")
			.headers(headers_20),
            http("request_40")
			.get("/nuxeo/nxfile/default/cdd0bad0-8bab-4eb8-97f8-035fcdb548c1/file:content/173Sounds20060606125733640highnasal_e.mp3")
			.headers(headers_20),
            http("request_41")
			.get("/nuxeo/nxfile/default/75a4eb27-0f1c-4406-ab8f-53ba5b3a7fdf/file:content/173Sounds20060606131149312high_i.mp3")
			.headers(headers_20),
            http("request_42")
			.get("/nuxeo/nxfile/default/61859841-683c-4c1e-9378-1938389155e5/file:content/173Sounds20060606131045875nasal_i.mp3")
			.headers(headers_20),
            http("request_43")
			.get("/nuxeo/nxfile/default/9af311c5-b6c3-4673-b5f1-2be4c471ff0c/file:content/173Sounds20060606131315515high_nasal_i.mp3")
			.headers(headers_20),
            http("request_44")
			.get("/nuxeo/nxfile/default/6e04c94a-83b7-49ee-b2e0-0521d7a95634/file:content/173Sounds20060606131409703j.mp3")
			.headers(headers_20),
            http("request_45")
			.get("/nuxeo/nxfile/default/bbdb7370-a171-49f0-a86d-6fb5467d78b7/file:content/173Sounds20060606131516375k.mp3")
			.headers(headers_20),
            http("request_46")
			.get("/nuxeo/nxfile/default/60a81ad3-29a0-49ea-a146-9abcbccdcaec/file:content/173Sounds20060606131704656l.mp3")
			.headers(headers_20),
            http("request_47")
			.get("/nuxeo/nxfile/default/faba6052-67b8-4a57-9383-41a47ae3b2fe/file:content/173Sounds20060606131607390k.mp3")
			.headers(headers_20),
            http("request_48")
			.get("/nuxeo/nxfile/default/389361c7-0f56-4306-a71a-3693bf59f702/file:content/173Sounds20060628215706687barred_l.mp3")
			.headers(headers_20),
            http("request_49")
			.get("/nuxeo/nxfile/default/31cb5841-37e7-4752-b171-8f50cae865ac/file:content/173Sounds20060606132048171m.mp3")
			.headers(headers_20),
            http("request_50")
			.get("/nuxeo/nxfile/default/35a5d610-7583-4c94-a08c-84230fdf485a/file:content/173Sounds20060606132200640n.mp3")
			.headers(headers_20),
            http("request_51")
			.get("/nuxeo/nxfile/default/ac692dc8-2157-4830-9432-d9106e8d31ba/file:content/173Sounds20060606132351921high_o.mp3")
			.headers(headers_20),
            http("request_52")
			.get("/nuxeo/nxfile/default/3c16a5e9-ab0f-406b-90fc-96a5a117e484/file:content/173Sounds20060606132255640o.mp3")
			.headers(headers_20),
            http("request_53")
			.get("/nuxeo/nxfile/default/e78cd8de-2641-4e6e-834b-04a6700da6bb/file:content/173Sounds20060606132447046o_nasal.mp3")
			.headers(headers_20),
            http("request_54")
			.get("/nuxeo/nxfile/default/708f76e5-5c00-4736-8dba-078cd2743cce/file:content/173Sounds20060606132613718nasalhigh_o.mp3")
			.headers(headers_20),
            http("request_55")
			.get("/nuxeo/nxfile/default/2f9fefab-b48e-4a07-bb78-05ca63955f7e/file:content/173Sounds20060606132707812r.mp3")
			.headers(headers_20),
            http("request_56")
			.get("/nuxeo/nxfile/default/12990b7c-9a5a-4c03-b2e3-592622479dd2/file:content/173Sounds20060606132836484s.mp3")
			.headers(headers_20),
            http("request_57")
			.get("/nuxeo/nxfile/default/03f8727d-047e-412c-b748-99d07fe0d8b8/file:content/173Sounds20060606133230093sh.mp3")
			.headers(headers_20),
            http("request_58")
			.get("/nuxeo/nxfile/default/a63f738f-38fc-4e01-8ba5-0134c882a9bb/file:content/173Sounds20060606133634640t.mp3")
			.headers(headers_20),
            http("request_59")
			.get("/nuxeo/nxfile/default/06893523-c9aa-48a6-8d23-90363b7c5aa6/file:content/173Sounds20060606133024953t.mp3")
			.headers(headers_20),
            http("request_60")
			.get("/nuxeo/nxfile/default/db5cd129-06c3-4b67-962b-4d2a15042ae0/file:content/173Sounds20060606133724765ts.mp3")
			.headers(headers_20),
            http("request_61")
			.get("/nuxeo/nxfile/default/24f8ac36-c4c4-4b26-9593-e16cd1be0f11/file:content/173Sounds20060606133815546ts.mp3")
			.headers(headers_20),
            http("request_62")
			.get("/nuxeo/nxfile/default/8ae22ad3-0fbe-490a-a453-15f9188a9402/file:content/173Sounds20060606133906125tth.mp3")
			.headers(headers_20),
            http("request_63")
			.get("/nuxeo/nxfile/default/b0fbfad5-5c80-4fd4-8dbb-ff0753ea4569/file:content/173Sounds20060606133953812tth.mp3")
			.headers(headers_20),
            http("request_64")
			.get("/nuxeo/nxfile/default/9368b0d4-7c0d-4585-8327-79f1b548d0d7/file:content/173Sounds20060606134031109t.mp3")
			.headers(headers_20),
            http("request_65")
			.get("/nuxeo/nxfile/default/84716129-858f-4546-8112-36b82ca306a6/file:content/173Sounds20060606134116093t.mp3")
			.headers(headers_20),
            http("request_66")
			.get("/nuxeo/nxfile/default/4846abb3-c8ca-455e-8097-b5b26ff20cec/file:content/173Sounds20060606134212265u.mp3")
			.headers(headers_20),
            http("request_67")
			.get("/nuxeo/nxfile/default/c934f93c-b5fe-4bb7-869d-32cbccd41cdc/file:content/173Sounds20060606134402859high_u.mp3")
			.headers(headers_20),
            http("request_68")
			.get("/nuxeo/nxfile/default/5c99ff33-2b60-4f7b-a95e-e8e19e3a3eda/file:content/173Sounds20060606134450093nasal_u.mp3")
			.headers(headers_20),
            http("request_69")
			.get("/nuxeo/nxfile/default/d6811e19-252f-42b1-b757-5c60184a2e9a/file:content/173Sounds20060606134532375high_nasal_u.mp3")
			.headers(headers_20),
            http("request_70")
			.get("/nuxeo/nxfile/default/8268eae5-6679-42a1-8e98-8dc5c28b6377/file:content/173Sounds20060606135241531w.mp3")
			.headers(headers_20),
            http("request_71")
			.get("/nuxeo/nxfile/default/1200c9bf-4a80-4f38-b5c4-53d41e818609/file:content/173Sounds20060606135326562x.mp3")
			.headers(headers_20),
            http("request_72")
			.get("/nuxeo/nxfile/default/175ea347-9113-40a6-88ba-06bcbbbd3a64/file:content/173Sounds20060606135406375y.mp3")
			.headers(headers_20),
            http("request_73")
			.get("/nuxeo/nxfile/default/c6412357-b443-4d00-8c1b-9b4e406daf51/file:content/173Sounds20060606135456484z.mp3")
			.headers(headers_20)))

	//setUp(scn.inject(atOnceUsers(10))).protocols(httpProtocol)
	setUp(scn.inject(rampUsers(30) during (10 seconds))).protocols(httpProtocol)
}
