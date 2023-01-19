create database enchere;
alter database enchere owner to postgres;
\c enchere postgres;

--MongoDB
create table admin(
    idAdmin serial primary key not null,
    identifiant varchar not null,
    mdp varchar not null
);

create table commission(
    idCommission serial primary key not null,
    commission numeric(4,2)
);
insert into commission(commission) values (10);

create table categorie(
    idCategorie serial primary key not null,
    nomCategorie varchar not null
);

create table utilisateur(
    idUtilisateur serial primary key not null,
    nomUser varchar not null,
    mdp varchar not null,
    numeroCompte varchar unique not null,
    montant int not null default 0
);

create table token(
    iduser int not null,
    token varchar primary key,
    datecreation timestamp not null,
    duree double precision not null,
    dateexpiration timestamp not null,
    foreign key (iduser) references utilisateur(idUtilisateur)  
);

create table rechargement(
    idRechargement serial primary key not null,
    numeroCompte varchar not null,
    montant int not null,
    etat int default 0,
    foreign key (numeroCompte) references utilisateur(numeroCompte)
);

create table produit(
    idProduit serial primary key not null,
    idUtilisateur int not null,
    nomProduit varchar not null,
    idCategorie int not null,
    descri varchar,
    prixEnchere int not null,
    prixMin int not null,
    duree int not null,
    debut timestamp default now(),
    statut int default 0,
    foreign key (idUtilisateur) references utilisateur(idUtilisateur),
    foreign key (idCategorie) references categorie(idCategorie)
);

--MongoDB
create table photo(
    idPhoto serial primary key not null,
    photo varchar not null,
    idProduit int not null,
    foreign key (idProduit) references produit(idProduit)
);

create table enchere(
    idEnchere serial primary key not null,
    idProduit int not null,
    idUtilisateur int not null,
    prix int not null,
    dateMise date default now(),
    foreign key (idProduit) references produit(idProduit),
    foreign key (idUtilisateur) references utilisateur(idUtilisateur)
);

create table bloquage(
    idBloquage serial primary key,
    idProduit int unique not null,
    idUtilisateur int not null,
    prix int not null,
    dateMise date default now(),
    foreign key (idProduit) references produit(idProduit),
    foreign key (idUtilisateur) references utilisateur(idUtilisateur)
);

create table benefice(
    idBenefice serial primary key not null,
    idProduit int not null,
    valeur float not null,
    foreign key (idProduit) references produit(idProduit)
);

create or replace view v_produit as 
select p.*,c.nomCategorie from produit p 
join categorie c on p.idCategorie=c.idCategorie;

create or replace view v_encherePrixMax as
select idProduit,max(prix) prix from enchere group by idProduit;

create or replace view v_enchereTermine as
select v_produit.*,idEnchere,enchere.idUtilisateur gagnant,v_encherePrixMax.prix,dateMise
from v_produit,enchere,v_encherePrixMax
where v_produit.idProduit=enchere.idProduit and v_produit.idProduit=v_encherePrixMax.idProduit and v_produit.statut=1
group by v_produit.idProduit ,v_produit.idUtilisateur,v_produit.nomCategorie  ,v_produit.nomProduit  ,v_produit.idCategorie  ,v_produit.descri ,v_produit.prixEnchere  ,v_produit.prixMin  ,v_produit.duree  ,v_produit.debut  ,v_produit.statut ,idEnchere,enchere.idUtilisateur,v_encherePrixMax.prix,dateMise;

create or replace view caclient as
select idUtilisateur,sum(prix*commission.commission/100) prix from v_enchereTermine,commission group by idUtilisateur
union
select gagnant idUtilisateur,sum(prix) prix from v_enchereTermine group by gagnant;

create or replace view clientca as
select idUtilisateur,sum(prix) from caclient group by idUtilisateur;

create or replace view v_caclient as
select utilisateur.*,sum from utilisateur,clientca where clientca.idUtilisateur=utilisateur.idUtilisateur;

create or replace view cacategorie as
select idCategorie,sum(prix) from v_enchereTermine group by idCategorie;

create or replace view v_cacategorie as
select categorie.*,sum from cacategorie,categorie where categorie.idCategorie=cacategorie.idCategorie;

create or replace view v_rechargement as 
select idRechargement,utilisateur.*,rechargement.montant recharge,rechargement.etat from utilisateur,rechargement where utilisateur.numeroCompte=rechargement.numeroCompte;

create or replace view v_montant_user as 
select b.idUtilisateur,(sum(r.montant)-sum(b.prix))as montant from bloquage b 
join utilisateur u 
on b.idUtilisateur=u.idUtilisateur 
join rechargement r 
on u.numeroCompte=r.numeroCompte 
where r.etat=1 
group by b.idUtilisateur,r.numeroCompte;


insert into utilisateur (nomUser,mdp,numeroCompte) values
('Rabe','rabe','C0001'),
('Rasoa','rasoa','C0002');

insert into categorie (nomCategorie) values ('Appareil Electronique'),('meuble'),('Decoration');


insert into produit 	(idUtilisateur,nomProduit,		idCategorie 	,descri,		prixEnchere	, prixMin	, 	duree	,statut	)
		values 			(1,'Fer a repasser',	1				,'Baolai',		20000		, 25000 	,	1		,0 		),
						(1,'Fauteuil',		2				,'2 personnes',	1000000		, 1050000 	,	1		,0 		),
						(1,'Tableau',			3				,'Paysage',		50000		, 55000 	,	1		,0 		),
						(2,'Vase',			3				,'En argile'	,50000		, 55000 	,	1		,0 		),
						(2,'Laptop',			1				,'Asus'		,   5000000		, 5100000 	,	2		,0 	),
						(2,'Canape',			2				,'Canape-lit Pliable',10000 , 11000 	,	2		,0 	);

insert into rechargement (numeroCompte,montant) values
('C0001',1000),
('C0002',2000);

insert into enchere (idProduit,idUtilisateur,prix) values
(1,2,5000),
(1,2,6000);
