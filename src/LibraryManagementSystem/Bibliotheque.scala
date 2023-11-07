package LibraryManagementSystem

import scala.collection.mutable.ListBuffer

// Bibliothèque class managing a list of Livre objects
class Bibliotheque {
  private val listeDeLivres: ListBuffer[Livre] = ListBuffer()

  def ajouterLivre(livre: Livre): Unit = {
    listeDeLivres += livre
  }

  def emprunterLivre(titre: String): Unit = {
    val livreOption = listeDeLivres.find(_.titre == titre)
    livreOption.foreach(_.emprunter())
  }

  def rendreLivre(titre: String): Unit = {
    val livreOption = listeDeLivres.find(_.titre == titre)
    livreOption.foreach(_.rendre())
  }

  def afficherLivres(): Unit = {
    println("Livres disponibles dans la bibliothèque :")
    listeDeLivres.foreach(println)
  }
}

