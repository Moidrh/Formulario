create table `User`
(
	`id` integer not null,
	`firstName` varchar(255) not null,
	`lastName` varchar(255) not null,
	`procesado` boolean not null,
	primary key (`id`)
);