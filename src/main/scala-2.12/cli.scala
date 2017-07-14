//import scopt.OptionParser

case class Config(mode: String = null,
                  concurrency: Int = 1,
                  max_connection: Int = 1,
                  force: Boolean = false,
                  delay: Int = 1000,
                  host: String = "localhost",
                  port: Int = 3000,
                  protocol: String = "http",
                  from: Int = -1,
                  to: Int = -1)

object Cli {
  def parse(args: String) = ???
}