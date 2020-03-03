package com.tudorzgureanu.playsample.api.controllers

import java.time.LocalDateTime

import com.tudorzgureanu.playsample.api.controllers.PlaySampleControllerSpec.SampleServiceDummy
import com.tudorzgureanu.playsample.model.SampleResponse
import com.tudorzgureanu.playsample.services.SampleService
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import play.api.http.Status
import play.api.libs.json.Json
import play.api.test._
import play.api.test.Helpers._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class PlaySampleControllerSpec extends AnyWordSpec with Matchers {

  val sampleResponse = new SampleResponse("Hello!", LocalDateTime.now())
  val sampleService = new SampleServiceDummy(sampleResponse)
  val controller = new PlaySampleController(sampleService, stubControllerComponents())

  "PlaySampleController" should {
    "return 200 OK with the sample response as json" in {
      val request = FakeRequest(method = "GET", path = "/hello")

      val result = controller.helloWorld().apply(request)

      status(result) shouldBe Status.OK
      contentAsJson(result) shouldBe Json.toJson(sampleResponse)
    }
  }
}

object PlaySampleControllerSpec {

  class SampleServiceDummy(sampleResponse: SampleResponse) extends SampleService {
    override def helloWorld: Future[SampleResponse] = Future.successful(sampleResponse)
  }
}
