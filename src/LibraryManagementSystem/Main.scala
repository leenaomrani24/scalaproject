package LibraryManagementSystem

object Main {
  def main(args: Array[String]): Unit = {
    val bibliotheque = new Bibliotheque()

    // Adding initial books to the library
    bibliotheque.ajouterLivre(new Livre("Clean Code", "Robert C. Martin", 2008))
    bibliotheque.ajouterLivre(new Livre("The Catcher in the Rye", "J.D. Salinger", 1951))
    bibliotheque.ajouterLivre(new Livre("To Kill a Mockingbird", "Harper Lee", 1960))

    println("Bienvenue dans la bibliothèque!")

    var running = true
    while (running) {
      println("Que voulez-vous faire?")
      println("1. Ajouter un livre")
      println("2. Emprunter un livre")
      println("3. Rendre un livre")
      println("4. Afficher les livres disponibles")
      println("5. Quitter")

      scala.io.StdIn.readLine().toInt match {
        case 1 =>
          println("Entrez les détails du livre (titre, auteur, année de publication):")
          val details = scala.io.StdIn.readLine().split(",").map(_.trim)
          val newBook = new Livre(details(0), details(1), details(2).toInt)
          bibliotheque.ajouterLivre(newBook)
          println(s"Le livre ${newBook.titre} a été ajouté à la bibliothèque.")
        case 2 =>
          println("Entrez le titre du livre que vous souhaitez emprunter :")
          val bookToBorrow = scala.io.StdIn.readLine()
          bibliotheque.emprunterLivre(bookToBorrow)
          println(s"Vous avez emprunté le livre : $bookToBorrow")
        case 3 =>
          println("Entrez le titre du livre que vous souhaitez rendre :")
          val bookToReturn = scala.io.StdIn.readLine()
          bibliotheque.rendreLivre(bookToReturn)
          println(s"Vous avez rendu le livre : $bookToReturn")
        case 4 =>
          bibliotheque.afficherLivres()
        case 5 =>
          running = false
          println("Au revoir!")
        case _ =>
          println("Choix invalide. Veuillez entrer un nombre entre 1 et 5.")
      }
    }
  }
}

