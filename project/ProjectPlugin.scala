import sbt.Keys._
import sbt._

object ProjectPlugin {

  implicit final class PlayOps(val project: Project) extends AnyVal {

    import play.sbt._
    import PlayImport.PlayKeys
    import play.twirl.sbt.Import.TwirlKeys

    def enablePlay: Project =
      project
        .enablePlugins(PlayScala)
        // Disabling play project layout in favour of sbt layout
        // see more https://www.playframework.com/documentation/2.8.x/Anatomy
        .disablePlugins(PlayLayoutPlugin)
        .disablePlugins(PlayLogback)
        .settings(PlayKeys.playMonitoredFiles ++= (sourceDirectories in(Compile, TwirlKeys.compileTemplates)).value)
  }

}
