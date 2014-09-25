import com.github.play2war.plugin._

version := "1.0-SNAPSHOT"

Play2WarPlugin.play2WarSettings

Play2WarKeys.servletVersion := "3.1"

name := "playBlog"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache
)     

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.22"

libraryDependencies += "postgresql" % "postgresql" % "9.1-901.jdbc4"

play.Project.playJavaSettings

