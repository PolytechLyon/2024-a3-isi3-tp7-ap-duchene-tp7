# Exercice 1

Il test tous les cas relatifs à la connexion, que ce soit avec un mauvais user, password, token ou la déconnexion etc..
Ce sont tous les fichiers présent dans domain/login.

Il faut encrypter le password dans le SimpleLoginService

# Exercice 2

@Configuration est une annotation qui permet de définir une classe de configuration. Elle est utilisée pour définir des beans, des méthodes de configuration et des méthodes de configuration de beans.
@Bean est une annotation qui est utilisée pour définir un bean. Il est utilisé pour créer et gérer l'instance de l'objet retourné par cette méthode.
@Scope est une annotation qui est utilisée pour définir la portée d'un bean. Ici, le scope est un Singleton, ce qui veut dire que Spring créera une seule instance de ce bean pour toute l'application.

La classe InjectionPoint st utilisée par Spring pour stocker des informations sur le point d'injection actuel. Dans notre cas, elle est utilisée pour obtenir le nom de la classe où le bean Logger est injecté