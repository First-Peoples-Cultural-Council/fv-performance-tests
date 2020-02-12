
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class SignInTest extends Simulation {

	val httpProtocol = http
		.baseUrl("https://preprod.firstvoices.com")
		.inferHtmlResources(BlackList(""".*.css""", """.*.js""", """.*.ico"""), WhiteList())
		.acceptHeader("image/webp,*/*")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-CA,en-US;q=0.7,en;q=0.3")
		.userAgentHeader("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:70.0) Gecko/20100101 Firefox/70.0")

	val headers_0 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
		"Accept-Encoding" -> "gzip, deflate",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_3 = Map(
		"Accept" -> "application/json",
		"Content-Type" -> "application/json",
		"Nuxeo-Transaction-Timeout" -> "60000",
		"Origin" -> "https://preprod.firstvoices.com",
		"properties" -> "*")

	val headers_4 = Map(
		"Accept" -> "application/json",
		"Nuxeo-Transaction-Timeout" -> "60000",
		"properties" -> "*")

	val headers_7 = Map(
		"Accept" -> "application/json",
		"Content-Type" -> "application/json",
		"Nuxeo-Transaction-Timeout" -> "60000",
		"Origin" -> "https://preprod.firstvoices.com",
		"enrichers.document" -> "ancestry,permissions",
		"properties" -> "*")

	val headers_12 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_16 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
		"Origin" -> "https://preprod.firstvoices.com",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_23 = Map(
		"Accept" -> "application/json",
		"Nuxeo-Transaction-Timeout" -> "60000",
		"enrichers.document" -> "ancestry,dialect,permissions,acls",
		"properties" -> "*")

	val headers_26 = Map(
		"Accept" -> "application/json",
		"Nuxeo-Transaction-Timeout" -> "60000",
		"enrichers.document" -> "ancestry,portal",
		"properties" -> "*")

	val headers_31 = Map(
		"Accept" -> "application/json",
		"Nuxeo-Transaction-Timeout" -> "60000",
		"enrichers.document" -> "ancestry, breadcrumb",
		"properties" -> "*")

    val uri1 = "preprod.firstvoices.com"

	val scn = scenario("SignInTest")
		.exec(http("request_0")
			.get("http://" + uri1 + "/")
			.headers(headers_0))
		.pause(1)
		.exec(http("request_1")
			.get("/apple-touch-icon.png")
			.resources(http("request_2")
			.get("/favicon-16x16.png"),
            http("request_3")
			.post("/nuxeo/api/v1/automation/User.Get")
			.headers(headers_3)
			.body(RawFileBody("signintest/0003_request.json")),
            http("request_4")
			.get("/nuxeo/api/v1/user/Guest")
			.headers(headers_4),
            http("request_5")
			.get("/assets/images/logo.png"),
            http("request_6")
			.get("/assets/images/logo-fpcc-white.png"),
            http("request_7")
			.post("/nuxeo/api/v1/automation/Document.EnrichedQuery")
			.headers(headers_7)
			.body(RawFileBody("signintest/0007_request.json")),
            http("request_8")
			.post("/nuxeo/api/v1/automation/Document.EnrichedQuery")
			.headers(headers_3)
			.body(RawFileBody("signintest/0008_request.json")),
            http("request_9")
			.post("/nuxeo/api/v1/automation/FVGetUserStartPage")
			.headers(headers_3)
			.body(RawFileBody("signintest/0009_request.json")),
            http("request_10")
			.get("/assets/styles/assets/images/footer-background.png"),
            http("request_11")
			.get("/assets/images/fv-intro-background.jpg")))
		.pause(2)
		.exec(http("request_12")
			.get("/nuxeo/logout")
			.headers(headers_12)
			.resources(http("request_13")
			.get("/nuxeo/login.jsp?nxtimeout=true&forceAnonymousLogin=true&requestedUrl=nxstartup.faces")
			.headers(headers_12),
            http("request_14")
			.get("/nuxeo/img/Logo.PNG"),
            http("request_15")
			.get("/nuxeo//img/footer-background.png"))
			.check(status.is(401)))
		.pause(4)
		.exec(http("request_16")
			.post("/nuxeo/startup")
			.headers(headers_16)
			.formParam("user_name", "DUMMY_MEMBER")
			.formParam("user_password", "DUMMY_MEMBER")
			.formParam("language", "en")
			.formParam("requestedUrl", "nxstartup.faces")
			.formParam("forceAnonymousLogin", "")
			.formParam("form_submitted_marker", "")
			.formParam("Submit", "Log In"))
		.pause(1)
		.exec(http("request_17")
			.post("/nuxeo/api/v1/automation/User.Get")
			.headers(headers_3)
			.body(RawFileBody("signintest/0017_request.json"))
			.resources(http("request_18")
			.get("/nuxeo/api/v1/user/DUMMY_MEMBER")
			.headers(headers_4),
            http("request_19")
			.get("/Workspaces/assets/images/logo.png"),
            http("request_20")
			.get("/Workspaces/assets/images/logo-fpcc-white.png"),
            http("request_21")
			.post("/nuxeo/api/v1/automation/Document.EnrichedQuery")
			.headers(headers_3)
			.body(RawFileBody("signintest/0021_request.json")),
            http("request_22")
			.post("/nuxeo/api/v1/automation/Document.EnrichedQuery")
			.headers(headers_3)
			.body(RawFileBody("signintest/0022_request.json")),
            http("request_23")
			.get("/nuxeo/api/v1/path/FV/Workspaces/Data/Demonstration/Esperanto/Esperanto")
			.headers(headers_23),
            http("request_24")
			.get("/Workspaces/assets/styles/assets/images/footer-background.png"),
            http("request_25")
			.get("/explore/FV/Workspaces/Data/Demonstration/Esperanto/assets/images/cover.png"),
            http("request_26")
			.get("/nuxeo/api/v1/path/FV/Workspaces/Data/Demonstration/Esperanto/Esperanto/Portal")
			.headers(headers_26),
            http("request_27")
			.get("/nuxeo/nxfile/default/621409cd-0a18-4f86-972a-3d5ac6c9add6/picture:views/0/content/Thumbnail_esperanto.jpg"),
            http("request_28")
			.get("/nuxeo/nxfile/default/f19a3c40-e705-468f-b21d-e5efe9c0c2bc/picture:views/1/content/Small_Raven.jpg"),
            http("request_29")
			.get("/nuxeo/nxfile/default/e526b771-9768-4563-9a8e-59466af39162/picture:views/1/content/Small_FN.jpg"),
            http("request_30")
			.post("/nuxeo/api/v1/automation/Workflow.GetOpenTasks")
			.headers(headers_3)
			.body(RawFileBody("signintest/0030_request.json")),
            http("request_31")
			.get("/nuxeo/api/v1/id/61f54d5e-00a3-4af6-a70a-43ae0d12286f")
			.headers(headers_31),
            http("request_32")
			.get("/nuxeo/nxfile/default/bc27bd4b-5e27-4975-b6f1-e421df67271a/picture:views/1/content/Small_horse.jpg"),
            http("request_33")
			.get("/nuxeo/nxfile/default/66815ebf-94b2-4d94-add7-dbe3d84c6791/picture:views/1/content/Small_boxer_dog.jpg"),
            http("request_34")
			.get("/nuxeo/api/v1/id/c29930d4-2245-4c35-b7f1-3064021fb6a2")
			.headers(headers_31),
            http("request_35")
			.get("/nuxeo/nxfile/default/0bafda4b-80da-40fe-8fc8-5b9176cd3580/file:content/dog.jpg")))

	//setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
	setUp(scn.inject(rampUsers(30) during (10 seconds))).protocols(httpProtocol)
}