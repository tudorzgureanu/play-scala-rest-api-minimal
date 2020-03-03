package com.tudorzgureanu.playsample.services

import java.time.{LocalDateTime, ZoneOffset}

import com.tudorzgureanu.playsample.model.SampleResponse

import scala.concurrent.Future

trait SampleService {
  def helloWorld: Future[SampleResponse]
}

class SampleServiceImpl extends SampleService {

  def helloWorld: Future[SampleResponse] =
    Future.successful(SampleResponse("Hello world!", LocalDateTime.now(ZoneOffset.UTC)))
}
