Feature: L'utilisateur peut obtenir, créer, supprimer et mettre à jour des régions avec succès

  Scenario: L'utilisateur obtient une région créée
    When l'utilisateur crée une région
    And l'utilisateur obtient la région créée
    Then l'utilisateur reçoit un code d'état de 200
    And la région récupérée est correcte

  Scenario: L'utilisateur obtient toutes régions
    Given les régions sont chargées
    When l'utilisateur obtient toutes régions
    Then l'utilisateur reçoit un code d'état de 200
    And la liste des regions n'est pas vide et une taille de 3
