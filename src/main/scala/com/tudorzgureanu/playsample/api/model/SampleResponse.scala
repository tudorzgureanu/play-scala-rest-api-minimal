package com.tudorzgureanu.playsample.api.model

import java.time.LocalDateTime
import play.api.libs.json._

case class SampleResponse(message: String, time: LocalDateTime)

object SampleResponse {
  implicit val sampleResponseFormat: Format[SampleResponse] = Json.format[SampleResponse]
}
