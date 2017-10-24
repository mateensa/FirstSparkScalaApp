import org.apache.spark.sql.SparkSession

object FirstSparkScalaApp{

  def main(args: Array[String]) = {

    System.out.println("First Scala App")

    val spark = SparkSession.builder().appName("Spark basic example").config("spark.master", "local").getOrCreate();
    val sc = spark.sparkContext;
    val rdd = sc.parallelize(1 to 1000, 2)
    rdd.collect().foreach(println)

  }

}

