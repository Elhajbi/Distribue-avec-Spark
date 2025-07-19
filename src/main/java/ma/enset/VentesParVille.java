package ma.enset;

import org.apache.spark.api.java.*;
import org.apache.spark.SparkConf;
import scala.Tuple2;

public class VentesParVille {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("TotalVentesParVille").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> lignes = sc.textFile("ventes.txt");

        JavaPairRDD<String, Double> ventesParVille = lignes
                .mapToPair(ligne -> {
                    String[] parts = ligne.split(" ");
                    String ville = parts[1];
                    Double prix = Double.parseDouble(parts[3]);
                    return new Tuple2<>(ville, prix);
                })
                .reduceByKey(Double::sum);

        ventesParVille.foreach(tuple ->
                System.out.println("Ville: " + tuple._1 + ", Total: " + tuple._2)
        );

        sc.close();
    }
}
