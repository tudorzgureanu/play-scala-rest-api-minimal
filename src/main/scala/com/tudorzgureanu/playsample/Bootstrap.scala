package com.tudorzgureanu.playsample

import com.tudorzgureanu.playsample.api.controllers.PlaySampleController
import com.tudorzgureanu.playsample.api.routers.PlaySampleRouter
import com.tudorzgureanu.playsample.services.{SampleService, SampleServiceImpl}
import play.api.{Application, ApplicationLoader, BuiltInComponentsFromContext}
import play.api.ApplicationLoader.Context
import play.api.libs.ws.ahc.AhcWSComponents
import play.api.routing.Router
import play.filters.HttpFiltersComponents

class Bootstrap extends ApplicationLoader {

  override def load(context: Context): Application =
    new SampleApplication(context).application
}

class SampleApplication(context: Context)
    extends BuiltInComponentsFromContext(context)
    with controllers.AssetsComponents
    with HttpFiltersComponents
    with AhcWSComponents {

  val sampleService: SampleService = new SampleServiceImpl
  val sampleController: PlaySampleController = new PlaySampleController(sampleService, controllerComponents)

  override lazy val router: Router = new PlaySampleRouter(sampleController, executionContext)

}
