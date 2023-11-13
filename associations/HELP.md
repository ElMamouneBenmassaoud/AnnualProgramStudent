# Les associations avec Spring JPA

## Warning
Dans le cas des associations bidirectionnelles, l'objet prioritaire
est celui qui ne contient pas l'annotation `mappedBy`.

## Unidirectionnelles
### OneToMany
Department & Employee

### ManyToOne
Student & School

### OneToOne
Car & ParkingSpot

### ManyToMany
Book & Author

## Bidirectionnelles
### OneToMany
Customer & Client
ATTENTION : il faut garder la cohérence des données (voir Customer (addOrder) et Order (setCustomer))
SaleOrder est propriétaire de la relation (voir mappedBy)

Lorsque l'on fait la liaison, on observe que l'attribut 'customer' de SaleOrder est bien rempli avec l'id du client.

### ManyToMany
Actor & Movie
ATTENTION : il faut garder la cohérence des données (voir Actor (addMovie) et Movie (addActor))
Movie est propriétaire de la relation (voir mappedBy)

Comme Movie est propriétaire, j'ai choisi d'ajouter un Acteur à un film via la méthode de Movie mais l'inverse aurait aussi été possible.

## Unidirectionel vs Bidirectionnel
Les associations unidirectionnelles sont des relations entre deux tables où une table contient une clé étrangère faisant référence à la clé primaire de l'autre table. La navigation se fait uniquement d'une table enfant vers une table parent, offrant généralement des performances plus rapides et une cohérence des données assurée par des contraintes de clé étrangère.

En revanche, les associations bidirectionnelles sont des relations entre deux tables où les deux tables contiennent des clés étrangères se faisant référence mutuellement. Cela permet une navigation dans les deux directions, mais peut entraîner une complexité accrue de la structure de table, une vitesse généralement plus lente et une plus grande flexibilité pour apporter des modifications indépendantes aux tables sans affecter l'autre.

## Credits 
Les exemples proviennent de : [Baeldung](https://www.baeldung.com/jpa-hibernate-associations) et ont été adaptés et modifiés par Cameron Noupoué