package com.tudorzgureanu.playsample.api.routers

import com.tudorzgureanu.playsample.api.controllers.PlaySampleController
import play.api.routing.Router.Routes
import play.api.routing.SimpleRouter
import play.api.routing.sird._

import scala.concurrent.ExecutionContext

class PlaySampleRouter(playSampleController: PlaySampleController, implicit val ec: ExecutionContext)
    extends SimpleRouter {

  override def routes: Routes = {
    case GET(p"/hello") => playSampleController.helloWorld()
  }
}
