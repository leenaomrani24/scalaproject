package LibraryManagementSystem

// Livre class representing a book
class Livre(val titre: String, val auteur: String, val annéeDePublication: Int) {
  private var estEmprunté: Boolean = false

  def emprunter(): Unit = {
    estEmprunté = true
  }

  def rendre(): Unit = {
    estEmprunté = false
  }

  def isEmprunté: Boolean = estEmprunté

  override def toString: String = s"$titre - $auteur ($annéeDePublication)"
}

