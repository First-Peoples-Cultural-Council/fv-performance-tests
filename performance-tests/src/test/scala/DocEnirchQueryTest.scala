
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class DocEnrichQueryTest extends Simulation {

    	val httpProtocol = http
		.baseUrl("https://preprod.firstvoices.com")
		.inferHtmlResources(BlackList(""".*.css""", """.*.js""", """.*.ico"""), WhiteList())
		.acceptHeader("application/json")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-CA,en-US;q=0.7,en;q=0.3")
		.userAgentHeader("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:70.0) Gecko/20100101 Firefox/70.0")

	    val headers = Map(
		    "Content-Type" -> "application/json",
		    "Nuxeo-Transaction-Timeout" -> "60000",
		    "Origin" -> "https://preprod.firstvoices.com",
		    "enrichers.document" -> "character",
		    "properties" -> "*")


        val scn = scenario("CharQueryTest")
		    .exec(http("request_0")
			.post("/nuxeo/api/v1/automation/Document.EnrichedQuery")
			.headers(headers)
			.body(RawFileBody("charquerytest.json")))

    //setUp(scn.inject(atOnceUsers(20))).protocols(httpProtocol)
    setUp(scn.inject(rampUsers(100) during (10 seconds))).protocols(httpProtocol)
    //
}