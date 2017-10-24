import org.apache.spark.sql.SparkSession

object DataFrameExample extends Serializable {
  def main(args: Array[String]) = {

    val spark = SparkSession
      .builder()
      .appName("Databricks Spark Example")
      .config("spark.sql.warehouse.dir", "/user/hive/warehouse")
      .config("spark.master", "local")
      .getOrCreate()
    import spark.implicits._

    spark.udf.register("pointlessUDF", com.imran.tuto.DFUtils.pointlessUDF(_:String):String)

    val authors = Seq("bill,databricks", "matei,databricks")
    val authorsDF = spark
      .sparkContext
      .parallelize(authors)
      .toDF("raw")
      .selectExpr("split(raw, ',') as values")
      .selectExpr("pointlessUDF(values[0]) as name", "values[1] as company")
      .show()



  }
}