package com.tudorzgureanu.playsample.api.controllers

import com.tudorzgureanu.playsample.services.SampleService
import play.api.libs.json.Json
import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents}

import scala.concurrent.ExecutionContext

class PlaySampleController(sampleService: SampleService, val controllerComponents: ControllerComponents)
    extends BaseController {

  def helloWorld()(implicit ec: ExecutionContext): Action[AnyContent] = Action.async { request =>
    println(s"${request.method} ${request.path}")
    sampleService.helloWorld.map(res => Ok(Json.toJson(res)))
  }
}
