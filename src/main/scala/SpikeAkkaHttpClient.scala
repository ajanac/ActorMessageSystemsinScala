/**
  * Created by aishwaryav88 on 11/1/2016.
  */
import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.stream.ActorMaterializer
import akka.util.ByteString
import org.json4s.jackson._

import scala.concurrent.duration._
import scala.concurrent.{Await, Future}
import scala.sys.process.Process
import java.io._
object SpikeAkkaHttpClient extends App {

  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()
  //responseFuture gives the HTTP response containing the json key value pairs of all the java projects from the github search
  val responseFuture: Future[HttpResponse] =
  Http().singleRequest(HttpRequest(HttpMethods.GET,uri = "https://api.github.com/search/repositories?q=language:java&sort=stars&order=desc"))
  import system.dispatcher
  val response = Await.result(responseFuture, 5.seconds)
  val resp= response.entity.dataBytes.runFold(ByteString.empty)(_ ++ _).map(_.utf8String)
  Await.result(resp, 5.seconds)
  //parse the Json key value pairs from the http response
  val json1=parseJson(resp.value.get.get)
  //urls contain all the github clone urls of java projects retrieved from the search
  val urls= prettyJson(json1 \\ "clone_url" \"clone_url")
   println(urls)


  // Splits the string of URLs tofetch each url
  val toRemove = "[]".toSet
  val words = urls.filterNot(toRemove)


  //This for loop selects each URL and clones it into a Directory named Resources(to be created manually)
  for(url<- words.split(",")){

    println(url)
    val output=Process("git clone"+url,new File("C:\\Users\\Vignesh\\Documents\\cs474hw3\\Resources")).!!
    println(output)

  }

  //Here we take each url and creates its UDB by analysing the project using UNderstand API. We are showing here for a single project


  //Clones a project named ReactiveX under Resources folder (if already cloned above, produces an error!!)
  val output=Process("git clone https://github.com/ReactiveX/RxJava.git",new File("C:\\Users\\Vignesh\\Documents\\cs474hw3\\Resources")).!!
  println(output)
    //creates UDB of each project by analysing the project using Understand API
  val udbop=Process("und -db rxjava create -languages java add C:\\Users\\Vignesh\\Documents\\cs474hw3\\Resources analyze"). !!
  println(udbop)

  //  Http().shutdownAllConnectionPools().onComplete(_ => system.shutdown())
}

//"https://github.com/ReactiveX/RxJava.git", "https://github.com/square/retrofit.git", "https://github.com/square/okhttp.git", "https://github.com/iluwatar/java-design-patterns.git", "https://github.com/nostra13/Android-Universal-Image-Loader.git", "https://github.com/JakeWharton/butterknife.git", "https://github.com/google/guava.git", "https://github.com/PhilJay/MPAndroidChart.git", "https://github.com/futurice/android-best-practices.git", "https://github.com/google/iosched.git", "https://github.com/greenrobot/EventBus.git", "https://github.com/square/leakcanary.git", "https://github.com/square/picasso.git", "https://github.com/bumptech/glide.git", "https://github.com/facebook/fresco.git", "https://github.com/zxing/zxing.git", "https://github.com/spring-projects/spring-framework.git", "https://github.com/libgdx/libgdx.git", "https://github.com/jfeinstein10/SlidingMenu.git", "https://github.com/ReactiveX/RxAndroid.git", "https://github.com/loopj/android-async-http.git", "https://github.com/nathanmarz/storm.git", "https://github.com/androidannotations/androidannotations.git", "https://github.com/spring-projects/spring-boot.git", "https://github.com/JakeWharton/ViewPagerIndicator.git", "https://github.com/alibaba/weex.git", "https://github.com/netty/netty.git", "https://github.com/chrisbanes/PhotoView.git", "https://github.com/afollestad/material-dialogs.git" ]