package ma.enset;

import org.apache.spark.api.java.*;
import org.apache.spark.SparkConf;
import scala.Tuple2;

public class VentesParVilleEtAnnee {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("TotalVentesParVilleEtAnnee").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> lignes = sc.textFile("ventes.txt");

        JavaPairRDD<String, Double> ventesParVilleEtAnnee = lignes
                .mapToPair(ligne -> {
                    String[] parts = ligne.split(" ");
                    String date = parts[0]; // yyyy-mm-dd
                    String ville = parts[1];
                    double prix = Double.parseDouble(parts[3]);
                    String annee = date.split("-")[0];
                    String key = ville + "_" + annee;
                    return new Tuple2<>(key, prix);
                })
                .reduceByKey(Double::sum);

        ventesParVilleEtAnnee.foreach(tuple ->
                System.out.println("Ville et année: " + tuple._1 + ", Total: " + tuple._2)
        );

        sc.close();
    }
}
